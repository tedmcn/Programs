/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 17 Sep 2016
 Problem 2 - This program converts a user inputed temperature
 in degrees Fahrenheit to Celsius. The final Celsius value is 
 then presented solely including the whole and tenths value.
 Bugs: None
 */

import java.util.*;

public class Problem2 {
	public static void main(String[] args) {
        // Creates new Scanner objectn then prompts user to input temperature
		Scanner console = new Scanner(System.in);
        System.out.println("Enter a temperature in degrees Fahrenheit(Input a whole number):");
        // Assigns value for temperature inputted by user to an integer
		int fTemp = console.nextInt();
        // Calculates the degrees Celsius
        double cTemp = 5*((double)fTemp-32)/9;
        // Converts the double value of Celsius to an integer
        int a = (int)cTemp;
        // Isolates the tenths place decimal value
        int b = (int)((cTemp-a)*10);
        // Prints initial inputted Fahrenheit value and its equivalnet in Celcius(including solely the tenths place)
		System.out.println(fTemp+" degrees Fahrenheit is "+a+"."+b+" degrees Celsius.");
	}
}		
