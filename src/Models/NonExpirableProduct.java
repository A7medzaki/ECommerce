package Models;

public class NonExpirableProduct extends Product{

    public NonExpirableProduct(double price, String name, int quantity) {
        super(price, name, quantity);
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
