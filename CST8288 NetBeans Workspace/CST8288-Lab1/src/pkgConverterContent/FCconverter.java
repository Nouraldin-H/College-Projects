// standard Algonquin header goes here.
/*
Student Name: Nouraldin Hassan
Student Number: 041054019
Course & Section #: 22S_CST8288_010/011
Declaration:
This is my own original work and is free from Plagiarism.
*/
package pkgConverterContent;

/**
 * class to convert Fahrenheit to Celsius
 * @author Nouraldin Hassan
 */
public class FCconverter implements IConvert {
	private final double convFactor=1.8;
	private final double convOrigin=32.0;
	
	/**
	 * @param fahrenheit value in Fahrenheit to be converted
	 * @return equivalent in Celsius
	 */
        @Override
	public double convert(double fahrenheit) {
		return (fahrenheit - convOrigin)/convFactor;
	}

        /** THIS IS EXTRA CONTENT
	 * @param value value in Fahrenheit to be showed
	 * @return value in Fahrenheit (CURRENTLY UNSUPPORTED)
	 */
        @Override
        public double showValue(double value) {
            return value;
        }
}
