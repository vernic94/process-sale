package main.processSale.controller;

import main.processSale.integration.*;
import main.processSale.model.Receipt;
import main.processSale.model.Sale;


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

    public void addItem(String itemID){
       ItemDTO itemDTO = this.itemRegistry.getItem(itemID);
       System.out.println(itemDTO.toString());
       this.currentSale.addItem(itemDTO);
    }

    public boolean concludeSale(double paidAmount) {
          boolean isSaleConcluded = this.currentSale.concludeSale(paidAmount);
          if (isSaleConcluded) {
              this.inventorySystem.updateInventory();
              this.accountingSystem.addSale();
          }
          return isSaleConcluded;
    }

    public void printReceipt(){
        Receipt receipt = new Receipt(this.currentSale);
        Printer printer = new Printer();
        printer.print(receipt.createReceiptString());
    }

    public double getCurrentTotalPrice(){

        return this.currentSale.getTotalPriceIncTax();
    }
}

