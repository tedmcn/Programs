/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 4 Oct 2016
 Problem 3 - This program takes a user inputted integer, which 
 is the value of the exponent the users desires to exponentiate
 the number 2 by. Starting from exponent 0, all values counting
 up until the users input will serve as the exponent of 2, be 
 evaluated, and printed.
 Bugs: None
 */

import java.util.*;

public class Problem3 {
	public static void main(String[] args) {
		// Creates scanner and prompts user to input a value for the exponent, then assigns it to a variable.
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter an exponent: ");
		int x = console.nextInt();
        // Creates loop that prints all outcomes of 2 to the power of the user input starting from 0.
        for(int j = 0; j < x; j++)
            System.out.println(exponentLoop(j));
	}
	public static int exponentLoop(int x) {
        // Assigns variable to 1, in order to since an number to a 0 exponent is 1.
        int n = 1;
        // Creates for loop that exponentiates 2 starting from 0 until user inputted value.
        for(int i = 0; i < x; i++) {
			// The preset variable becomes reassigned each time the loop runs to emulated exponentiation.
            n = n*2;
		}
        return n;
    }
}
