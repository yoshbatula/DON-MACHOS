package org.example.donmachos;

import javafx.scene.image.ImageView;

public class cartItems {

    private String imageCoffe;
    private String CoffeNames;
    private String Size;
    private String Mood;
    private int quantity;
    private Double price;

    public String getImage() {
        return imageCoffe;
    }

    public void setImage(String image) {
        this.imageCoffe = image;
    }

    public String getCoffeNames() {
        return CoffeNames;
    }

    public void setCoffeNames(String coffeNames) {
        CoffeNames = coffeNames;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getMood() {
        return Mood;
    }

    public void setMood(String mood) {
        Mood = mood;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
