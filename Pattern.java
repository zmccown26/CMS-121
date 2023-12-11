/*
 * Assignment 2 - Fabric Pattern
 * Zach McCown
 * FabricPattern - Generate Fabric Pattern based on User Input
 * 
 * This Java program prompts the user to input the width and height dimensions of a fabric pattern. It validates
 * the inputs to ensure the width is a multiple of 6 and the height is an odd number greater than or equal to 7.
 * The program then generates and prints a fabric pattern based on the specified dimensions.
 * 
 * Instructions:
 * 1. Run the program and follow the prompts to enter the width and height of the fabric.
 * 2. The program validates the inputs and generates a fabric pattern based on the specified dimensions.
 * 3. The fabric pattern consists of rows with a specific arrangement of '*' and ' ' characters.
 * 
 * Note: This program assumes valid input for width and height.
 */

import java.util.Scanner;

public class FabricPattern {

    public static void main(String[] args) {
        // Open scanner
    	Scanner scanner = new Scanner(System.in);

        // Prompt the user for width dimension
        System.out.print("What is the width of your fabric? ");
        int width = validateWidth(scanner);

        // Prompt the user for height dimension
        System.out.print("What is the height of your fabric? ");
        int height = validateHeight(scanner);

        // Close scanner
        scanner.close();

        // Generate and print the fabric pattern
        generateFabricPattern(width, height);
    }

    // Method to validate width input
    private static int validateWidth(Scanner scanner) {
        int width = scanner.nextInt();
        
        // Check if width input meets the requirement (multiple of 6)
        while (width % 6 != 0) {
            System.out.println("Please enter a width which is a multiple of 6");
            width = scanner.nextInt();
        }
        
        return width;
    }

    // Method to validate height input
    private static int validateHeight(Scanner scanner) {
        int height = scanner.nextInt();
        
        // Check if height input meets the requirements (odd and at least 7)
        while (height % 2 == 0 || height < 7) {
            System.out.println("Please enter an odd height which is at least 7");
            height = scanner.nextInt();
        }
        
        return height;
    }

    // Method to generate and print the fabric pattern
    private static void generateFabricPattern(int width, int height) {
        for (int i = 1; i <= height; i++) {
            if (i <= 2 || i >= height - 1) {
                // Get the first two and bottom two rows to get * all across
                for (int v = 1; v <= width; v++) {
                    System.out.print("*");
                }
            } else if (i % 2 == 1) {
                // Create the pattern in the middle for the odd rows (***   )
                for (int j = 1; j <= width; j++) {
                    if (j % 6 == 1 || j % 6 == 2 || j % 6 == 3) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            } else {
                // Create the pattern in the middle for the even rows (   ***)
                for (int z = 1; z <= width; z++) {
                    if (z % 6 == 0 || z % 6 == 4 || z % 6 == 5) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            
            // Move to the next line for the next loop iteration
            System.out.print("\n");
        }
    }
}

