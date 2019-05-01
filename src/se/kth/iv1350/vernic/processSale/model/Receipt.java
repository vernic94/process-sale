package se.kth.iv1350.vernic.processSale.model;

/**
 * presents data from Sale
 */
public class Receipt extends Sale{

    private Sale sale;

    /**
     * creates object of type Receipt constructor
     */
    public Receipt(Sale finishedSale){
        this.sale = finishedSale;
    }

    /**
     * converts to String
     */
    public String createReceiptString() {
        StringBuilder sb = new StringBuilder();
        sb.append("- - RECEIPT - -\n");
        sb.append("Name of Store\n");
        sb.append("\n- - ITEMS - -\n");
        for(int i =0; i < this.sale.getSaleItems().size(); i++){
                sb.append("Nr " + (i+1) + " ");
                sb.append(this.sale.getSaleItems().get(i).getDescription() + " ");
                sb.append(this.sale.getSaleItems().get(i).getPrice() + " SEK\n");
        }
        sb.append("\n- - TOTALS - -\n");
        sb.append("Total Price: "+ this.sale.getTotalPrice() + "SEK\n");
        sb.append("Tax: "+ this.sale.getTax() + "SEK\n");
        sb.append("Total Price inc. tax: "+ this.sale.getTotalPriceIncTax() + "SEK\n");
        sb.append("Amount paid: " + this.sale.getPaidAmount() + "SEK\n");
        sb.append("Change: " + this.sale.getChange() + "SEK\n");
        sb.append("\nTHANKS FOR SHOPPING \n HAVE A GOOD DAY\n");
        sb.append("- -  END OF RECEIPT - -\n");
        return sb.toString();
    }
}
