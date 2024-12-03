package org.example.donmachos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class summaryCont {

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

    private cartItems summarylist;

    public void setData(cartItems carts) {
        this.summarylist = carts;

        Image image = new Image(getClass().getResourceAsStream(summarylist.getImage()));
        imgCart.setImage(image);
        cartCoffeName.setText(summarylist.getCoffeNames());
        moodCart.setText(summarylist.getMood());
        sizeCart.setText(summarylist.getSize());
        quantityCart.setText("Qty: " + summarylist.getQuantity());
        priceCart.setText("₱" + summarylist.getPrice());
    }

}
