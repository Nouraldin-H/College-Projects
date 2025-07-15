package task3original;
//ToDo: Supervisor wants programmer comments (use /* */ comment)

//ToDo: Supervisor wants programmer comments (use /* */ comment)
public class CircularSawBladeVerifier {
	// ToDo: Create a public static final EPSILON with value 0.015625
	//       i.e. one-64th of an inch 1/64
	
	/*
	 * This is a utility class with only static members, prevent
	 * Instantiation.
	 */
	private CircularSawBladeVerifier() {}
	
	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	public static boolean isDiameterInTolerance(CircularSawBlade blade) {
		// check that the diameter does not differ more than EPSILON and expected diameter

		// Tip: The constant in class CircularSawBlade documents the expected
		// value for diameter.
		// return a boolean that indicates if the circular saw blade diameter is within 
		// tolerance (i.e. difference of actual and expected is less than or equal to EPSILON)
		
		return false; //placeholder so the code will compile, update with the actual true or false
	}
	
	public static boolean isKerfInTolerance(CircularSawBlade blade) {
		// check that the diameter does not differ more than EPSILON and expected kerf

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
