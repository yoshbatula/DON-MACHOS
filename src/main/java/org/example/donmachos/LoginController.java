package org.example.donmachos;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
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


    private User user;

    public void register(ActionEvent event) throws SQLException {

        DBCONNECTION db = new DBCONNECTION();

        String emailAddress = EmailTF.getText();
        String password = passwordTF.getText();
        String username = userTF.getText();

        user = new User(emailAddress, username, password);

        if(EmailTF.getText().isBlank() || userTF.getText().isBlank() || passwordTF.getText().isBlank()) {
            EmailTF.setStyle("-fx-border-color: red; -fx-border-radius: 9px; -fx-font-family: 'Palatino Linotype'");
            userTF.setStyle("-fx-border-color: red; -fx-border-radius: 9px; -fx-font-family: 'Palatino Linotype'");
            passwordTF.setStyle("-fx-border-color: red; -fx-border-radius: 9px; -fx-font-family: 'Palatino Linotype'");

        } else if (event.getSource() == submitBTN) {
            try {
                Statement stmt = db.getConnection().createStatement();
                String sql = "insert into user (Email, Username, Password)\n" +
                        "values ()";
                PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
                preparedStatement.setString(1, EmailTF.getText());
                preparedStatement.setString(2, userTF.getText());
                preparedStatement.setString(3, passwordTF.getText());
            } catch (SQLException e) {
                e.printStackTrace();
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
}







