package org.example.donmachos;

import javafx.scene.image.ImageView;

public class cart {

    private String image;
    private String CoffeName;
    private String CoffeDescription;
    private boolean bestSeller;

    public boolean isBestSeller() {
        return bestSeller;
    }

    public void setBestSeller(boolean bestSeller) {
        this.bestSeller = bestSeller;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCoffeName() {
        return CoffeName;
    }

    public void setCoffeName(String coffeName) {
        CoffeName = coffeName;
    }

    public String getCoffeDescription() {
        return CoffeDescription;
    }

    public void setCoffeDescription(String coffeDescription) {
        CoffeDescription = coffeDescription;
    }
}
