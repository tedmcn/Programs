/* Name: Joshua Alvarado
 * PA3 Part 1
 * COSI 12B Section 1
 * This program is a subclass from the superclass RegularTicket, which is constructed the same,
 * but its price and String representation are altered in terms of the walk up ticket object 
 * credentials. 
 */

public class WalkupTicket extends RegularTicket {
	
	/**
	 * @WalkupTicket - constructs walkup tick object using method from superclass RegularTicket.
	 * @param number - integer value which represents ticket.
	 */
	public WalkupTicket(int number) {
		super(number);
	}

	/**
	 * @getPrice - gets value of regular ticket from superclass, then adds difference to equate 50.
	 */
	public double getPrice() {
		return super.getPrice()+10;
	}

	/**
	 * @print - returns String representation of ticket, including its number and price, and its type of ticket. 
	 * @return - String representation of walk up ticket.
	 */
	public String print() {
		return super.print()+" (Walk up ticket)";
	}
}
