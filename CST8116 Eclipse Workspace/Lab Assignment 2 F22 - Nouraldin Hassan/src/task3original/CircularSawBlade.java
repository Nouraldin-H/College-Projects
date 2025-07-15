package task3original;
/*
 * Student Name: Stanley Pieda
 * Lab Professor: Professor Stanley Pieda
 * Due Date: The due date
 * Description: Assignment 02 (22F) Starter Code
 */

/* This class models a circular saw blade with measurements for diameter 
 * and kerf in inches. Note that for a high end circular saw blade 
 * with 7 and 1/4 inch (7.25 inch) diameter, the the kerf would be 
 * approximately 1/17 of an inch (0.059 inches to be exact). 
 * Constants are provided for the high end circular saw blade dimensions.
 * 
 * Note: A kerf is the thickness of the cut made by a saw blade. [1]
 */
public class CircularSawBlade {

	public static final double EXPECTED_DIAMETER = 7.25; 
	public static final double EXPECTED_KERF = 0.059;
	private double diameter; // Measured diameter in inches
	private double kerf; // Measured kerf in inches
	
	/*
	 * No-argument constructor, sets diameter and kerf to 
	 * the same values as the constants.
	 */
	public CircularSawBlade() {
		this(EXPECTED_DIAMETER, EXPECTED_KERF); 
	}
	
	/*
	 * Overloaded constructor, sets diameter and kerf as specified. The parameters
	 * are ordered from left to right as 
	 * (double diameter, double kerf)
	 */
	public CircularSawBlade(double diameter, double kerf) {
		this.diameter = diameter;
		this.kerf = kerf;
	}

	/*
	 * Accessor for diameter, uses inches as unit of measure
	 */
	public double getDiameter() {
		return diameter;
	}

	/*
	 * Mutator for diameter, uses inches as unit of measure
	 */
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	/*
	 * Accessor for kerf, uses inches as unit of measure
	 */
	public double getKerf() {
		return kerf;
	}

	/*
	 * Mutator for kerf, uses inches as unit of measure
	 */
	public void setKerf(double kerf) {
		this.kerf = kerf;
	}
	
	/*
	 * Returns a String that represents the data held within this object.
	 */
	public String toString() {
		String result;

		// the \ in the text-block escapes so there is no line-feed at the end
		// of the generated String.
		result = String.format(
				"""
				diameter: %.4f (inch), width: %.4f (inch) \
				""", diameter, kerf);
		
		return result;
	}
	
}
/*
 * References:
 * [1] C. Baylor. What Does the Term "Kerf" Mean in Woodworking?. thesprucecrafts.com.
 * https://www.thesprucecrafts.com/definition-of-kerf-3536563 (Accessed Oct 28, 2022).
 */
