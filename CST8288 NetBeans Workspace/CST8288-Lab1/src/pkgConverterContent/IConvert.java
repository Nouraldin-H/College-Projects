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
 * Conversion interface for converting units to other units.
 * @see InCmConverter for example.
 * @author Nouraldin Hassan
 */
public interface IConvert {
    /**
     * converts the value in the parenthesis to another unit (i.e. Inches to Centimeters)
     */
    double convert(double value);
    /** THIS IS EXTRA CONTENT
     * displays the value in the parenthesis (i.e. Inches), but does not include the unit measurement
     */
    double showValue(double value);
    //double setValueDouble();
}
