/*
 * Assessment: Hybrid Exercise 2 - 2022-09-18 - Task Debugging
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 331
 * Due Date: September 18, 11:59 PM
 * Created: September 18
 * Modified: September 18
 * Description: Hybrid Exercise 2, Task Debugging File
*/

public class Hybrid2Debugging {
	public static void main(String[] args) {
		double sum = 0.1; // assigned 0.1
		sum = sum + 0.1; // expect that 0.2 is assigned
		sum = sum + 0.1; // expect that 0.3 is assigned
		sum = sum + 0.1; // expect that 0.4 is assigned
		sum = sum + 0.1; /// expect that 0.5 is assigned
		sum = sum + 0.1; // expect that 0.6 is assigned
		sum = sum + 0.1; // expect that 0.7 is assigned
		sum = sum + 0.1; // expect that 0.8 is assigned
		sum = sum + 0.1; // expect that 0.9 is assigned
		sum = sum + 0.1; // expect that 1.0 is assigned
		System.out.println("Sum is: " + sum);
	}
}
