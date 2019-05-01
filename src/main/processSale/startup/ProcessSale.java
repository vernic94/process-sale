package main.processSale.startup;

import main.processSale.controller.Controller;
import main.processSale.integration.RegistryCreator;
import main.processSale.view.View;

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
