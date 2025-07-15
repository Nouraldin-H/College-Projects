package task1;

/*
 * Assessment: Lab Exercise 4 - 2022-11-04 - Task 1-B
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 330/331
 * Due Date: November 06, 11:59 PM
 * Created: November 04
 * Modified: November 04
 * Description: Lab Exercise 4, Task 1 File
*/

/*
 * ToDo: Provide overview of class, and comment all constructors and methods
 */
import java.util.Scanner;

public class FishSizeCheck {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Muskellunge muskie = new Muskellunge();
		double length; // To declare length without a fixed value for further declaration ~Nouraldin
		String report;

		System.out.printf("%s", "Enter length: ");
		length = keyboard.nextDouble();
		muskie.setLength(length); // gets the length from Muskellunge muskie ~Nouraldin

		report = muskie.catchReport(); // Get report from Muskellunge via muskie

		System.out.printf("%s%n", report);
		System.out.printf("%s%n", "Program modified by Nouraldin Hassan");
		keyboard.close(); // Close scanner to prevent resource leak
	}
}
