import java.util.Scanner;
/*
 * Assessment: Lab Exam 1 - 2022-10-14 - Task 1
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 330/331
 * Due Date: October 14, 9:50 AM
 * Created: October 14
 * Modified: October 14
 * Description: Lab Exam 1, Task 1 File
*/

public class TunaSaladCalc {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String text;
		double number;
		TunaSaladProgram tunaSaladProgram = new TunaSaladProgram();
	
		System.out.printf("%n"); // Utilizes a no-argument constructor
		
		System.out.printf("%s", "enter weight (grams): ");
		number = keyboard.nextDouble();
		tunaSaladProgram.setWeight(number); // gets the weight from tunaSaladProgram
		
		System.out.printf("%s", "enter calories per gram: ");
		number = keyboard.nextInt();
		tunaSaladProgram.setCalories((int) number); // uses a cast because calories is an integer
		
		number = tunaSaladProgram.calculateTotalCalories();
		System.out.printf("total calories: %.4f%n", number);
		
		text = tunaSaladProgram.toString();
		System.out.printf("weight reports: %s%n", text);
		
		System.out.printf("%s", "Program by Nouraldin Hassan");
	}
}
