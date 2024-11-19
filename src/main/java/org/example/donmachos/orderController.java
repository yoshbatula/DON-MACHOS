package org.example.donmachos;

import javafx.scene.image.ImageView;

public class orderController{
    private String coffeename;
    private ImageView coffeImageView;
    private int quantity;
    private double price;
    private String size;
    private String mood;

    public orderController(String coffeename, ImageView coffeImageView, int quantity, double price, String size, String mood) {
        this.coffeename = coffeename;
        this.coffeImageView = coffeImageView;
        this.quantity = quantity;
        this.price = price;
        this.size = size;
        this.mood = mood;
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

    public String getSize() {
        return size;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}