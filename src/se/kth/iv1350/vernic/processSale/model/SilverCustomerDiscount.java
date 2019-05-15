package se.kth.iv1350.vernic.processSale.model;

/**
 * Discount available for the silver members of the store
 */
public class SilverCustomerDiscount implements Discounter {
    /**
     * calculates discount amount of the silver customers
     * @param amount total price of sale
     * @return discounted amount
     */
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.8;
    }
}
