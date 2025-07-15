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
 * This class converts Centimeters to Inches and implements IConvert
 * @author Nouraldin Hassan
 */
public class CmInConverter implements IConvert {

        private final double convFactor = 2.54;

        /**S
         * @param centimeters value in Centimeters to be converted
         * @return equivalent in Inches
         */
        @Override
        public double convert(double centimeters) {
            return centimeters * convFactor;
        }
        /** THIS IS EXTRA CONTENT
	 * @param value value in Centimeters to be showed
	 * @return value in Centimeters
	 */
        @Override
        public double showValue(double value) {
            return value;
        }
}
