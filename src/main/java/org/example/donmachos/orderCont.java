package org.example.donmachos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
            public void onHandleMood(ActionEvent event) {

            }

            @Override
            public void handleSize(ActionEvent event) {
                Button source = (Button) event.getSource();
                String size = source.getText();
                double price = switch (size) {
                    case "Small" -> 39;
                    case "Medium" -> 69;
                    case "Large" -> 99;
                    default -> 0;
                };
                System.out.println("Selected Size: " + size + " | Price: " + price);
            }

            @Override
            public void handleQuantity(ActionEvent event) {
                Button source = (Button) event.getSource();
                boolean isIncrement = source.getText().equals("+");
                System.out.println("Quantity " + (isIncrement ? "Increased" : "Decreased"));
            }

            @Override
            public void handleAddToCart(cart item) {
                System.out.println("Added to cart: " + item.getCoffeName());
                addCartItemToCartUI(item);
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

                orderContainerCont orderController = fxmlLoader.getController();
                orderController.setData(item, cartListener);

                Button hotBTN = orderController.getHotBTN();
                Button iceBTN = orderController.getIceBTN();
                Button smallSize = orderController.getSmallSize();
                Button mediumSize = orderController.getMediumSize();
                Button largeSize = orderController.getLargeSize();
                Button minusBTN = orderController.getMinusBTN();
                Button plusBTN = orderController.getPlusBTN();
                Button addToCart = orderController.getAddTocartBTN();
                Text mainPrice = orderController.getMainPrice();
                Text Size = orderController.getSize();
                TextArea textAreaQuant = orderController.getTextAreaQuant();

                hotBTN.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        temperature = "Hot";
                        System.out.println(temperature);
                    }
                });

                hotBTN.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        temperature = "Ice";
                        System.out.println(temperature);
                    }
                });

                smallSize.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        basePrice = 39;
                        Size.setText("Small");
                        mainPrice.setText(String.valueOf("₱" + basePrice));
                    }
                });

                mediumSize.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        basePrice = 69;
                        Size.setText("Medium");
                        mainPrice.setText(String.valueOf("₱" + basePrice));
                    }
                });

                largeSize.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        basePrice = 99;
                        Size.setText("Large");
                        mainPrice.setText(String.valueOf("₱" + basePrice));
                    }
                });

                minusBTN.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (quantity > 1) {
                            quantity--;
                            textAreaQuant.setText(String.valueOf(quantity));
                        }
                    }
                });

                plusBTN.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        quantity ++;
                        textAreaQuant.setText(String.valueOf(quantity));
                    }
                });

                addToCart.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        addCartItemToCartUI(item);
                    }
                });

                if (column == 2) {
                    column = 0;
                    row++;
                }
                grid.add(pane, column++, row);
                GridPane.setMargin(pane, new Insets(20));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void addCartItemToCartUI(cart item) {
        HBox cartItem = new HBox();
        cartItem.setSpacing(20);

        Text itemDetails = new Text(
                item.getImage() + item.getCoffeName() + "Qty: " + quantity + " - ₱" + basePrice
        );

        Button removeButton = new Button("Remove");
        removeButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        removeButton.setOnAction(e -> cartContent.getChildren().remove(cartItem));

        cartItem.getChildren().addAll(itemDetails, removeButton);
        cartContent.getChildren().add(cartItem);
    }

    @FXML
    private GridPane grid;
    @FXML
    private ScrollPane scroll;
    @FXML
    private VBox cartContent;

    private String temperature;

    private int basePrice = 39; // default baseprice

    private int quantity = 1; // default quantity

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
            carts.setCoffeName("DON MATCHATOS");
            carts.setCoffeDescription("Pure matcha from Japan, chilled milk, matcha syrup.");
            carts.setBestSeller(true);
            carlist.add(carts);

            carts = new cart();
            carts.setImage("images/10 1.png");
            carts.setCoffeName("MATCHA BERRY");
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
}
