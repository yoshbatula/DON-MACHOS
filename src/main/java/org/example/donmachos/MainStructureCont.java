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
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainStructureCont implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            // Initial view setup (first view to load)
            switchToView("HOMEINTERFACE");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // A method to load an FXML file and return its corresponding AnchorPane
    private AnchorPane loadFXML(String fxmlFileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
        return fxmlLoader.load();
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

    @FXML
    private Button orderNOWBTN;

    HOMECONTROLLER hc = new HOMECONTROLLER();

    private void switchToView(String viewName) {
        AnchorPane pane = null;
        try {
            switch (viewName) {
                case "HOMEINTERFACE":
                    pane = loadFXML("HOMEINTERFACE.fxml");
                    break;
                case "MENU":
                    pane = loadFXML("MENU.fxml");
                    break;
                case "ORDERING":
                    pane = loadFXML("ORDERING.fxml");
                    break;

                default:
                    throw new IllegalArgumentException("Unknown view: " + viewName);
            }

            if (pane != null) {
                contentpane.getChildren().clear();
                contentpane.getChildren().add(pane);

                FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), pane);
                fadeTransition.setFromValue(0.0);
                fadeTransition.setToValue(1.0);

                TranslateTransition slideTransition = new TranslateTransition(Duration.millis(500), pane);
                slideTransition.setFromX(contentpane.getWidth());
                slideTransition.setToX(0);

                fadeTransition.play();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == menuBTN) {
            switchToView("MENU");
        } else if (event.getSource() == homeBTN) {
            switchToView("HOMEINTERFACE");
        } else if (event.getSource() == ordersBTN) {
            switchToView("ORDERING");
        } else if (event.getSource() == ordersBTN1) {
            switchToView("ORDERING");
        } else if (event.getSource() == hc.getOrdernowBTN()) {
            switchToView("ORDERING");
        }
    }
}
