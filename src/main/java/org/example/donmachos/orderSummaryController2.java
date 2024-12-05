package org.example.donmachos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    private Button proceedBTN;

    public void orderSummary(ActionEvent event) {
        String name = nameTF.getText();
        String address = addressTF.getText();
        String city = cityTF.getText();
        String cellphone = cellphoneTF.getText();

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
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
