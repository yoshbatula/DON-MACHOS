package org.example.donmachos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

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
        System.out.println("Setting data for: " + carts.getCoffeName());
        this.cartlist = carts;
        this.cartListener = cartListener;
        Image image = new Image(getClass().getResourceAsStream(cartlist.getImage()));
        imgView.setImage(image);
        COFFENAME.setText(cartlist.getCoffeName());
        COFFEDESCRIPTION.setText(cartlist.getCoffeDescription());
        mainPrice.setText(String.format("₱%.2f", basePrice));

        largeSize.setOnAction(event ->{
            cartListener.handleSize(carts);
        });

        mediumSize.setOnAction(event ->{
            cartListener.handleSize(carts);
        });

        smallSize.setOnAction(event ->{
            cartListener.handleSize(carts);
        });

        iceBTN.setOnAction(event ->{
            cartListener.onHandleMood();
        });

        hotBTN.setOnAction(event ->{
            cartListener.onHandleMood();
        });

        minusBTN.setOnAction(event ->{
            cartListener.handleQuantity();
        });

        plusBTN.setOnAction(event ->{
            cartListener.handleQuantity();
        });

        addTocartBTN.setOnAction(event ->{
            cartListener.handleAddToCart();
        });
    }



}
