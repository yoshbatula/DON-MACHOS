package org.example.donmachos;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.List;

public class summaryController {

    @FXML
    private GridPane orderSumarryGrid;

    @FXML
    private Button proceedBTN;

    @FXML
    private Text subtotaltext;

    @FXML
    private Text totalText;


    private List<cartItems> cartModel;
    private cartItems cartItem;

    public void setData(double subtotal, double total, List<cartItems> cartModel, cartItems cartItem) {
        this.cartModel = cartModel;
        this.cartItem = cartItem;

        subtotaltext.setText(String.format("%.2f", subtotal));
        totalText.setText(String.format("%.2f", total));

        updateOrderSummaryUI();

    }

    private void updateOrderSummaryUI() {
        orderSumarryGrid.getChildren().clear();

        int column = 0;
        int row = 0;
        for (cartItems item : cartModel) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("summaryModel.fxml"));
                AnchorPane pane = fxmlloader.load();

                SummaryModelController controller = fxmlloader.getController();
                controller.setData(cartModel,cartItem);

                orderSumarryGrid.add(pane, column, row);
                GridPane.setMargin(pane, new Insets(10));

                if (column == 0) {
                    row++;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
