/* Name: Joshua Alvarado
 * PA3 Part 1
 * COSI 12B Section 1
 * This program is a subclass from the superclass RegularTicket, which is constructed the same 
 * way except for the addition of the amount of days in advance the client purchased it. Also,
 * the getPrice differs depending on how many days in advance the ticket was purchased from, and 
 * the String representation includes the amount of days in advance the ticket was purchased. 
 */

public class AdvanceTicket extends RegularTicket {

	private int days;
	
	/**
	 * @AdvanceTicket - constructs advance ticket object with its number value and days in advance purchased. 
	 * @param number - integer value which represents ticket.
	 * @param days - integer value of the amount of days in advance the ticket was purchased.
	 */
	public AdvanceTicket(int number, int days) {
		super(number);
		this.days = days;
	}
	
	/**
	 * @getPrice - determines price for ticket depending on how many days in advance it was purchased in. 
	 */
	public double getPrice() {
		if (days >= 20) {
			return super.getPrice()-25;
		} else if (20 > days && days > 10) {
			return super.getPrice()-20;
		} else {
			return super.getPrice();
		}
	}

	/**
	 * @print - adds the amount of days in advance the ticket was purchased. 
	 */
	public String print() {
		return super.print()+" (Days purchased in advance: "+days+")";
	}
}
