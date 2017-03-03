/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 4 Oct 2016
 Problem 7 - This program takes two user inputted values,
 representing the amount of rows and columns desired. Numbers 
 counting upward from 1 are printed going down the rows vertically,
 but continues at the top of columns when going rightward.
 Bugs: None
 */

import java.util.*;

public class Problem7 {
	public static void main(String[] args) {
		// Creates scanner and prompts user to input values for rows and columns of thr grid.
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the amount of rows: ");
		int rows = console.nextInt();
        System.out.print("Enter the amount of columns: ")
		int columns = console.nextInt();
        // Inserts inputted values as parameters for static method.
		grid(rows, columns);
	}
	public static void grid(int rows, int columns) {
		// Outer for loop controls amount of rows printed.
        for(int i = 1; i <= rows; i++) {
			// Inner loop controls how long and indented the columns are.
            for(int j = 1; j <= columns; j++) {
                System.out.printf("%-6d", i);
                // Adds number of rows(user input) to the value right of each column.
                i = i+rows;
            }
            // Goes onto new line and resets variable for running of outer loop.
            System.out.println();
            i = i-(rows*columns);
        }
	}
}
