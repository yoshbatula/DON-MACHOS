package org.example.donmachos;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

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

                cartItems existingItem = findItemInCart(cartModel, item, selectedSize, temperature);
                if (existingItem != null) {
                    existingItem.setQuantity(existingItem.getQuantity() + quantity);
                    existingItem.setPrice(existingItem.getPrice() + (basePrice * quantity));
                } else {
                    cartItems cartItem = new cartItems();
                    cartItem.setCoffeNames(item.getCoffeName());
                    cartItem.setMood(temperature);
                    cartItem.setSize(selectedSize);
                    cartItem.setQuantity(quantity);
                    cartItem.setPrice(Double.valueOf(basePrice * quantity));
                    cartItem.setImage(item.getImage());
                    cartModel.add(cartItem);
                }
                updateSubtotalAndTotal();
                updateCartUI(cartModel);
            }
        };

        List<cart> sortedList = prioritizeBestSellers(getData());
        int column = 0;
        int row = 0;

        for (cart item : sortedList) {
            try {

                cartContent.getChildren().clear();
                grid.getColumnConstraints().clear();
                grid.getRowConstraints().clear();

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
                        selectedSize = "Small";
                        Size.setText(selectedSize);
                        mainPrice.setText(String.valueOf("₱" + basePrice));
                    }
                });

                mediumSize.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        basePrice = 69;
                        selectedSize = "Medium";
                        Size.setText(selectedSize);
                        mainPrice.setText(String.valueOf("₱" + basePrice));
                    }
                });

                largeSize.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        basePrice = 99;
                        selectedSize = "Large";

                        Size.setText(selectedSize);
                        mainPrice.setText("₱" + basePrice);

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



                GridPane.setMargin(pane, new Insets(10));
                grid.add(pane, column++, row);

                if (column == 2) {
                    column = 0;
                    row++;
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private cartItems findItemInCart(List<cartItems> cartModel, cart item, String selectedSize, String selectedMood) {
        for (cartItems cartItem : cartModel) {
            if (cartItem.getCoffeNames().equals(item.getCoffeName()) &&
                    (cartItem.getSize() != null && cartItem.getSize().equals(selectedSize)) &&
                    (cartItem.getMood() != null && cartItem.getMood().equals(selectedMood))) {
                return cartItem;
            }
        }
        return null;
    }

    private void updateSubtotalAndTotal() {
        double subtotalAmount = 0;
        double totalAmount = 0;

        for (cartItems cartItem : cartModel) {
            double itemSubtotal = cartItem.getPrice();
            subtotalAmount += itemSubtotal;
            totalAmount += itemSubtotal;
        }


        subtotaltext.setText("₱" + String.format("%.2f", subtotalAmount));
        totalText.setText("₱" + String.format("%.2f", totalAmount));
    }

    private void removeItemFromCart(cartItems cartItemToRemove) {
        System.out.println("Before removal: " + cartModel.size() + " items.");
        boolean removed = cartModel.removeIf(cartItem -> cartItem.equals(cartItemToRemove));
        if (removed) {
            System.out.println("Item removed successfully.");
        } else {
            System.out.println("Failed to remove item. Check equality logic.");
        }
        System.out.println("After removal: " + cartModel.size() + " items.");
        updateSubtotalAndTotal();
        updateCartUI(cartModel);
    }

    private void updateCartUI(List<cartItems> cartModel) {
        System.out.println("CartContent children before clear: " + cartContent.getChildren().size());
        cartContent.getChildren().clear();
        System.out.println("CartContent children after clear: " + cartContent.getChildren().size());

        System.out.println("Grid children before clear: " + gridAddCart.getChildren().size());
        gridAddCart.getChildren().clear();
        System.out.println("Grid children after clear: " + gridAddCart.getChildren().size());

        gridAddCart.getRowConstraints().clear();

        System.out.println("CartContent cleared. Updating cart UI with " + cartModel.size() + " items.");

        int column = 0;
        int row = 0;

        for (cartItems cartItem : cartModel) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("addtocartModel.fxml"));
                AnchorPane cartItemPane = fxmlLoader.load();

                addtocartcont cartController = fxmlLoader.getController();
                cartController.setData(cartItem);

                Button removeBTN = cartController.getRemoveBTN();
                removeBTN.setOnAction(event -> removeItemFromCart(cartItem));

                cartOrderBTN.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (!cartModel.isEmpty()) {
                            try {
                                FXMLLoader fxmlLoader = new FXMLLoader();
                                fxmlLoader.setLocation(getClass().getResource("ORDERING.fxml"));
                                AnchorPane summaryPane = fxmlLoader.load();

                                summaryController controller = fxmlLoader.getController();
                                controller.setData(getSubtotal(), getTotal(), cartModel);

                                parentContainer.getChildren().clear();
                                parentContainer.getChildren().add(summaryPane);

                                AnchorPane.setTopAnchor(summaryPane, 0.0);
                                AnchorPane.setRightAnchor(summaryPane, 0.0);
                                AnchorPane.setBottomAnchor(summaryPane, 0.0);
                                AnchorPane.setLeftAnchor(summaryPane, 0.0);

                            } catch (IOException e) {
                                e.printStackTrace();
                                throw new RuntimeException("Failed to load summary.fxml", e);
                            }
                        } else {
                            alert.setAlertType(Alert.AlertType.ERROR);
                            alert.setTitle("CART IS EMPTY");
                            alert.setHeaderText(null);
                            alert.setContentText("Cart is empty");
                            alert.show();
                        }
                    }
                });


                gridAddCart.add(cartItemPane, column, row);
                GridPane.setMargin(cartItemPane, new Insets(10));

                if (column == 0) {
                    row++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        cartContent.requestLayout();
        gridAddCart.requestLayout();
    }

    private double getSubtotal() {
        double subtotal = 0;
        for (cartItems item : cartModel) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }

    private double getTotal() {

        return getSubtotal();
    }
    private Alert alert;

    @FXML
    private Button cartOrderBTN;

    @FXML
    private GridPane orderSumarryGrid;

    @FXML
    private Button homeBTN;

    @FXML
    private Button orderBTN;

    @FXML
    private GridPane gridAddCart;
    @FXML
    private Text subtotaltext;

    @FXML
    private Text totalText;

    @FXML
    private GridPane grid;
    @FXML
    private ScrollPane scroll;
    @FXML
    private VBox cartContent;

    @FXML
    private AnchorPane menuContainer;

    @FXML
    private AnchorPane parentContainer;



    private String temperature = "Hot";

    private int basePrice = 39;

    private int quantity = 1;

    private String selectedSize = "Small";


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

            carts = new cart();
            carts.setImage("images/9 5.png");
            carts.setCoffeName("DONYA BERRY");
            carts.setCoffeDescription("Real strawberry fruit, chilled milk, strawberry syrup.");
            carts.setBestSeller(true);
            carlist.add(carts);

            carts = new cart();
            carts.setImage("images/10 3.png");
            carts.setCoffeName("BLACK FOREST");
            carts.setCoffeDescription("Dark chocolate, strawberry syrup, milk.");
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
