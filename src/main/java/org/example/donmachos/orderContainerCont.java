package org.example.donmachos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.example.donmachos.CartListener;
import org.example.donmachos.cart;

public class orderContainerCont {

    @FXML
    private Text COFFEDESCRIPTION;

    @FXML
    private Text COFFENAME;

    @FXML
    private Text SIZE;

    @FXML
    private Button addTocartBTN;

    @FXML
    private Button hotBTN;

    @FXML
    private Button iceBTN;

    @FXML
    private AnchorPane imgContainer;

    @FXML
    private ImageView imgView;

    @FXML
    private Button largeSize;

    @FXML
    private Text mainPrice;

    @FXML
    private Button mediumSize;

    @FXML
    private Button minusBTN;

    @FXML
    private Button plusBTN;

    @FXML
    private Button smallSize;

    @FXML
    private TextArea textAreaQuant;
    private cart cartlist;
    private double basePrice = 39;
    private CartListener cartListener;

    public void setData(cart carts, CartListener cartListener) {
        this.cartlist = carts;
        this.cartListener = cartListener;

        if (hotBTN != null) {
            hotBTN.setOnAction(event -> cartListener.onHandleMood(event));
        }
        if (iceBTN != null) {
            iceBTN.setOnAction(event -> cartListener.onHandleMood(event));
        }
        if (smallSize != null) {
            smallSize.setOnAction(event -> cartListener.handleSize(event));
        }
        if (mediumSize != null) {
            mediumSize.setOnAction(event -> cartListener.handleSize(event));
        }
        if (largeSize != null) {
            largeSize.setOnAction(event -> cartListener.handleSize(event));
        }
        if (minusBTN != null) {
            minusBTN.setOnAction(event -> cartListener.handleQuantity(event));
        }
        if (plusBTN != null) {
            plusBTN.setOnAction(event -> cartListener.handleQuantity(event));
        }
        if (addTocartBTN != null) {
            addTocartBTN.setOnAction(event -> cartListener.handleAddToCart(carts));
        }

        Image image = new Image(getClass().getResourceAsStream(cartlist.getImage()));
        imgView.setImage(image);
        COFFENAME.setText(cartlist.getCoffeName());
        COFFEDESCRIPTION.setText(cartlist.getCoffeDescription());
        mainPrice.setText(String.format("₱%.2f", basePrice));
    }

    public Button getHotBTN() {
        return hotBTN;
    }

    public Button getIceBTN() {
        return iceBTN;
    }

    public Button getSmallSize() {
        return smallSize;
    }

    public Button getMediumSize() {
        return mediumSize;
    }

    public Button getLargeSize() {
        return largeSize;
    }

    public Button getMinusBTN() {
        return minusBTN;
    }

    public Button getPlusBTN() {
        return plusBTN;
    }

    public Text getSize() {
        return SIZE;
    }
}
