/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 21 Oct 2016
 Problem 6 - This program asks for two user inputted birthdays,
 then determines how many days are left till both birthdays 
 based on the current date, which also must be inputted. Also, 
 this code states which persons birthday is sooner. First, a method
 determines what numer(1-365) the date is in the year based on both 
 the month and day. This is done for the two birthdays and the current 
 date. Then, the three values returned and ran through another static 
 method to find the amount of days till both birthdays, as well as which
 birthday is approaching next.
 Bugs: None
 */

import java.util.*;

public class Problem6 {
	public static void main(String[] args) {
        /* Creates scanner and prompts user to enter two birthdays and the current date(month and day), so 
           that they may be stored in individual variables. */
        Scanner console = new Scanner(System.in);
		System.out.println("Please enter the first persons birthday month and day(1-12, 1-31): ");
		int m1 = console.nextInt();
		int d1 = console.nextInt();
		System.out.println("Please enter the second persons birthday month and day(1-12, 1-31): ");
		int m2 = console.nextInt();
		int d2 = console.nextInt();
		System.out.println("Please enter the current month and day: ");
		int month = console.nextInt();
		int day = console.nextInt();
        // Inputs used to calculate the number of day in the year(1-365) that the three dates fall on.
        int x = num(m1, d1);
        int y = num(m2, d2);
        int z = num(month, day);
        /* Return values of day in the year are ran through method to find how many days till birthdays,
           while also identifying which birthday is the soonests. */
        compile(x, y, z);
    }
    public static int num(int m, int d) {
        // Variable intialized equal to 0 for future reassignment after test.
        int n = 0;
        // Tests for what month it is, then assigns days up until the month to preinitialized variable.
        if (m == 1) {
            n = n+0;
        } else if (m == 2) {
            n = n+31;
        } else if (m == 3) {
            n = n+59;
        } else if (m == 4) {
            n = n+90;
        } else if (m == 5) {
            n = n+120;
        } else if (m == 6) {
            n = n+151;
        } else if (m == 7) {
            n = n+181;
        } else if (m == 8) {
            n = n+212;
        } else if (m == 9) {
            n = n+243;
        } else if (m == 10) {
            n = n+273;
        } else if (m == 11) {
            n = n+304;
        } else if (m == 12) {
            n = n+334;
        }
        // Adds day in month entered to amount of days until the month, then reassigns it to the variable.
        n = n+d;
        return n;
    }
    public static void compile(int x,int y,int z) {
        // Preinitializes variables a and b as integers for testing.
        int a;
        int b;
        // Tests if first birthday is after or before current date, then calculates days until birthday.
        if (x > z) {
            a = x-z;
            System.out.println(a+" days are left till the first persons birthday.");
        } else {
            a = -(z-x)+365;
            System.out.println(a+" days are left till the first persons birthday.");
        }
        // Tests if second birthday is after or before current date, then calculates days until birthday.
        if (y > z) {
            b = y-z;
            System.out.println(b+" days are left till the second persons birthday.");
        } else {
            b = -(z-y)+365;
            System.out.println(b+" days are left till the second persons birthday.");
        // Determines whether first or second persons birthday is approaching by comparing days till day.
        }
        if (a < b) {
            System.out.println("The first persons birthday is approaching the soonest.");
        } else if (b < a) {
            System.out.println("The second persons birthday is approaching the soonest.");
        }
    }
}
