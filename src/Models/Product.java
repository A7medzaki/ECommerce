package Models;

public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(double price, String name, int quantity) {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

    public abstract boolean isExpired();

    public void decreaseQuantity(int quantity){
        this.quantity -= quantity;
    }

    public boolean isAvailable(int requestedQty) {
        return quantity >= requestedQty;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}