package org.example.donmachos;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ThankyouController {

    @FXML
    private Button BackToHomeBTN;

    public void BackToHome() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainStructure.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();

        Stage window = (Stage) BackToHomeBTN.getScene().getWindow();
        window.close();
    }
}
