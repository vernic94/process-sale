package se.kth.iv1350.vernic.processSale.integration;

/**
 * ItemDTO holds all the information about an item
 */
public class ItemDTO {

    private double tax;
    private double price;
    private String description;
    private String itemIdentifier;

    /**
     * object of type ItemDTO constructor
     * @param itemIdentifier item identification nr
     * @param description item description
     * @param price item price
     * @param tax taxation of item
     */
    public ItemDTO(double tax, String itemIdentifier, String description, double price){

        this.tax = tax;
        this.itemIdentifier = itemIdentifier;
        this.price = price;
        this.description = description;
    }

    /**
     * creates a string with all the info about the item
     * @return string with all the item info
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.itemIdentifier == null){
            this.itemIdentifier = new String();
        }
        sb.append("description: " + description + " ");
        sb.append("price: " + price + " ");
        sb.append("item Identifier: " + itemIdentifier + " ");
        sb.append("tax: " + tax + " ");
        return sb.toString();
    }

    /**
     * gets the items identifier
     * @return itemIdentifier
     */

    public String getItemIdentifier() {
        return itemIdentifier;
    }

    /**
     * gets the price of the item
     * @return itemPrice
     */

    public double getPrice(){
        return this.price;
    }

    /**
     * gets item description
     * @return item description
     */
    public String getDescription(){
        return description;
    }
}
