/* Name: Joshua Alvarado
 * PA1
 * COSI 12B Section 1
 * This program compiles the result of a personality test (Keirsey), by
 * first reading the input file containing the A & B answers for each test
 * taker (or omitted - answers), then outputs a text file containing the name 
 * of the test taker, a summary or how many A & B answers were picked for each 
 * group, including the percentage of B answers guessed in the group and the 
 * test takers final 4 letter personality type. 
 */

import java.io.*;
import java.util.*;

public class PersonalityTest {

	private static Scanner file;
	private static Scanner console = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		// Checks for correct input file name and assigns it to String.
		String inputFile = askFileName();
		// Passes input file name for scanning of answers and output file creation.
		compileAnswers(inputFile);
	}

	/**
	 * compileAnswers reads the text file, outputs the test takers name, and stores
	 * the amount of A & B answers from each group in their own respective arrays.
	 * @param inputFile - String name of file which will be read.
	 * @throws FileNotFoundException
	 */
	public static void compileAnswers(String inputFile) throws FileNotFoundException {
		// Initializes two integer arrays for A & B counting for each group.
		int[] aCount = new int[4];
		int[] bCount = new int[4];
		// Count variable created for answers String character traversing.
		int count = 0;
		// Prompts for output file name, then assigns it to a String.
		System.out.print("Output file name: ");
		String outputFile = console.next();
		// Creates file object for input file and then a scanner to read it.
		File f = new File(inputFile);
		file = new Scanner(f);
		// Creates PrintStream object to print test results to output text file.
		PrintStream output = new PrintStream(new File(outputFile));
		// Loop executes until there are no lines left in input file.
		while (file.hasNextLine()) {
			// Outputs line containing test takers name to text file.
			output.println(file.nextLine()+":");
			// Assigns line containing test takers answers to a a String.
			String answers = file.nextLine();
			// Outer loop iterates for the amount of question groups.
			for(int k = 0; k < 10; k++) {
				// Inner loop iterates for the amount of questions in each group.
				for(int j = 0; j < 7; j++) {
					// Checks if it is the first question in group for I vs E.
					if (j == 0) {
						if (Character.toUpperCase(answers.charAt(count))=='A') {
							aCount[0]++;
						} else if (Character.toUpperCase(answers.charAt(count))=='B') {
							bCount[0]++;
						}
					// Checks if it is the second or third question in group for S vs N.
					} else if (j == 1 || j == 2) {
						if (Character.toUpperCase(answers.charAt(count))=='A') {
							aCount[1]++;
						} else if (Character.toUpperCase(answers.charAt(count))=='B') {
							bCount[1]++;
						}
					// Checks if it is the fourth or fifth question in group for T vs F.
					} else if (j == 3 || j == 4) {
						if (Character.toUpperCase(answers.charAt(count))=='A') {
							aCount[2]++;
						} else if (Character.toUpperCase(answers.charAt(count))=='B') {
							bCount[2]++;
						}
					// Checks if it is the sixth or last question in group for J vs P.
					} else {
						if (Character.toUpperCase(answers.charAt(count))=='A') {
							aCount[3]++;
						} else if (Character.toUpperCase(answers.charAt(count))=='B') {
							bCount[3]++;
						}
					}
					// Increments for answers String character traversal.
					count++;
				}
			}
			// Sends arrays containing A & B answers for each group to be formatted properly.
			formatToString(output, aCount, bCount);
			// Reinitialized A & B count arrays and count variable to 0 for next test takers answers.
			Arrays.fill(aCount, 0);
			Arrays.fill(bCount, 0);
			count = 0;
		}
	}
	
	/**
	 * formatToString takes information regarding amount of A and B answers for each
	 * group and formats it properly for output. Calculates percent of B answers 
	 * correct for each group as well for outputting.
	 * @param output - Needed for outputting correctly formatted info to file.
	 * @param a - array containing A answers for each 4 personality groups.
	 * @param b - array containing B answers for each 4 personality groups.
	 */
	public static void formatToString(PrintStream output, int[] a, int[] b) {
		// Initializes variable to hold percent of B answers picked.
		int bPercent = 0;
		// Creates String for bracket representation of percents.
		String percentBracket = "[";
		// Creates String for adding personality type letters based on results.
		String letterCombo = "";
		// Iterates for the personality type groups.
		for(int i = 0; i < 4; i++) {
			// Outputs each groups answers dimension. 
			output.print(a[i]+"A-"+b[i]+"B ");
			// Checks if first group, finds percent for B answers and letter of type.
			if (i == 0) {
				bPercent = (int)(((double)b[i]/10)*100);
				if (bPercent > 50) {
					letterCombo += "I";
				} else if (bPercent < 50) {
					letterCombo += "E";
				} else {
					letterCombo += "X";
				}
				percentBracket += bPercent+"%, ";
			// Checks if second group, finds percent for B answers and letter of type.
			} else if (i == 1) {
				bPercent = (int)(((double)b[i]/20)*100);
					if (bPercent > 50) {
						letterCombo += "N";
					} else if (bPercent < 50) {
						letterCombo += "S";
					} else {
						letterCombo += "X";
					}
				percentBracket += bPercent+"%, ";
			// Checks if third group, finds percent for B answers and letter of type.
			} else if (i == 2) {
				bPercent = (int)(((double)b[i]/20)*100);
					if (bPercent > 50) {
						letterCombo += "F";
					} else if (bPercent < 50) {
						letterCombo += "T";
					} else {
						letterCombo += "X";
					}
				percentBracket += bPercent+"%, ";
			// Runs for last group, finds percent for B answers and letter of type.
			} else {
				bPercent = (int)(((double)b[i]/20)*100);
				if (bPercent > 50) {
					letterCombo += "P";
				} else if (bPercent < 50) {
					letterCombo += "J";
				} else {
					letterCombo += "X";
				}
				percentBracket += bPercent+"%]";
			}
			// Reinitializes percent to 0 for next group.
			bPercent = 0; 
		}
		// Writes the percent bracket and letter combo of type to output file.
		output.println("\n"+percentBracket+" = "+letterCombo+"\n");
	}
	
	/**
	 * askFileName prompts user for an existing file name, which will be used in reading
	 * for test takers names and answers. If input does not exist, it will keep prompting 
	 * for a file name that does.
	 * @return inputFile - String name of proven existing input file.
	 */
	public static String askFileName() {
		System.out.print("Input file name: ");
		String inputFile = console.next();
		// Initializes file object for checking its existence.
		File f = new File(inputFile);
		// Runs until an existing file name is inputed.
		while (!f.exists()) {
			System.out.print("Please input an existing file name: ");
			inputFile = console.next();
			f = new File(inputFile);
		}
		// Returns the confirmed existing String name of the input file which will be read.
		return inputFile;
	}
}