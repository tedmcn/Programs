/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 4 Oct 2016
 Problem 2 - This program takes two user inputs, in which being
 their first and last names, then converts it into pig latin 
 format. The first letter is taken and moved to the end of the
 name along with -ay following it, then the second letter (now 
 the first), is capitalized to complete pig latin translation.
 Bugs: None
 */

import java.util.*;

public class Problem2 {
	public static void main(String[] args) {
		// Creates scanner and prompts user to input first and last name, then assigns values to strings.
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter your first name: ");
		String first = console.next();
		System.out.println("Please enter your last name: ");
		String last = console.next();
        // Prints out returned pigLatin translated string values for both first and last name.
        System.out.printf("%s %s \n", pigLatin(first), pigLatin(last));
	}
    public static String pigLatin(String name) {
        // Sets all letters to lowercase and assigns the starting letter for each pig latin name.
        String lowerName = name.toLowerCase();
        String capFirst = lowerName.substring(1,2);
        // Completes pigLatin translation(uppercases second letter, moves first letter to end, adds "ay").
        String completeName = capFirst.toUpperCase()+lowerName.substring(2)+lowerName.charAt(0)+"ay";
        return completeName;
    }
}

