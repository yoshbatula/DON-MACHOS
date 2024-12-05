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
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.example.donmachos.singleton.UserSingleton;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainStructureCont implements Initializable {

    private User user;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserSingleton userSingleton = UserSingleton.getInstance();
        try {
            switchToView("HOMEINTERFACE");
            usernameLabel.setText(userSingleton.getUsername());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

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

    @FXML
    private Label usernameLabel;


    @FXML
    private Button hamburgerBTN;


    @FXML
    private AnchorPane hamburgerContainer;


    @FXML
    public void HamburgerSwitch(ActionEvent event) throws IOException {
        try {

            hamburgerContainer.getChildren().clear();

            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("hamburgermenu.fxml"));
            AnchorPane pane = fxmlloader.load();

            hamburgerContainer.getChildren().add(pane);

            if (hamburgerContainer == null) {
                System.out.println("hamburgerContainer is null");
            }


//            TranslateTransition slideTransition = new TranslateTransition(Duration.millis(500), pane);
//            slideTransition.setFromX(-pane.getWidth());
//            slideTransition.setToX(0);
//            slideTransition.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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
        }
    }
}
