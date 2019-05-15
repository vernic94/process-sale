package se.kth.iv1350.vernic.processSale.integration;

import org.junit.Test;
import se.kth.iv1350.vernic.processSale.controller.ItemCouldNotBeAddedException;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Test for the methods and exceptions thrown in the itemRegistry class
 * Both these test are based on the fact that the
 * hard coded item identifier 1000 exists in the
 * itemRegistry while 10 doesn't
 */
public class ItemRegistryTest {
    /**
     * Checks that exceptions are not thrown for valid item identifier
     */
    @Test
    public void getExistingItem() {
        ItemRegistry itemRegistry = new ItemRegistry();
        try{
            itemRegistry.getItem("1002");
            //assertEquals(itemRegistry.getItem("10"), null);
        } catch(DatabaseFailureException | ItemNotFoundException e) {
            fail("exception should not occur for a valid item");
        }
    }
/**
 * Tests that the right exception is thrown
 */
    @Test(expected = ItemNotFoundException.class)
    public void getNonExistingItem() throws ItemNotFoundException {
        ItemRegistry itemRegistry = new ItemRegistry();
        try{
            itemRegistry.getItem("10");
            fail("Could add a non-existing item.");
        }catch(DatabaseFailureException ex){
            assertTrue("Wrong exception message, does not contain specified item: "
                    + ex.getMessage(), ex.getMessage().contains(itemRegistry.getItem("10!").toString()));
        }
    }
}