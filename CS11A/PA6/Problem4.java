 /* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 18 Nov 2016
 Problem 4 - This program plays a game of Tic-Tac-Toe with the user.
 The user is assigned 'X' and the computer is assigned 'O'. However, 
 this program is designed only to win or tie with the user, no matter
 if the user chooses to go first or second. This is done by making sure
 to block any opportunity the user has to win, as well as fill in the
 final place where the computer would win. Every round of choices, the 
 user is prompted the CPU's choice, as well as an updated Tic-Tac-Toe 
 grid. The user has the ability to play again if they choose to.
 Bugs: None
 */

import java.util.*;

public class Problem4 {

	public static void main(String[] args) {
		// Prompts user of game and creates scanner for user inputs.
		System.out.println("\nWelcome to Tic-Tac-Toe!");
		Scanner console = new Scanner(System.in);
		// Initializes boolean value to run game until user wishes to quit (Later tested depending on user input).
		boolean play = true;
			// While loop iterates each game, and runs until user wants to stop.
			while (play) {
			// Initializes variable to increment amount of go's user takes.
			int go = 0;
			// Initializes character for testing winner of game.
			char result = 'o';
			// Prompts is user wishes to go first or not, then assigns value of 1 or 0 for testing in each case.
			System.out.print("\nWould you like to go first? (1 is Yes/0 is No): ");
			int first = console.nextInt();
			System.out.println();
			// Strings initializes for saving user and cpu 'X' and 'O' choices.
			String userPick = " ";
			String cpuPick = " ";	
			// Initializes grid used for Tic-Tac-Toe with no elements.
			char[][] grid = new char[5][5];
			// Constructs grid (with boundry lines and number values for places) to be used for game.
			gridConstruct(grid, userPick, cpuPick, first, go);
			// Iterates until game is identified to have been one by either user or cpu.
			while (result == 'o') {
				// Increments to track what number move it is.
				go++;
				// Prints board on terminal after each new choice by user and cpu.
				gridUpdate(grid);
				// Depending on who goes first, code runs for user input or cpu choice, and updates choices.
				if (first%2 == 1) {
					System.out.printf("\nPlease choose a place (Pick an avaliable number value): ");
					int pick = console.nextInt(); 
					System.out.println();
					userPick = pick+userPick;
				} else if (first%2 == 0) {
					int nextPick = pick(grid, go);
					System.out.printf("\nCPU pick: %s\n", nextPick);
					cpuPick = nextPick+cpuPick;
					System.out.println();
				}
				gridConstruct(grid, userPick, cpuPick, first, go);
				// Increments first so it is the next players turn (either user or cpu).
				first++;
				// Checks if there is a row with all 'X' or 'O' and reassigns final result. 
				result = winner(grid);
			} 
			// Prints completed grid after game conclusion and prints result of game.
			gridUpdate(grid);
			if (result == 'i') {
				System.out.print("\nYou win! Want to play again? (Yes/No): ");
			} else if (result == 'a') {
				System.out.print("\nYou lose. Want to play again? (Yes/No): ");
			} else {
				System.out.print("\nIt's a tie. Want to play again? (Yes/No): ");
			}
			// Initializes String scanner to ask user if they wish to play again, then tests and cancels game loop if not.
			String again = console.next();
			// If users enters anything but yes, game quits since the games loop is reliant on play being true.
			if (!(again.equalsIgnoreCase("Yes"))) {
				System.out.println();
				play = false;
			}
		}	
	}
	
