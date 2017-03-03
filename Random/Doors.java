/* There are 100 doors in a row that are all initially closed.

You make 100 passes by the doors.

The first time through, visit every door and toggle the door (if the door is closed, open it; if it is open, close it).

The second time, only visit every 2nd door   (door #2, #4, #6, ...),   and toggle it.

The third time, visit every 3rd door (door #3, #6, #9, ...), etc,   until you only visit the 100th door. */
import java.util.*;

public class Doors {
    public static void main(String[] args) {
        boolean[] doors = new boolean[100];
        for(int i = 0; i < 100; i++) {
            doors[i] = false;
        }
        boolean[] run = runs(doors);
        printFinal(run);
    }
    
    public static boolean[] runs(boolean[] a) {
        int inc = 1;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 100; j+=inc) {
                if(a[j] == false) {
                    a[j] = true;
                } else {
                    a[j] = false;
                }
            }
            inc++;
        }
        return a;
    }
    
    public static void printFinal(boolean[] a) {
        int count = 1; 
        for(int i = 0; i < 100; i++) {
            if(a[i] == false) {
                System.out.println("Door #"+count+" is closed.");
                count++;
            } else {
                System.out.println("Door #"+count+" is open.");
                count++;
            }
        }
    }
}