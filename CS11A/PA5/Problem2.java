/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 3 Nov 2016
 Problem 2 - This program utilizes binary search in a guessing game, so that the 
 computer can effectively make guesses on a user thought up number (this number
 would be in the range of 1 till the class constant). In order to do binary search,
 variables for the min and max of the range or needed. The first guess will 
 always be half of the entire range. Once higher or lower is stated by the 
 user, the min is either reassigned to the the half of the range, since that is the
 starting point for the higher interval, or the max is reassigned to half of the 
 range, since the program must now focus on the lower interval. The amount of guesses
 is tracked by incrementing a variable after each guess iteration. The amount of games
 is determined by the amount of times the outer while loop runs, which is done by also
 initialized a counting variable and incrementing it after each run (Runs depend if the
 user says yes or no). Also, the amount of guesses by the computer is prompted and then
 asks the user if they want to play again. If no, session summary statistics are displayed
 (Total amount of games, guesses, average amount of guesses, and the most amount of guesses
 made in a game).
 Bugs: None
 */

import java.util.*;

public class Problem2 {
    
    public static final int con = 100;

        public static void main(String[] args) {
            // Creates scanner and prompts the user how game works.
            Scanner console = new Scanner(System.in);
            System.out.println("\nThis program allows you to play a guessing game.");
            System.out.println("Think of a number between 1 and "+con);
            System.out.println("and I will guess until I get it.");
            System.out.println("For each guess, tell me if the");
            System.out.println("right answer is higher or lower than your guess, or if it is correct.");
            // Passes scanner object as parameter in this method to be used for all of the users inputs.
            guesses(console);
        }
    
    public static void guesses(Scanner console) {
        // Sets string variable so outer loop could run the first time and future reassignment.
        String s2 = "Yes";
        /* Initializes variables for counting the amount of games, guesses, and average guesses, 
           and the max guess in all rounds. */
        int totalGames = 0;
        int totalGuesses = 0;
        int maxGuesses = 0;
        int count;
        // Tests if user wants to play again (If they input anything starting with 'y' or 'Y').
        while (s2.charAt(0) == 'y' || s2.charAt(0) == 'Y') {
            // Prompts user to think of number in range that computer will guess.
            System.out.println("\nThink of a number ...");
            // Initializes variables for future incrementation and user input.
            count = 0;
            String s1 = "";
            /* Variables are created to close in on the intervals the user narrows their number down to, 
               always starting with the first guess being half the max. */
            int max = con;
            int min = 1;
            int guess = max/2;
            // Tests if user confirms correct guess and if guess is within the starting range each iteration.
            while (s1.equals("correct") ==  false && guess > 0 && guess < max) {
                /* Prompts the computers guess, then requires user to state higher, lower, and eventually 
                   correct to end while loop. */
                System.out.println("My guess: "+guess);
                s1 = console.next();
                // Prompts an error if guess becomes negative or over the max.
                if (guess < 1 || guess > max) {
                    System.out.println("Error.");
                /* If higher, min is assigned to half of the range. Then, it is added to max then divided by 2 
                   to find midpoint of the interval. */
                } else if (s1.equals("higher")) {
                    min = guess;
                    guess = (max+min)/2;
                /* If lower, max is assigned to half of the range. Then, it is added to min then divided by 2 
                   to find the midpoint of the interval. */
                } else if (s1.equals("lower")) {
                    max = guess;
                    guess = (min+max)/2;
                }
                // Increments for the amount of guesses each individual iteration and all guesses in total.
                count++;
                totalGuesses++;
                }
            // Prompts how many guesses the computer took in each game and asks if user wants to play again.
            System.out.println("I got it right in "+count+" guesses \n");
            System.out.print("Do you want to play again? ");
            s2 = console.next();
            // Increments the amount of total games played in a session.
            totalGames++;
            // Tests for the most amount of guesses made in a single game.
            if (count > maxGuesses) {
                maxGuesses = count;
            }
        }
        // Displays statistics of complete gaming session.
        System.out.println("\nOverall results:");
        System.out.println("    total games   = "+totalGames);
        System.out.println("    total guesses = "+totalGuesses);
        System.out.println("    guesses/game  = "+(double)(totalGuesses/totalGames));
        System.out.println("    max guesses   = "+maxGuesses);
    }
}
        
        
        
