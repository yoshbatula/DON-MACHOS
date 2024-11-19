package org.example.donmachos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class menuController implements Initializable {

    @FXML
    private ImageView DonBarkoIMG;

    @FXML
    private ImageView DonMatchatos;

    @FXML
    private ImageView IceBestSellerBTN;

    @FXML
    private Button LargeBestSellerBTN;

    @FXML
    private ImageView MatchaBerry;

    @FXML
    private Button addCARTBESTSELLER1;

    @FXML
    private Button addCARTBESTSELLER2;

    @FXML
    private Button addCARTBESTSELLER3;

    @FXML
    private Button addCARTBESTSELLER4;

    @FXML
    private ImageView caramelIMG;

    @FXML
    private VBox cartContent;

    @FXML
    private ScrollPane cartScrollPane;

    @FXML
    private ImageView hotBestSellerBTN;

    @FXML
    private Button mediumBestSellerBTN;

    @FXML
    private Button minusBestSellerBTN;

    @FXML
    private Button plusBestSellerBTN;

    @FXML
    private Button smallBestSellerBTN;

    @FXML
    private TextArea textBestSellerQuantity;

    private List<orderController> cartItems = new ArrayList<>();

    private String selectedMood = "Iced";
    private String selectedSize = "Small";
    private int quantity = 1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        addCARTBESTSELLER1.setId("addCARTBESTSELLER1");
        addCARTBESTSELLER2.setId("addCARTBESTSELLER2");
        addCARTBESTSELLER3.setId("addCARTBESTSELLER3");
        addCARTBESTSELLER4.setId("addCARTBESTSELLER4");

        if (DonBarkoIMG.getImage() == null) {
            DonBarkoIMG.setImage(new Image(getClass().getResource("/images/9_4.png").toExternalForm()));
        }
        if (caramelIMG.getImage() == null) {
            caramelIMG.setImage(new Image(getClass().getResource("/images/9_1.png").toExternalForm()));
        }
        if (DonMatchatos.getImage() == null) {
            DonMatchatos.setImage(new Image(getClass().getResource("/images/9_3.png").toExternalForm()));
        }
        if (MatchaBerry.getImage() == null) {
            MatchaBerry.setImage(new Image(getClass().getResource("/images/10_1.png").toExternalForm()));
        }

        addCARTBESTSELLER1.setOnAction(this::addToCart);
        addCARTBESTSELLER2.setOnAction(this::addToCart);
        addCARTBESTSELLER3.setOnAction(this::addToCart);
        addCARTBESTSELLER4.setOnAction(this::addToCart);

    }

    private void addToCart(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        orderController item = null;

        if (sourceButton.getId().equals("addCARTBESTSELLER2")) {
            item = new orderController("Don Darko", DonBarkoIMG, 1, 39.00, selectedSize, selectedMood);
        } else if (sourceButton.getId().equals("addCARTBESTSELLER1")) {
            item = new orderController("Caramel Macchiatos", caramelIMG, 1, 39.00, selectedSize, selectedMood);
        } else if (sourceButton.getId().equals("addCARTBESTSELLER3")) {
            item = new orderController("Don Matchatos", DonMatchatos,1, 39.00, selectedSize, selectedMood);
        } else if (sourceButton.getId().equals("addCARTBESTSELLER4")) {
            item = new orderController("Matcha Berry", MatchaBerry,1, 39.00, selectedSize, selectedMood);
        }

        if (item != null) {
            boolean found = false;

            for (orderController cartItem : cartItems) {
                if (cartItem.getCoffeename().equals(item.getCoffeename()) &&
                        cartItem.getSize().equals(item.getSize()) &&
                        cartItem.getMood().equals(item.getMood())) {
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                    found = true;
                    break;
                }
            }

            if (!found) {
                cartItems.add(item);
            }

            updateCart();
        }
    }

    private void updateCart() {
        cartContent.getChildren().clear();

        for (orderController item : cartItems) {
            HBox cartRow = new HBox();
            cartRow.setSpacing(10);

            ImageView productImage = new ImageView(item.getCoffeImageView().getImage());
            productImage.setFitHeight(50);
            productImage.setFitWidth(50);

            VBox details = new VBox();
            Text productName = new Text(item.getCoffeename());
            Text productDetails = new Text(item.getSize() + " | " + item.getMood());
            details.getChildren().addAll(productName, productDetails);

            VBox quantityPrice = new VBox();
            Text quantity = new Text("x" + item.getQuantity());
            double totalPrice = item.getQuantity() * item.getPrice();
            Text price = new Text("₱" + String.format("%.2f", totalPrice));
            quantityPrice.getChildren().addAll(quantity, price);

            cartRow.getChildren().addAll(productImage, details, quantityPrice);

            cartContent.getChildren().add(cartRow);
        }

    }

}