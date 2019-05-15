package se.kth.iv1350.vernic.processSale.integration;

/**
 * Exception for when a customer isn't found in the customer registry
 */
public class CustomerNotFoundException extends Exception {
    /**
     * CustomerNotFoundException constructor
     * @param msg error message sent to developer
     */
    public CustomerNotFoundException(String msg){
        super(msg);
    }
}
