package se.kth.iv1350.vernic.processSale.controller;

/**
 * Exception thrown from DatabaseFailureException to controller so that it can be caught in the view
 * In order to get the right abstraction level
 */
public class ItemCouldNotBeAddedException extends Exception {
    /**
     * ItemCouldNotBeAddedException constructor
     * @param msg Error message sent to developer
     * @param cause The cause of the exception which is the database failure
     */
    public ItemCouldNotBeAddedException(String msg, Exception cause){
        super(msg, cause);
    }
}
