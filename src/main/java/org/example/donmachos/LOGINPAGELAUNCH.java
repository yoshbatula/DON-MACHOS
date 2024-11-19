package org.example.donmachos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LOGINPAGELAUNCH extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LOGINPAGELAUNCH.class.getResource("HOMEINTERFACE.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("LOGIN FORM!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}