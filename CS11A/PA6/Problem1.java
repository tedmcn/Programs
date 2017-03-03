/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 19 Nov 2016
 Problem 1 - This program checks whether inputted values by the 
 user are unique, meaning that the numbers inputted do not repeat.
 The inputted values are stored in an array, which is then tested
 in static method isUnique by traversing the array and identifying
 whether two elements in the array equal each other. If so, the 
 method returns the boolean false, but if unique, it returns true.
 Bugs: None
 */

import java.util.*;

public class Problem1 {
	
	public static void main(String[] args) {
		// Creates scanner and prompts user amount of inputs being entered.
		Scanner console = new Scanner (System.in);
		System.out.println("How many values will you be inputting?");
		int inputs = console.nextInt();
		// Prompts for user to input values. (One at a time)
		System.out.println("Please input your "+inputs+" values.");
		// Initializes array to length specified by user.
		int[] a = new int[inputs];
		// Traverses array and asks user to input value for each element.
		for(int i = 0; i < inputs; i++) {
			a[i] = console.nextInt(); 
		}
		// Test if value from isUnique is true or false then prints if unique or not. 
		if (isUnique(a) == true) {
			System.out.println("The inputs you entered are unique. (true)");
		} else {
			System.out.println("The inputs you entered are not unique. (false)");
		}
	}
	
	public static boolean isUnique(int[] a) {
		// Initializes boolean for potential future reassignment and int for incrementing.
		boolean unique = true;
		int check = 1;	
		// Traverses array by each alternating place and checks if values repeat.
		for(int i = 0; i < a.length; i++) {
			for(int j = check; j < a.length; j++) {
				// Initializes alternating values for testing.
				int x = a[i];
				int y = a[j];
				if (x == y) {
				// If values equate, false is reassigned and returned.
					unique = false;
				}
			}
			// Increments for further testing array.
			check++;
		}
		// Returns true if no values repeat.
		return unique;
	}
}		
	