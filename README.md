# Fawry OOP Assessment - E-Commerce System

A simple Object-Oriented Programming (OOP) console-based e-commerce system that demonstrates real-world modeling of products, carts, customers, shipping, and checkout logic — built in **Java** as part of the Fawry assessment.

---

## 📦 Features

- ✅ Define products with `name`, `price`, `quantity`, and (optionally) `expiry date` and `weight`
- ✅ Support for:
  - Expirable products (like Cheese, Biscuits)
  - Non-expirable products (like Mobile Scratch Cards)
  - Shippable products with weight
- ✅ Add items to cart with a specified quantity (respecting stock)
- ✅ Checkout functionality with:
  - Subtotal calculation
  - Fixed shipping fee (30 EGP)
  - Validation for expired products, out-of-stock items, and insufficient balance
  - Shipment notice with product weights
  - Receipt printing
- ✅ Object-Oriented Design with interfaces and inheritance

---

## 🧱 OOP Design

### ✅ Classes

- `Product` (abstract)
  - `ExpirableProduct` (adds expiry logic)
  - `ShippableProduct` (implements `ShippableItem`)
  - `ExpirableShippableProduct` (both expirable and shippable)
  - `NonExpirableProduct` (like digital products)
- `Customer`
- `Cart` & `CartItem`
- `CheckoutService`
- `ShippingService`

### ✅ Interfaces

- `ShippableItem`  
  ```java
  public interface ShippableItem {
      String getName();
      double getWeight();
  }
