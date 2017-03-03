/* Name: Joshua Alvarado
   Email: jalva@brandeis.edu
   Date: 3 Sep 2016
   PA 1 - This program utilizes static methods to print out
   a multi-line poem. Six static methods are used to gather the
   poem's repeating sentences. Then, an additional seven  
   static methods (which are essentially the poem's stanzas) 
   are then printed in the main method to execute the poem.
   Bugs: None
*/

public class ThisHouse {
	
	public static void main(String[] args) {
		thisHouse();
		thisMalt();
		thisRat();
		thisCat();
		thisDog();
		thisCow();
		thisMaiden();
	}
	
    // STANZA STRUCTURE: The next seven methods print out the stanzas of the poem.
    
    // Prints poem's starting sentence followed by a blank line.
	public static void thisHouse() {
		System.out.println("This is the house that Jack built.");
		System.out.println();
	}
	
    // Prints second stanza, which prints a new statement followed by the sentence from thatLay() and a blank line.
    public static void thisMalt() {
		System.out.println("This is the malt");
		thatLay();
		System.out.println();
	}
	
    // Prints third stanza, which prints a new sentence followed by sentences from thatAte() and a blank line.
	public static void thisRat() {
		System.out.println("This is the rat,");
		thatAte();
		System.out.println();
	}
	
    // Prints fourth stanza, which prints a new sentence follwed by sentences from thatKilled() and a blank line.
	public static void thisCat() {
		System.out.println("This is the cat,");
		thatKilled();
		System.out.println();
	}
	
    // Prints fifth stanza, which prints a new sentence followed by sentences from thatWorried() and a blank line.
	public static void thisDog() {
		System.out.println("This is the dog,");
		thatWorried();
		System.out.println();
	}
	
    // Prints sixth stanza, which prints a new sentence followed by sentences from thatTossed() and a blank line.
	public static void thisCow() {
		System.out.println("This is the cow with the crumpled horn,");
		thatTossed();
		System.out.println();
	}
	
    // Prints seventh stanza, which prints a new sentence followed by sentences from thatMilked().
	public static void thisMaiden() {
		System.out.println("This is the maiden all forlorn");
		thatMilked();
	}
	
	// REPEATING SENETENCES: These last six methods group together repeating sentences poem's stanzas.
	
    // Prints poem's most repeated sentence.
	public static void thatLay() {
		System.out.println("That lay in the house that Jack built.");
	}
	
    // Prints a new repeating sentence along with the repeating sentence from thatLay().
	public static void thatAte() {
		System.out.println("That ate the malt");
		thatLay();
	}
	
    // Prints new repeating sentence along with previous repeating sentences from thatAte().
	public static void thatKilled() {
		System.out.println("That killed the rat,");
		thatAte();
	}	
		
    // Prints new repeating senetnce along with previous repeating sentences from thatKilled().
	public static void thatWorried() {
		System.out.println("That worried the cat,");
		thatKilled();
	}
	
    // Prints new repeating sentence along with previous repeating sentences from thatWorried().
     public static void thatTossed() {
		System.out.println("That tossed the dog,");
		thatWorried();
	}
    
    // Prints new sentence along with previous repeating sentences from thatTossed().
    public static void thatMilked() {
		System.out.print("That milked the cow with the crumpled horn,");
		thatTossed();
	}
}
	
	
	