/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 19 Nov 2016
 Problem 3 - This program replicates the famous guessing game of 
 The Price is Right. The user inputs values which are stored in a 
 array of integers, which is then compared to a constant number, which
 serves as the correct bid. The static method priceIsRight by checking
 each individual element compared to the correct price, and saves elements
 which are greater than the previous, as long as it is under the correct price.
 If greater than the correct price, the next element in the array is tested. 
 If all values are greater than the correct price, the value of -1 is returned.
 Bugs: None
 */

import java.util.*;

public class Problem3 {
	public static void main(String[] args) {
		// Creates scanner and prompts user to input amount of bids being made.
		Scanner console = new Scanner (System.in);
		System.out.println("How many bids will you be making?");
		int inputs = console.nextInt();
		// Prompts user to input guesses and assigns values as elements in the array.
		System.out.println("Please input your "+inputs+" bid values.");
		int[] bids = new int[inputs];
		for(int i = 0; i < inputs; i++) {
			bids[i] = console.nextInt(); 
		}
		// Prompts user which bid was lower but closest to correct price.
		System.out.print("The bid less than but closest to the price was ");
		System.out.println(priceIsRight(bids, 280)+".");
	}
	
	public static int priceIsRight(int[] a, int y) {
		// Initializes int for saving value lower than but closest to correct price.
		int x = 0;
		// Increments count to check if all values in array are over correct price.
		int count = 0;
		/* Traverses array and checks if value is greater than previous, but less than
		   correct price. */ 
		for(int i = 0; i < a.length; i++) {
			if (a[i] > x && a[i] < y) {
				x = a[i];
			}
			// If greater than correct price, increments count.
			if (a[i] > y) {
				count++;
			}
		}
		// If count is equal to value of array length, all values are over correct price.
		if (count == a.length) {
			return -1;
		}
		// Returns value lower but closest to correct price in array.
		return x;
	}
}

			
				
				