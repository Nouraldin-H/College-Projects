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
 * class to convert Celsius to Fahrenheit
 * @author Nouraldin Hassan
 */
public class CFconverter implements IConvert {
	private final double convFactor=1.8;
	private final double convOrigin=32.0;
        
	/**
	 * @param celsius value in Celsius to be converted
	 * @return equivalent in Fahrenheit
	 */
        @Override
	public double convert(double celsius) {
		return celsius*convFactor + convOrigin;
	}
        
        /** THIS IS EXTRA CONTENT
	 * @param value value in Celsius to be showed
	 * @return value in Celsius (CURRENTLY UNSUPPORTED)
	 */
        @Override
        public double showValue(double value) {
            return value;
        }
}
