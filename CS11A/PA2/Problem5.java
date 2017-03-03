/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 17 Sep 2016
 Problem 5 - This program determines the amount of pizza that should be
 ordered for a party with a certain amount of people, which is found by 
 taking the amount of slices needed and dividing by the slices the pizza 
 size they want supplies. It is assumed that one person will eat four slices.
 The size of the pizza and the amount of people attending their party is 
 inputted by the user.
 Bugs:
 */

import java.util.*;

public class Problem5 {
	public static void main(String[] args) {
		// Creates new Scanner object, then prompts user to input desired pizza diameter
        Scanner console = new Scanner(System.in);
		System.out.println("Please state the diameter of the pizza in inches:");
        // Assigns value inputted by user to an integer
		int diameter = console.nextInt();
        // Calculates the radius of the pizza
		double radius = diameter/2;
        // Calculates the surface area of the pizza, then the slices it will have
		double slices = 3.14*(radius * radius)/14.125;
        // Prompts user to input the amount of people attending their party
		System.out.println("How many people will be attending your party?");
        // Assigns value inputted by user to an integer
        int people = console.nextInt();
        // Assigns value for the amount of slices that will be needed to an integer
        int allSlices = people*4;
        // Calculates pizzas needed by dividing the slices needed by the slices one pizza provides
        double totalPizza = allSlices/slices;
        // Checks if there are decimal places, then calculates whether there should be one extra pizza(will either be 1 or 0)
        double extraPizza = (totalPizza%1)/(totalPizza%1);
        // Prints the amount of pizzas needed for the party(adds 1 additional pizza if decimals are present)
        System.out.println("You will need "+(((int)totalPizza+(int)extraPizza))+" pizzas for your party.");
    }
}
				
