package se.kth.iv1350.vernic.processSale.model;

import se.kth.iv1350.vernic.processSale.integration.ItemDTO;

import java.util.ArrayList;

/**
 * gathers all the info about a specific sale
 */
public class Sale {
    private static final double TAX_RATE = 0.2;
    private double totalPrice;
    private double tax;
    private double totalPriceIncTax;
    private double paidAmount;
    private double change;
    private ArrayList<ItemDTO> saleItems;

    /**
     * Constructor of the class Sale
     */
    public Sale() {
        this.totalPrice = 0;
        this.tax = 0;
        this.totalPriceIncTax = 0;
        this.paidAmount = 0;
        this.change = 0;
        this.saleItems = new ArrayList<>();
    }


    private void updateTax(){
        this.tax = totalPrice * TAX_RATE;
        this.totalPriceIncTax = this.totalPrice + this.tax;
    }

    private void calculateChange(){
        this.change = paidAmount - totalPriceIncTax;
    }

    private void updateTotalPrice(ItemDTO scannedItem){
        this.totalPrice += scannedItem.getPrice();
    }

    /**
     * adds scanned items to the ongoing sale
     * @param scannedItem The scanned items which will be added to the current Sale
     */
    public void addItem(ItemDTO scannedItem){
        this.saleItems.add(scannedItem);
        this.updateTotalPrice(scannedItem);
        this.updateTax();
    }

    /**
     * concludes the ongoing sale
     * @param paidAmount the amount paid by the customer
     * @return true if the paid amount is higher than the total price. false otherwise
     */
    public boolean concludeSale(double paidAmount){
        this.paidAmount = paidAmount;
        this.calculateChange();
        return  this.change >= 0;
    }

    /**
     * gets the totalPrice of the concluded sale
     * @return the total price of te concluded sale
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * gets the TAX amount
     * @return the TAX
     */
    public double getTax() {
        return tax;
    }

    /**
     * Gets the total price of the concluded sale inc. TAX
     * @return total price inc TAX
     */
    public double getTotalPriceIncTax() {
        return totalPriceIncTax;
    }

    /**
     * gets the amount paid by the customer
     * @return amount paid by the customer
     */
    public double getPaidAmount() {
        return paidAmount;
    }

    /**
     * Gets change that should be given back to the customer
     * @return change
     */
    public double getChange() {
        return change;
    }

    /**
     * gets all items in the ongoing sale
     * @return the items of the sale
     */

    public ArrayList<ItemDTO> getSaleItems() {
        return saleItems;
    }
}
