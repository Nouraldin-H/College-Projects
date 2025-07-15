import java.io.DataInput;
import java.io.DataOutput;
import java.util.Scanner;

/*
 * Assessment: Lab Exercise 1.2 - 2022-09-09 - Task 3: Pseudocode
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 331
 * Due Date: September 16, 11:59 PM
 * Created: September 10
 * Modified: September 11
 * Description: Lab Exercise 1, Task 2 File
*/
public class Task2Pseudocode {
	public static void main(String[] args) { //Only String can be used, so the code can run properly
		/** The following is provided Pseudocode:
		 *  start
				sum = number1 + number2
				input number1
				output "Enter number1"
				declarations
					num number1
					num number2
					num sum
				output "Sum is: " + sum
    			output "Enter number2"
    			input number2
			stop

		 */
		/** The following is corrected Pseudocode:
		 *  start
				
				declarations
					num number1
					num number2
					num sum
				output "Enter number1"
				input number1
				output "Enter number2"
    			input number2
				sum = number1 + number2
				output "Sum is: " + sum
			stop

		 */
		// start has already been declared, courtesy of public class and static void
		Scanner sc = new Scanner(System.in); //adds a scanner and utilizes the input system
			int number1; //declare number1 but without any assigned value
			int number2;
			System.out.println("Enter number1"); //outputs a string to prompt the user to type
			number1 = sc.nextInt(); //the user needs to type an integer. 42, for example
			System.out.println("Enter number2");
			number2 = sc.nextInt(); //8, for example
			int sum = number1 + number2; //declared sum for the next output
			System.out.println("Sum is: " + sum);
		// Stop has already been declared, courtesy of the curly brackets at the end
	}
}
/***/