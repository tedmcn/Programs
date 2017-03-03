/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 21 Oct 2016
 Problem 2 - This program prints out a series of stars, spaces,
 forward slashes, and back slashes to the console, with the stars
 and forward slashes decrementing while the spaces and back slashes
 increment after each iteration. The size of the grid is dependent 
 on the integer value passed as a parameter through the static method.
 Thus, the middle section containing the slashes stays middle alligned,
 as everything increments and decrements the same amount of times, no
 matter how many rows are requested.
 Bugs: None
 */

public class Problem2 {
	public static void main(String[] args) {
        // Calls upon method and prints amount of rows depending on parameter.
        grid(6);
    }
    public static void grid(int rows) {
        // Outer for loop determines rows that will be printed.
        for(int i = rows;  i >= 1; i--) {
            // Prints amount of left alligned stars based on amount of rows.
            for(int star = i; star >= 2; star--) {
                System.out.print("*");
            }
            // Prints beginning with one space, then inceases amount of spaces by 1 each iteration.
            for(int space = rows; space >= i; space--) {
                System.out.print(" ");
            }
            // Prints full line of forward slashes first, then decreases by 2 each iteration.
            for(int forwardSlash = i; forwardSlash >= 2; forwardSlash--) {
                System.out.print("//");
            }
            // Start off by printing no back slahes, then prints 2 every next line.
            for(int backSlash = i; backSlash <= rows-1; backSlash++) {
                System.out.print("\\\\");
            }
            // Prints begining with one space, then increases amount of spaces by 1 each iteration.
            for(int space2 = rows; space2 >= i; space2--) {
                System.out.print(" ");
            }
            // Prints amount of right alligned stars, same as the original left alligned stars.
            for(int star2 = i; star2 >= 2; star2--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
