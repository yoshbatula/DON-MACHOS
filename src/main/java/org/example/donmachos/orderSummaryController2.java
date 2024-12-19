package org.example.donmachos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.List;

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

    private orders order;
    private double subtotal;
    private double total;

    private List<cartItems> cartModel;
    private cartItems cartItem;

    public void setOrder(double subtotal, double total, List<cartItems> cartModel, cartItems cartItem) {
        this.subtotal = subtotal;
        this.total = total;
        this.cartModel = cartModel;
        this.cartItem = cartItem;
    }


}


