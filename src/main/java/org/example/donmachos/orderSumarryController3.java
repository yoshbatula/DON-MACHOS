package org.example.donmachos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.List;

public class orderSumarryController3 {

    @FXML
    private Button codBTN;

    @FXML
    private Button debitCardBTN;

    @FXML
    private Button eWalletBTN;

    @FXML
    private Button proceedBTN3;

   private String PaymentMethod;

    private double subtotal;
    private double total;
    private orders order;
    private List<cartItems> cartModel;
    private cartItems cartItem;

    public void setData(double subtotal, double total, orders order, List<cartItems> cartModel, cartItems cartItem) {
        this.subtotal = subtotal;
        this.total = total;
        this.order = order;
        this.cartModel = cartModel;
        this.cartItem = cartItem;

        System.out.println("Subtotal: " + subtotal);
        System.out.println("Total: " + total);
    }


    public void orderSummary3(ActionEvent event) {
       if (event.getSource() == codBTN) {
           PaymentMethod = "Cash-On-Delivery";
           System.out.println("Cash-On-Delivery");
       } else if (event.getSource() == debitCardBTN) {
           PaymentMethod = "Debit Card";
           System.out.println("Debit Card");
       } else if (event.getSource() == eWalletBTN) {
           PaymentMethod = "E-Wallet";
           System.out.println("E-Wallet");
       } else if (event.getSource() == proceedBTN3) {
           try {
               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Ordering4.fxml"));
               AnchorPane pane = fxmlLoader.load();

               orderSummaryController4 controller = fxmlLoader.getController();
               controller.setData(subtotal, total, order, PaymentMethod, cartModel, null);

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

    public String getPaymentMethod() {
        return PaymentMethod;
    }
}