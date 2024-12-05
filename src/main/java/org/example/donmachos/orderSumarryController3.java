package org.example.donmachos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class orderSumarryController3 {

    @FXML
    private Button codBTN;

    @FXML
    private Button debitCardBTN;

    @FXML
    private Button eWalletBTN;

    @FXML
    private Button proceedBTN;

    public void orderSummary3(ActionEvent event) {
       if (event.getSource() == codBTN) {
           String cod = "Cash-On-Deliverty";
       } else if (event.getSource() == debitCardBTN) {
           String debit = "Debit Card";
       } else if (event.getSource() == eWalletBTN) {
           String ewallet = "EWallet";
       } else if (event.getSource() == proceedBTN) {
           try {
               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Ordering4.fxml"));
               AnchorPane pane = fxmlLoader.load();
           } catch (Exception e) {
               throw new RuntimeException(e);
           }
       }

    }

}