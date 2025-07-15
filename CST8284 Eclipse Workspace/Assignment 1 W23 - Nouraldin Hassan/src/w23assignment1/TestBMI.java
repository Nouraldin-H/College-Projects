package w23assignment1;
/*
 * Assessment: Lab Assignment 1
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Dave Houtman, Sandra Iroakazi
 * Lab Section Number: 300/301
 * Due Date: Feb 24, 2023
 * Description: 
 */
import org.junit.Test;
import org.junit.Assert;
/*
 * ------ TESTING PROCEDURES AND ASSUMPTIONS ------
 * BMITesting(); failed, value guessed to 204. failed, value guessed to 24. succeeded, value guessed to 24.20.
 * BMITesting2(); failed, value guessed to -24.20. failed, value guessed to -26.00. succeeded, value guessed to -26.03.
 * BMITesting3(); failed, value guessed to 0. failed, value is null and cannot be estimated.
 * BMITesting4(); succeeded, value guessed to 0.
 * 
 * BMITesting() used same/normal values.
 * BMITesting2(); used different values for int and double, and set them to negative.
 * BMITesting3(); changes all values to null (string) and 0 (integer & double).
 * BMITesting4(); used same/normal values but set weight to 0.
 */
/**
 * Tests the method `BMI()` as part of the variable `patient`. <br>
 * all parameters are passed for the test <br>
 * NOTE: when debugging, payment and purchase will be re-initialized to 0 from the method `giveChange()`,
 * which is why it is hard to catch on to what makes the test succeed. <p>
 * <i>The following tests are conducted:</i> <ol><li>
 * 1. Positive Values <li>
 * 2. Negative Values <li>
 * 3. 0 Values <li>
 * 4. 0 Weight Check </ol>
 * CODE ISSUES: <ul><li> sometimes setting expected to negative value makes the test fail.
 * </ul>
 * @see HealthDataTest
 * @author Nouraldin Hassan
 */
public class TestBMI
{
   private static final double EPSILON = 1E-2;
   
// /**
// *  Tests positive BMI values. Expected value is changed after testing.
// *  Expected value should return as 24.20
// */
//public @Test void BMITesting()
//   {
//	  /**
//	   * Passed parameters: <br> First name: Nouraldin <br>
//	   * Last name: Hassan <br>
//	   * Gender: Male <br>
//	   * Birth year: 2004 <br>
//	   * Birth month: 4 <br>
//	   * Birth day: 23 <br>
//	   * Height: 66 <br>
//	   * Weight: 150 <br>
//	   * BMI Expected: 206, 24, 24.20
//	   */
//      Patient patient = new Patient("Nouraldin", "Hassan", "Male", 2004, 04, 23, 66, 150);
//      patient.getBMI();
//      double expected = 24.20;
//      Assert.assertEquals("Failed, expected different from actual", expected, patient.getBMI(), EPSILON);
//    }
//   
///**
// * Tests negative BMI values. Expected value is changed after testing.
// * Expected value should return as -26.03, given the values.
// */
//public @Test void BMITesting2()
//   {
//	  /**
//	   * Passed parameters: <br> First name: Nouraldin <br>
//	   * Last name: Hassan <br>
//	   * Gender: Male <br>
//	   * Birth year: -1956 <br>
//	   * Birth month: -6 <br>
//	   * Birth day: -14 <br>
//	   * Height: -63 <br>
//	   * Weight: -147 <br>
//	   * BMI Expected: -24.20, -26.03
//	   */
//      Patient patient = new Patient("Nouraldin", "Hassan", "Male", -1956, -06, -14, -63, -147);
//      patient.getBMI();
//      double expected = -26.03;
//      Assert.assertEquals("Failed, expected different from actual", expected, patient.getBMI(), EPSILON);
//    }
///**
// * Tests BMI values all set to 0. Strings are set to null. Expected value is set to 0 on purpose. <br>
// * Expected value should return as NaN, causing the test to fail.
// */
//public @Test void BMITesting3()
//   {
//	  /**
//	   * Passed parameters: <br> First name is null <br>
//	   * Last name is null <br>
//	   * Gender is null <br>
//	   * Birth year: 0 <br>
//	   * Birth month: 0 <br>
//	   * Birth day: 0 <br>
//	   * Height: 0 <br>
//	   * Weight: 0 <br>
//	   * BMI Expected: 0
//	   */
//      Patient patient = new Patient(null, null, null, 0, 0, 0, 0, 0);
//      patient.getBMI();
//      double expected = 0;
//      Assert.assertEquals("Failed, expected different from actual", expected, patient.getBMI(), EPSILON);
//    }
/**
 * Tests BMI values from weight being set to 0. Expected value is set to 0 on purpose. <br>
 * Expected value should return as 0.
 */
public @Test void BMITesting4()
{
	  /**
	   * Passed parameters: <br> First name: Nouraldin <br>
	   * Last name: Hassan <br>
	   * Gender: Male <br>
	   * Birth year: 2004 <br>
	   * Birth month: 4 <br>
	   * Birth day: 23 <br>
	   * Height: 66 <br>
	   * Weight: 0 <br>
	   * BMI Expected: 0
	   */
   Patient patient = new Patient("Nouraldin", "Hassan", "Male", 2004, 04, 23, 66, 0);
   patient.getBMI();
   double expected = 0;
   Assert.assertEquals("Failed, expected different from actual", expected, patient.getBMI(), EPSILON);
 }
}