	public static void gridConstruct(char[][] grid, String userPick, String cpuPick, int first, int go){
		// Creates Tic-Tac-Toe grid (using -,+,|) with refrence numbers for user choices (1-9).
		char y = ' ';
		String pick = " ";
		if (go == 0){
			grid[0][0] = '1';
			grid[0][1] = '|';	
			grid[0][2] = '2';
			grid[0][3] = '|';
			grid[0][4] = '3';
			grid[1][0] = '-';
			grid[1][1] = '+';
			grid[1][2] = '-';
			grid[1][3] = '+';
			grid[1][4] = '-';
			grid[2][0] = '4';
			grid[2][1] = '|';
			grid[2][2] = '5';
			grid[2][3] = '|';
			grid[2][4] = '6';
			grid[3][0] = '-';
			grid[3][1] = '+';
			grid[3][2] = '-';
			grid[3][3] = '+';
			grid[3][4] = '-';
			grid[4][0] = '7';
			grid[4][1] = '|';
			grid[4][2] = '8';
			grid[4][3] = '|';
			grid[4][4] = '9';
		} else {
			// Takes user and cpu picks, then assigns 'X' or 'O' to place corresponding to pick. 
			for(int i = 0; i < 2; i++) {
				if (i == 0) {
					y = 'X';
					pick = userPick;
				} else if (i == 1){
					y = 'O';
					pick = cpuPick;
				}
				for(int j = 0; j < pick.length(); j++) {
					if (pick.charAt(j) == '1') {
						grid[0][0] = y;
					} else if (pick.charAt(j) == '2') {
						grid[0][2] = y;
					} else if (pick.charAt(j) == '3') {
						grid[0][4] = y;
					} else if (pick.charAt(j) == '4') {
						grid[2][0] = y;
					} else if (pick.charAt(j) == '5') {
						grid[2][2] = y;
					} else if (pick.charAt(j) == '6') {
						grid[2][4] = y;
					} else if (pick.charAt(j) == '7') {
						grid[4][0] = y;
					} else if (pick.charAt(j) == '8') {
						grid[4][2] = y;
					} else if (pick.charAt(j) == '9') {
						grid[4][4] = y;
					}
				}
			}
		}
	}

	public static int pick(char[][] grid, int go) { 
		// Initializes integer for returning computer choice depending on user picks.
		int n = 0;
		// Takes result from blockWin to check for an opportunity to block or win for cpu.
		if (blockWin(grid, 1) != 0) {
			n = blockWin(grid, 1);
		} else if (blockWin(grid, 2) != 0) {
			n = blockWin(grid, 2);
		} else { 
			if (go%2 == 1) {
				if (go == 1) {
					n = 9;
				} else if (go >= 3) {
					if ('X' == grid[0][0] || 'X' == grid[4][4]) {
						if (go == 3) {
							n = 3;
						} else if (go == 5) {
							if ('X' == grid[0][0]) {
								n = 7;
							} else if ('X' == grid[4][4]) {
								n = 1;
							}
						}
					} else if ('X' == grid[2][2]) {
						n = 3;
					} else if ('X' == grid[0][4]) {
						if (go== 3) {
							n = 1;
						} else if (go == 5) {
							n = 7;
						}
					} else {
						if (go == 3) {
							if (grid[2][4] == 'X') {
								n = 1;
							} else if (grid[0][2] == 'X') {
								n = 7;
							} else if (grid[2][0] == 'X') {
								n = 3;
							} else if (grid[4][2] == 'X') {
						    	n = 3;
							}
						} else if (go == 5) {
							if (grid[0][0] == 'O') {
								n = 3;
							} else if (grid[4][4] == 'O') {
								n = 3;
							} else if (grid[0][4] == 'O') {
								n = 7;
							}
						}
					}
				}
			} else {
				if (go >= 2) {
						if ('X' == grid[2][2] && go == 2) {
						n = 9;
					} else if ('X' == grid[0][0] || 'X' == grid[0][4] || 'X' == grid[4][0] || 'X' == grid[4][4]) {
						if (go == 2) {
							n = 5;
						} else if (go > 2) {
							n = check(grid);
					    }
					} else {
						if (go == 2) {
							n = 5;
						} else if (go > 2) {
							n = check(grid);
						}
					}
				}				
			}
		}
		return n;
	}

	public static int check(char[][] grid) {
		// Returns integer if value in places being test are neither 'X' or 'O'.
		int n = 0;
		if (grid[0][0] == '1') {
			n = 1;
		} else if (grid[0][2] == '2') {
			n = 2;
		} else if (grid[0][4] == '3') {
			n = 3;
		} else if (grid[2][0] == '4') {
			n = 4;
		} else if (grid[2][2] == '5') {
			n = 5;
		} else if (grid[2][4] == '6') {
			n = 6;
		} else if (grid[4][0] == '7') {
			n = 7;
		} else if (grid[4][2] == '8') {
			n = 8;
		} else if (grid[4][4] == '9') {
			n = 9;
		}
		return n;
	}
 
