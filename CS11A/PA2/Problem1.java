/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 17 Sep 2016
 Problem 1 - This program takes a user inputted four digit 
 number and individually prints each digit on one line of code
 so they appear in order going down vertically in the console window.
 Bugs: None
 */

import java.util.*;

public class Problem1 {
	public static void main(String[] args) {
        // Creates new Scanner object, then prompts user to input four digit number
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter a four-digit positive integer:");
        // Assigns the number inputted by the user to an integer
		int number = console.nextInt();
        // Isolates the thousands place
        int digit1 = (number/1000)%10;
        // Isolates the hundreds place
        int digit2 = (number/100)%10;
        // Isolates the tens place
        int digit3 = (number/10)%10;
        // Isolates the ones place
        int digit4 = (number/1)%10;
        // Prints and seperates isolated digits in order on seperate lines
        System.out.println(digit1+"\n"+digit2+"\n"+digit3+"\n"+digit4);
	}
}
		
		
