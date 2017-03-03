/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 3 Nov 2016
 Problem 1 - This program plays a user interactive game of Rock, Paper, Scissors.
 The user is prompted for what strategy they wish the computer to use. Stragey 1 is
 randomized choices, while strategy 2 uses two strategy's based on human psychology 
 (People typically begin with rock since its percieved sturdy and powerful, so the
 computer always guesses rock first. The other is that people tend to repeat their 
 choices since they believe it is unpredictable, so I made the computer choose each
 choice it makes twice sequencially). Additionally, this program also prompts the user how many
 rounds they wish to play.
 Bugs: None
 */

import java.util.*;

public class Problem1 {
	
    public static void main(String[] args) {
        // Initialized variable to iterate loop the amount of rounds the user wants.
        int rounds = 0;
        // Creates scanner and asks the user to input their prefered strategy.
        Scanner console = new Scanner(System.in);
        System.out.println("Would you like to use strategy 1 or 2? ");
        int pickStrategy = console.nextInt();
        // After confirming a valid input for strategy, the user is prompted for the amount of rounds the want to play.
        if (pickStrategy == 1 || pickStrategy == 2) {
            System.out.println("How many rounds would you like to play? ");
            rounds = console.nextInt();
        // If invalid, will prompt error.
        } else {
            System.out.println("Error. Please run again and input a proper startegy.");
        }
        // Runs strategy 1 if choosen.
        if (pickStrategy == 1) {
            randomPick(console, rounds);
        }
        // Runs strategy 2 if choosen.
        if (pickStrategy == 2) {
            rockFirst(console, rounds);
        }
    }
    
    public static void randomPick(Scanner console, int x) {
        // Initializes string for computer choice.
        String s2 = "";
        // for loop iterates the amount of rounds that was inputted.
        for(int i = 0; i < x; i++) {
            // Prompts for user choice and asigns to variable.
            System.out.println("Rock, Paper, or Scissors? ");
            String s1 = console.next();
            // Creates random object for picking randomized computer choices.
            Random rand = new Random();
            int randomNum = rand.nextInt(3);
            // Switch statement checks what number is generate and chooses either Rock, Paper or Scissor.
            switch (randomNum) {
                case 0:
                    s2 = "Rock";
                    break;
                case 1:
                    s2 = "Paper";
                    break;
                case 2:
                    s2 = "Scissors";
                    break;
            }
        // Results of user and computer choice are sent to this method to determine the winner.
        winner(s1, s2);
        }
    }
    
    public static void rockFirst(Scanner console, int x) {
        // Initializes string variable to assign fixed order of computer choices.
        String s2;
        // Initializes variable for repeating the same choice order.
        int y = 1;
        // for loop iterates the amount of rounds the user inputted.
        for(int i = 0; i < x; i++) {
            // Prompts user for choice and assigns to variable.
            System.out.println("Rock, Paper, or Scissors? ");
            String s1 = console.next();
            // Runs each choice twice and repeats order after every possible choice is made.
            if (y > 6) {
                y = 1;
            }
            if (y == 1 || y == 2) {
                s2 = "Paper";
                y++;
            } else if (y == 3 || y == 4) {
                s2 = "Rock";
                y++;
            } else {
                s2 = "Scissors";
                y++;
            }
        // Results are user and computer choice are sent to this method to determine the winner.
        winner(s1, s2);
        }
    }
    
    public static void winner(String s1, String s2) {
        // If the user input did not match a valid choice, an error is displayed.
        if (s1.equals("Rock") == false && s1.equals("Paper") == false && s1.equals("Scissors") == false) {
            System.out.println("Error, invalid choice. ");
        // If a valid input is entered, this tests if the choices match and then prompts the user that it is a tie.
        } else if (s1.equals(s2)) {
            System.out.println("Computer guessed "+s2+". It's a tie!");
        // Tests if user won by assuring user choice is superior to the computers, then prompts the user as the winner.
        } else if (s1.equals("Rock") && s2.equals("Scissors") || s1.equals("Paper") && s2.equals("Rock") || s1.equals("Scissors")
                   && s2.equals("Paper")) {
            System.out.println("Computer guessed "+s2+". You win!");
        // Otherwise, prompt the user that they lost (All other possibilties were tested).
        } else {
            System.out.println("Computer guessed "+s2+". You lose!");
        }
    }
}
        
