package main.processSale.integration;


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

    public String getItemIdentifier() {
        return itemIdentifier;
    }

    public double getPrice(){
        return this.price;
    }

    public String getDescription(){
        return description;
    }
}
