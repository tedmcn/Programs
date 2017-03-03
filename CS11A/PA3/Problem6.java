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

public class Problem6 {
	public static void main(String[] args) {
        /* Creates scanner and assigns inputted value, which is the amount of fibonnaci numbers to be displayed, to an integer. */
        Scanner console = new Scanner(System.in);
		System.out.println("Please input an integer: ");
		int a = console.nextInt();
        // Executes loop for the amount fibonnaci numbers desired.
        for(int j = 1; j <= a; j++) {
            System.out.print(fibonacci(j)+" ");
        }
	}
	public static int fibonacci(int x) {
        // Assigns starting two fibannaci numbers to variables.
        int n = 0;
		int y = 1;
		// Executes loop which reassigns variables after adding them together(moves them up the sequence).
        for(int i = 1; i <= x; i++) {
            y = y+n;
            n = y-n;
		}
        return y-n;
    }
}
