package main.processSale.model;

import main.processSale.integration.ItemDTO;

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

    /**
     * calculates change
     */
    private void calculateChange(){
        this.change = paidAmount - totalPriceIncTax;
    }

    /**
     * updates totalPrice
     */
    private void updateTotalPrice(ItemDTO scannedItem){
        this.totalPrice += scannedItem.getPrice();
    }

    /**
     * adds scanned items to the ongoing sale
     */
    public void addItem(ItemDTO scannedItem){
        this.saleItems.add(scannedItem);
        this.updateTotalPrice(scannedItem);
        this.updateTax();
    }

    public boolean concludeSale(double paidAmount){
        this.paidAmount = paidAmount;
        this.calculateChange();
        return  this.change >= 0;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTax() {
        return tax;
    }

    public double getTotalPriceIncTax() {
        return totalPriceIncTax;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getChange() {
        return change;
    }

    public ArrayList<ItemDTO> getSaleItems() {
        return saleItems;
    }
}
