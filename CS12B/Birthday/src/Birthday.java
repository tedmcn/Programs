/* Name: Joshua Alvarado
 * PA2
 * COSI 12B Section 1
 * This program utilizes a Date class, which constructs an object containing the integer values 
 * for the month, day, and year. This client code prompts the client for their birthday, which is 
 * then used to construct a Date object to print a String representation of the date, the day of 
 * week their birthday was on, how long it will be until their birthday, and how many days old 
 * they are. However, if the inputed date happens to be the current date (Which is constructed via
 * an empty parameter constructor), it will prompt the user a happy birthday message as well as how 
 * years old they are now. If the birth year happens to be a leap year, it will prompt if so. 
 */

import java.util.*;

public class Birthday { 
	
	// Initializes scanner for inputs and global variables userDays and todayDays for use in multiple methods.
	public static int userDays;
	public static int todayDays;
	public static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Prompts user for birth date in specific format for proper object construction.
		System.out.print("What month, day, and year were you born? ");
		// Stores each integer value for date in variables to be passed into constructor.
		int month = console.nextInt();
		int day = console.nextInt();
		int year = console.nextInt();
		// Constructs date for inputed birthday as well as current day program is run.
		TeacherDate date = new TeacherDate(year, month, day);
		TeacherDate today = new TeacherDate();
		// Prompts user String representation of birthday as well as day of week it was on.
		System.out.println("Your were born on "+date.toString()+", which was a "+date.getDayOfWeek()+".");
		// Checks if birthday year was leap year, then prompts if so.
		if (date.isLeapYear()) {
			System.out.println(date.getYear()+" was a leap year.");
		}
		// Calculates current age and stores in variable in case current date is birthday.
		int currAge = today.getYear()-date.getYear();
		// Checks if month and day are the same, then prompts happy birthday with age.
		if (today.getDay() == date.getDay() && today.getMonth() == date.getMonth()) {
			System.out.println("Happy Birthday! You are now "+currAge+".");
		// If not birthday, solely prompts client days remaining till their birthday.
		} else {
			System.out.println("It will be your birthday in "+daysTillBDay(date, today)+" days.");
		}
		// Prompts user how many days they have been alive for.
		System.out.println("You are "+daysAlive(date, today)+" days old.");
	}
	
	/**
	 * @daysTillBirthday - calculates how many days remain until the clients birthday by finding how 
	 * many days into the year is the current date as well as the users birthday. Once both are found,
	 * they are subtracted and attributed the absolute value math function to find the amount of days
	 * remaining.
	 * @param date - contains date for clients birthday.
	 * @param today - contains date for current day.
	 * @return - integer value of days between current date and birthday.
	 */
	public static int daysTillBDay(TeacherDate date, TeacherDate today) {
		// Loop iterates 12 times for each month.
		for(int i = 1; i < 13; i++) {
			// Adds amount of days into year until month of birthday.
			if (date.getMonth() > i) {
				if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
					userDays += 31;
				} else if (i == 2) {
					if (today.isLeapYear()) {
						userDays += 29;
					} else {
						userDays += 28;
					}
				} else {
					userDays += 30;
				}
			}
			// Adds amount of days into year until month of current day.
			if (today.getMonth() > i) {
				if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
					todayDays += 31;
				} else if (i == 2) {
					if (today.isLeapYear()) {
						todayDays += 29;
					} else {
						todayDays += 28;
					}
				} else {
					todayDays += 30;
				}
			}
		}
		// Adds day of birthday or current date for corresponding month.
		userDays += date.getDay();
		todayDays += today.getDay();
		// Finds days remaining till birthday using userDays and todayDays.
		if (userDays < todayDays) {
			return 365-(todayDays-userDays);
		} else {
			return userDays-todayDays;
		}
	}
	
	/**
	 * @daysAlive - determines the amount of days the client has been alive for, as it first finds days 
	 * after their day of birth into the year, then finds total days after birth year stopping at the 
	 * current year, then finds the extra days for leap years. In the end, all are added up, but also
	 * including days into the current year.
	 * @param date - contains date for clients birthday.
	 * @param today - contains date for current day.
	 * @return - integer value of days client has been alive.
	 */
	public static int daysAlive(TeacherDate date, TeacherDate today) {
		// Initializes count variable for leap year days in years alive interval.
		int countExtra = 0;
		// Calculates days in year following birthday when born.
		int firstYear = 365-userDays; 
		// Without incorporating leap year days, finds total days in life not including first and current year.
		int days = (today.getYear()-date.getYear()-1)*365;
		// Iterates for each year alive and determines if year was a leap year, then increments count variable.
		for(int i = today.getYear(); i > date.getYear()-1; i--) {
			if ((i%4 == 0 && i%100 != 0) || i%400 == 0) {
				countExtra++;
			}
		}
		// Sums days, first year days, extra days for leap years, and days into current year to find days alive.
		return days+firstYear+todayDays+countExtra;
	}
}
