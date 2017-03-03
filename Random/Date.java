/* Name: Joshua Alvarado
 * PA2
 * COSI 12B Section 1
 * This program creates the Date class object, which fields are solely the integer values for
 * the year, month, and date the constructed date is on. However, if the Date object is constructed
 * with no parameters, it will create an Date containing the current date the program is run on.
 * This class contains instance methods which return the day, month, and year (integer values) of
 * date, the day of the week it falls on, whether the year in the date is a leap year, the next following 
 * date, amount of days in the dates month, the string representation of the date, and whether a 
 * date passed as a parameter is equivalent to the implicit parameter date.
 */

public class Date {
	
	// Initializes encapsulated fields for Date object.
	private int year;
	private int month;
	private int day;
	
	/**
	 * @Date - This Date constructor activates when a Date is constructed with parameters 
	 * indicating the year, month, and day of the date.
	 * @param year - year of Date object being constructed.
	 * @param month - month of Date object being constructed.
	 * @param day - day of Date object being constructed.
	 */
	public Date(int year, int month, int day) {
		// Assigns values passed into constructor to corresponding class fields.
		this.year= year;
		this.month = month;
		this.day = day;
	}
	
	/**
	 * @Date - This Date constructor is activated when a Date object is constructed without
	 * any parameters, thus creating a Date object for the current day the program is run.
	 */
	public Date() {
		// Initializes count for finding days into the year, and extraDays for extra leap year days.
		int count = 0;
		int extraDays = 0;
		// Calculates amount of days elapsed since 1/1/1970, then saves into integer.
		int daysSinceEpoch = TeacherDate.getDaysSinceEpoch();
		// Finds amount of years that have passed since 1970, then reconverts years into days for another variable.
		int years = (daysSinceEpoch/365);
		int days = years*365;
		// Initializes current year to Date objects year field.
		year = years+1970;
		// Iterates every year from 1970 till 2017 to count extra leap year days.
		for(int i = 1970; i < year; i++) {
			if ((i%4 == 0 && i%100 != 0) || i%400 == 0) {
				extraDays++;
			}
		}
		// 
		int daysIntoYear = daysSinceEpoch-days-extraDays+1;
		for(int i = 1; i < 13; i++) {
			if (i == 4 || i == 6 || i == 9 || i == 11) {
				count += 30;
				if (daysIntoYear < count) {
					month = i;
					day = daysIntoYear-count+30;
					break;
				}
			} else if (i == 2) {
				count += 28;
				if (daysIntoYear < count) {
					month = i;
					day = daysIntoYear-count+28;
					break;
				}
			} else {
				count += 31;
				if (daysIntoYear < count) {
					month = i;
					day = daysIntoYear-count+31;
					break;
				}
			}
		}
    }
    
	/**
	 * @getDay - instance method which returns value of dates day field.
	 * @return - integer value of Date's day.
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * @getMonth - instance method which returns value of dates month field.
	 * @return - integer value of Date's month.
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * @getYear - instance method which returns value of dates year field.
	 * @return - integer value of Date's year.
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * @getDayOfWeek - Determines String value of dates day of the week.
	 * @return - String value of Date's day of the week.
	 */
	public String getDayOfWeek() {
		// Initializes count for extra leap year days and daysIntoYear days elapsed in current year.
		int count = 0;
        int daysIntoYear = 0;
        // Iterates for all years between current year and 1753 for leap year day count.
		for(int i = 1753; i < getYear(); i++) {
			if ((i%4 == 0 && i%100 != 0) || i%400 == 0) {
				count++;
			}
		}
		// Iterates for each month until month of date and counts days till then.
        for(int i = 1; i < 13; i++) {
			if (getMonth() > i) {
				if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
					daysIntoYear += 31;
				} else if (i == 2) {
                    if (isLeapYear()) {
					   daysIntoYear += 29;
                    } else {
                       daysIntoYear += 28;
                    }
				} else {
					daysIntoYear += 30;
				}
			}
        }
        // Calculates total days since current and input date.
		int days = (getYear()-1753)*365+count+daysIntoYear+getDay();
		// Determines what day of the week it is.
		if (days%7 == 0) {
			return "Sunday";
		} else if (days%7 == 1) {
			return "Monday";
		} else if (days%7 == 2) {
			return "Tuesday";
		} else if (days%7 == 3) {
			return "Wednesday";
		} else if (days%7 == 4) {
			return "Thursday";
		} else if (days%7 == 5) {
			return "Friday";
		} else {
			return "Saturday";
		}
	}
	
	/**
	 * @isLeapYear - Determines whether dates year is a leap year.
	 * @return - boolean value if it is leap year or not (Yes = True, No = False)
	 */
	public boolean isLeapYear() {
		if ((year%4 == 0 && year%100 != 0) || year%400 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @nextDay - Changes current date to the following date.
	 */
	public void nextDay() {
		day++;
		if (day > daysInMonth()) {
			month++;
			day = 1;
			if (month > 12) {
				year++;
				month = 1;
			}
		}
	}
	
	/**
	 * @daysInMonth - Finds the amount of days that are in dates corresponding month.
	 * @return - integer value of how many days are in dates month.
	 */
	public int daysInMonth() {
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		} else if (month == 2) {
			if (isLeapYear()) {
				return 29;
			} else {
				return 28;
			}
		} else {
			return 31;
		}
	}
	
	/**
	 * @toString - Returns String representaion of date.
	 * @return - String value demonstration year/month/day of date.
	 */
	public String toString() {
		return year+"/"+month+"/"+day;
	}

	/**
	 * @equals - Checks if input parameter object is equal to implicit parameter object.
	 * @return - boolean value signaling whether parameter object is equivalent to date object.
	 */
	public boolean equals(Object o) {
		if (o instanceof Date) {
			Date other = (Date) o;
			return year == other.year && month == other.month && day == other.day;
		} else {
			return false;
		}
	}
}

