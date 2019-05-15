package se.kth.iv1350.vernic.processSale.integration;

/**
 * Exception for if the database fails
 */
public class DatabaseFailureException extends RuntimeException {
    /**
     * DatabaseFailureException constructor
     * @param msg Error message sent to developer
     */
    public DatabaseFailureException(String msg){
        super(msg);
    }
}
