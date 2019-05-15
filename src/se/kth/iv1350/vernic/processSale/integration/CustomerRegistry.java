package se.kth.iv1350.vernic.processSale.integration;

/**
 * customer registry where all the customers who are members of the shop are stored
 */
public class CustomerRegistry {
    private CustomerDTO[] customersInRegistry = {
            new CustomerDTO("Veronika", "gold", "123"),
            new CustomerDTO("Ernesto", "silver", "456")
    };

    /**
     * gets the customer info from the registry
     * @param personalCode the customer identifier
     * @return the customer if there is one with that personalCode in the registry, otherwise throws an exception
     * @throws CustomerNotFoundException exception thrown if item isn't found in registry
     */
    public CustomerDTO getCustomer(String personalCode) throws CustomerNotFoundException {
        for (int i=0; i < customersInRegistry.length; i++) {
            if (this.customersInRegistry[i].getPersonalCode().equals(personalCode)){
                return this.customersInRegistry[i];
            }
        }
        throw new CustomerNotFoundException("LOG MESSAGE: Customer not existing. Identifier: " + personalCode);
    }

}
