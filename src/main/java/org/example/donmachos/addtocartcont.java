package org.example.donmachos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class    addtocartcont {

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

    @FXML
    private Button removeBTN;


    private cartItems cartitems;

    private CartListener cartListener;

    public void setData(cartItems cartitems, CartListener cartListener) {
        this.cartitems = cartitems;
        this.cartListener = cartListener;

        Image image = new Image(getClass().getResourceAsStream(cartitems.getImage()));
        imgCart.setImage(image);
        cartCoffeName.setText(cartitems.getCoffeNames());
        moodCart.setText(cartitems.getMood());
        sizeCart.setText(cartitems.getSize());
        quantityCart.setText("Qty: " + cartitems.getQuantity());
        priceCart.setText("₱" + cartitems.getPrice());

        removeBTN.setOnAction(event -> {
            if (cartListener != null) {
                cartListener.handleRemoveFromCart(cartitems);
            }
        });
    }

    public Text getSizeCart() {
        return sizeCart;
    }

    public Button getRemoveBTN() {
        return removeBTN;
    }
}