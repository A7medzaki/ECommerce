package Models;

public class ShippableProduct extends Product implements ShippableItem{

    private final double weight;

    public ShippableProduct(double price, String name, int quantity, double weight) {
        super(price, name, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
