/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 17 Sep 2016
 Problem 4 - This program calculates the amount of slices a pizza of 
 a certain measurement will be cut into. THe measurement of the 
 pizza is reliant on the users input of their desired pizza diameter.
 Bugs: None
 */

import java.util.*;

public class Problem4 {
	public static void main(String[] args) {
        // Creates new Scanner object, then prompts user to input desired diameter of pizza
		Scanner console = new Scanner(System.in);
		System.out.println("Please state the diameter of the pizza in inches:");
        // Assigns value inputted by user to an integer
		int diameter = console.nextInt();
        // Calculates the radius of the pizza
		double radius = diameter/2;
        // Calculates the total surface area(in square inches) of the pizza
		double totalPizza = 3.14*(radius * radius);
        // Divides the surface area of the total pizza by the surface area of a slice
		double slices = totalPizza/14.125;
        // Prints the amount of slices a pizza of a certain diameter can be cut into
		System.out.println("Number of slices: "+(int)slices);
	}
}
				