 	public static char winner(char[][] grid) {
		// Checks rows, then columns, then diagnolly to determine if there is a winner.
		// Returns 'i' if user wins, but returns 'a' if cpu wins.
		if ((grid[0][0] == grid[0][2] && grid[0][2] == grid[0][4]) || (grid[0][0] == grid[2][0] 
			&& grid[2][0] == grid[4][0]) || (grid[0][0] == grid[2][2] && grid[2][2] == grid[4][4])) {
			if (grid[0][0] == 'O') {
				return 'a';
			} else {
				return 'i';
			}
		} else if ((grid[4][4] == grid[2][4] && grid[2][4] == grid[0][4]) || (grid[4][4] == grid[4][2] 
			&& grid[4][2] == grid[4][0])) {
			if (grid[4][4] == 'O'){
				return 'a';
			} else {
			    return 'i';
			}
		} else if ((grid[0][2] == grid[2][2] && grid[2][2] == grid[4][2]) || (grid[4][0] == grid[2][2] 
			&& grid[2][2] == grid[0][4]) || (grid[2][0] == grid[2][2] && grid[2][2] == grid[2][4])) {
			if (grid[2][2] == 'O'){
				return 'a';
			} else {
				return 'i';
			}
		// Returns values other than 'i' and 'a' to indicate that no one wins.	
		} else if (grid[0][0] != '1' && grid[0][2] != '2' && grid[0][4] != '3' && grid[2][0] != '4' 
			&& grid[2][2] != '5' && grid[2][4] != '6' && grid[4][0] != '7' && grid[4][2]!= '8' && grid[4][4] != '9') {
			return 'x';
		} else {
			return 'o';
		}
	}

	public static int blockWin(char[][] grid, int go) {
		// Initializes variables 
		int n = 0;
		int pick = 0;
		char[] place = new char[3];
		char a = place[0];
		char b = place[1];
		char c = place[2];
		for(int k = 0; k <= 4; k++) {
			for(int i = 0; i <= 4; i = i+2) {
				// Initializes z for incrementing array for storing values in rows, columns, and slants on grid.
				int z = 0;
				for(int j = 4; j >= 0; j = j-2) {
					// Checks rows.
					if (k == 0 && n == 0) {
						place[z] = grid[i][j]; 
				    // Checks columns.	
					} else if (k == 1 && n == 0) {	
						place[z] = grid[j][i];				
					// Checks slants.
					} else if (k == 3 && n == 0) {
						place[z] = grid[j][j];
					} else if (k == 4 && n == 0) {
						place[z] = grid[4-j][j];
					}
					z++;					
				}
				/* Takes values in each individual place and tests according to their row, column, or slant if there is a
				   chance to block or tie. */
				a = place[0];
				b = place[1];
				c = place[2];
				if (go == 1) {
					if ((a == b && c != 'O' && c != 'X' && a == 'O') || (b == c && a != 'O' && a != 'X' && b == 'O') || 
						(a == c && b != 'O' && b != 'X' && c == 'O')) {
						n = 1;
					}
				} else if (go == 2) {
					if ((a == b && c != 'O' && c != 'X' && a == 'X') || (b == c && a != 'O' && a != 'X' && b == 'X') || 
						(a == c && b != 'O' && b != 'X' && c == 'X')) {
						n = 1;
					}
				}	
			}
		}
		// Checks which place is empty but also has the ability to block user or to win the game.
		if (a == b || a == c || b == c) {
			if (a == '1' || b == '1' || c == '1') {
				pick = 1;
			} else if (a == '2' || b == '2' || c == '2') {
				pick = 2;
			} else if (a == '3' || b == '3' || c == '3') {
				pick = 3;
			} else if (a == '4' || b == '4' || c == '4') { 
				pick = 4;
			} else if (a == '5' || b == '5' || c == '5') {
				pick = 5;
			} else if (a == '6' || b == '6' || c == '6') {
				pick = 6;
			} else if (a == '7' || b == '7' || c == '7') {
				pick = 7;
			} else if (a == '8' || b == '8' || c == '8') {
				pick = 8;
			} else if (a == '9' || b == '9' || c == '9') {
				pick = 9;
			}
		}
		return pick;
	}

	public static void gridUpdate(char[][] grid) {
		// Traverses 2D array for Tic-Tac-Toe grid and displays values present in all spaces after each pick.
		for(int i = 0; i< grid.length; i++) {
			for(int j = 0; j< grid[i].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
}