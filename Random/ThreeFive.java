/* If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000. */
import java.util.*;

public class ThreeFive {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("\nThis program will take an input, and add all numbers that are less than");
		System.out.println("the input, but also numbers that are multiples of three or five.\n");
		System.out.print("Please enter a number: ");
		int num = console.nextInt();
		System.out.println(threeFive(num));
	}

	public static int threeFive(int x) {
		int total = 0;
		for(int i = 1; i < x; i++) {
			if (i%3 == 0 || i%5 == 0) {
				total += i;
			} 
		}
		return total;
	}
}

