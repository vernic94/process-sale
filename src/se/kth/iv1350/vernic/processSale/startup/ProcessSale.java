package se.kth.iv1350.vernic.processSale.startup;

import se.kth.iv1350.vernic.processSale.controller.Controller;
import se.kth.iv1350.vernic.processSale.integration.RegistryCreator;
import se.kth.iv1350.vernic.processSale.view.View;

/**
 * contains <code> main </code> method that performs application <code>ProcessSale</code> startup
 */
public class ProcessSale {
    /**
     * Starts everything
     */
    public static void main(String[] args){
        RegistryCreator registryCreator = new RegistryCreator();
        Controller contr = new Controller(registryCreator);
        new View(contr).sampleExecution();
    }
}
