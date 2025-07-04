package Models;

import java.time.LocalDate;

public class ExpirableShippableProduct extends ExpirableProduct implements ShippableItem{

    private double weight;

    public ExpirableShippableProduct(double price, String name, int quantity, LocalDate expiryDate, double weight) {
        super(price, name, quantity, expiryDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
