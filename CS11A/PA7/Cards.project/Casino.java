/* Name: Joshua Alvarado
Email: jalva@brandeis.edu
Date: 1 Dec 2016
Casino class - The purpose of the Casino class 
Bugs: None
*/

import java.util.*;

public class Casino {

	public static void main(String[] args) {
		// Prompts user name and rules of Simple War.
		System.out.println("\nWelcome to Simple War!\n");
		System.out.println("RULES: You and I will both select one card each.");
		System.out.println("If your card value is higher, you win.");
		System.out.println("If the my card value is higher, you lose.");
		System.out.println("If both cards are the same value, it is a tie.");
		// Initializes starting balance, then prompts user. 
		int balance = 1000;
		System.out.println("\nYour starting balance is $"+balance);
		// Initializes boolean value to run while loop, and also for asking if user wishes to play again.
		boolean play = true;
		// Creates scanner for asking user inputs for bets and whether they want to play again.
		Scanner console = new Scanner(System.in);
		// Initializes Deck object game will utilize to pull cards out of, then shuffles the deck. 
		Deck deck = new Deck();
		deck.shuffle();
		// Runs while loop until user is out of money or when user states to stop.
		while (balance > 0 && play) {
			// Prompts user to enter bet and assigns value to integer.
			System.out.print("\nHow much do you want to bet? $");
			int bet = console.nextInt();
			// Initializes cards that user and cpu will draw from the deck.
			Card user = deck.drawNextCard();
			Card cpu = deck.drawNextCard();
			// Assigns value of drawed card to integer for testing which card is higher. 
			int userValue = user.getValue();
			int cpuValue = cpu.getValue();
			// Prompts user with string representation of cards.
			System.out.println("\nYour Card: "+user.toString());
			System.out.println("My Card: "+cpu.toString());
			// If user value is higher, prompts that they won and adds bet amount to balance.
			if (userValue > cpuValue) {
				System.out.println("\nYou win!\n");
				balance += bet;
			// If cpu value is greater than users, prompts user they lost and subtracts bet from balance. 
			} else if (userValue < cpuValue) {
				System.out.println("\nYou lose!\n");
				balance -= bet;
			// Prompts for tie since values are conclusively equal. 
			} else {
				System.out.print("It's a tie.");
			}			
			// Prompts new updated balance and discards cards for user and cpu.
			System.out.println("Your balance is currently $"+balance);
			deck.discard(user);
			deck.discard(cpu);
			// If balance is 0 or less, prompts user and exits out of game.
			if (balance <= 0) {
				System.out.println("\nYou are out of money! Thanks for playing.\n");
				play = false;
			// If there is still funds in balance, prompts user if they want to play again.	
			} else {
				System.out.print("\nWould you like to keep playing? (1 for Yes/0 for No): ");
				// Takes user input of 1 or 0 if they wish to keep playing.
				int playAgain = console.nextInt();
				// If users does choose 0, prompts final balance and exits game.
				if (playAgain == 0) {
					System.out.println("\nThanks for playing! Final balance: $"+balance+"\n");
					play = false;
				}
			}
		}
	}
}