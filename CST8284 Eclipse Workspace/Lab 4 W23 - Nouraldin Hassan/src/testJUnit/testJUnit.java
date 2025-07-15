package testJUnit;

/**
 * @author Nouraldin Hassan
 * this class tests the function of JUnit with two overloaded constructors, utilized in two files respectively.
 * @see test1.ConcatTest
 * @see test1.MultiplyTest
 */
public class testJUnit {

	/**
	 * @param one first string used for concatenation
	 * @param two second string used for concatenation
	 * @return first and second string concatenated
	 */
	public String concatenate(String one, String two) { // kept for reference
		return one + two;
	}
	/**
	 * @param number1 first integer used for multiplication
	 * @param number2 second integer used for multiplication
	 * @return first and second integer multiplied together
	 */
	public int multiply(int number1, int number2) { // kept for reference
		return number1 * number2;
	}
	
}
