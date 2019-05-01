package se.kth.iv1350.vernic.processSale.integration;

/**
 * instantiates ItemRegistry, AccountingSystem and InventorySystem
 */
public class RegistryCreator {
    private AccountingSystem accountingSystem = new AccountingSystem();
    private InventorySystem inventorySystem = new InventorySystem();
    private ItemRegistry itemRegistry = new ItemRegistry();

    public ItemRegistry getItemRegistry(){
        return itemRegistry;
    }

    public AccountingSystem getAccountingSystem(){
        return accountingSystem;
    }

    public InventorySystem getInventorySystem(){
        return inventorySystem;
    }
}
