package se.kth.iv1350.vernic.processSale.model;

import se.kth.iv1350.vernic.processSale.integration.ItemDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class SaleTest {

    @Test
    /**
     * checks that the items are added correctly to the sale and the price is calculated correctly
     */
    public void addItem() {
      Sale sale = new Sale();
      ItemDTO item1 = new ItemDTO(0.05, "1000", "milk", 10.5);
      ItemDTO item2 = new ItemDTO(0.5, "1001", "lax", 69.99);
      sale.addItem(item1);
      sale.addItem(item2);
      assertEquals(item1.getPrice()+item2.getPrice(), sale.getTotalPrice(), 0);
      assertEquals(sale.getTotalPriceIncTax(),sale.getTotalPrice()+sale.getTax(),0);
    }

    @Test
    /**
     * checks that the change is calculated correctly if there should be any,
     * otherwise that the sale is not concluded
     */
    public void concludeSale() {
        Sale sale = new Sale();
        ItemDTO item1 = new ItemDTO(0.05, "1000", "milk", 10.5);
        ItemDTO item2 = new ItemDTO(0.5, "1001", "lax", 69.99);
        sale.addItem(item1);
        sale.addItem(item2);
        double paidAmountLess = 4;
        double paidAmountEqual = sale.getTotalPriceIncTax();
        double paidAmountGreater = 200;
        assertEquals(sale.concludeSale(paidAmountLess),false);
        boolean resultEqual = sale.concludeSale(paidAmountEqual);
        assertEquals(resultEqual,true);
        assertEquals(sale.getChange(), 0,0 );
        boolean resultGreater = sale.concludeSale(paidAmountGreater);
        assertEquals(resultGreater,true);
        assertEquals(sale.getChange(), paidAmountGreater - sale.getTotalPriceIncTax(), 0);
    }


}