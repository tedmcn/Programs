/* Name: Joshua Alvarado
 Email: jalva@brandeis.edu
 Date: 4 Oct 2016
 Problem 4 - This program takes in user inputs for 3
 items, specifying the name, quantity and price. Then, 
 these values are taken to print a reciept, which includes
 the total amount for each item, total before tax, amount
 of tax needed to be paid, and the grand total with added 
 tax.
 Bugs: None
 */

import java.util.*;

public class Problem4 {
	public static void main(String[] args) {
		// Creates scanner and prompts user to input name, quantity, and price of item.
        Scanner console = new Scanner(System.in);
        System.out.print("Input name of item 1: ");
        String item1 = console.next();
        System.out.print("Input quantity of item 1: ");
        int quantity1 = console.nextInt();
        System.out.print("Input price of item 1: ");
        double price1 = console.nextDouble();
        // Skips a line for the next item, then calculates total amount due for the item.
        System.out.println();
        double total1 = quantity1*price1;
        
        // Prompts user to input name, quantity, and price of item.
        System.out.print("Input name of item 2: ");
        String item2 = console.next();
        System.out.print("Input quantity of item 2: ");
        int quantity2 = console.nextInt();
        System.out.print("Input price of item 2: ");
        double price2 = console.nextDouble();
        // Skips a line for the next item, then calculates total amount due for the item.
        System.out.println();
        double total2 = quantity2*price2;
        
        // Prompts user to input name, quantity, and price of item.
        System.out.print("Input name of item 3:");
        String item3 = console.next();
        System.out.print("Input quantity of item 3:");
        int quantity3 = console.nextInt();
        System.out.print("Input price of item 3:");
        double price3 = console.nextDouble();
        // Skips a line for the next item, then calculates total amount due for the item.
        System.out.println();
        double total3 = quantity3*price3;
        
        // Sets string variables for reciept labeling.
        String item = "Item";
        String quantity = "Quantity";
        String price = "Price";
        String total = "Total";
        
        // Formats receipt by indenting and assigning the right values under the appropriate labels.
        System.out.println("Your bill: ");
        System.out.printf("%-30s"+"%-10s"+"%-12s"+"%-10s\n", item, quantity, price, total);
        System.out.printf("%-30s"+"%-10s"+"%.2f"+"%12.2f\n", item1, quantity1, price1, total1);
        System.out.printf("%-30s"+"%-10s"+"%.2f"+"%12.2f\n", item2, quantity2, price2, total2);
        System.out.printf("%-30s"+"%-10s"+"%.2f"+"%12.2f\n", item3, quantity3, price3, total3);
        
        // Calculates subtotal(before tax)
        System.out.println();
        double stotal = total1+total2+total3;
        String sub = "Subtotal";
        // Assigns tax value to a variable then multiplies it by subtotal to find tax due.
        double tax = .0625;
        double subtax = stotal*tax;
        String stax = 100*tax+"% sales tax";
        // Calculates grand total by adding total amount due and taxs due.
        double totalf = stotal+subtax;
        // Prints out subtotal, amount of tax, and grand total.
        System.out.printf("%-50s"+"$%.2f\n", sub, stotal);
        System.out.printf("%-50s"+"$%.2f\n", stax, subtax);
        System.out.printf("%-50s"+"$%.2f\n", total, totalf);
    }
}
