package se.kth.iv1350.vernic.processSale.controller;

import se.kth.iv1350.vernic.processSale.model.Receipt;
import se.kth.iv1350.vernic.processSale.model.Sale;
import se.kth.iv1350.vernic.processSale.integration.*;


public class Controller {

    private Sale currentSale;
    private RegistryCreator registryCreator;
    private ItemRegistry itemRegistry;
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;

    /**
     * Controller constructor
     */
    public Controller(RegistryCreator regCreator){
        registryCreator = regCreator;
        itemRegistry = registryCreator.getItemRegistry();
        accountingSystem = registryCreator.getAccountingSystem();
        inventorySystem = registryCreator.getInventorySystem();
    }

    /**
     * creates instance of Sale and CashRegister
     * @return
     */
    public void startNewSale(){
        this.currentSale = new Sale();
    }

    /**
     * Checks if item has valid identifier
     * @param itemId
     * @return
     */
    public boolean checkIfValid(String itemId){
        return this.itemRegistry.checkIfValid(itemId);
    }

    /**
     * adds items to the current sale
     * @param itemID the items identifier
     * @return itemDTO
     */
    public ItemDTO addItem(String itemID){
       ItemDTO itemDTO = this.itemRegistry.getItem(itemID);
       this.currentSale.addItem(itemDTO);
       return itemDTO;
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

