package se.kth.iv1350.vernic.processSale.integration;

/**
 * instantiates ItemRegistry, AccountingSystem and InventorySystem
 */
public class RegistryCreator {
    private AccountingSystem accountingSystem = new AccountingSystem();
    private InventorySystem inventorySystem = new InventorySystem();
    private ItemRegistry itemRegistry = new ItemRegistry();

    /**
     * gets the item registry
     * @return item registry
     */
    public ItemRegistry getItemRegistry(){
        return itemRegistry;
    }

    /**
     * gets the accounting system
     * @return accounting system
     */
    public AccountingSystem getAccountingSystem(){
        return accountingSystem;
    }

    /**
     * gets inventory system
     * @return inventory system
     */
    public InventorySystem getInventorySystem(){
        return inventorySystem;
    }
}
