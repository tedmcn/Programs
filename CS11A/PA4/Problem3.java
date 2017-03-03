/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 21 Oct 2016
 Problem 3 - This program reads an integer entered by the user, 
 which takes the input and divides it by 2 if even and multiplies 
 it by 3 and adds 1 if odd. The value is printed after each iteration, 
 then the  amount of procedures is printed by creating a variable equal
 to 0 and increasing its value by 1 after each iteration. If the 
 value inputted is equal to or less than 1, an error message is
 printed.
 Bugs: None
 */

import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        // Creates scanner and stores integer variable to be tested in variable.
        Scanner console = new Scanner(System.in);
        System.out.println("Please input an integer: ");
        int num = console.nextInt();
        // Calls upon method as integer value is passed as a parameter.
        sequence(num);
	}
	public static void sequence(int x) {
        // Prints starting value before sequence runs.
        System.out.println("Initial value is: "+x);
        // Assigns value of input to another variable and a variable to 0 for calculations and reassignemts.
        int y = x;
        int z = 0;
        // Tests if value inputted is greater than 1 in order to run.
        if (y > 1) {
            // Runs loop until final value is ultimately 1.
            for(int i = 1; y > 1; i++) {
                // Tests if value is even, divides value by 2, prints it. It then adds to amount of iterations.
                if (y%2 == 0) {
                    y = y/2;
                    System.out.println("Next value is: "+y);
                    z = z+1;
                /* Tests if value is odd, multiplies it by 3 then adds 1, prints it, then adds to amount of iterations. */
                } else if (y%2 == 1) {
                    y = (y*3)+1;
                    System.out.println("Next value is: "+y);
                    z = z+1;
                }
            }
        // If value is less than or equal to 1, error message is printed.
        } else {
            System.out.println("Error");
        }
        // Ends sequence by stating final value, as well as the total amount of operations preformed.
        System.out.println("Final value 1, number of operations preformed "+z);
    }
}
