package Services;

import Models.ShippableItem;

import java.util.List;

public class ShippingService {
    public static double ship(List<ShippableItem> items) {
        double totalWeight = items.stream().mapToDouble(ShippableItem::getWeight).sum();
        double cost = totalWeight * 10; // Shipping cost per kg
        System.out.printf("Shipping %.2f kg, cost = $%.2f\n", totalWeight, cost);
        return cost;
    }
}
