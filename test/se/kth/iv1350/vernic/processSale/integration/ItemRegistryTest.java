package se.kth.iv1350.vernic.processSale.integration;

import org.junit.Test;
import se.kth.iv1350.vernic.processSale.model.Sale;

import static org.junit.Assert.*;

public class ItemRegistryTest {

    /**
     * Both these test are based on the fact that the
     * hard coded item identifier 1000 exists in the
     * itemRegistry while 10 doesn't
     */
    @Test
    public void checkIfValid() {

        ItemRegistry itemRegistry = new ItemRegistry();
        assertEquals(itemRegistry.checkIfValid("10"), false);
        assertEquals(itemRegistry.checkIfValid("1000"), true);

    }

    @Test
    public void getItem() {

        ItemRegistry itemRegistry = new ItemRegistry();
        assertEquals(itemRegistry.getItem("10"), null);
        assertNotEquals(itemRegistry.getItem("1000"), null);
    }
}