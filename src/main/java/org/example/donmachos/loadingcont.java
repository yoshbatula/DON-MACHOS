package org.example.donmachos;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loadingcont implements Initializable {

    @FXML
    private AnchorPane mainComponents;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new Splash().start();
    }

    class Splash extends Thread {
        public void run() {
            try {
                Thread.sleep(5000);

                Platform.runLater(new Runnable() {
                    public void run() {
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("loadingscreen"));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();
                    }
                });
                Parent root = FXMLLoader.load(getClass().getResource("loadingscreen"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();

                mainComponents.getScene().getWindow().hide();


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
