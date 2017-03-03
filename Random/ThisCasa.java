/* Name: Joshua Alvarado
 * Email: jalva@brandeis.edu
 * Date: 3 Sep 2016
 * PA 1 - This program utilizes static methods to print out
 * a multi-line poem. All static methods are then printed in
 * order in the main method.
 * Bugs: None
 */

public class ThisCasa {
    
    public static void main (String[] args) {
        System.out.println("This is the house that Jack built. /n");
        System.out.println("This is the malt");
        layHouse();
        System.out.println();
        System.out.println("This is the rat,");
        ateMalt();
        System.out.println();
        System.out.println("This is the cat,");
        killedRat();
        System.out.println();
        System.out.println("This is the dog,");
        worriedCat();
        System.out.println();
        System.out.println("This is the cow with the crumpled horn,");
        tossedDog();
        System.out.println();
        System.out.println("This is the maiden all forlorn");
        milkedCow();
    }
    
    public static void layHouse() {
        System.out.println("That lay in the house that jack built.");
    }
    
    public static void ateMalt() {
        System.out.println("That ate the malt");
        layHouse();
    }
    
    public static void killedRat() {
        System.out.println("That killed the rat,");
        ateMalt();
    }
    
    public static void worriedCat() {
        System.out.println("That worried the cat,");
        killedRat();
    }
    
    public static void tossedDog() {
        System.out.println("That tossed the dog,");
        worriedCat();
    }
    
    public static void milkedCow() {
        System.out.println("That milked the cow with the crumpled horn,");
        tossedDog();
    }
}