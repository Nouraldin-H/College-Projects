import java.math.*;
import java.util.Scanner;

/*
 * Assessment: Lab Assignment 1 - 2022-10-06 - Task 2
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 330/331
 * Due Date: October 07, 11:59 PM
 * Created: October 06
 * Modified: October 07
 * Description: Lab Assignment 1, Task 2-A File
*/
/*
Circular base (diameter, radius for 1/2 the perimeter) and how tall the pyramid-like shape (height) is. This is the program.
Reference: [1]"Cone Volume Calculator," . (From Omni Calculator), following the formula to get the Volume.
 */
public class Cone { 
/* Pseudocode
start
	declarations
		double height
		double radius
	output "please enter the height"
	input height
	output "please enter the radius"
	input radius
	volume = 1.0/3 * math.pi * radius^2 * height
	output "the volume of the cone is: " + volume
	
	toString()
		declarations
			String report
		report = format width + "," + height + "," + radius + ","
	return report
stop
 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double height;
		double radius;
		String report;
		
		// 1/3 = 0.3333333
		double oneDivByThree = 0.333333333333333333333333333333333333333; // Multiple 3's for an accurate value
		
		System.out.println("Enter the height: ");
		height = keyboard.nextDouble(); //Expects a double input. Try 35.7
		System.out.println("Enter the radius: ");
		radius = keyboard.nextDouble(); //Try 23.3
		ConeInfo cone1 = new ConeInfo(height, radius); //For reference
		//System.out.println(cone1); // commented out because of error caused
		double cone1results = oneDivByThree * Math.PI * Math.pow(radius, 2) * height;
		System.out.println("The volume of the cone is " + cone1results); // line for separation
		System.out.println("Program by Nouraldin Hassan");
		System.out.println("BELOW IS DEBUG/TEST STUFF THAT YOU CAN IGNORE");
		System.out.println("power test with radius: " + Math.pow(radius, 2)); // testing output of Math.pow with radius and 2 (radius^2)
		System.out.println(Math.PI);
		System.out.println("1/3 times pi: " + (1 / 3 * Math.PI));
		System.out.println("1/3 only: " + (1 / 3));
		//keyboard.nextLine(); //to fix input skips
	}
}
