/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
Student Name: Nouraldin Hassan
Student Number: 041054019
Course & Section #: 22S_CST8288_010/011
Declaration:
This is my own original work and is free from Plagiarism.
*/
package pkgConverterContent;

/**
 * This class converts Inches to Centimeters and implements IConvert
 * @author Nouraldin Hassan
 */
public class InCmConverter implements IConvert {

        private final double convFactor = 2.54;

        /**
         * @param inches value in Inches to be converted
         * @return equivalent in Centimeters
         */
        @Override
        public double convert(double inches) {
            return inches / convFactor;
        }
        /** THIS IS EXTRA CONTENT
	 * @param value value in Inches to be showed
	 * @return value in Inches
	 */
        @Override
        public double showValue(double value) {
            return value;
        }
}
