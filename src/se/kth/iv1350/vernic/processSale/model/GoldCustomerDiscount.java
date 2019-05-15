package se.kth.iv1350.vernic.processSale.model;
/**
 * Discount available for the gold members of the store
 */
public class GoldCustomerDiscount implements Discounter{
    /**
     * calculates discount amount of the gold customers
     * @param amount total price of sale
     * @return discounted amount
     */
    @Override
    public double calculateDiscount(double amount){
        return amount * 0.5;
    }

}
