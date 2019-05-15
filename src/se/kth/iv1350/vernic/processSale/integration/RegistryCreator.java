package se.kth.iv1350.vernic.processSale.integration;

/**
 * instantiates ItemRegistry, AccountingSystem and InventorySystem
 */
public class RegistryCreator {
    private static RegistryCreator registryCreator;

    private RegistryCreator(){
    }

    private AccountingSystem accountingSystem = new AccountingSystem();
    private InventorySystem inventorySystem = new InventorySystem();
    private ItemRegistry itemRegistry = new ItemRegistry();
    private CustomerRegistry customerRegistry = new CustomerRegistry();


    /**
     * gets the one and only instance of registryCreator with global point of access
     * @return registryCreator instance (Singleton)
     */
    public static RegistryCreator getRegistryCreatorInstance(){
        if(registryCreator == null){
            registryCreator = new RegistryCreator();
        }
        return registryCreator;
    }

    /**
     * gets the customer registry
     * @return customer registry
     */
    public CustomerRegistry getCustomerRegistry() {
        return customerRegistry;
    }

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
