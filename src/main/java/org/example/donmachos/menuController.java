package org.example.donmachos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
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
    private ImageView DonMatchatos1;

    @FXML
    private Button IceBestSellerBTN;

    @FXML
    private Button LargeBestSellerBTN;

    @FXML
    private ImageView MatchaBerry;

    @FXML
    private ImageView MatchaBerry1;

    @FXML
    private Button addCARTBESTSELLER1;

    @FXML
    private Button addCARTBESTSELLER2;

    @FXML
    private Button addCARTBESTSELLER21;

    @FXML
    private Button addCARTBESTSELLER3;

    @FXML
    private Button addCARTBESTSELLER31;

    @FXML
    private Button addCARTBESTSELLER4;

    @FXML
    private Button addCARTBESTSELLER41;

    @FXML
    private ImageView caramelIMG;

    @FXML
    private VBox cartContent;

    @FXML
    private ScrollPane cartScrollPane;

    @FXML
    private Button dondarkoHOT;

    @FXML
    private Button dondarkoICE;

    @FXML
    private Button dondarkoL;

    @FXML
    private Button dondarkoM;

    @FXML
    private Button dondarkoS;

    @FXML
    private Button dondarkominus;

    @FXML
    private Button dondarkoplus;

    @FXML
    private Button hotBestSellerBTN;

    @FXML
    private Button mediumBestSellerBTN;

    @FXML
    private Button minusBestSellerBTN;

    @FXML
    private Button plusBestSellerBTN;

    @FXML
    private Button smallBestSellerBTN;

    @FXML
    private Text subtotaltext;

    @FXML
    private TextArea textBestSellerQuantity;

    @FXML
    private Text totalText;

    @FXML
    private Button homeBTN;

    @FXML
    private TextArea dondarkoQuantity;


    private List<orderController> cartItems = new ArrayList<>();

    private String selectedMood = "Iced";
    private String selectedSize = "Small";
    private int quantity = 1;
    private int quantity1= 1;
    private double price;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dondarkoHOT.setOnAction(this::selectMood);
        dondarkoICE.setOnAction(this::selectMood);

        dondarkoS.setOnAction(this::selectSize);
        dondarkoM.setOnAction(this::selectSize);
        dondarkoL.setOnAction(this::selectSize);

        dondarkominus.setOnAction(this::adjustQuantity);
        dondarkoplus.setOnAction(this::adjustQuantity);

        hotBestSellerBTN.setOnAction(this::selectMood);
        IceBestSellerBTN.setOnAction(this::selectMood);

        smallBestSellerBTN.setOnAction(this::selectSize);
        mediumBestSellerBTN.setOnAction(this::selectSize);
        LargeBestSellerBTN.setOnAction(this::selectSize);

        minusBestSellerBTN.setOnAction(this::adjustQuantity);
        plusBestSellerBTN.setOnAction(this::adjustQuantity);

        textBestSellerQuantity.setText(String.valueOf(quantity));
        dondarkoQuantity.setText(String.valueOf(quantity));

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

    private void selectMood(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        if (sourceButton.equals(hotBestSellerBTN)) {
            selectedMood = "Hot";
        } else if (sourceButton.equals(IceBestSellerBTN)) {
            selectedMood = "Iced";
        } else if (sourceButton.equals(dondarkoHOT)) {
            selectedMood = "Hot";
        } else if (sourceButton.equals(dondarkoICE)) {
            selectedMood = "Iced";
        }

        System.out.println("Selected Mood: " + selectedMood);
    }

    private void selectSize(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        if (sourceButton.equals(smallBestSellerBTN)) {
            selectedSize = "Small";
            price = 39.00;
        } else if (sourceButton.equals(mediumBestSellerBTN)) {
            selectedSize = "Medium";
            price = 69.00;
        } else if (sourceButton.equals(LargeBestSellerBTN)) {
            selectedSize = "Large";
            price = 99.00;
        } else if (sourceButton.equals(dondarkoS)) {
            selectedSize = "Small";
            price = 39.00;
        } else if (sourceButton.equals(dondarkoM)) {
            selectedSize = "Medium";
            price = 69.00;
        } else if (sourceButton.equals(dondarkoL)) {
            selectedSize = "Large";
            price = 99.00;
        }

        System.out.println("Selected Size: " + selectedSize);
        System.out.println("Price: ₱" + price);
    }

    private void adjustQuantity(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        if (sourceButton.equals(minusBestSellerBTN) && quantity > 1) {
            quantity--;
            System.out.println("Minus button clicked: " + quantity);
        } else if (sourceButton.equals(plusBestSellerBTN)) {
            quantity++;
            System.out.println("Plus button clicked: " + quantity);
        } else if (sourceButton.equals(dondarkominus) && quantity1 > 1) {
            quantity1--;
            System.out.println("Minus button clicked: " + quantity1);
        } else if (sourceButton.equals(dondarkoplus)) {
            quantity1++;
            System.out.println("Plus button clicked: " + quantity1);
        }

        orderController selectedItem = null;
        for (orderController item : cartItems) {

            if (item.getCoffeename().equals("Don Darko")) {
                selectedItem = item;
                break;
            }
        }

        if (selectedItem != null) {

            if (sourceButton.equals(minusBestSellerBTN) && selectedItem.getQuantity() > 1) {
                selectedItem.setQuantity(selectedItem.getQuantity() - 1);
            } else if (sourceButton.equals(plusBestSellerBTN)) {
                selectedItem.setQuantity(selectedItem.getQuantity() + 1);
            }

            updateCart();
        }
        textBestSellerQuantity.setText(String.valueOf(quantity));
        dondarkoQuantity.setText(String.valueOf(quantity1));
    }

    private void addToCart(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        orderController item = null;

        if (sourceButton.getId().equals("addCARTBESTSELLER2")) {
            item = new orderController("Don Darko", DonBarkoIMG, quantity, price, selectedSize, selectedMood);
        } else if (sourceButton.getId().equals("addCARTBESTSELLER1")) {
            item = new orderController("Caramel Macchiatos", caramelIMG, quantity, price, selectedSize, selectedMood);
        } else if (sourceButton.getId().equals("addCARTBESTSELLER3")) {
            item = new orderController("Don Matchatos", DonMatchatos, quantity, price, selectedSize, selectedMood);
        } else if (sourceButton.getId().equals("addCARTBESTSELLER4")) {
            item = new orderController("Matcha Berry", MatchaBerry, quantity, price, selectedSize, selectedMood);
        }

        if (item != null) {
            boolean found = false;


            for (orderController cartItem : cartItems) {
                if (cartItem.getCoffeename().equals(item.getCoffeename()) &&
                        cartItem.getSize().equals(item.getSize()) &&
                        cartItem.getMood().equals(item.getMood())) {
                    cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
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

        double subtotal = 0.0;

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

            subtotal += totalPrice;
        }

        subtotaltext.setText("₱" + String.format("%.2f", subtotal));
        totalText.setText("₱" + String.format("%.2f", subtotal));

        javafx.application.Platform.runLater(() -> cartScrollPane.setVvalue(1.0));
    }

    public void switchform(ActionEvent event) throws IOException {

        if (event.getSource() == homeBTN) {

            Stage window = (Stage) homeBTN.getScene().getWindow();
            window.close();

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HOMEINTERFACE.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("HOME INTERFACE");
            stage.setScene(scene);
            stage.show();
        }
    }
}