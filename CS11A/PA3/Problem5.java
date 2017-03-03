/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 4 Oct 2016
 Problem 5 - This program takes three user inputted integers,
 then factorializes them and prints the result. Factorialization 
 takes the all numbers prior to a specified number and multiplies
 all of them together.
 Bugs: None
 */
import java.util.*;

public class Problem5 {
	public static void main(String[] args) {
		// Creates scanner then prompts user to input three integers and assigns them to variables.
        Scanner console = new Scanner(System.in);
		System.out.print("Enter the first number: ");
		int n1 = console.nextInt();
		System.out.print("Enter the second number: ");
		int n2 = console.nextInt();
		System.out.print("Enter the third number: ");
		int n3 = console.nextInt();
        // Prints all three factorialized user inputted values after running them through static method. 
        System.out.println(n1+"! = "+factorial(n1));
        System.out.println(n2+"! = "+factorial(n2));
        System.out.println(n3+"! = "+factorial(n3));
	}
	public static int factorial(int x) {
        // Assigns 1 to a variable as the starting point for factorialization.
        int z = 1;
		// Creates for loop which factorializes up to user inputted value.
        for(int i = 1; i <= x; i++) {
			// Constantly rassigns variable after multiplying by the following number.
            z = z*i;
		}
        // Returns variable after it is factorialized desired amount of times.
        return z;
	}
}
		
