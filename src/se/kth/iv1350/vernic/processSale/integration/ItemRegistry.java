package se.kth.iv1350.vernic.processSale.integration;

public class ItemRegistry {

    private ItemDTO[] itemsInRegistry = {
            new ItemDTO(0.05, "1000", "milk", 10.5),
            new ItemDTO(0.5, "1001", "lax", 69.99),
            new ItemDTO(0.02, "1002", "pesto", 30.95),
            new ItemDTO(0.20, "1003", "mozzarella", 19.95)};

    /**
     * checks if the item identifier is valid(if it exists in the item registry)
     * @param itemID the items identifier
     * @return true if the item exists (if the identifier is valid), false otherwise
     */
    public boolean checkIfValid(String itemID){
        boolean isValid = false;
        for (int i=0; i < itemsInRegistry.length; i++) {
            if (this.itemsInRegistry[i].getItemIdentifier().equals(itemID)){
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    /**
     * gets the item from the registry
     * @param itemID the items identifier
     * @return the item if there is one with that identifier in the registry, null otherwise
     */
    public ItemDTO getItem(String itemID) {
        for (int i=0; i < itemsInRegistry.length; i++) {
            if (this.itemsInRegistry[i].getItemIdentifier().equals(itemID)){
                return this.itemsInRegistry[i];
            }
        }
        return null;
    }

}
