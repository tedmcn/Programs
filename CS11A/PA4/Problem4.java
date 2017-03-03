/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 21 Oct 2016
 Problem 4 - This program prompts the user for a date,
 then determines what day of the week that specific day 
 was or will be. Leap years are taken into account, as the 
 order of days is not consistent. This date is then ran 
 through a static method as a parameter, so taht the 
 number of day in the year is succefully found (days that
 are skipped are taken into account by incorperating
 when leap years occur and how many days are skipped. 
 Then, this number is ran through another static method 
 to determine the day of the week that date falls on.
 Bugs: None
 */

import java.util.*;

public class Problem4 {
    public static void main(String[] arg) {
        // Creates scanner and prompts user to inout the month, day and year of the date.
        Scanner console = new Scanner(System.in);
        System.out.println("Enter a month(1-12): ");
        int month = console.nextInt();
        System.out.println("Enter a day(1-31): ");
        int day = console.nextInt();
        System.out.println("Enter a year(YYYY): ");
        int year = console.nextInt();
        // Assigns value returned from method to an integer.
        int num = number(month, day, year);
        // Runs number of date through method to determine day of the week.
        date(num);
    }
    public static int number(int m, int d, int y) {
        // Initalizes variable set to 0 for saving the amount of days up until a month.
        int n = 0;
        // Tests for user inputted month then reassigns amount of days to a variable.
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
            n= n+273;
        } else if (m == 11) {
            n = n+304;
        } else if (m == 12) {
            n = n+334;
        }
        // Calculates the amount of dyas in the year the date is, considering leap years.
        n = n+d+(y*365+y/4-y/100+y/400);
        // Tests if the year entered is a leap year, and if true, 1 day is subtracted.
        if (n/4 == 0 && n/100 == 0 && n/400 == 0 || n/4 == 0 && n/100 != 0) {
            n = n-1;
        }
        return n;
    }
    public static void date(int num) {
        // Initializes string variable for testing.
        String date = "";
        // Tests for what day of the week it is by using modulus to allign with a day.
        if (num%7==0) {
            date = "Saturday";
        } else if (num%7 == 1) {
            date = "Sunday";
        } else if (num%7 == 2) {
            date = "Monday";
        } else if (num%7 == 3) {
            date = "Tuesday";
        } else if (num%7 == 4) {
            date = "Wednesday";
        } else if (num%7 == 5) {
            date = "Thursday";
        } else if (num%7 == 6) {
            date = "Friday";
        }
        // Prints name of day inputted date falls on.
        System.out.println("That day is a "+date);
    }
}
