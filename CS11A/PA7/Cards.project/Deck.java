/* Name: Joshua Alvarado
Email: jalva@brandeis.edu
Date: 1 Dec 2016
Deck class - The purpose of the Deck class is to intializes the deck
for card drawing in the games, as well as creating the discard pile for
after the cards are used each round. However, this class also preforms 
operations on the deck which are necessary for card games, such as shuffling,
drawing the next card from the deck, and discarding a card(s) after it 
is used. After the deck is completely used up, the dicsard pile becomes the
deck again, and it is shuffled for more rounds of gaming.
Bugs: None
*/

import java.util.*;

public class Deck {
	// Initializes global arrays for deck and discard pile, as well as counters which are needed for testing.
	public Card[] deck;
	public Card[] discardPile;
	private int count = 0;
	private int count1 = 0;

	public Deck() {
		// Initializes Card object array for the deck.
		deck = new Card[52];
		// Initializes count variable for traversing deck array, so that each unique card can be assigned.
		int place = 0;
		// Nested for loop which accounts for the 13 values for each of the 4 suits in a deck. 
		for(int i = 1; i < 5; i++) {
			for(int j = 1; j < 14; j++) {
				// Checks for every new value in outer loop, then changes the suit name in the card intialization.
				if (i == 1) {
					Card c1 = new Card(j, "Hearts");
					deck[place] = c1;
					place++;
				} else if (i == 2) {
					Card c1 = new Card(j, "Diamonds");
					deck[place] = c1;
					place++;
				} else if (i == 3) {
					Card c1 = new Card(j, "Clubs");
					deck[place] = c1;
					place++;
				} else if (i == 4) {
					Card c1 = new Card(j, "Spades");
					deck[place] = c1;
					place++;
				}
			}
		}
		// Initializes discard pile thats length of the deck.
		discardPile = new Card[52];
	}

	public void shuffle() {
		// Iterates lenght of deck and picks random index that is occupied with a Card value.
		for(int i = 0; i <= 51; i++) {
			// Creates random object for random shuffling of deck (through swapping of indexes).
			Random rand = new Random();
			int j = rand.nextInt(52);
			Card temp = deck[j];
			if (temp != null && deck[i] != null) {
				deck[j] = deck[i];
				deck[i] = temp;
			}
		}
	}

	public Card drawNextCard() {
		// Initializes Card object thats being drawn.
		Card c5 = deck[count];
		// Tests if deck still has Card objects in it.
		if (count < 52) {
			count++;
		} else {
			// Assigns now full discard pile back to deck, then reinitializes discard with null.
			deck = discardPile.clone();
			discardPile = new Card[52];
			// Shuffles newly created deck.
			shuffle();
			// Resets count after deck restart.
			count = 0;
			// Initializes card them increments count for next iteration.
			c5 = deck[count];
			count++;
		}
		return c5;
	}

	public void discard(Card c) {
		// Takes in a card as a paramter and places it in discard pile then increments count for next place.
		if (count1 < 52) {
			discardPile[count1] = c;
			count1++;
		// If discard pile reaches end, it reassigns count1 to 0 for another iteration of decks. 
		} else {
			count1 = 0;
			discardPile[count1] = c;
			count1++;

		}
	}

}