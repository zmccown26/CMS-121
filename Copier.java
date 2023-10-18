import java.util.Scanner;
import java.io.IOException;

/*   
  Assignment 1 done by Zach McCown

  This program serves as the code needed for a photocopier
    It will take 4 bits of data
      ID Number
      Current Balance
      Number of black and white copies
      Number of colored copies
    Compute if these inputs are allowed
    Output a message if there is a problem
    Otherwise say the job is done and give the remaining balance
  */


public class Copier {
        public static void main(String[] args) {
            try {

            Scanner scanner = new Scanner(System.in);

            // Prompt the user to enter employee information
            System.out.print("Enter your ID number: ");
            int id = scanner.nextInt();

            System.out.print("Enter your current balance on the card (in cents): ");
            double balance = scanner.nextDouble();

            System.out.print("Enter the number of black & white copies: ");
            int bwCopies = scanner.nextInt();

            System.out.print("Enter the number of colored copies: ");
            int coloredCopies = scanner.nextInt();

            // close the scanner
            scanner.close();

            // Check if the employee has the privilege to make colored copies
            boolean canMakeColoredCopies = id % 100 == 65;

            // Calculate the total cost of the print job
            double totalCost = (bwCopies * .10) + (coloredCopies * .25);

            // Check if the employee has sufficient funds and the privilege for colored copies
            if (!canMakeColoredCopies && (coloredCopies > 0)) {
                System.out.println("You do not have the priviledge to print colored copies.");
            }

            else if (balance >= totalCost) {
                // Deduct the cost from the balance
                balance -= totalCost;
                System.out.println("Printing...");
                System.out.println("Total cost: " + totalCost + " cents");
                System.out.println("Remaining balance: " + balance + " cents");
            }

            else {
                System.out.println("Insufficient funds for this print job.");
            }

            }
            catch(Exception e) {
                System.out.println("Some error in this code is preventing the rightfull execution");

            }

        }
    }
  }
}