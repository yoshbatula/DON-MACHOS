package org.example.donmachos;

public class menuCONTAINER {

    private String coffeename;
    private String coffeIMG;
    private int quantity;
    private double price;
    private String description;

    public menuCONTAINER(String coffeename, String coffeIMG, int quantity, double price, String description) {
        this.coffeename = coffeename;
        this.coffeIMG = coffeIMG;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public String getCoffeename() {
        return coffeename;
    }

    public void setCoffeename(String coffeename) {
        this.coffeename = coffeename;
    }

    public String getCoffeIMG() {
        return coffeIMG;
    }

    public void setCoffeIMG(String coffeIMG) {
        this.coffeIMG = coffeIMG;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}