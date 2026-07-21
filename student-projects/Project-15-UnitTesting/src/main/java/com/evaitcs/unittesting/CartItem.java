package com.evaitcs.unittesting;

/**
 * ============================================================================
 * CLASS: CartItem
 * TOPIC: A simple model class — will be tested through ShoppingCartTest
 * ============================================================================
 */
public class CartItem {

    private String productId;
    private String name;
    private double price;
    private int quantity;

    /**
     * - name must not be null/empty
     * - price must be > 0
     * - quantity must be >= 1
     * Throw IllegalArgumentException for invalid input.
     */
    public CartItem(String productId, String name, double price, int quantity) {
        if (productId == null || productId.isEmpty()) {
            throw new IllegalArgumentException("productId must be non-null and non-empty");
        }

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name must be non-null and non-empty");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("price must be > 0");
        }

        if (quantity < 1) {
            throw new IllegalArgumentException("quantity must be >= 1");
        }

        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity desired quantity
     * Only sets the field if the parameter is >= 1.
     */
    public void setQuantity(int quantity) {
        if (quantity >= 1) {
            this.quantity = quantity;
        }
    }

    /**
     * @return price * quantity
     */
    public double getSubtotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("CartItem{id='%s', name='%s', price=%.2f, qty=%d}",
                productId, name, price, quantity);
    }
}

