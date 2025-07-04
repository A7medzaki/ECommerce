package Services;

import Models.*;

import java.util.List;

public class CheckoutService {

    private void printShipmentNotice(List<CartItem> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0.0;
        for (CartItem item : items) {
            Product p = item.getProduct();
            if (p instanceof ShippableItem shippable) {
                double w = shippable.getWeight() * item.getQuantity();
                totalWeight += w;
                System.out.printf("%dx %s %.0fg\n", item.getQuantity(), p.getName(), shippable.getWeight() * 1000);
            }
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }

    private void printReceipt(List<CartItem> items, double subtotal, double shipping, double total) {
        System.out.println("\n** Checkout receipt **");
        for (CartItem item : items) {
            System.out.printf("%dx %s %.0f\n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", subtotal);
        System.out.printf("Shipping %.0f\n", shipping);
        System.out.printf("Amount %.0f\n", total);
    }

    public void checkout(Customer customer) {
        Cart cart = customer.getCart();
        List<CartItem> items = cart.getCartItems();

        if (items.isEmpty())
            throw new RuntimeException("Cart is empty");

        for (CartItem item : items) {
            if (item.getProduct().isExpired())
                throw new RuntimeException(item.getProduct().getName() + " is expired!");
        }

        double subtotal = cart.getSubTotal();
        List<ShippableItem> shippableItems = cart.getShippableItems();

        if (!shippableItems.isEmpty()) {
            printShipmentNotice(items);
        }

        double shippingFees = ShippingService.ship(shippableItems);
        double total = subtotal + shippingFees;

        if (total > customer.getBalance())
            throw new RuntimeException("Customer balance is insufficient");

        customer.pay(total);

        for (CartItem item : items) {
            item.getProduct().decreaseQuantity(item.getQuantity());
        }

        printReceipt(items, subtotal, shippingFees, total);
    }
}
