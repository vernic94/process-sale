package se.kth.iv1350.vernic.processSale.controller;

import org.junit.Test;
import se.kth.iv1350.vernic.processSale.integration.ItemDTO;
import se.kth.iv1350.vernic.processSale.integration.RegistryCreator;

import static org.junit.Assert.*;

public class ControllerTest {


    /**
     * Tests that the method addItem really adds an Item to the ongoing sale
     */
    @Test
    public void addItem() {
        RegistryCreator registryCreator = new RegistryCreator();
        Controller contr = new Controller(registryCreator);
        contr.startNewSale();
        ItemDTO item = contr.addItem("1000");
        assertTrue(contr.getCurrentTotalPrice() > item.getPrice());
    }

    /**
     * Tests that concludeSale only returns true when the paidAmount
     * is greater or equal than the total cost of the sale
     */
    @Test
    public void concludeSale() {
        RegistryCreator registryCreator = new RegistryCreator();
        Controller contr = new Controller(registryCreator);
        contr.startNewSale();
        contr.addItem("1000");
        contr.addItem("1002");
        double paidAmountLess = 4;
        double paidAmountEqual = contr.getCurrentTotalPrice();
        double paidAmountGreater = 200;
        assertEquals(contr.concludeSale(paidAmountLess),false);
        boolean resultEqual = contr.concludeSale(paidAmountEqual);
        assertEquals(resultEqual,true);
        boolean resultGreater = contr.concludeSale(paidAmountGreater);
        assertEquals(resultGreater,true);
    }
}