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
    List<cartItems> cartModel = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cartListener = new CartListener() {
            @Override
            public void onHandleMood(ActionEvent event) {

            }

            @Override
            public void handleSize(ActionEvent event) {
            }

            @Override
            public void handleQuantity(ActionEvent event) {

            }
            @Override
            public void handleAddToCart(cart item) {
                cartItems existingItem = findItemInCart(cartModel, item, item.getSize(), temperature);
                if (existingItem != null) {
                    existingItem.setQuantity(existingItem.getQuantity() + quantity);
                    existingItem.setPrice(existingItem.getPrice() + (basePrice * quantity));
                } else {
                    cartItems cartItem = new cartItems();
                    cartItem.setCoffeNames(item.getCoffeName());
                    cartItem.setMood(temperature);
                    cartItem.setSize(cartItem.getSize());
                    cartItem.setQuantity(quantity);
                    cartItem.setPrice((double) (basePrice * quantity));
                    cartItem.setImage(item.getImage());
                    cartModel.add(cartItem);
                }
                updateCartUI(cartModel);
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

                iceBTN.setOnAction(new EventHandler<ActionEvent>() {
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
                        cartListener.handleAddToCart(item);
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

    private cartItems findItemInCart(List<cartItems> cartModel, cart item, String selectedSize, String selectedMood) {
        for (cartItems cartItem : cartModel) {
            if (cartItem.getCoffeNames().equals(item.getCoffeName()) &&
                    cartItem.getSize().equals(selectedSize) &&
                    cartItem.getMood().equals(selectedMood)) {
                return cartItem;
            }
        }
        return null;
    }

    private void updateCartUI(List<cartItems> cartModel) {
        cartContent.getChildren().clear();
        for (cartItems cartItem : cartModel) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("addtocart.fxml"));
                AnchorPane cartItemPane = fxmlLoader.load();

                addtocartcont cartController = fxmlLoader.getController();
                cartController.setData(cartItem);

                cartContent.getChildren().add(cartItemPane);
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
    private VBox cartContent;

    private String temperature = "Hot";

    private int basePrice = 39;

    private int quantity = 1;

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
