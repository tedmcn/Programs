/* Name: Joshua Alvarado
Email: jalva@brandeis.edu
Date: 1 Dec 2016
Card class - The purpose of the Card class is to construct the card
objects which will be used in both the Deck and Casino class. Each card
is contructed with two qualities that are essential for the games, in which
being its value and suit. Other than construct the Card object, this code
has methods which return the cards value, color (according to its suit), 
suit, and string representation of the card. 
Bugs: None
*/

public class Card {
	// Initializes class global variables needed for card constructing and methods.
	private String suit;
	private String color;
	public int value; 

	public Card(int value, String suit) {
		// Once a Card constructor is initialized from another class using parameters, it is created.
		this.value = value;
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public String getColor() {
		// Tests for cards suit then returns appropriate color for that suit. 
		if (suit.equals("Hearts") || suit.equals("Diamonds")) {
			color = "Red";
		} else {
			color = "Black";
		}
		return color;
	}

	public String getSuit() {
		return suit;
	}

	public String toString() {
		// Initializes strings for final string representation of card and word representation of certain values.
		String card = " ";
		String valueName = " ";
		// Tests if cards value is one with a name, then assigns name to string for complete String representation.
		if (value == 1) {
			valueName = "Ace";
		} else if (value == 11) {
			valueName = "Jack";
		} else if (value == 12) {
			valueName = "Queen";
		} else if (value == 13) {
			valueName = "King";
		} else {
			// If card value does not have a name attribute to it, it prints solely the numerical value and suit.
			card = value+" of "+suit;
		}
		// If card value is one with a name, string representation using value name is assigned.
		if (value == 1 || value == 11 || value == 12 || value == 13) {
			card = valueName+" of "+suit;
		} 
		return card;
	}
}