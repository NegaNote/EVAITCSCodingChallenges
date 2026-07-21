package com.evaitcs.unittesting;

/**
 * ============================================================================
 * CLASS: DiscountCalculator
 * TOPIC: Business logic class — great for parameterized test practice
 * ============================================================================
 */
public class DiscountCalculator {

    /**
     * Rules:
     *   Total >= $500  → 20% discount
     *   Total >= $200  → 10% discount
     *   Total >= $100  → 5% discount
     *   Total < $100   → 0% discount
     *
     * @param total the cart total before discount
     * @return the discount percentage (0, 5, 10, or 20)
     * @throws IllegalArgumentException if total is negative
     */
    public double getDiscountPercent(double total) {
        if (total < 0.0) {
            throw new IllegalArgumentException();
        }
        if (total >= 500.0) {
            return 20;
        } else if (total >= 200) {
            return 10;
        } else if (total >= 100) {
            return 5;
        } else {
            return 0.0;
        }
    }

    /**
     * @param total the original total
     * @return the total after applying the appropriate discount
     */
    public double calculateFinalPrice(double total) {
        double discountPercent = getDiscountPercent(total);

        return total - total * discountPercent * 0.01; // Replace this line
    }

    /**
     * Valid codes: "SAVE10", "WELCOME20", "VIP30"
     *
     * @param code the promo code
     * @return true if the code is valid
     */
    public boolean isValidPromoCode(String code) {
        if (code == null) {
            return false;
        }
        return code.equals("SAVE10") || code.equals("WELCOME20") || code.equals("VIP30");
    }

    /**
     * "SAVE10"    → 10%
     * "WELCOME20" → 20%
     * "VIP30"     → 30%
     * Invalid     → throws IllegalArgumentException
     *
     * @param code the promo code
     * @return the discount percentage for the code
     */
    public double getPromoDiscount(String code) {
        return switch (code) {
            case "SAVE10" -> 10;
            case "WELCOME20" -> 20;
            case "VIP30" -> 30;
            default -> throw new IllegalArgumentException();
        };
    }
}

