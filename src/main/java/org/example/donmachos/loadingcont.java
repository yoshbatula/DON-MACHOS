package org.example.donmachos;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Text;

public class loadingcont implements Initializable {

    @FXML
    private AnchorPane mainComponents;

    @FXML
    private Text loadingText;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        FadeTransition fade = new FadeTransition();
        fade.setNode(loadingText);
        fade.setDuration(Duration.millis(1500));
        fade.setCycleCount(TranslateTransition.INDEFINITE);
        fade.setAutoReverse(true);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        new loadingScreen().start();
    }

    class loadingScreen extends Thread {
        public void run() {
            try {
                Thread.sleep(5000);

                Platform.runLater(new Runnable() {
                    public void run() {
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/org/example/donmachos/LOGIN.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(loadingcont.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();

                        mainComponents.getScene().getWindow().hide();

                    }
                });
            } catch (InterruptedException e) {
                Logger.getLogger(loadingcont.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
