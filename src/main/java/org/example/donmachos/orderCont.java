package org.example.donmachos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class orderCont implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carlist.addAll(getData());
        int column = 0;
        int row = 0;
        for (int i = 0; i < carlist.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("orderContainer.fxml"));
            try {
                AnchorPane pane = fxmlLoader.load();

                menuOrderCONT ordercont = fxmlLoader.getController();
                ordercont.setData(carlist.get(i));


                if (column == 2) {
                    column = 0;
                    row++;
                }
                grid.add(pane, column++, row);
                GridPane.setMargin(pane, new Insets(10));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    private GridPane grid;
    @FXML
    private ScrollPane scroll;

    @FXML
    private AnchorPane menuITems;

    private List<cart> carlist = new ArrayList<>();

    private List<cart> getData() {
        List<cart> carlist = new ArrayList<>();
        cart carts;

        for (int i = 0; i < 20; i++) {
            carts = new cart();
            carts.setImage("images/9 1.png");
            carts.setCoffeName("CARAMEL\n" +
                    "MACCHIATOS");
            carts.setCoffeDescription("Chilled milk, espresso, and caramel syrup.");
            carlist.add(carts);
        }

        return carlist;
    }

}
