package task2fix;
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
//Pseudocode starts here
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
*		output "Program by Nouraldin Hassan"
*	stop
*
*	SIDE NOTE: Loops and special statements are used.
*/
public class AppleProgram2 {
	public static void main(String[] args) {
		//int[] sizearray = {163,150,138,125,113,100,88,80};

		Apple2 applecost = new Apple2(); //Call Apple class via applecost declaration
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter apple size: ");
		int size = keyboard.nextInt();
		applecost.setSize(size); //set the size of size via initialization
		double cost = applecost.costPerApple();
		//if (cost != 0) {
		//	System.out.println("List of available sizes: 163, 150, 138, 125, 113, 100, 88, 80");
		//}
		if (size != 0) { //was "size != sizearray" to compare
			//Integer.parseInt("size"); //To parse the given sizes to an int, because of string input
			System.out.printf("Size selected: %d %n", size);
			if (size == 163 || size == 150 || size == 138 || size == 125 || size == 113 || size == 100 || size == 88 || size == 80) {
			System.out.printf("Apple cost: %.3f %n", cost); }
			else {
			System.out.println("Apple cost: N/A"); }
		}
		else {
			
			System.out.println("Invalid input");
			
			//else if (applecost.equals("stop") || applecost.equals("'stop'")) {
		}
		System.out.println("Program by Nouraldin Hassan, with additional help by Xinlan Zhang");
		keyboard.close();
	}
}