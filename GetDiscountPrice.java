/*
 * Lab 1 - GetDiscountPrice
 * Zach McCown, Jerome Verbaet, Ella Johnson
 *
 * GetDiscountPrice - Calculate Sale Price with Discount
 * 
 * This Java program calculates the sale price based on the original price and discount percentage entered by the user.
 * It prompts the user to input the original price and discount percentage, then computes the discount amount and
 * the resulting sale price. The program handles potential input errors gracefully.
 * 
 * Instructions:
 * 1. Run the program and follow the prompts to enter the original price and discount percentage.
 * 2. The program calculates the discount amount and displays the final sale price.
 * 3. In case of errors during input, the program provides a clear error message.
 * 
 * Note: This program assumes valid input for the original price and discount percentage.
 */
import java.util.Scanner;

public class GetDiscountPrice {
  public static void main(String[] args) {
    try {
    //create scanner to read original price and discount percent
    Scanner calculateDiscountPrice = new Scanner(System.in);

    //prompt user for original price
    System.out.println("Please enter original price");

    //read the double entered
    double originalPriceEntered = calculateDiscountPrice.nextDouble();		

    //prompt user for discount percentage
    System.out.println("Please enter the discount percentage");

    //read the double entered
    double discountPercentage = calculateDiscountPrice.nextDouble();

    //close scanner
    calculateDiscountPrice.close();		

    double discountPrice = (originalPriceEntered * discountPercentage) / 100;
    double salePrice = originalPriceEntered - discountPrice;

    //print out the personalized welcome message
    System.out.println("Sale Price: " + salePrice);


    }
    catch(Exception e) {
      System.out.println("could not open Scanner");
    }
  }

}
