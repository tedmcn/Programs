/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 4 Oct 2016
 Problem 1 - This program takes a user input which is the amount of
 times a baseball player was at bat, and also the amount of hits
 they had to find their batting average. This is done by taking the 
 amount of hits and dividing it by the total amount of times at
 bat.
 Bugs: None
 */

import java.util.*;

public class Problem1 {
	public static void main(String[] args) {
		// Creates scanner then prompts user to input times at bat and hits.
        Scanner console = new Scanner(System.in);
		System.out.println("Please state how many times at bat: ");
		double atBat = console.nextDouble();
		System.out.println("Please state how many hits: ");
		double numHits = console.nextDouble();
        // Prints the batting average by taking inputs and running it through the static method.
        System.out.printf("Your batting average is: %.4f\n", battingAverage(atBat, numHits));
	}
	
    public static double battingAverage(double atBat, double numHits) {
		// Calculates the batting average by dividing hits by times at bat.
        double average = (numHits/atBat);
        // Returns average value so that it is identifiable by the main method.
        return average;
	}
}
