/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 17 Sep 2016
 Problem 3 - This program returns change to the user depending 
 on the price of the item being purchased(since it is always assumed 
 that one dollar is used to pay). The goal is to provide the user change
 using the fewest coins.
 Bugs: None
 */

import java.util.*;

public class Problem3 {
	public static void main(String[] args) {
        // Creates new Scanner object, then prompts user to input value of item
		Scanner console = new Scanner(System.in);
		System.out.println("Enter price of item");
		System.out.println("(from 25 cents to a dollar, in 5-cent increments):");
        // Assigns value inputted by user to an integer
		int price = console.nextInt();
        // Calculates change due by subtracting money given and price
        int change = 100-price;
        // Determines amount of quarters to be given
        int quarters = change/25;
        // Determines amount of dimes to the given
        int dimes = (change%25)/10;
        // Determines if a nickel is to be given
        int nickels = ((change%25)%10)/5;
        // Prints the items price and the change that the user will recieve
        System.out.println("You bought an item for "+price+" cents and gave me a dollar, so your");
        System.out.println("change is:");
        System.out.println(quarters+ " quarters, \n"+dimes+" dimes, \n"+nickels+" nickel");
	}
}
		
