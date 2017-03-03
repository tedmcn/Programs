/* Name: Joshua Alvarado
 * PA3 Part 1
 * COSI 12B Section 1
 * This program is the client code which tests all the ticket objects that have
 * been created using super and subclasses in order to form a hierarchy. The array
 * which will store the tickets is created using the object of the main superclass
 * which is RegularTicket. Then, the ticket is then populated with the tickets, with
 * each index pertaining to a certain type of ticket object. After the array is 
 * populated, each ticket is printed with their String representation, and the final
 * profit of all tickets is calculated and also printed.
 */

public class TestTicket {

	public static void main(String[] args) {
		// Initializes ticket holder for 15 tickets of differing types. 
		RegularTicket[] arr = new RegularTicket[15];
		// Populates array with tickets in corresponding indices. 
		createArray(arr);
		// Prints each ticket String representation and total profit from all tickets.
		print(arr);
	}

	/**
	 * @createArray - populates the array with the appropriate ticket types at each index.
	 * @param arr - array which will contain all the 15 ticket.
	 */
	public static void createArray(RegularTicket[] arr) {
		// Initialize num for ticket number assigning in order from 1-15.
		int num = 1;
		// Traverses entire array to populate with tickets. 
		for(int i = 0; i < arr.length; i++) {
			// Tests for match indices then constructs appropriate ticket type and increments num for next ticket.
			if (i == 0 || i == 1 || i == 2 || i == 11 || i == 12 || i == 13 || i == 14) {
				RegularTicket t = new RegularTicket(num);
				arr[i] = t;
			} else if (i == 3 || i == 4) {
				WalkupTicket t = new WalkupTicket(num);
				arr[i] = t;
			} else if (i == 5 || i == 6 || i == 7) {
				if (i == 5) {
					AdvanceTicket t = new AdvanceTicket(num, 30);
					arr[i] = t;
				} else if (i == 6) {
					AdvanceTicket t = new AdvanceTicket(num, 15);
					arr[i] = t;
				} else {
					AdvanceTicket t = new AdvanceTicket(num, 3);
					arr[i] = t;
				}
			} else if (i == 8 || i == 9 || i == 10) {
				if (i == 8) {
					StudentAdvanceTicket t = new StudentAdvanceTicket(num, 30);
					arr[i] = t;
				} else if (i == 9) {
					StudentAdvanceTicket t = new StudentAdvanceTicket(num, 15);
					arr[i] = t;
				} else {
					StudentAdvanceTicket t = new StudentAdvanceTicket(num, 3);
					arr[i] = t;
				}
			}
			num++;
		}
		// NOTE: Array is passed by reference, so void is okay and no return is needed.
	}
	
	/**
	 * @print - prints each ticket and its String representation as well as the total profit.
	 * @param arr - populated array for printing tickets String representation and total profit.
	 */
	public static void print(RegularTicket[] arr) {
		// Traverses array and prints String representation for each ticket.
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].print());
		}
		// Stores double value of profit from calculate method for printing.
		double profit = calculateProfit(arr);
		System.out.println("Total profit: "+profit);
	}
	
	/**
	 * @calculateProfit - calculates the profit by traversing through array and computing sum of all tickets.
	 * @param arr - array for traversing each ticket for their price.
	 * @return - double value of total profit from all tickets.
	 */
	public static double calculateProfit(RegularTicket[] arr) {
		// Initializes total increment value.
		double profit = 0;
		// Traverse through array and adds each tickets value to profit total.
		for(int i = 0; i < arr.length; i++) {
			profit += arr[i].getPrice();
		}
		return profit;
	}
}
