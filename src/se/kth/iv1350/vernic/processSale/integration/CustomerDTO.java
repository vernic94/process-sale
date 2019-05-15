package se.kth.iv1350.vernic.processSale.integration;

/**
 * Holds all the information included in the customerDTO
 */
public class CustomerDTO {
    
    private String name;
    private String membershipCardType; 
    private String personalCode;

    /**
     * customer DTO that holds all info about a customer
     * @param name customer name
     * @param membershipCardType type of membership card the customer has
     * @param personalCode the customers personal code
     */
    public CustomerDTO(String name, String membershipCardType, String personalCode) {
        this.name = name;
        this.membershipCardType = membershipCardType;
        this.personalCode = personalCode;
    }

    /**
     * gets customers name
     * @return customers name
     */
    public String getName() {
        return name;
    }

    /**
     * gets customers membership card type
     * @return customer card type (gold or silver or null)
     */
    public String getmembershipCardType() {
        return membershipCardType;
    }

    /**
     * gets customers personal code
     * @return customers personal code
     */
    public String getPersonalCode() {
        return personalCode;
    }
}
