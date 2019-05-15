package se.kth.iv1350.vernic.processSale.integration;

/**
 * Item registry class, where all the items of the shop are stored
 */
public class ItemRegistry {

    private ItemDTO[] itemsInRegistry = {
            new ItemDTO(0.05, "1000", "milk", 10.5),
            new ItemDTO(0.5, "1001", "lax", 69.99),
            new ItemDTO(0.02, "1002", "pesto", 30.95),
            new ItemDTO(0.20, "1003", "mozzarella", 19.95)};

    /**
     * gets the item from the registry
     * @param itemID the items identifier
     * @return the item if there is one with that identifier in the registry, otherwise throws an exception
     * @throws ItemNotFoundException exception thrown if item isn't found in registry
     * @throws DatabaseFailureException exception thrown if database fails
     */
    public ItemDTO getItem(String itemID) throws ItemNotFoundException, DatabaseFailureException {
        if(itemID.equals("1000")) {
            throw new DatabaseFailureException("LOG MESSAGE: Call to database Failed");
        }
        for (int i=0; i < itemsInRegistry.length; i++) {
            if (this.itemsInRegistry[i].getItemIdentifier().equals(itemID)){
                return this.itemsInRegistry[i];
            }
        }
        throw new ItemNotFoundException("LOG MESSAGE: User tried to add item with the invalid identifier: " + itemID);
    }

}
