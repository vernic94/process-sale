package se.kth.iv1350.vernic.processSale.view;

import se.kth.iv1350.vernic.processSale.controller.Controller;
import se.kth.iv1350.vernic.processSale.controller.ItemCouldNotBeAddedException;
import se.kth.iv1350.vernic.processSale.integration.*;

import java.util.Scanner;

/**
 * Placeholder class instead of true interface.
 * Contains hard-coded user input simulations in method <code>sampleExecution()</code> that generates system operation calls.
 */
public class View {

    private Controller contr;
    private Scanner in;

    /**
     * creates new instance
     * @param contr Controller that is used for all operations
     */
    public View(Controller contr) {
        this.contr = contr;
        this.in = new Scanner(System.in);
    }

    private boolean checkIfSalesIsDone() {
        System.out.println("Is the sale finished? Press y to conclude the sale, n to continue \n");
        String result = this.in.nextLine();
        if(result.equals("y"))
            return false;
        return true;
    }

    private void handleSale() {
        boolean isProcessing = true;
        while (isProcessing) {
            System.out.println("Choose a product and specify its identifier: \n");
            String id = this.in.nextLine();
            try {
                ItemDTO itemDTO = this.contr.addItem(id);
                System.out.println(itemDTO.toString());
            }catch (ItemNotFoundException ex) {
                System.out.println("Item " + id + " not found. Please insert a valid Identifier.\n" + ex.getMessage());
            }
            catch(ItemCouldNotBeAddedException ex) {
                System.out.println("Database failed. Please try again.\n"+ ex.getMessage());
            }

            isProcessing = this.checkIfSalesIsDone();
        }
    }

    private void handlePersonalCode(){
        System.out.println("Are you a member of this Store? If yes, please enter your personal code, otherwise press enter. ");
        String personalCode = this.in.nextLine();
        try{
            this.contr.setPersonalCode(personalCode);
            System.out.println("Amount to pay after discount: " + this.contr.getCurrentTotalPrice()+ " SEK\n");
        }catch (CustomerNotFoundException ex){
            System.out.println("No such personal code.\n" + ex.getMessage());
        }
    }

    /**
     * Simulates a user input that generates calls to all system operations
     */
    public void sampleExecution(){

        System.out.println("Welcome to the cashier!");
        while(true) {
            System.out.println("New sale! \n");
            contr.startNewSale();
            this.handleSale();
            boolean isPaymentDone = false;
            while(!isPaymentDone) {
                System.out.println("Amount to pay: " + this.contr.getCurrentTotalPrice()+ " SEK\n");
                this.handlePersonalCode();
                System.out.println("Please insert a valid amount which represents the payment.\n");
                double amount = this.in.nextDouble();
                in.nextLine();
                if (this.contr.concludeSale(amount)) {
                    this.contr.printReceipt();
                    isPaymentDone = true;
                }
                else
                    System.out.println("The amount inserted is not enough to conclude the sale.\n");
            }

        }

    }
}
