package task3;
/*
 * Assessment: Lab Assignment 2 - 2022-11-23
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 330/331
 * Due Date: November 25, 11:59 PM
 * Created: November 22
 * Modified: November 23
 * Description: Lab Assignment 2, CSB File
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
		this(EXPECTED_DIAMETER, EXPECTED_KERF); /*assign EXP_DIAM and EXP_KERF to CSB no-argument constructor*/
	}
	
	/*
	 * Overloaded constructor, sets diameter and kerf as specified. The parameters
	 * are ordered from left to right as 
	 * (double diameter, double kerf)
	 */
	public CircularSawBlade(double diameter, double kerf) { /*argmuent constructor, assigning diameter and kerf as local variables*/
		this.diameter = diameter;
		this.kerf = kerf;
	}

	/*
	 * Accessor for diameter, uses inches as unit of measure
	 */
	public double getDiameter() { /*getter*/
		return diameter;
	}

	/*
	 * Mutator for diameter, uses inches as unit of measure
	 */
	public void setDiameter(double diameter) { /*setter*/
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
	public String toString() { /*String value method (string value constructor?)*/
		String result;

		// the \ in the text-block escapes so there is no line-feed at the end
		// of the generated String.
		result = String.format( /*formats the string*/
				"""
				diameter: %.4f (inch), width: %.4f (inch) \
				""", diameter, kerf); /*%.4f rounds the values to 4 demical places. \ is an escape character. Raw string is used*/
		
		return result; /*applies the result in return when toString is called upon*/
	}
	
}
/*
 * References:
 * [1] C. Baylor. What Does the Term "Kerf" Mean in Woodworking?. thesprucecrafts.com.
 * https://www.thesprucecrafts.com/definition-of-kerf-3536563 (Accessed Oct 28, 2022).
 */
