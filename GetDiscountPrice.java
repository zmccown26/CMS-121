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