package org.example.donmachos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class orderSumarryController3 {

    @FXML
    private Button codBTN;

    @FXML
    private Button debitCardBTN;

    @FXML
    private Button eWalletBTN;

    @FXML
    private Button proceedBTN;
    private String cod;
    private String debit;
    private String ewallet;
    public void orderSummary3(ActionEvent event) {
       if (event.getSource() == codBTN) {
            cod = "Cash-On-Delivery";
       } else if (event.getSource() == debitCardBTN) {
            debit = "Debit Card";
       } else if (event.getSource() == eWalletBTN) {
            ewallet = "E-Wallet";
       } else if (event.getSource() == proceedBTN) {
           try {
               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Ordering4.fxml"));
               AnchorPane pane = fxmlLoader.load();

               Stage stage = new Stage();
               stage.setScene(new Scene(pane));
               stage.show();

               Stage window = (Stage) proceedBTN.getScene().getWindow();
               window.close();
           } catch (Exception e) {
               throw new RuntimeException(e);
           }
       }

    }

    public String getCod() {
        return cod;
    }

    public String getDebit() {
        return debit;
    }

    public String getEWallet() {
        return ewallet;
    }
}