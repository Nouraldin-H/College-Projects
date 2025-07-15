import java.util.Scanner;

/*
 * Assessment: Lab Exercise 1 - 2023-01-11
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Dave Houtman, Sandra Iroakazi
 * Lab Section Number: 300/301
 * Due Date: ???
 * Created: January 13
 * Modified: January 18
 * Description: Lab Exercise 1, the main class for printing first and last name of a student, and their student number.
*/
/**
 * @author Nouraldin Hassan
 */
/**Driver class refers to driving the program forwards, and in this case, having the user input their name, both first and last, including their student number*/
public class Driver {

	/**
	 * @param args arguments that are part of the main method
	 */
	public static void main(String[] args) {
		/**Assigns sc variable as a new scanner, utilizing the System.in argument*/
		Scanner sc = new Scanner(System.in);
		/**assigns the variable 'username' to the Username class*/
		Username username = new Username();
		/**the console prints out the given value, a string in this case, and a new line is always created*/
		System.out.println("Enter your first name:");
		/**the user is prompted to input a variable. next() means that any value is accepted, such as a string or integer*/
		username.setFirstname(sc.next());
		System.out.println("Enter your last name:");
		username.setLastname(sc.next());
		System.out.println("Enter your student number:");
		/**the user is prompted to input an integer. A value other than an integer displays an error and terminates the program */
		username.setStudentnumber(sc.nextLong());
		/**the variable report is assigned to username to call for the toString method*/
		String report = username.toString();//Username.createReport();
		/**the variable usergenerate is assigned to username to call for the generateUsername method*/
		String usergenerate = username.generateUsername();
		/**report by itself is printed, as it was initialized with username.toString*/
		System.out.println("\n" + report); //you can also print username.toString() instead
		System.out.println("Your username is " + usergenerate + ".");
		System.out.println("\nProgram by Nouraldin Hassan");
		
		/**Closes the scanner*/
		sc.close();
	}

}
