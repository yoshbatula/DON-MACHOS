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

    private cartItems cartItem;

    private List<cartItems> CartModel;




    public void orderSummary3(ActionEvent event) {
       if (event.getSource() == codBTN) {
           PaymentMethod = "Cash";
           System.out.println("Cash-On-Delivery");
       } else if (event.getSource() == debitCardBTN) {
           PaymentMethod = "Card";
           System.out.println("Debit Card");
       } else if (event.getSource() == eWalletBTN) {
           PaymentMethod = "E-Wallet";
           System.out.println("E-Wallet");
       } else if (event.getSource() == proceedBTN3) {
           try {
               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Ordering4.fxml"));
               AnchorPane pane = fxmlLoader.load();

               orderSummaryController4 controller = fxmlLoader.getController();
               controller.setData(subtotal, total, order, PaymentMethod, CartModel, null);

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

    public void setOrder(double subtotal, double total, List<cartItems> cartModel, Object o) {
        this.CartModel = cartModel;
        this.total = total;
        this.subtotal = subtotal;
    }
}