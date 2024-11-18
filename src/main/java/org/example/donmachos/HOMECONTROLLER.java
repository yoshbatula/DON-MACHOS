package org.example.donmachos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;

public class HOMECONTROLLER {


    @FXML
    private Button orderBTN;

    public void switchForm(ActionEvent event) throws IOException {

        if(event.getSource() == orderBTN) {

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MENU.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("MENU INTERFACE");
            stage.setScene(scene);
            stage.show();
        }
    }
}
