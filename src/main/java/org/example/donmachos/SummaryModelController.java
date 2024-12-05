package org.example.donmachos;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.util.List;

public class SummaryModelController {

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

    public void setData(List<cartItems> cartModel, cartItems cartItem) {
        this.cartModel = cartModel;
        this.cartItem = cartItem;

        Image image = new Image(getClass().getResourceAsStream(cartItem.getImage()));
        imgCart.setImage(image);
        cartCoffeName.setText(cartItem.getCoffeNames());
        moodCart.setText(cartItem.getMood());
        priceCart.setText(String.format("₱%.2f", cartItem.getPrice()));
        quantityCart.setText(String.valueOf(cartItem.getQuantity()));
        sizeCart.setText(cartItem.getSize());

    }
}
