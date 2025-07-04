import Models.*;
import Services.CheckoutService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Ahmed", 1000);
        Cart cart = customer.getCart();

        Product cheese = new ExpirableShippableProduct(100, "Cheese", 10, LocalDate.now().plusDays(5), 0.4);
        Product biscuits = new ExpirableShippableProduct(150, "Biscuits", 5, LocalDate.now().plusDays(3), 0.7);
        Product scratchCard = new NonExpirableProduct(50, "Scratch Card", 50);

        try {
            cart.addItem(cheese, 2);
            cart.addItem(biscuits, 1);
            cart.addItem(scratchCard, 1);

            CheckoutService checkout = new CheckoutService();
            checkout.checkout(customer);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}