package org.example.donmachos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.List;

public class summaryController {

    @FXML
    private GridPane orderSumarryGrid;


    @FXML
    private Button proceedBTN1;

    @FXML
    private Text subtotaltext;

    @FXML
    private Text totalText;


    private List<cartItems> cartModel;
    private cartItems cartItem;

    public void setData(double subtotal, double total, List<cartItems> cartModel, cartItems cartItem) {
        this.cartModel = cartModel;
        this.cartItem = cartItem;

        subtotaltext.setText(String.format("₱%.2f", subtotal));
        totalText.setText(String.format("₱%.2f", total));

        updateOrderSummaryUI();
    }

    public void switchToAnotherOrder() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ordering2.fxml"));
            AnchorPane ordering2Pane = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(ordering2Pane));
            stage.show();

            Stage window = (Stage) proceedBTN1.getScene().getWindow();
            window.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
                controller.setData(cartModel, item);

                orderSumarryGrid.add(pane, column, row);
                GridPane.setMargin(pane, new Insets(10));

                if (column == 0) {
                    row++;
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Error updating order summary UI.", e);
            }
        }
    }

}
