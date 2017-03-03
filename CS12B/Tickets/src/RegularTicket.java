/* Name: Joshua Alvarado
 * PA3 Part 1
 * COSI 12B Section 1
 * This program serves as the originating or actual superclass for the rest of the 
 * subclasses in the ticket hierarchy. This superclass RegularTicket object is 
 * constructed with a number, representing the ticket. Also, it contains methods 
 * which returns the price of regular ticket, and a String representation of the
 * regular ticket containing its ticket number and price.
 */

public class RegularTicket {
		
	private int number;
	
	/**
	 * @RegularTicket - constructs the regular ticket object, assigning it the number value.
	 * @param number - integer value which represents ticket. 
	 */
	public RegularTicket(int number) {
		this.number = number;
	}
	
	/**
	 * @getPrice - returns the price of the regular ticket.
	 * @return - price of ticket as double
	 */
	public double getPrice() {
		return 40;
	}
	
	/**
	 * @print - returns String representation of ticket, including its number and price. 
	 * @return - String representation of regular ticket.
	 */
	public String print() {
		return "Ticket number = "+number+" and price = "+getPrice();
	}
}
