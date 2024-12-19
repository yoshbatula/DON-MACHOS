package org.example.donmachos;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.print.PrinterJob; // Correct import
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import javafx.embed.swing.SwingFXUtils;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class orderSummaryController4 {

    @FXML
    private Text addressText;

    @FXML
    private Text cellphoneText;

    @FXML
    private Text cityText;

    @FXML
    private Text nameText;

    @FXML
    private GridPane orderCartsSumarry;

    @FXML
    private Text paymentMethodText;

    @FXML
    private Button proceedBTN4;

    @FXML
    private Text subtotaltext;

    @FXML
    private Text totalText;

    @FXML
    private Button ProccedTOBTN;

    private orderSumarryController3 orderSummary;

    private List<cartItems> cartModel;
    private cartItems cartItem;
    private orders order;
    private String PaymentMethod;

    @FXML
    private AnchorPane ReceiptLayout;

    public void setData(double subtotal, double total, orders order, String paymentMethod, List<cartItems> cartModel, cartItems cartItem) {
        this.order = order;
        this.PaymentMethod = paymentMethod;
        this.cartModel = cartModel;
        this.cartItem = cartItem;

        paymentMethodText.setText(paymentMethod);
        subtotaltext.setText(String.format("₱%.2f", subtotal));
        totalText.setText(String.format("₱%.2f", total));

        System.out.println("OrderSummaryController4 - Subtotal: " + subtotal);
        System.out.println("OrderSummaryController4 - Total: " + total);

        SummaryUpdateForUI();
    }

    public void SummaryUpdateForUI() {
        orderCartsSumarry.getChildren().clear();
        int row = 0;
        int column = 0;

        for (cartItems item : cartModel) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("summaryModel.fxml"));
                AnchorPane pane = fxmlLoader.load();

                SummaryModelController controller = fxmlLoader.getController();
                controller.setData(cartModel, item);

                orderCartsSumarry.add(pane, column, row);
                GridPane.setMargin(pane, new Insets(10));

                if (column == 0) {
                    row++;
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Error populating cart items in UI", e);
            }
        }
    }

    @FXML
    private void handleProceedButton() {
        PrintReceipt();
        SaveReceiptAsImage();
    }

    public void PrintReceipt() {

        PrinterJob printerJob = PrinterJob.createPrinterJob();

        if (printerJob != null) {
            boolean proceed = printerJob.showPrintDialog(ReceiptLayout.getScene().getWindow());
            if (proceed) {
                boolean success = printerJob.printPage(ReceiptLayout);
                if (success) {
                    printerJob.endJob();
                } else {
                    System.out.println("Printing failed.");
                }
            } else {
                System.out.println("Print job canceled.");
            }
        } else {
            System.out.println("Could not create a PrinterJob.");
        }
    }

    public void ProceedToThankYouPage() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Thankyou.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();

        Stage window = (Stage) ProccedTOBTN.getScene().getWindow();
        window.close();

    }
    public void SaveReceiptAsImage() {
        try {
            WritableImage snapshot = ReceiptLayout.snapshot(new SnapshotParameters(), null);

            File file = new File("receipt.png");

            if (ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", file)) {
                System.out.println("Receipt saved as an image: " + file.getAbsolutePath());
            } else {
                System.out.println("Failed to save the receipt as an image.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while saving the receipt as an image: " + e.getMessage());
        }
    }
}



