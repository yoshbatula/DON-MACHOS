package org.example.donmachos;

import javafx.event.ActionEvent;

public interface CartListener {
    void onHandleMood(ActionEvent event);
    void handleSize(ActionEvent event);
    void handleQuantity(ActionEvent event);
    void handleAddToCart(cart carts);
    void handleRemoveFromCart(cartItems cartitems);
}
