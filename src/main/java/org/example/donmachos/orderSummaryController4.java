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

    private orderSumarryController3 orderSummary;

    private List<cartItems> cartItemsList;
    private cartItems cartItem;
    private orders order;

    public void setData(double subtotal, double total, orders order) {
        this.order = order;

        nameText.setText(order.getName());
        addressText.setText(order.getAddress());
        cellphoneText.setText(order.getCellphone());
        cityText.setText(order.getCity());
        paymentMethodText.setText(orderSummary.getPaymentMethod());
        subtotaltext.setText(String.format("₱%.2f", subtotal));
        totalText.setText(String.format("₱%.2f", total));

        System.out.println("OrderSummaryController4 - Subtotal: " + subtotal);
        System.out.println("OrderSummaryController4 - Total: " + total);
    }
}
