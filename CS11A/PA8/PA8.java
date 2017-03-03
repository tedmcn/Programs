/* Name: Joshua Alvarado
Email: jalva@brandeis.edu
Date: 9 Dec 2016
PA8 - This program is capable of reading a .txt file, and creating a new
.txt file which substitutes placeholders in the originating file with the 
user inputs. Also, this program is able to call upon an already created 
madlib, and views its contents through the console. In order to assess for
placeholders, the code identifies if a string begins and ends with < or >,
then takes the word within to prompt the user for their input.
Bugs: None
*/

import java.io.*;
import java.util.*;

public class PA8 {
	public static void main(String[] args) throws FileNotFoundException {
		// Creates scanner for user input in UI loop, which asks if they want to create, view, or quit madlibs.
		Scanner console = new Scanner(System.in);
		// Prompts rules of madlibs.
		System.out.println("Welcome to Mad Libs!\nI will ask you to provide various words");
		System.out.println("and phrases to fill in a story.\nThe result will be written to an output file.");
		// Initiallizes char value for option testing.
		char q = 'C';
		// Runs until user does not want to either create of view a madlib.
		while (q == 'c' || q == 'C' || q == 'V' || q == 'v') {
			System.out.print("\n(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
			q = console.nextLine().charAt(0);
			// Runs create or view method depending on input.
			if (q == 'C' || q == 'c') {
				create();
			} 
			if (q == 'V' || q =='v') {
				view();
			}
		}
	}

	public static void create() throws FileNotFoundException {
		// Creates scanner for inputs in new file.
		Scanner console = new Scanner(System.in);
		// Checks is askMadLib() if user input file exists for traversing. 
		String fileName = askMadLib();
		// Prompts output file name for later PrintStream creation.
		System.out.print("Output file name: ");
		String newFile = console.nextLine();
		System.out.println();
		// Initializes file which will be used in creating madlib.
		File f = new File(fileName);
		// Creates scanner to scan through input file of madlib.
		Scanner file = new Scanner(f);
		// Creates output PrintStream for writing user inputs in output file. 
		PrintStream output = new PrintStream(new File(newFile));
		// Runs until input file's text ends.
		while (file.hasNextLine()) {
			// Sets full text line to a String, then creates scanner to scan for each token in line.
			String line = file.nextLine();
			Scanner word = new Scanner(line);
			// Runs until line does not have a next word.
			while (word.hasNext()) {     
				// Sets word token to String to check if its a placeholder.
				String word1 = word.next();
				// If the token begins and ends with < and > respectively, it is a placeholder.
				if (word1.charAt(0) == '<' && word1.charAt(word1.length()-1) == '>') {
					// Sends contents of placeholder to prompt() for user input word, then prints to output file.
					word1 = word1.substring(1, word1.length()-1);
					String returnedWord = prompt(word1);
					output.print(returnedWord+" ");
				} else {
					// If not a placeholder, solely prints the word to output file.
					output.print(word1+" ");
				}
			}
			// Once current line no longer has tokens, it moves to next line.
			output.println();
		}
		System.out.println("Your mad-lib has been created!");
	}

	public static void view() throws FileNotFoundException {
			// Checks if file being called to view exists in directory.
			String fileName = askMadLib();
			// Initializes file and scanner for traversal.
			File f = new File(fileName);
			Scanner file = new Scanner(f);
			System.out.println();
			// Runs until file no longer has text.
			while (file.hasNextLine()) {
				// Sets line fetched to String for printing each word.
				String line = file.nextLine();
				Scanner word = new Scanner(line);
				// Runs until no more words are in line fetched.
				while (word.hasNext()) {
					// Grabs next word and prints.
					String word1 = word.next();
					System.out.print(word1+" ");
				} 
				// Once line is done, moves onto next one.
				System.out.println();
			}
	}

	public static String askMadLib() {
		// Creates scanner for user inputs for file name.
		Scanner console = new Scanner(System.in);
		// Prompts file name and assigns to String.
		System.out.print("Input file name: "); 
		String fileName = console.nextLine();
		// Initializes file with input name.
		File f = new File(fileName);
		// Checks if inputted file name actually exists, then returns name.
		if (f.exists()) {
			return fileName;
		} 
		// Runs until proper file name is inputted, then returns it once true.
		while (!(f.exists())) {
			System.out.print("File not found. Try again: ");
			fileName = console.nextLine();
			f = new File(fileName);
		}
		return fileName;
	}

	public static String prompt(String s1) {
		// Creates scanner for user input for prompted placeholder.
		Scanner console = new Scanner(System.in);
		// Replaces any dashes in placeholder with spaces.
		s1 = s1.replace("-", " ");
		// Checks if starting character in placeholder is a vowel, then prompts with "an" if so.
		char a = s1.charAt(0);
		String an = "";
		if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' 
			|| a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U') {
			an = "an";		
		// If it does not start with vowel, "a" is used in prompt.
		} else {
			an = "a";
		}		
		// Prompts with proper "a" or "an" and placeholder name, then takes user input and returns it. 
		System.out.print("Please type "+an+" "+s1+": ");
		String input = console.nextLine();
		return input;
	}
}