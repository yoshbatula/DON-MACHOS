    package org.example.donmachos;

    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.stage.Stage;

    import java.io.IOException;

    public class HOMECONTROLLER {

        @FXML
        private Button orderBTN;

        @FXML
        private Button homeBTN;

        @FXML
        private Button menuBTN;

        @FXML
        private Button ordersBTN;

        @FXML
        private Button ordernowBTN;

        public void switchForm(ActionEvent event) throws IOException {

            if (event.getSource() == ordersBTN) {
                Stage window = (Stage) ordersBTN.getScene().getWindow();
                window.close();

                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MENU.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("MENU INTERFACE");
                stage.setScene(scene);
                stage.show();

            } else if (event.getSource() == menuBTN) {
                Stage window = (Stage) menuBTN.getScene().getWindow();
                window.close();

                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MENU.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("MENU INTERFACE");
                stage.setScene(scene);
                stage.show();

            } else if (event.getSource() == ordernowBTN) {
                Stage window = (Stage) ordernowBTN.getScene().getWindow();
                window.close();

                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MENU.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("MENU INTERFACE");
                stage.setScene(scene);
                stage.show();
            }
        }

        public Button getOrdernowBTN() {
            return ordernowBTN;
        }
    }
