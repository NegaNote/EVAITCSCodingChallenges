package com.evaitcs.unittesting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * ============================================================================
 * CLASS: ShoppingCart
 * TOPIC: The main class to be tested with JUnit 5
 * ============================================================================
 *
 * TDD APPROACH:
 * Write the tests in ShoppingCartTest.java FIRST, then come here and
 * implement each method to make the tests pass. Red → Green → Refactor!
 * ============================================================================
 */
public class ShoppingCart {

    private List<CartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }


    /**
     * If an item with the same productId already exists, increase its quantity.
     * Otherwise, add the new item.
     *
     * @param item the item to add
     * @throws IllegalArgumentException if item is null
     */
    public void addItem(CartItem item) {
        if (item == null) {
            throw new IllegalArgumentException("item must not be null");
        }

        boolean found = false;
        int index = -1;
        for (int i = 0; i < items.size(); i++) {
            if (item.getProductId().equals(items.get(i).getProductId())) {
                found = true;
                index = i;
                break;
            }
        }

        if (found) {
            CartItem foundItem = items.get(index);
            foundItem.setQuantity(foundItem.getQuantity() + item.getQuantity());
        } else {
            items.add(item);
        }
    }

    /**
     * @param productId the product to remove
     * @return true if found and removed
     */
    public boolean removeItem(String productId) {
        boolean found = false;
        int index = -1;
        for (int i = 0; i < items.size(); i++) {
            if (productId.equals(items.get(i).getProductId())) {
                found = true;
                index = i;
                break;
            }
        }

        if (found) {
            items.remove(index);
        }

        return found;
    }

    /**
     * @return the sum of all item subtotals
     */
    public double getTotal() {
        return items.stream()
            .map(CartItem::getSubtotal)
            .reduce(0.0, Double::sum);
    }

    /**
     * @return number of unique items
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * @return sum of all quantities
     */
    public int getTotalQuantity() {
        return items.stream().map(CartItem::getQuantity)
                .reduce(0, Integer::sum);
    }

    /**
     * @param productId the product to find
     * @return Optional containing the item if found, empty otherwise
     */
    public Optional<CartItem> findItem(String productId) {
        boolean found = false;
        CartItem item = null;
        for (CartItem cartItem : items) {
            if (productId.equals(cartItem.getProductId())) {
                found = true;
                item = cartItem;
                break;
            }
        }
        if (found) {
            return Optional.of(item);
        } else {
            return Optional.empty();
        }
    }

    /**
     * Clears the shopping cart.
     */
    public void clear() {
        items.clear();
    }

    /**
     * @return true if no items in cart
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * @param discountPercent the discount (0-100)
     * @return the discounted total
     * @throws IllegalArgumentException if discount is < 0 or > 100
     */
    public double applyDiscount(double discountPercent) {
        if (discountPercent < 0.0 || discountPercent > 100.0) {
            throw new IllegalArgumentException("discountPercent must be between 0.0 and 100.0, inclusive");
        }
        return getTotal() - getTotal() * discountPercent * 0.01; // Replace this line
    }

    /**
     * Get an unmodifiable view of all the items in the cart.
     * @return the unmodifiable list of items
     */
    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}

