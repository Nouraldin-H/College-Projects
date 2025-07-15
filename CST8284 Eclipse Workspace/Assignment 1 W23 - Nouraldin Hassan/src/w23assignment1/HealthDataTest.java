package w23assignment1;
/*
 * Assessment: Lab Assignment 1
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Dave Houtman, Sandra Iroakazi
 * Lab Section Number: 300/301
 * Due Date: Feb 24, 2023
 * Description: 
 */
import java.util.Scanner;

/**
 * This class serves as the main method class for inputting health data.
 * @author Nouraldin Hassan
 */
public class HealthDataTest {
	
	/**
	 * Created for other methods to access this method within the class.
	 */
	public HealthDataTest() {
		
	}

	/**
	 * CODE ISSUES: <ul><li> When you pass a parameter in a method, you are still required to input the same variable, overriding the parameter itself.
	 * <li> see {@link Patient#Patient()} </ul>
	 * @param args the string arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Patient patient = new Patient("nouraldin");
		System.out.print("Enter the patient's first name: ");
		patient.setFirstName(sc.next());
		System.out.print("Enter the patient's last name: ");
		patient.setLastName(sc.next());
		System.out.print("Enter the patient's gender: ");
		patient.setGender(sc.next());
		System.out.print("Enter the patient's birth year: ");
		patient.setBirthYear(sc.nextInt());
		System.out.print("Enter the patient's birth month: ");
		patient.setBirthMonth(sc.nextInt());
		System.out.print("Enter the patient's birth day: ");
		patient.setBirthDay(sc.nextInt());
		System.out.print("Enter the patient's height (in inches): ");
		patient.setHeight(sc.nextDouble());
		System.out.print("Enter the patient's weight (in lbs): ");
		patient.setWeight(sc.nextDouble());
		patient.displayMyHealthData();
		
		if (patient.getWeight() <= 18.5)
			System.out.print("\nPatient is Underweight");
		else if (patient.getWeight() >= 18.5 && patient.getWeight() <= 24.9)
			System.out.print("\nPatient is Normal Weight");
		else if (patient.getWeight() >= 25 && patient.getWeight() <= 29.9)
			System.out.print("\nPatient is Overweight");
		else
			System.out.print("\nPatient is Obese");
		if (patient.Age() >= 150)
			System.out.print("\nPatient is Dead");
		sc.close();
	}
}
