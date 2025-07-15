package task1;

import java.util.Scanner;

/*
 * Assessment: Lab Exercise 2.1-A - 2022-09-23 - Task 1: Problem Solving
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 330/331
 * Due Date: September 30, 11:59 PM
 * Created: September 23
 * Modified: September 29
 * Description: Lab Exercise 2, Task 1 File
*/
public class Car2 {
	public static void main(String[] args) {
		Car2Info carinfo = new Car2Info();

		Scanner keyboard = new Scanner(System.in);
		String vin;
		double mileage;
		double invoiceprice;
		String report;

		System.out.println("There are 5 cars detected in the inventory system");
		System.out.println("Enter the first car's VIN: ");
		vin = keyboard.nextLine(); //Expects a string input
		System.out.println("Enter the first car's Mileage (in km): ");
		mileage = keyboard.nextDouble(); //Expects a double input
		System.out.println("Enter the first car's invoice price: ");
		invoiceprice = keyboard.nextDouble(); //Expects a float input
		Car2Info car1 = new Car2Info(vin, mileage, invoiceprice); //default values used if CarInfo() parenthesis is left empty
		System.out.println(); // line for separation
		keyboard.nextLine(); //to fix input skips
	/*	System.out.println("Enter the second car's VIN: ");
		vin = keyboard.nextLine(); //Expects a string input
		System.out.println("Enter the second car's Mileage (in km): ");
		mileage = keyboard.nextDouble(); //Expects a double input
		System.out.println("Enter the second car's invoice price: ");
		invoiceprice = keyboard.nextDouble(); //Expects a float input
		Car2Info car2 = new Car2Info("G5474G874", 97720, 400,000.29);
		car2.printProperties();
		System.out.println(); // line for separation
		keyboard.nextLine(); //to fix input skips
		System.out.println("Enter the third car's VIN: ");
		vin = keyboard.nextLine(); //Expects a string input
		System.out.println("Enter the third car's Mileage (in km): ");
		mileage = keyboard.nextDouble(); //Expects a double input
		System.out.println("Enter the third car's invoice price: ");
		invoiceprice = keyboard.nextDouble(); //Expects a float input
		Car2Info car3 = new Car2Info("Lexus", "LX", 2021);
		car3.printProperties();
		System.out.println(); // line for separation
		keyboard.nextLine(); //to fix input skips
		System.out.println("Enter the fourth car's VIN: ");
		vin = keyboard.nextLine(); //Expects a string input
		System.out.println("Enter the fourth car's Mileage (in km): ");
		mileage = keyboard.nextDouble(); //Expects a double input
		System.out.println("Enter the fourth car's invoice price: ");
		invoiceprice = keyboard.nextDouble(); //Expects a float input
		Car2Info car4 = new Car2Info("Hyundai", "Santa Fe", 2023);
		car4.printProperties();
		System.out.println(); // line for separation
		keyboard.nextLine(); //to fix input skips
		System.out.println("Enter the fifth car's VIN: ");
		vin = keyboard.nextLine(); //Expects a string input
		System.out.println("Enter the fifth car's Mileage (in km): ");
		mileage = keyboard.nextDouble(); //Expects a double input
		System.out.println("Enter the fifth car's invoice price: ");
		invoiceprice = keyboard.nextDouble(); //Expects a float input
		Car2Info car5 = new Car2Info("Chevorlet", "Malibu", 2019);
		car5.printProperties();
		System.out.println(); // line for separation
*/	}
}
/** I would use the following data types for each data item:
* VIN: String (to input both numbers/integers and letters)
* Mileage & Invoice Price: Double (to input numbers/integers with decimals) in high accuracy.
*/