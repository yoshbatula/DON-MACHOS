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
public class menuOrderCONT {

    @FXML
    private Text COFFEDESCRIPTION;

    @FXML
    private Text COFFENAME;

    @FXML
    private ImageView imgView;

    private cart cartlist;

    public void setData(cart carts) {
        this.cartlist = carts;
        Image image = new Image(getClass().getResourceAsStream(cartlist.getImage()));
        imgView.setImage(image);
        COFFENAME.setText(cartlist.getCoffeName());
        COFFEDESCRIPTION.setText(cartlist.getCoffeDescription());
    }

}
