package se.kth.iv1350.vernic.processSale.controller;

import se.kth.iv1350.vernic.processSale.model.*;
import se.kth.iv1350.vernic.processSale.integration.*;

/**
 * The processSale application's only controller. All model calls are routed through here.
 */
public class Controller {

    private Sale currentSale;
    private RevenueCounter revenueCounter;
    private ItemRegistry itemRegistry;
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private CustomerRegistry customerRegistry;

    /**
     * Controller constructor
     */
    public Controller(RegistryCreator regCreator){
        itemRegistry = regCreator.getItemRegistry();
        accountingSystem = regCreator.getAccountingSystem();
        inventorySystem = regCreator.getInventorySystem();
        customerRegistry = regCreator.getCustomerRegistry();
        revenueCounter = new RevenueCounter();
    }

    /**
     * adds revenue observers to the revenue counter that holds the list of the observers
     * @param revenueObserver
     */
    public void addRevenueObserver(RevenueObserver revenueObserver){
        this.revenueCounter.addRevenueObserver(revenueObserver);
    }

    /**
     * creates instance of Sale and CashRegister
     * @return
     */
    public void startNewSale(){
        this.currentSale = new Sale();
    }

    /**
     * adds items to the current sale
     * @param itemID the items identifier
     * @return itemDTO
     */
    public ItemDTO addItem(String itemID) throws ItemNotFoundException, ItemCouldNotBeAddedException {
            try {
                ItemDTO itemDTO = this.itemRegistry.getItem(itemID);
                this.currentSale.addItem(itemDTO);
                return itemDTO;
            }catch (DatabaseFailureException ex){
                throw new ItemCouldNotBeAddedException("LOG MESSAGE: Call to database failed",ex);
            }
    }

    /**
     * sets the personal code of the customer and chooses the correct discounter on the current sale
     * @param personalCode the customers personal code
     * @throws CustomerNotFoundException exception thrown if there's no such code
     */
    public void setPersonalCode(String personalCode) throws CustomerNotFoundException {
        CustomerDTO customerDTO = customerRegistry.getCustomer(personalCode);
        if (customerDTO.getmembershipCardType().equals("gold")) {
            this.currentSale.setDiscounter(new GoldCustomerDiscount());
            this.currentSale.applyDiscount();
        }
        if (customerDTO.getmembershipCardType().equals("silver")) {
            this.currentSale.setDiscounter(new SilverCustomerDiscount());
            this.currentSale.applyDiscount();
        }
    }

    /**
     * Checks if the sale is concluded or not
     * @param paidAmount the amount paid by the customer
     * @return true if the sale is concluded, false otherwise
     */
    public boolean concludeSale(double paidAmount) {

          boolean isSaleConcluded = this.currentSale.concludeSale(paidAmount);
          if (isSaleConcluded) {
              this.inventorySystem.updateInventory();
              this.accountingSystem.addSale();
              this.revenueCounter.setLastRevenue(currentSale.getTotalPriceIncTax());
          }
          return isSaleConcluded;
    }

    /**
     * prints the receipt with the sale information
     */
    public void printReceipt(){
        Receipt receipt = new Receipt(this.currentSale);
        Printer printer = new Printer();
        printer.print(receipt.createReceiptString());
    }

    /**
     * gets the totalprice of the current sale inc TAX
     * @return the total price of the current sale
     */
    public double getCurrentTotalPrice(){

        return this.currentSale.getTotalPriceIncTax();
    }
}

