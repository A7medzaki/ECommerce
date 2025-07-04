package Models;

public class Customer {
    private String name;
    private double balance;
    private Cart cart = new Cart();

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void pay(double amount){
        if (amount > balance)
            throw new IllegalArgumentException("Insufficient balance");
        balance -= amount;
    }

    public void printCheckoutDetails(double subtotal, double shipping, double total){
        System.out.println("----- Checkout -----");
        System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.printf("Shipping: $%.2f\n", shipping);
        System.out.printf("Total Paid: $%.2f\n", total);
        System.out.printf("Remaining Balance: $%.2f\n", balance);
    }

}
