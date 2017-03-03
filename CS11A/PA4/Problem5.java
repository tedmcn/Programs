/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 21 Oct 2016
 Problem 5 - This program takes a user inputted integer
 no larger than 4999, and converts it to display its
 equivalent in roman numerals. The thousands place is first 
 isolated by division, then the result is the amount of times
 the character for thousand will run. Similarly, the hundreds,
 tens, and ones place is determined by checking each digit in
 each place, then tests its value to determine which charaters 
 are printed.
 Bugs: None
 */

import java.util.*;

public class Problem5 {
	public static void main(String[] args) {
        // Creates scanner and assigns input to a variable.
		Scanner console = new Scanner(System.in);
        System.out.println("Please print a number no larger then 4999: ");
        int num = console.nextInt();
		// Runs method to determine amount of M's for thousands place.
        thousandsPlace(num);
        /* Runs method to determine which combinations of letters are need to display
           hundreds, tens and ones place of input. */
        romanConvert('M', 'D', 'C', ((num%1000)/100));
        romanConvert('C', 'L', 'X', ((num%100)/10));
        romanConvert('X', 'V', 'I', ((num%10)/1));
        System.out.println();
	}
    public static void thousandsPlace(int x) {
        // Prints M by the amount of the digit in the thousands place.
        for(int i = 1; i <= (x/1000); i++) {
            System.out.print("M");
        }
    }
    public static void romanConvert(char a, char b, char c, int x) {
        // Tests if value is 9 to display appropriate notation.
        if (x == 9) {
            System.out.print(c);
            System.out.print(a);
        // If not 9, tests if value is 5 or greater then prints appropriate notation. .
        } else if (x >= 5) {
            System.out.print(b);
            for(int i = 0; i < x-5; i++) {
                System.out.print(c);
            }
        // If not greater or equal to 5, it tests if value is 4, then prints approprite notation.
        } else if (x == 4) {
            System.out.print(c);
            System.out.print(b);
        // If not 4, tests is value is greater than or equal to 1, then prints the amount of the value.
        } else if (x >= 1) {
            for(int i = 0; i < x; i++)
                System.out.print(c);
        }
    }
}
