/*
 * Assessment: Recipe Exercise 1-C - 2022-09-09 - Cookie Recipe in Java
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 331
 * Due Date: September 16, 11:59 PM
 * Created: September 15
 * Modified: September 15
 * Description: Lab Exercise 1-C Demonstration File
*/
import java.util.Scanner;

public class CookieRecipe {
	/*
start
	declarations
		num cupsOfFlour				// whole number
		num teaspoonOfBakingPowder		// decimal number
		num batches					// multiplier, as decimal number

// num a and num b could work but you may never know what a or b stands for.

	cupsOfFlour = 3
	teaspoonOfBakingPowder =  3.0/4.0 //0.75. Use floating point division

	output "enter number of batches" //printed by console/program
	input batches //typed by user

	output (cupsOfFlour * batches) + " cups all-purpose flour"
	output "3/4 teaspoons baking powder"
	output "Step 1 do the things"
	output "Step 2 preheat oven"
	output "Step 3 do more things"
	output "Step 4 eat cookie"
stop
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		double cupsOfFlour = 3.0;					// whole number
		double teaspoonOfBakingPowder = 3.0/4;		// decimal number
		double batches;								// multiplier, as decimal number
		Scanner keyboard = new Scanner(System.in);
		
		// input batches
		System.out.print("Enter batches: ");
		batches = keyboard.nextDouble();
		
		System.out.println((cupsOfFlour * batches) + " cups all-purpose flour");
		System.out.println((teaspoonOfBakingPowder * batches) + " teaspoon(s) baking powder"); //This is not Pseudo code, so "output "string"" does not work when used with System.out.println //System.out.println(output "3/4 teaspoons baking powder"); causes problems. Remove "output".
        System.out.println("Step 1 do the things");
        System.out.println("Step 2 preheat oven");
        System.out.println("Step 3 do more things");
        System.out.println("Step 4 eat cookie");
        System.out.println("Therefore:\n 3 cups all-purpose flour\n 3/4 teaspoons baking powder\n Step 1 do the things\n Step 2 preheat oven\n Step 3 do more things\n Step 4 eat cookie\n And that's it");
        System.out.print("Enjoy!");
    } // end main
} // end class
