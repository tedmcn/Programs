/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 17 Sep 2016
 Problem 6 - This program helps the user find the amount of
 ingredients(in cups) they need for a desired amount of cookies using
 a set recipe which is intended for 48 cookies.
 Bugs: None
 */

import java.util.*;

public class Problem6 {
	public static void main(String[] args) {
        // Creates new Scanner object, then prompts user to input desired amount of cookies
		Scanner console = new Scanner(System.in);
		System.out.println("How many cookies do you want to bake?");
        // Assigns value inputted by user to an integer
        int cookies = console.nextInt();
        // Calculates the amount of sugar, butter, and flour needed, then rounds up the hundreths place
        double sugar = (1.5/48)*cookies-(1.5/48)*cookies%.01;
        double butter = (1.0/48)*cookies-(1.0/48)*cookies%.01;
		double flour = (2.75/48)*cookies-(2.75/48)*cookies%.01;
        // Adds .01 to final value to fully complete rounding the hundreths place
        double finalSugar = sugar+.01;
        double finalButter = butter+.01;
        double finalFlour = flour+.01;
        // Prints the amount of ingredients that will be needed in cups
        System.out.println("For this many cookies, you will need: ");
		System.out.println(finalSugar+" cup(s) of sugar \n"+finalButter+" cup(s) of butter");
		System.out.println(finalFlour+ " cup(s) of flour");
	}
}
		
		
