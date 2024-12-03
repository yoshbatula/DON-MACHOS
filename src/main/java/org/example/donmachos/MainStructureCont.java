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
import javafx.util.Duration;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainStructureCont implements Initializable {

    // Removed the Map to always reload the views fresh each time
    // private final Map<String, AnchorPane> loadedViews = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            // Initially loading the default view
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

    // A method to switch views
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
                // Add other cases if necessary for other views
                default:
                    throw new IllegalArgumentException("Unknown view: " + viewName);
            }

            // If the pane was successfully loaded, clear the content and add the new view
            if (pane != null) {
                contentpane.getChildren().clear();
                contentpane.getChildren().add(pane);

                // Apply fade transition for smooth switching
                FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), pane);
                fadeTransition.setFromValue(0.0);
                fadeTransition.setToValue(1.0);
                fadeTransition.play();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Switches to a different view based on which button is pressed
    public void switchForm(ActionEvent event) {
        if (event.getSource() == menuBTN) {
            switchToView("MENU"); // Switches to the "MENU" view
        } else if (event.getSource() == homeBTN) {
            switchToView("HOMEINTERFACE"); // Switches to the "HOMEINTERFACE" view
        } else if (event.getSource() == ordersBTN) {
            switchToView("ORDERING"); // Switches to the "ORDERING" view

        }
    }
}