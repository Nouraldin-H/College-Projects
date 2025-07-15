package task3;
/*
 * Assessment: Lab Assignment 2 - 2022-11-23
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 330/331
 * Due Date: November 25, 11:59 PM
 * Created: November 22
 * Modified: November 23
 * Description: Lab Assignment 2, CSBV File
*/

//ToDo: Supervisor wants programmer comments (use /* */ comment)
public class CircularSawBladeVerifier {
	public static final double EPSILON = 0.015625; /* EPSILON declared */
	// ToDo: Create a public static final EPSILON with value 0.015625
	//       i.e. one-64th of an inch 1/64
	public static int kerfUntoleranceCount = 0; /*try declaration in class instead of in method*/
	public static int diamUntoleranceCount = 0;
	
	/*
	 * This is a utility class with only static members, prevent
	 * Instantiation.
	 */
	private CircularSawBladeVerifier() {} /*private no-argument constructor*/
	
	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	public static boolean isDiameterInTolerance(CircularSawBlade blade) {
		// check that the diameter does not differ more than EPSILON and expected diameter
		/*int diamUntoleranceCount = 0;*/ /*try declaration in method instead of in class*/
		++diamUntoleranceCount; /*increase non-tolerance count*/
		double diamdiff = Math.abs(CircularSawBlade.EXPECTED_DIAMETER - blade.getDiameter());
		/*System.out.println(blade.getDiameter()); [debug thing] to get inputted diameter*/
		if (diamdiff <= EPSILON) /*using the static value. using the direct value "7.25" is the same thing or no?*/ {
			/*System.out.println(diamdiff + " is close to " + EPSILON);*/ /*debugging purposes*/ /*Math.abs(CircularSawBlade.EXPECTED_DIAMETER) <= EPSILON*/
			--diamUntoleranceCount; /*decrease non-tolerance count*/
			return true;
		}
		// Tip: The constant in class CircularSawBlade documents the expected
		// value for diameter.
		// return a boolean that indicates if the circular saw blade diameter is within 
		// tolerance (i.e. difference of actual and expected is less than or equal to EPSILON)
		return false; /*it's false if diamdiff > EPSILON. No need for "else" decision statement as this works in roughly the same way in this context*/
	}
	
	public static boolean isKerfInTolerance(CircularSawBlade blade) {
		// check that the diameter does not differ more than EPSILON and expected kerf
		
		double kerfdiff = Math.abs(CircularSawBlade.EXPECTED_KERF - blade.getKerf());
		/*System.out.println(blade.getKerf()); [debug thing] to get inputted kerf*/
		kerfUntoleranceCount++;
		if (kerfdiff <= EPSILON) /*using the static value. using the direct value "7.25" is the same thing or no?*/ {
			/*System.out.println(kerfdiff + " is close to " + EPSILON);*/ //Math.abs(CircularSawBlade.EXPECTED_DIAMETER) <= EPSILON
			kerfUntoleranceCount--;
			return true;
		}
		// Tip: The constant in class CircularSawBlade documents the expected
		// value for kerf.
		// return a boolean that indicates if the circular saw blade kerf is within 
		// tolerance (i.e. difference of actual and expected is less than or equal to EPSILON)
		
		return false; //placeholder so the code will compile, update with the actual true or false
	}
}

/*
 * References:
 * [1] C. Baylor. What Does the Term "Kerf" Mean in Woodworking?. thesprucecrafts.com.
 * https://www.thesprucecrafts.com/definition-of-kerf-3536563 (Accessed Oct 28, 2022).
 */
