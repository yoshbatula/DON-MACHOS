package org.example.donmachos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

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


    public void switchform(String fxmlfile) {

    }
}
