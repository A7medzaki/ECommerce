package Models;

import java.time.LocalDate;

public class ExpirableProduct extends Product{

    private final LocalDate expiryDate;

    public ExpirableProduct(double price, String name, int quantity, LocalDate expiryDate) {
        super(price, name, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}