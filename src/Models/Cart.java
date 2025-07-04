package Models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();

    public void addItem(Product product, int quantity){
        if(!product.isAvailable(quantity))
            throw new IllegalArgumentException("Not enough quantity for: ");

        cartItems.add(new CartItem(product, quantity));
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public boolean isEmpty(){
        return cartItems.isEmpty();
    }

    public double getSubTotal(){
        return cartItems.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public List<ShippableItem> getShippableItems(){
        List<ShippableItem> shippableItems = new ArrayList<>();
        for (CartItem cartItem : cartItems){
            if(cartItem.getProduct() instanceof ShippableItem)
                shippableItems.add((ShippableItem) cartItem.getProduct());
        }
        return shippableItems;
    }
}
