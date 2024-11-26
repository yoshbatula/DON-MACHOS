package org.example.donmachos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class menuOrderCONT  {

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
    private VBox cartContent;

    @FXML
    private TextArea textAreaQuant;


    private cart cartlist;
    private int quantity = 1;
    private double basePrice = 39;
    private String temperature = "Hot";

    public void setData(cart carts) {
        System.out.println("Setting data for: " + carts.getCoffeName());
        this.cartlist = carts;
        Image image = new Image(getClass().getResourceAsStream(cartlist.getImage()));
        imgView.setImage(image);
        COFFENAME.setText(cartlist.getCoffeName());
        COFFEDESCRIPTION.setText(cartlist.getCoffeDescription());
        mainPrice.setText(String.format("₱%.2f", basePrice));
    }

    public void handleHotColdSelection(ActionEvent event) {
        if (event.getSource() == hotBTN) {
            temperature = "Hot";
            SIZE.setText("Hot");
        } else if (event.getSource() == iceBTN) {
            temperature = "Cold";
            SIZE.setText("Cold");
        }

        updatePrice();
    }

    public void handleSizeSelection(ActionEvent event) {
        if (event.getSource() == smallSize) {
            basePrice = 39;
            SIZE.setText("Small");
        } else if (event.getSource() == mediumSize) {
            basePrice = 69;
            SIZE.setText("Medium");
        } else if (event.getSource() == largeSize) {
            basePrice = 99;
            SIZE.setText("Large");
        }
        updatePrice();
    }

    public void handleQuantityChange(ActionEvent event) {
        if (event.getSource() == minusBTN && quantity > 1) {
            quantity--;
        } else if (event.getSource() == plusBTN) {
            quantity++;
        }

        updatePrice();

        textAreaQuant.setText(String.valueOf(quantity));
    }


    private void updatePrice() {
        double totalPrice = basePrice * quantity;
        mainPrice.setText(String.format("₱%.2f", totalPrice));
    }

    public void handleAddToCart(ActionEvent event) {
        if (cartlist != null) {
            cartlist.setQuantity(quantity);
            cartlist.setSize(SIZE.getText());
            cartlist.setPrice(basePrice * quantity);

            System.out.println("Adding to cart: " + cartlist.getCoffeName());
            addCartItemToCartUI(cartlist);
        } else {
            System.out.println("Cartlist is null.");
        }
    }

    private void addCartItemToCartUI(cart item) {
        HBox cartItem = new HBox();
        cartItem.setSpacing(10);

        Text itemDetails = new Text(
                item.getCoffeName() + " (" + item.getSize() + ") - Qty: " + item.getQuantity() + " - ₱" + item.getPrice()
        );

        Button removeButton = new Button("Remove");
        removeButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        removeButton.setOnAction(e -> cartContent.getChildren().remove(cartItem));

        cartItem.getChildren().addAll(itemDetails, removeButton);

        cartContent.getChildren().add(cartItem);
    }
}
