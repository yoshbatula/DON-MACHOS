package org.example.donmachos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainStructureCont implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private FlowPane contentpane;

    @FXML
    private Button homeBTN;

    @FXML
    private Button menuBTN;

    @FXML
    private Button ordersBTN;

    @FXML
    private Button ordersBTN1;


    public void switchForm(ActionEvent event) throws IOException {
        if (event.getSource() == menuBTN) {
            contentpane.getChildren().clear();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            AnchorPane pane = fxmlLoader.load();

            contentpane.getChildren().add(pane);
        }
    }
}
