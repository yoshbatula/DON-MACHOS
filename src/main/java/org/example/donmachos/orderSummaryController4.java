package org.example.donmachos;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
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

    private List<cartItems> cartModel;
    private cartItems cartItem;
    private orders order;
    private String PaymentMethod;

    public void setData(double subtotal, double total, orders order, String paymentMethod, List<cartItems> cartModel, cartItems cartItem) {
        this.order = order;
        this.PaymentMethod = paymentMethod;
        this.cartModel = cartModel;
        this.cartItem = cartItem;

        nameText.setText(order.getName());
        addressText.setText(order.getAddress());
        cellphoneText.setText(order.getCellphone());
        cityText.setText(order.getCity());
        paymentMethodText.setText(paymentMethod);
        subtotaltext.setText(String.format("₱%.2f", subtotal));
        totalText.setText(String.format("₱%.2f", total));

        System.out.println("OrderSummaryController4 - Subtotal: " + subtotal);
        System.out.println("OrderSummaryController4 - Total: " + total);

        SummaryUpdateForUI();
    }

    public void SummaryUpdateForUI() {
        orderCartSummary.getChildren().clear();
        int row = 0;
        int column = 0;
        for (cartItems cartItem : cartModel) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("summaryModel.fxml"));
                AnchorPane pane = fxmlLoader.load();

                orderCartSummary.add(pane, column, row);
                GridPane.setMargin(pane, new Insets(10));

                orderCartSummary.getRowConstraints().clear();
                if (column == 0) {
                    row++;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
