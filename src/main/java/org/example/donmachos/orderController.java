package org.example.donmachos;

import javafx.scene.image.ImageView;

public class orderController{
    private String coffeename;
    private ImageView coffeImageView;
    private int quantity;
    private double price;
    private String description;

    public orderController(String coffeename, ImageView coffeImageView, int quantity, double price, String description) {
        this.coffeename = coffeename;
        this.coffeImageView = coffeImageView;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public String getCoffeename() {
        return coffeename;
    }

    public ImageView getCoffeImageView() {
        return coffeImageView;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
