/* Name: Joshua Alvarado
 * PA3 Part 1
 * COSI 12B Section 1
 * This program is a subclass from the subclass AdvanceTicket, which's superclass is RegularTicket.
 * The only difference from AdvanceTicket is that the price is cut in half for all prices, no matter 
 * the amount of days in advance it has been purchased. 
 */

public class StudentAdvanceTicket extends AdvanceTicket {

	/**
	 * @StudentAdvanceTicket - constructs student advance ticket object with its number value and days in advance purchased. 
	 * @param number - integer value which represents ticket.
	 * @param days - integer value of the amount of days in advance the ticket was purchased.
	 */
	public StudentAdvanceTicket(int number, int days) {
		super(number, days);
	}

	/**
	 * @getPrice - determines price using days in superclass AdvanceTicket, then cuts it in half for students.
	 */
	public double getPrice() {
		return super.getPrice()/2;
	}
	
}
