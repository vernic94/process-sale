package se.kth.iv1350.vernic.processSale.integration;

/**
 * Exception for when an item isn't found in the registry.
 */
public class ItemNotFoundException extends Exception{
    /**
     * ItemNotFoundException constructor
     * @param msg error message sent to developer
     */
    public ItemNotFoundException(String msg){
        super(msg);
    }
}
