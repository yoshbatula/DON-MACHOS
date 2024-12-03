package org.example.donmachos;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    @FXML
    private Text cartCoffeName;

    @FXML
    private ImageView imgCart;

    @FXML
    private Text moodCart;

    @FXML
    private Text priceCart;

    @FXML
    private Text quantityCart;

    @FXML
    private Text sizeCart;


    private List<cartItems> cartModel;
    private cartItems cartItem;
    public void setData(double subtotal, double total, List<cartItems> cartModel, cartItems cartItem) {
        this.cartModel = cartModel;
        this.cartItem = cartItem;

        Image image = new Image(getClass().getResourceAsStream(cartItem.getImage()));
        imgCart.setImage(image);
        cartCoffeName.setText(cartItem.getCoffeNames());
        moodCart.setText(cartItem.getMood());
        priceCart.setText(String.valueOf(cartItem.getPrice()));
        quantityCart.setText(String.valueOf(cartItem.getQuantity()));
        sizeCart.setText(String.valueOf(cartItem.getSize()));
        subtotaltext.setText("₱" + String.format("%.2f", subtotal));
        totalText.setText("₱" + String.format("%.2f", total));

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
