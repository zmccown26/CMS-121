import java.util.Scanner;

/*
  Lab 1 - TilesRequired
  Zach McCown
  
  This program calculates the amount of tiles needed and the cost 
  to tile a room based on user-input dimensions. It prompts the user 
  to enter the length and width of the room in feet, reads the input, 
  and calculates the number of tiles needed. The program then computes 
  the number of packages required (where each package contains 12 tiles) 
  and calculates the total cost of the tiles. The final results are displayed as the output.
*/

public class TilesRequired {
    public static void main(String[] args) {
        //create a scanner object to read input from the user
        Scanner InputFeetAndWidth = new Scanner(System.in);

        //prompt the user for the length and width of the room in feet
        System.out.println("Enter the length of the room in feet: ");
        double inputLength = InputFeetAndWidth.nextDouble();

        System.out.println("Enter the width of the room in feet: ");
        double inputWidth = InputFeetAndWidth.nextDouble();

        //close scanner
        InputFeetAndWidth.close();

        /* 
        * wanted to round up numbers so 
        * user could put in any values 
        * (had to look up the Math.ceil function)
        */
        double length = Math.ceil(inputLength);
        double width = Math.ceil(inputWidth);

        //define the dimensions of each tile
        double tileLength = 1.0; // feet
        double tileWidth = 0.5;  // feet

        //amount of tiles needed in length
        double tilesNeededLength = length / tileLength;

        //amount of tiles needed in width
        double tilesNeededWidth = width / tileWidth;

        //calculate total number of tiles needed
        double totalTiles = tilesNeededLength * tilesNeededWidth;

        //print amount of tiles needed
        System.out.println("Amount of tiles needed: " + totalTiles);

        //see how many packages we need (comes in 12)
        double numPackagesDecimal = totalTiles / 12.00;

        //use Math.ceil to round up so you get enough tiles
        double numPackages = Math.ceil(numPackagesDecimal);

        //create variable for cost of tiles (each package is $36.28)
        double totalCost = numPackages * 36.28;

        //print out results
        System.out.println("The cost of tiling this floor: $" + totalCost);



    }

}
