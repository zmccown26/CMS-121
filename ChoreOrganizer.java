/*
 * FINAL PROJECT - Zach McCown and Jerome Verbaet
 * ChoreOrganizer - A simple chore tracking and payment management program
 * 
 * This Java program allows a parent to organize and track chores for her children.
 * It provides functionality to add new chores, remove completed chores, view remaining tasks, and calculate the amount
 * owed to each child based on completed chores.
 * 
 * Instructions:
 * 1. Run the program and follow the on-screen menu to perform various tasks.
 * 2. The program keeps track of chores for each child, their values, and the total amount owed to each child.
 * 3. Use the menu options to add or remove chores, view remaining tasks, and calculate and pay amounts owed.
 * 
 * Note: This program is a simple utility and does not store data between runs.
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class ChoreOrganizer {
	// Declare array strings as classes
	public static ArrayList<String> choresZach;
	public static ArrayList<String> choresJerome;
	public static ArrayList<String> choresElla;
	public static ArrayList<Double> choresValueZach;
	public static ArrayList<Double> choresValueJerome;
	public static ArrayList<Double> choresValueElla;
    
	
	public static void printChoiceMenu() {
		// Method to display menu
		System.out.println("0. End program");
		System.out.println("1. Add new chore");
		System.out.println("2. Remove chore");
		System.out.println("3. Get money totals");
		System.out.println("4. Read remaining chores");
	}

	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public static int readInputInt() {
		// Method to read user input (type int)
		Scanner userInput = new Scanner(System.in);
		int choice = userInput.nextInt();
		return choice;
	}
	
	
	
	public static double readInputDouble() {
		// Method to read user input (type double)
		Scanner userInput = new Scanner(System.in);
		double choice = userInput.nextDouble();
		return choice;
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public static String readInputString() {
		// Method to read user input (type String)
		Scanner userInput = new Scanner(System.in);
		String text = userInput.nextLine();
		//userInput.close(); 
		return text;
	}
	
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	
	public static void addChoreTab() {
		// Method for adding chores to specific children or randomly
		System.out.println("1. Add chore to Zach");
		System.out.println("2. Add chore to Jerome");
		System.out.println("3. Add chore to Ella");
		System.out.println("9. Add chore randomly");
		
		
		int choice = readInputInt();
		if (choice ==9) {
			Random generator = new Random();
			choice = generator.nextInt(4);
		}
		
		switch(choice) {
		case 1:
			System.out.println("Which chore would you like to add:");
			String chore1 = readInputString();
			choresZach.add(chore1);
			System.out.println("What value would you want to add to this chore:");
			double value1 = readInputDouble();
			choresValueZach.add(value1);
			break;
			
		case 2:
			System.out.println("Which chore would you like to add:");
			String chore2 = readInputString();
			choresJerome.add(chore2);
			System.out.println("What value would you want to add to this chore:");
			double value2 = readInputDouble();
			choresValueJerome.add(value2);
			break;
		case 3:
			System.out.println("Which chore would you like to add:");
			String chore3 = readInputString();
			choresElla.add(chore3);
			System.out.println("What value would you want to add to this chore:");
			double value3 = readInputDouble();
			choresValueElla.add(value3);
			break;		
		
		default:
			System.out.println("You did not enter one of the viable options.");
			
		
			
		}
	}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public static void removeChoreTab(int[] totals) {
		// Method to remove a chore from a specific child and add money to their total
		readRemainingTasks();
	
		System.out.println("1. Remove chore from Zach");
		System.out.println("2. Remove chore from Jerome");
		System.out.println("3. Remove chore from Ella");
		
		int choice0 = readInputInt();
		switch(choice0) {
		case 1:
			System.out.println("Which chore would you like to remove from Zach?");
			int choice1 = readInputInt();
			choresZach.remove(choice1 - 1);
			totals[0] += choresValueZach.get(choice1 - 1);
			choresValueZach.remove(choice1 - 1);
			break;
		case 2:
			System.out.println("Which chore would you like to remove from Jerome?");
			int choice2 = readInputInt();
			choresJerome.remove(choice2 - 1);
			totals[1] += choresValueJerome.get(choice2 - 1);
			choresValueJerome.remove(choice2 - 1);	
			break;
		case 3:
			System.out.println("Which chore would you like to remove from Ella?");
			int choice3 = readInputInt();
			choresElla.remove(choice3 - 1);
			totals[2] += choresValueElla.get(choice3 - 1);
			choresValueElla.remove(choice3 - 1);
			break;		
		}	
		
	}


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public static void getAmountToPay(int[] totals, String[] names) {
		// Method to print out the amount due for each child and choose to pay them or not
		System.out.println(names[0] + " is owed $" + totals[0]);
		System.out.println(names[1] + " is owed $" + totals[1]);
		System.out.println(names[2] + " is owed $" + totals[2]);
		System.out.println("Would you want to pay these amounts?");
		System.out.println("1. Yes");
		System.out.println("2. No, go back to main menu");
		int choice = readInputInt();
		if(choice == 1){
			for(int i = 0; i < totals.length; i ++){
			totals[i] = 0;
			}
			
		}
	}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public static void readRemainingTasks() {
		// Method to display the chores each child still has to complete
		System.out.println("Chores for Zach:");
		for(int i = 0; i < choresZach.size(); i++) {
			System.out.println(i + 1 + ". " + choresZach.get(i));
		}

		System.out.println("Chores for Jerome:");
		for(int i = 0; i < choresJerome.size(); i++) {
			System.out.println(i + 1 + ". " + choresJerome.get(i));
		}

		System.out.println("Chores for Ella:");
		for(int i = 0; i < choresElla.size(); i++) {
			System.out.println(i + 1 + ". " + choresElla.get(i));
			}
		}
	
	
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		
		int[] totals = {0,0,0};
		final String[] names = {"Zach", "Jerome", "Ella"};
		// Declare arrays lists
		choresZach = new ArrayList<String>();
		choresJerome = new ArrayList<String>();
		choresElla = new ArrayList<String>();
		choresValueZach = new ArrayList<Double>();
		choresValueJerome = new ArrayList<Double>();
		choresValueElla = new ArrayList<Double>();
		
		// Initialize choice variable in order to only print welcome statement one time
		int choice = 10;
		
		do {
			if (choice == 10){
				System.out.println("Hello, welcome back Dr. Elva! What would you like to do today?");
			}
			printChoiceMenu();
			choice = readInputInt();
			// Process commands
			switch(choice) {
				case 0:
					break;
				case 1:
					addChoreTab();
					break;
				case 2:
					removeChoreTab(totals);
					break;
				case 3:
					getAmountToPay(totals, names);
					break;
				case 4:
					readRemainingTasks();
					break;
				default:
					System.out.println("You did not enter a valid choice.");
					break;
			}
			
			// End loop
		}while(choice != 0);
		
	}
}
