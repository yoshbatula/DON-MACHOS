package org.example.donmachos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class orderSummaryController2 {

    @FXML
    private TextField addressTF;

    @FXML
    private TextField cellphoneTF;

    @FXML
    private TextField cityTF;

    @FXML
    private TextField nameTF;


    @FXML
    private Button proceedBTN2;

    private String name = nameTF.getText();
    private String address = addressTF.getText();
    private String city = cityTF.getText();
    private String cellphone = cellphoneTF.getText();

    public void orderSummary(ActionEvent event) {

        if (name.isEmpty()) {
            nameTF.setStyle("-fx-border-color: red;");
        } else if (address.isEmpty()) {
            addressTF.setStyle("-fx-border-color: red;");
        } else if (city.isEmpty()) {
            cityTF.setStyle("-fx-border-color: red;");
        } else if (cellphone.isEmpty()) {
            cellphoneTF.setStyle("-fx-border-color: red;");
        } else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Ordering3.fxml"));
                AnchorPane pane = fxmlLoader.load();

                Stage stage = new Stage();
                stage.setScene(new Scene(pane));
                stage.show();

                Stage window = (Stage) proceedBTN2.getScene().getWindow();
                window.close();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCellphone() {
        return cellphone;
    }
}
