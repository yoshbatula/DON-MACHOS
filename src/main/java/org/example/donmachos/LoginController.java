package org.example.donmachos;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {

    @FXML
    private TextField EmailAddressTF;

    @FXML
    private Button createBTN;

    @FXML
    private Button forgotpassBTN;

    @FXML
    private TextField passTF;

    @FXML
    private RadioButton rememberRBTN;

    @FXML
    private TextField EmailTF;

    @FXML
    private TextField passwordTF;

    @FXML
    private Button submitBTN;

    @FXML
    private TextField userTF;

    @FXML
    private PasswordField passwordPF;

    @FXML
    private PasswordField passPF;

    @FXML
    private Button signBTN;

    private User user;

    public void register(ActionEvent event) throws SQLException {

        DBCONNECTION db = new DBCONNECTION();

        String emailAddress = EmailTF.getText();
        String password = passwordPF.getText();
        String username = userTF.getText();

        user = new User(emailAddress, username, password);

        if (EmailTF.getText().isBlank() || userTF.getText().isBlank() || passwordPF.getText().isBlank()) {

            EmailTF.setStyle("-fx-border-color: red; -fx-border-radius: 9px; -fx-font-family: 'Palatino Linotype'");
            userTF.setStyle("-fx-border-color: red; -fx-border-radius: 9px; -fx-font-family: 'Palatino Linotype'");
            passwordPF.setStyle("-fx-border-color: red; -fx-border-radius: 9px; -fx-font-family: 'Palatino Linotype'");
        } else if (event.getSource() == submitBTN) {
            try {
                Statement stmt = db.getConnection().createStatement();
                String sql = "INSERT INTO user (Email, Username, Password) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
                preparedStatement.setString(1, emailAddress);
                preparedStatement.setString(2, username);
                preparedStatement.setString(3, password);

                int rowsAffected = preparedStatement.executeUpdate();


                if (rowsAffected > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration Successful");
                    alert.setHeaderText(null);
                    alert.setContentText("User registered successfully!");
                    alert.showAndWait();

                    Stage window = (Stage) submitBTN.getScene().getWindow();
                    window.close();

                    Stage stage = new Stage();
                    FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("LOGIN.fxml"));
                    Scene scene = new Scene(fxmlloader.load());
                    stage.setScene(scene);
                    stage.show();

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Registration Failed");
                    alert.setHeaderText(null);
                    alert.setContentText("An error occurred while registering the user. Please try again.");
                    alert.showAndWait();
                }

            } catch (SQLException e) {
                e.printStackTrace();

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Database Error");
                alert.setHeaderText("Error during registration");
                alert.setContentText("An error occurred: " + e.getMessage());
                alert.showAndWait();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void switchform(ActionEvent event) throws IOException {
        if (event.getSource() == createBTN) {

            Stage window = (Stage) createBTN.getScene().getWindow();
            window.close();

            Stage stage = new Stage();
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("REGISTER.fxml"));
            Scene scene = new Scene(fxmlloader.load());
            stage.setScene(scene);
            stage.show();
        }
    }

    public void login(ActionEvent event) {
        DBCONNECTION db = new DBCONNECTION();

        try {
            Statement stmt = db.getConnection().createStatement();
            String sql = "SELECT * FROM user WHERE Email = ? AND Password = ?";
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, EmailAddressTF.getText());
            preparedStatement.setString(2, passPF.getText());

            ResultSet result = preparedStatement.executeQuery();

            if (!result.next()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Invalid email or password. Please try again.");
                alert.showAndWait();

            } else {
                Stage window = (Stage) signBTN.getScene().getWindow();
                window.close();

                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HOMEINTERFACE.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("HOME INTERFACE");
                stage.setScene(scene);
                stage.show();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}







