package org.example.donmachos;

public class order {

    public int price;
    public String mood;
    public int sugar;
    public int quantity;

    public order(int price, String mood, int sugar, int quantity) {
        this.price = price;
        this.mood = mood;
        this.sugar = sugar;
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
