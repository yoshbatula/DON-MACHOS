package org.example.donmachos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.List;

public class orderSummaryController4 {

    @FXML
    private Text addressText;

    @FXML
    private Text cellphoneText;

    @FXML
    private Text cityText;

    @FXML
    private Text nameText;

    @FXML
    private GridPane orderCartSummary;

    @FXML
    private Text paymentMethodText;

    @FXML
    private Button proceedBTN4;

    @FXML
    private Text subtotaltext;

    @FXML
    private Text totalText;

    private List<cartItems> cartItemsList;
    private cartItems cartItem;

    public void setData(double subtotal, double total, List<cartItems> cartItemsList, cartItems cartItem) {
        this.cartItemsList = cartItemsList;
        this.cartItem = cartItem;

        subtotaltext.setText(String.format("₱%.2f", subtotal));
        totalText.setText(String.format("₱%.2f", total));
    }
}
