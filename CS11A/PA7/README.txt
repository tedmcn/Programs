Joshua Alvarado
December 1, 2016
COSI 11A

PA7 Writeup

Card class

- In this class, I primarily followed the framework and suggestions on the assignment sheet, but I in doing so, realized what additional tests were necessary when initializing a Card object. The card is comprised of its suit, color, and value. Knowing this, I knew to create a constructor which assigns inputted values back to the global variables, so that they can be used in further testing. In the getColor method, I tested for the inputted suit, then returned the cards color according to its suit. In toString, I assigned the name of value to a string for printing the string representation, as well as solely print the cards number value if it did not have an intrinsic name value for it.

Deck class

- This class was indeed more logical, since all the methods (other than the constructor), served as ways of behavior for the constructor. For the constructor, I create each unique playing card that is part of a 52 deck, then assign its value to each slot in a 52 length Card array, which serves as the deck. In order to shuffle, it traverses the array randomly, but never repeating a already selected index. Then, it swaps values of two indexes until everything has been moved at least once. For drawing the cards, it would take the each subsequent value from the start of the deck, and assign its Card value to a Card variable to be returned. Once the deck is completely used, it makes the discard pile the deck, resets discard pile to all null, then draws the first card from the new deck. For discarding, I sent the card being discarded to the discard pile, then move to the next index for the next discard. 

Casino class

- In the Casino class client code, I simulate the game of Simple War. Essentially, I prompt the user rules of the game, give them a $1000 balance, and start the loop for the game (The scanner object and deck Card array shuffled is created first for starting the game). The game loop runs until the user runs out of money, or if they decide not not play anymore once prompted. The game is responsible for taking the users bet, drawing the cards, checking for which value is better, and adding or subtracting bet from the balance.