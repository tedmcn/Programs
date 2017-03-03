/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 19 Nov 2016
 Problem 2 - This program checks for the longest sorted sequence in
 an array, which elements will be assigned by the user, then returns 
 the length of the sequence. The longest sorted sequence is contingent 
 on whether the numbers are going in increasing order form left to right. 
 Bugs: None
 */

import java.util.*;

public class Problem2 {
	public static void main(String[] args) {
		// Creates scanner and prompts for amount of values being inputted.
		Scanner console = new Scanner(System.in);
		System.out.println("How many values will you be inputting?");
		int inputs = console.nextInt();
		// Prompts for the values then assigns them as elements in the array. 
		System.out.println("Please input your "+inputs+" values.");
		int[] a = new int[inputs];
		for(int i = 0; i < inputs; i++) {
			a[i] = console.nextInt(); 
		}
		// Prompts how long the longest sorted sequence is.
		System.out.print("The length of the longest sorted sequence is ");
		System.out.println(longestSortedSequence(a));
	}
	
	public static int longestSortedSequence(int[] a) {
		// Initializes variables that will be used to check if values increase.
		int x;
		int y;
		/* Initializes count to determine length of sequences that increase and update
		   to save a sequences length to count another. */
		int count = 1;
		int update = 0;
		// Traverses array and checks if next value is greater than previous to increment.
		for(int i = 0; i < a.length-1; i++) {
			x = a[i];
			if (i+1 != a.length) {
				y = a[i+1];
				if (x < y) {
					count++;
				// Checks if new sequence is greater than previous then updates and resets.
				} else if (count > update) {
					update = count;
					count = 1;
				// Resets count if values do not increase.
				} else {
					count = 1;
				}
			}
		}
		// Returns length of sequence.
		return update;
	}			
}