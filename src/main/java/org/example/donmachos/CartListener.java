package org.example.donmachos;

import javafx.event.ActionEvent;

public interface CartListener {
    public void onHandleMood(ActionEvent event);
    public void handleSize(ActionEvent event);
    public void handleQuantity(ActionEvent event);
    public void handleAddToCart(cart carts);
}
