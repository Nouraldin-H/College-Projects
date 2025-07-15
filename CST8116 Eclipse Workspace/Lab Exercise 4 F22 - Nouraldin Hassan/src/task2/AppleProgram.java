package task2;
/*
 * Assessment: Lab Exercise 4 - 2022-11-10 - Task 2-B
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 330/331
 * Due Date: November ??, 11:59 PM
 * Created: November 10
 * Modified: November 16
 * Description: Lab Exercise 4, Task 2 File. Tested
*/
import java.util.Scanner;
// Pseudocode starts here
  /*	
   *	start
   *		applecost = new Apple()
   *		input size
   *
   *		if size not equals 0
   *			output size
   *			output cost
   *		else if size equals switch size
   *			output "N/A"
   *		end if
   *		output "Program by Nouraldin Hassan"
   *	stop
   *
   *	SIDE NOTE: Loops and special statements are used.
   */
public class AppleProgram {
	public static void main(String[] args) {

		Apple applecost = new Apple(); //Call Apple class via applecost declaration
		Scanner keyboard = new Scanner(System.in);

		System.out.println("At any time, you may enter 1 for a list of available sizes to type, or enter 2 to end the process");
		boolean loop = true;
		while (loop == true){

			System.out.print("Enter apple size: ");
			int size = keyboard.nextInt();
			applecost.setSize(size); //set the size of size via initialization
			//double cost = applecost.costPerApple(); //Initializes cost via method.
			if (size == 1) {
				System.out.println("List of available sizes: 163, 150, 138, 125, 113, 100, 88, 80");
			}
			else if (size != 0 && size == 163 || size == 150 || size == 138 || size == 125 || size == 113 || size == 100 || size == 88 || size == 80) {
				//Integer.parseInt("cost"); //To parse the given sizes to an int, because of string input
				System.out.printf("%s %d %n","size selected:", size);
				System.out.printf("Apple cost: %.3f %n", applecost.costPerApple()); // you can also use cost instead of applecost method.
			}
			else if (size != 0 && size != 2) {
				System.out.printf("%s %d %n","Size selected:", size);
				System.out.println("Apple cost: N/A"); //About the same as "Invalid Input" or "Invalid"
			}
			else if (size == 2) {
				System.out.println("Program stopped\nProgram by Nouraldin Hassan");
				loop = false;
				keyboard.close(); //by itself, resource leak. See other keyboard close at end of code
				return; //Returns you out of the scope. break; also works
			}
			else {
				System.out.println("Invalid Input"); //Appears if you somehow manage to pass nextInt without an int
			}
			
		}
		keyboard.close(); //For some reason, this doesn't work by itself
	}
}