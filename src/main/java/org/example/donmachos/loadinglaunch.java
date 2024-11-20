package org.example.donmachos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class loadinglaunch extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("loadinglaunch.fxml"));
        Scene scene = new Scene(root);
        stage.initModality(Modality.NONE);
        stage.setScene(scene);
        stage.show();
    }
}
