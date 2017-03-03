/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 21 Oct 2016
 Problem 1 - This program converts a user inputted binary 
 string into its decimal form as an integer. The conversion 
 occurs in a static method returning an integer value, which
 is then printed as the method is called upon in the main method.
 The binary string is broken apart from left to right, caluculating 
 the value of each place, then adding the sum of each place after 
 each iteration.
 Bugs: None
 */

import java.util.*;

public class Problem1 {
	public static void main (String[] args) {
		// Creates scanner object for user binary number input.
        Scanner console = new Scanner (System.in);
        System.out.println("Please input a binary number: ");
        String binary = console.next();
		// Runs user input as parameter through method to convert into decimal form.
        System.out.println(decimalConvert(binary));
    }
    public static int decimalConvert(String x) {
        // Assigns length of input and exponents to be used for conversion to variables.
        int length = x.length();
        int power = length-1;
        // Initially assigns variable to 0, then it is reassigned as the sum is found.
        int z = 0;
        // Executes depending on the amount of places the binary number contains.
        for(int i = 0; i <= length-1; i++) {
            // Takes each character and converts it to an integer of either 1 or 0.
            int number = (int)x.charAt(i);
            if (number == 49) {
                number = 1;
            } else {
                number = 0;
            }
            // Calculates bianry to decimal conversion.
            int decimal = number*(int)Math.pow(2, power);
            // Reassigns the power variable for the next place and z variable to add after each iteration.
            power = power-1;
            z = decimal+z;
        }
        return z;
    }
}
