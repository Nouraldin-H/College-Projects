import java.util.Scanner;

/*
 * Assessment: Lab Exercise 1 - 2023-01-11
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Dave Houtman, Sandra Iroakazi
 * Lab Section Number: 300/301
 * Due Date: ???
 * Created: January 11
 * Modified: January 18
 * Description: Lab Exercise 1, the class used for proving variables and value information for use with the main class 'Driver'. Values are formatted and a username is generated.
*/
/**
 * @author - Nouraldin Hassan
 */
// This is the introduction to Javadoc commenting and a refresher for the sake of remembering what to do for the code course CST8116
/**Username class refers to providing the name, both first and last, including student number, as getters and setters for accessing them through Driver class*/
public class Username { //Program is known as "Username"
	/**firstname is a string variable but is not initialized*/
	private String firstname;
	private String lastname;
	/**studentnumber is a long variable but is not initialized*/
	private long studentnumber;
	/**{@summary} firstname is the first name of the student
	 * @return the firstname to get
	 */
	public String getFirstname() {
		return firstname;
	}
	/**{@summary} firstname is the first name of the student
	 * @param firstname the firstname to set, specifying text of the first name
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**{@summary} lastname is the last name of the student
	 * @return the lastname to get
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * {@summary} lastname is the last name of the student
	 * @param lastname the lastname to set, specifying text of the last name
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**{@summary} studentnumber is the number assigned to the student
	 * @return the studentnumber to get
	 */
	public long getStudentnumber() {
		return studentnumber;
	}
	/**{@summary} studentnumber is the number assigned to the student
	 * @param studentnumber the studentnumber to set, specifying the long numerical value of the student number
	 */
	public void setStudentnumber(long studentnumber) {
		this.studentnumber = studentnumber;
	}
	/** {@summary} 
	 * toString is the method for formatting variables
	 */
	public String toString() {
		String reportTS; //this means report toString()
		reportTS = String.format("%s, %s, %02d %n", firstname, lastname, studentnumber);
		String report = "Hello, " + firstname + " " + lastname + ".\n" + "Your student number is " + studentnumber + ".";
		return /*reportTS + */report;
	}
	/**
	 * This method allows for username generation, utilizing first and last name, and the student number.
	 * each value is defined as a char array (char[]) and the values are converted to the char arrays. The only exception is that studentnumber is first converted to string before being converted to a char array.
	 * the variable username is initalized as an empty string for the process to work. the variable must equal itself + the char variables in for loops.
	 * <p> In this program, typing 0's at the beginning of the student number removes them (example: {@code 041232109} becomes {@code 41232109}, note the removal of the first zero), because of the conversion process from long to String to char.
	 * with the for loops, the char variables have the loop variable in the square brackets [] to add only the specified assigned array values from the loop according to the next variable value of the loop. 
	 * <pre>For instance:</pre>
	 * <blockquote><pre>{@code 
	 * for (int i = 0; i < 3; i++)
	 *     username = username + lastnamesplit[i];
	 * }</pre> {} omitted for viewing purposes</blockquote>
	 * if "Smith" were entered, lastnamesplit would have 5 values in the array, starting from 0. i variable increases to 3, and with i in {@code lastnamesplit[]}, username would equal to itself + {@code lastnamesplit[i]} and i increased by 3, so the values {@code S, m,} and {@code i} would be counted. In other words, {@code username} would equal to {@code Smi}.
	 * 
	 * @return username, containing values from firstname, lastname, and studentnumber as a string
	 */
	public String generateUsername() {
		String lastnamesplit = String.format("%s" , lastname.substring(0, lastname.length() - (lastname.length() - 3)));
		String firstnamesplit = String.format("%s", firstname.substring(firstname.length() - 2));
		//String studentnumbersplit = Long.toString(studentnumber);
		String username = String.format("%s%02d%s", lastnamesplit, (100 - studentnumber % 100), firstnamesplit); //must be an empty string.
		return username;
	}
}
// TODO: search "modulus in programming" and understand what the modulus symbol means