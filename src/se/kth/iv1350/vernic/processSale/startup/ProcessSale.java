package se.kth.iv1350.vernic.processSale.startup;

import se.kth.iv1350.vernic.processSale.controller.Controller;
import se.kth.iv1350.vernic.processSale.integration.RegistryCreator;
import se.kth.iv1350.vernic.processSale.view.TotalRevenueView;
import se.kth.iv1350.vernic.processSale.view.View;

/**
 * contains <code> main </code> method that performs application <code>ProcessSale</code> startup
 */
public class ProcessSale {
    /**
     * Starts everything
     */
    public static void main(String[] args){
        RegistryCreator registryCreator = RegistryCreator.getRegistryCreatorInstance();
        Controller contr = new Controller(registryCreator);
        contr.addRevenueObserver(new TotalRevenueView());
        new View(contr).sampleExecution();
    }
}
