/* 
 * Assignment 3 by Zach McCown and Jerome Verbaet
 * Database - Book Inventory Management System
 * 
 * This Java program provides functionality to manage a book inventory. It reads book data from a file, 
 * populates parallel arrays with titles, authors, genres, stocks, and prices. The program supports various
 * commands such as displaying books by a specific author, listing books with low stock, retrieving stock
 * information for a given book, displaying detailed information about a book, calculating the cost of the
 * entire inventory, and handling unknown commands.
 * 
 * Instructions:
 * 1. Ensure that the 'books.txt' file is in the correct format with book data.
 * 2. Run the program to execute commands and manage the book inventory.
 * 3. Use commands such as 'A' for authors' books, 'L' for low stock, 'S' for stock of a book, 'D' for detailed
 *    book information, and 'C' for the cost of the entire inventory.
 * 
 * Note: This program assumes a specific format for the input file and provides useful inventory management
 * features for a book database.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Database {
	
	// Declare arrays as static variables in the class, this to be able to use them throughout the whole program
    private static String[] titles;
    private static String[] authors;
    private static String[] genres;
    private static int[] stocks;
    private static double[] prices;
	
    
    // method to create and fill arrays by reading from the file of which the name is taken as an input
	public static void createArrays(String fileName) {
		try {
		Scanner linesBooks = new Scanner(new File(fileName));
		
		// read first line and store it as int to know how many books will be saved in the parallel arrays
		String firstLine = linesBooks.nextLine();
		int numBooks = Integer.parseInt(firstLine);
		
		// declare length of arrays depending on # of books 
		titles = new String[numBooks];
		authors = new String[numBooks];
		genres = new String[numBooks];
		stocks = new int[numBooks];
		prices = new double[numBooks];
		
		// populate arrays by reading file, splitting Strings, and assigning to correct array and location
		for (int i = 0; i < numBooks; i ++) {
			String bookLines = linesBooks.nextLine();
			String[] linePieces = bookLines.split("#");
			titles[i] = linePieces[0];
			authors[i] = linePieces[1];
			genres[i] = linePieces[2];
			stocks[i] = Integer.parseInt(linePieces[3]);
			prices[i] = Double.parseDouble(linePieces[4]);

		}
		// close Scanner
		linesBooks.close();
		
		}
		catch(FileNotFoundException e) {
			System.out.println("Sorry, did not find the File");
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	// method to display all books by given author; for loop because you need to check all, not one
	public static void getAuthorsBooks(String authorName) {
		System.out.println("Books by " + authorName);
		System.out.println("--------------------------");
		for(int i = 0; i < authors.length; i ++) {
			if (authorName.equals(authors[i]))
				System.out.println(titles[i]);
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	// method to display all books with stock less than 5; for loop because you need to check all, not one
	public static void getLowStock() {
		System.out.println("Low Stock");
		System.out.println("--------------");
		
		for (int i = 0; i < stocks.length; i ++) {
			if (stocks[i] < 5) {
				System.out.println("Title: " + titles[i] + "   Author: " + authors[i]);
				
			}
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	// loop to give stock of specific book, if loop continues unreasonable long, print that the book was not found
	public static void getStock(String titlename) {
		System.out.println("Current Stock");
		System.out.println("------------------");
		int i = 0;
				
		while((titlename.equals(titles[i]) == false && i < 100000)) {
			i++;
		}
		if (i > 99998)
			System.out.println("Book was not found");
		else
			System.out.println("Title: " + titles[i] + "   Number: " + stocks[i]);
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	// method to display all data from a specific book, if loop continues unreasonable long, print that the book was not found
	public static void getBookData(String titlename) {
		
		int i = 0;
		while(titlename.equals(titles[i])== false && i < 100000) {
			i++;
		}
		if (i > 99998)
			System.out.println("Book was not found");
		else {
			System.out.println("Title: " + titles[i]);
			System.out.println("Author: " + authors[i]);
			System.out.println("Genre: " + genres[i]);
			System.out.println("QOH: " + stocks[i]);
			System.out.println("Price: " + prices[i]);
	}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	// method to return cost of inventory by adding up the multiplication of stock and price for each book
	public static void getCostOfInventory() {
		double totalCost = 0.0;
		
		for(int i = 0; i < titles.length; i++) {
			totalCost += prices[i] * stocks[i];
		}
		System.out.println("The total cost of the inventory is $" + totalCost);
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	// method to process commands and make program go into the right method
	public static void processCommand(String line) {
		String[] linePieces = line.split("#");
		
		switch(linePieces[0]) {
		
		case "A":
			getAuthorsBooks(linePieces[1]);
			break;
		case "L":
			getLowStock();
			break;
		case "S":
			getStock(linePieces[1]);
			break;
		case "D":
			getBookData(linePieces[1]);
			break;
		case "C":
			getCostOfInventory();
			break;
		default:
			System.out.println("This command is not valid: " + line);
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	
	public static void main(String[] args) {
		try {
		
		Scanner scannerMain = new Scanner(new File("books.txt"));
		createArrays("books.txt");
		
		int numBooks = scannerMain.nextInt();
		scannerMain.nextLine(); // skip over first line
		
		// skip over lines that have book-data in them
		for(int i = 0; i < numBooks; i++) {
			scannerMain.nextLine();
		}
		// call processCommand method for each line
		while (scannerMain.hasNextLine()) {
			String line = scannerMain.nextLine();
			processCommand(line);
			System.out.println("\n");
		}
		
		
		}
		catch(FileNotFoundException e) {
			System.out.println("Sorry, did not find the File");
		}
		
	}

}
