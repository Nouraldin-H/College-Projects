package task3;
/*
 * Assessment: Lab Assignment 2 - 2022-11-23
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 330/331
 * Due Date: November 25, 11:59 PM
 * Created: November 22
 * Modified: November 23
 * Description: Lab Assignment 2, User File
 * - create a method inputPositiveDouble(String prompt) that ensures that only 
 *   positive numbers are entered, use this in the programs main method logic.
 */

import java.util.Scanner;

/*
 * This class provides utility for getting user input from the console using
 * an instance of Scanner set to new Scanner(System.in) and has methods that 
 * prevent program crashes from text inputs when numbers are expected.
 */
public class User {
	
	private static Scanner keyboard = new Scanner(System.in);
	
	/*
	 * This is a utility class with only static members, prevent
	 * Instantiation.
	 */
	private User() {}
	
	/*
	 * Does not prompt the user, reads in an int value when there is one. If
	 * the user does not provide input that can be converted into an int an
	 * error message is printed requesting a correct input and a loop is used
	 * to trap the user until they get this right. A future version of 
	 * the program might have a sanity check to break the loop after several 
	 * failed attempts and then shut down the program, rather than looping
	 * (in theory) forever.
	 */
	public static int inputInteger() { /*constructor*/
		boolean isInputBad = true;
		boolean hasNextInt;
		int value = 0; /*initial value declaration needed*/
		while(isInputBad) {
			hasNextInt = keyboard.hasNextInt();
			if(hasNextInt) {
				value = keyboard.nextInt();
				isInputBad = false; // break out of loop
			}
			else {
				System.out.print("Invalid input. Enter an integer number: ");
			}
			keyboard.nextLine(); // clean up input stream
		}
		return value;
	}
	
	/*
	 * This method prompts the user using the argument sent to message
	 *  and then calls to method inputInteger() to get the actual input value.
	 */
	public static int inputInteger(String message) {
		// This method calls inputInteger(), so no changes are needed here.
		System.out.printf("%s", message);
		int value = inputInteger(); 
		return value;
	}
	
	/*
	 * Does not prompt the user, reads in a double value when there is one. If
	 * the user does not provide input that can be converted into a double an
	 * error message is printed requesting a correct input and a loop is used
	 * to trap the user until they get this right. A future version of 
	 * the program might have a sanity check to break the loop after several 
	 * failed attempts and then shut down the program, rather than looping
	 * (in theory) forever.
	 */
	public static double inputDouble() {
		boolean isInputBad = true;
		boolean hasNextDouble;
		double value = 0.0;
		while(isInputBad) {
			hasNextDouble = keyboard.hasNextDouble();
			if(hasNextDouble) {
				value = keyboard.nextDouble();
				isInputBad = false; // break out of loop
			}
			else {
				System.out.print("Invalid input. Enter a number: ");
			}
			keyboard.nextLine(); // clean up input stream
		}
		return value;	
	}
	
	/*
	 * This method prompts the user using the argument sent to message
	 *  and then calls to method inputDouble() to get the actual input value.
	 */
	public static double inputDouble(String message) {
		// This method calls inputDouble(), so no changes are needed here.
		System.out.printf("%s", message);
		double value = inputDouble();
		return value;
	}
	
	/*
	 * this method is used to get a line of text from the console, it reads
	 * until it encounters a line terminator character.
	 */
	public static String inputString() {
		String value = keyboard.nextLine();
		return value;
	}
	
	/*
	 * This method prompts the user using the argument sent to message, 
	 * then calls to method inputString() which reads in the actual text.
	 */
	public static String inputString(String message) {
		System.out.printf("%s", message);
		String value = inputString();
		return value;
	}
	
	public static double inputPositiveDouble() {
		boolean isInputBad = true;
		boolean hasNextDouble;
		double value = Math.abs(0.0);
		while(isInputBad) {
			hasNextDouble = keyboard.hasNextDouble();
			if(hasNextDouble) {
				value = keyboard.nextDouble();
				if (value < 0) { /*added for positive validity*/
					isInputBad = true; /*added for positive validity. You have to enter a value again*/
					System.out.print("The input should be positive. Enter a number: "); /*added for positive validity*/
					}
				else
					isInputBad = false; // break out of loop
			}
			else {
				System.out.print("Invalid input. Enter a number: ");
			}
			keyboard.nextLine(); // clean up input stream
		}
		return value;	
	}
	/*
	 * ToDo Comments
	 */
	public double inputPositiveDouble(String prompt) {
		// toDo: implement the method
		System.out.printf("%s", prompt);
		double value = inputPositiveDouble();
		return value;
		/*return 0.0;*/ // only returns 0.0 so class will compile, replace with user provided value
	}
}