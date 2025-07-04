package Models;

public class CartItem {
    private final Product product;
    int quantity;

    public CartItem(Product product, int quantity) {
        if(!product.isAvailable(quantity))
            throw new IllegalArgumentException("Quantity exceeds available stock");
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice(){
        return product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
