package org.example.donmachos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class orderCont implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<cart> sortedList = prioritizeBestSellers(getData());
        int column = 0;
        int row = 0;

        for (cart item : sortedList) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("orderContainer.fxml"));
                AnchorPane pane = fxmlLoader.load();

                menuOrderCONT ordercont = fxmlLoader.getController();
                ordercont.setData(item);

                if (column == 2) {
                    column = 0;
                    row++;
                }
                grid.add(pane, column++, row);
                GridPane.setMargin(pane, new Insets(15));
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
