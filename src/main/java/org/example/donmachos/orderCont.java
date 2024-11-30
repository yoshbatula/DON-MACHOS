package org.example.donmachos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class orderCont implements Initializable {

    private CartListener cartListener;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cartListener = new CartListener() {
            @Override
            public void onHandleMood() {
                System.out.println("Mood changed!");
            }

            @Override
            public void handleSize(cart carts) {
                System.out.println("Size changed for: " + carts.getCoffeName());
            }

            @Override
            public void handleQuantity() {
                System.out.println("Quantity changed!");
            }

            @Override
            public void handleAddToCart() {
                System.out.println("Item added to cart!");
            }
        };

        List<cart> sortedList = prioritizeBestSellers(getData());
        int column = 0;
        int row = 0;

        for (cart item : sortedList) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("orderContainer.fxml"));
                AnchorPane pane = fxmlLoader.load();

                orderContainerCont ordercont = fxmlLoader.getController();
                ordercont.setData(item, cartListener);

                if (column == 2) {
                    column = 0;
                    row++;
                }
                grid.add(pane, column++, row);
                GridPane.setMargin(pane, new Insets(25));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @FXML
    private GridPane grid;
    @FXML
    private ScrollPane scroll;

    @FXML
    private AnchorPane menuItems;

    @FXML
    private VBox cartContent;

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
    private Text SIZE;

    @FXML
    private Button addTocartBTN;

    @FXML
    private Button hotBTN;

    @FXML
    private Button iceBTN;



    @FXML
    private TextArea textAreaQuant;


    private cart cartlist;
    private int quantity = 1;
    private double basePrice = 39;
    private String temperature = "Hot";

    private List<cart> carlist = new ArrayList<>();

    private List<cart> getData() {
        List<cart> carlist = new ArrayList<>();
        cart carts;

        for (int i = 0; i < 10; i++) {
            carts = new cart();
            carts.setImage("images/9 1.png");
            carts.setCoffeName("CARAMEL MACCHIATOS");
            carts.setCoffeDescription("Chilled milk, espresso, and caramel syrup.");
            carts.setBestSeller(true);
            carlist.add(carts);

            carts = new cart();
            carts.setImage("images/9 4.png");
            carts.setCoffeName("DON DARKO");
            carts.setCoffeDescription("High-quality dark chocolate, chocolate syrup.");
            carts.setBestSeller(true);
            carlist.add(carts);

            carts = new cart();
            carts.setImage("images/9 3.png");
            carts.setCoffeName("DON\n" +
                    "MATCHATOS");
            carts.setCoffeDescription("Pure matcha from Japan, chilled milk, matcha syrup.");
            carts.setBestSeller(true);
            carlist.add(carts);

            carts = new cart();
            carts.setImage("images/10 1.png");
            carts.setCoffeName("MATCHA\n" +
                    "BERRY");
            carts.setCoffeDescription("Matcha, strawberry extract syrup, chilled milk.");
            carts.setBestSeller(true);
            carlist.add(carts);
        }

        return carlist;
    }

    private List<cart> prioritizeBestSellers(List<cart> items) {
        List<cart> bestSellers = new ArrayList<>();
        List<cart> others = new ArrayList<>();

        for (cart item : items) {
            if (item.isBestSeller()) {
                bestSellers.add(item);
            } else {
                others.add(item);
            }
        }

        bestSellers.addAll(others);
        return bestSellers;
    }

    public void handleHotColdSelection(ActionEvent event) {
        if (event.getSource() == hotBTN) {
            temperature = "Hot";
            SIZE.setText("Hot");
            System.out.println(temperature);
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
