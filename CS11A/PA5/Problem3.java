/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 4 Nov 2016
 Problem 3 - This program plays a game of reverse hangman with the user. It guesses
 randomly, and if a correct letter is chosen, the letter is displayed as part
 of the word (computer won't guess same letter twice). The program prompts for 
 the length of the word and the word itself. The blank line displayed initially 
 is the length of the word, and changes depending if the correct letter is 
 guessed. If incorrect 6 times (the amount of body parts), the computer loses>
 For each incorrect guess, a new body part is displayed. 
 Bugs: None
 */

import java.util.*;

public class Problem3 {
	
	public static void main(String[] args) {
		// Creates scanner and prompts user how the game will work.
		Scanner console = new Scanner(System.in);
		System.out.println("\nThis program plays a game of reverse hangman.");
		System.out.println("You think of a word (by typing it on the computer) and I'll try to guess");
		System.out.println("the letters.\n");
		// Requests two inputs, being the letters in the word and the word itself.
		System.out.print("How many letters are in your word? ");
		int letterCount = console.nextInt();
		System.out.printf("Please enter the word for me to guess (letters only): ");
		String s1 = console.next();
		// Passes word as a parameter to method for computer guessing.
		hangman(s1);
	}

	public static void hangman(String s1){
		// String variables initialized fo blank spaces, as well as dashes for word guessing. 
		String s2 = " ";
		String x = "-";
		// Creates integer variables to track wrong guesses and right guesses.
		int right = 0;
		int wrong = 0;
		// Iterates dashes for the amount of letters in the word.
		for(int i = 1; i < s1.length(); i++){
			x = x+"-";
		}
		// Creates random object for random computer guessing.
		Random guess = new Random();
		// Initializes int for ASCII number to letter conversion.
		int letter;
		// Iterates until the 6 wrong guesses or when the word is completely guessed.
		while (x.equals(s1) == false && wrong < 7){
			// Prints dashed line of word.
			System.out.println(x);
			// Tests if the wrong and prints corresponding image of the hangman.
			if (wrong == 0) {
				System.out.println("+--+");
				System.out.println("|  |");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				System.out.println("+-----");
			} else if (wrong == 1) {
				System.out.println("+--+");
				System.out.println("|  |");
				System.out.println("|  O");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				System.out.println("+-----");
			} else if (wrong == 2) {
				System.out.println("+--+");
				System.out.println("|  |");
				System.out.println("|  O");
				System.out.println("|  |");
				System.out.println("|");
				System.out.println("|");
				System.out.println("+-----");
			} else if (wrong == 3) {
				System.out.println("+--+");
				System.out.println("|  |");
				System.out.println("|  O");
				System.out.println("|  |");
				System.out.println("|   \\");
				System.out.println("|");
				System.out.println("+-----");
			} else if (wrong == 4) {
				System.out.println("+--+");
				System.out.println("|  |");
				System.out.println("|  O");
				System.out.println("|  |");
				System.out.println("| / \\");
				System.out.println("|");
				System.out.println("+-----");
			} else if (wrong == 5) {
				System.out.println("+--+");
				System.out.println("|  |");
				System.out.println("|  O");
				System.out.println("|  |\\");
				System.out.println("| / \\");
				System.out.println("|");
				System.out.println("+-----");
			} else if (wrong == 6) {
				System.out.println("+--+");
				System.out.println("|  |");
				System.out.println("|  O");
				System.out.println("| /|\\");
				System.out.println("| / \\");
				System.out.println("|");
				System.out.println("+-----");
			}
			// Prompts how many letters of the word the computer guesses each guess.
			System.out.println("I've got "+right+" of the "+s1.length()+" letters so far");
			// Computer chooses different random letters and adds 97 for ASCII conversion from int to char.
			letter = guess.nextInt(26);
			char convert = (char)(letter+97);
			for(int j = 0; j < s2.length(); j++){
				while(convert == s2.charAt(j)){ 
					letter = guess.nextInt(26);
					convert = (char)(letter+97);
					j = 0;
				}
			}
			// Adds correctly guessed letter to string for checking if it matches letters in user input.
			s2 = s2+convert;
			// Boolean created so if guess is correct, the dash is updated.
			boolean correct = false;
			// Checks if guessed letter matches any letter in word inputted by user.
			for(int k = 0; k < s1.length(); k++) {
				if (convert == s1.charAt(k)) {
					correct = true;
					right++;
					x = update(k,s1,x);
				}
			}
			// Prompts user if computer guess was correct or wrong (increments wrong).
			System.out.println("I guess: "+convert);
			if (correct) {
				System.out.println("Is that letter in the word? y");
			} else {
				System.out.println("Is that letter in the word? n");
				wrong++;
			}
		}
		// If 6 wrong guesses are made, computer prompts it lost.
		if (wrong == 7) {
			System.out.println("\nYou beat me this time.\n");
		// If computer guesses word, prompts that it wins.
		} else {
			System.out.println("I won!");
		}
	}
	
	public static String update(int x, String s3, String s4){
		String word = "";
		// Replaces dashed lines with letter if correct letter is guessed in appropriate spot.
		for(int u = 0; u < s3.length(); u++){
			// Tests if what place computer guess would place in dashed line.
			if (u == x) {
				word = word+s3.charAt(u);
			} else {
				word = word+s4.charAt(u);
			}
		}
		return word;
	}
}

	