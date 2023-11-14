import java.util.Scanner;

public class FabricPattern {
    public static void main(String[] args) {
        // Open scanner
    	Scanner scanner = new Scanner(System.in);

        // Prompt the user for width dimension
        System.out.print("what is the width of your fabric? ");
        int width = scanner.nextInt();
        
        // Check if width input meets the requirement (multiple of 6)
        while(width % 6 != 0) {
        	System.out.println("please enter a width which is a mutiple of 6");
            width = scanner.nextInt();
        }
        
        
        // Prompt the user for height dimension
        System.out.print("what is the height of your fabric? ");
        int height = scanner.nextInt();
        
        // Check if height input meets the requirements (odd and at least 7)
        while(height % 2 == 0 || height < 7) {
        	System.out.println("please enter an odd height which at least 7");
            height = scanner.nextInt();
        }
        
        // Close scanner
        scanner.close();
        
        // Create for loop (we know how many times it should run)
        for(int i = 1; i <= height; i++) {
            // Get the first two and bottom two rows to get * all across
        	if(i <= 2 || i >= height - 1) {
        		for(int v = 1; v <= width; v++) {
        			System.out.print("*");
        		}
        	}
        	
        	// Create the pattern in the middle for the odd rows (***   )
        	else if(i % 2 == 1) {
        		for(int j = 1; j <= width; j++) {
        			if(j % 6 == 1 || j % 6 == 2 || j % 6 == 3) {
        				System.out.print("*");
        			}
        			else {
        				System.out.print(" ");
        			}	
        					
        		}
        	}
        	
        	// Create the pattern in the middle for the even rows (   ***)
        	else {
        		for(int z = 1; z <= width; z++) {
        			if(z % 6 == 0 || z % 6 == 4 || z % 6 == 5) {
        				System.out.print("*");
        			}
        			else {
        				System.out.print(" ");
        			}	
        					
        		}
        	}
        	
        	// Once goes through the for loop make it go to the next line for the next loop iteration
        	System.out.print("\n");
        
        }
        
       
    }
}
