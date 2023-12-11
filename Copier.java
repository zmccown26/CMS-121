/*   
 * Assignment 1 done by Zach McCown
 * Copier - Employee Copying Privilege Checker and Balance Deduction
 * 
 * This Java program simulates a copier system for employees, allowing them to make black & white and colored copies.
 * It prompts the user to enter their ID, current balance, and the number of copies to be made. It then checks if the
 * employee has the privilege to make colored copies based on their ID and deducts the total cost from their balance.
 * 
 * Instructions:
 * 1. Run the program and follow the prompts to enter employee information and print job details.
 * 2. The program checks for the privilege to make colored copies and deducts the total cost from the balance.
 * 3. If the employee lacks the privilege or has insufficient funds, appropriate messages are displayed.
 * 
 * Note: This program assumes that employee IDs ending in 65 have the privilege to make colored copies.
 */

import java.util.Scanner;
import java.io.IOException;

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
