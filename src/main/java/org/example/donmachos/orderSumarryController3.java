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
    private Button proceedBTN3;

    private String cod;
    private String debit;
    private String ewallet;

    private double subtotal;
    private double total;

    public void setData(double subtotal, double total,orders order) {
        this.subtotal = subtotal;
        this.total = total;

        System.out.println("Subtotal: " + subtotal);
        System.out.println("Total: " + total);
    }


    public void orderSummary3(ActionEvent event) {
       if (event.getSource() == codBTN) {
            cod = "Cash-On-Delivery";
           System.out.println("Cash-On-Delivery");
       } else if (event.getSource() == debitCardBTN) {
            debit = "Debit Card";
           System.out.println("Debit Card");
       } else if (event.getSource() == eWalletBTN) {
            ewallet = "E-Wallet";
           System.out.println("E-Wallet");
       } else if (event.getSource() == proceedBTN3) {
           try {
               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Ordering4.fxml"));
               AnchorPane pane = fxmlLoader.load();

               orderSummaryController4 controller = fxmlLoader.getController();
               controller.setData(subtotal, total);

               Stage stage = new Stage();
               stage.setScene(new Scene(pane));
               stage.show();

               Stage window = (Stage) proceedBTN3.getScene().getWindow();
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