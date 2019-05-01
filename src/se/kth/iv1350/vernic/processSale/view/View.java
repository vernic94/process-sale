package se.kth.iv1350.vernic.processSale.view;

import se.kth.iv1350.vernic.processSale.controller.Controller;

import java.util.Scanner;

public class View {

    private Controller contr;
    private Scanner in;

    /**
     * creates new instance
     *
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
            boolean validItemId = contr.checkIfValid(id);
            if (!validItemId)
                System.out.println("no such item. Please insert a valid item ID");
            else {
                this.contr.addItem(id);
                isProcessing = this.checkIfSalesIsDone();
            }
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
