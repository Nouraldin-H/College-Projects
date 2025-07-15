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
package pkgUnitConverter;

import pkgConverterContent.IConvert;
import pkgConverterContent.InCmConverter;

/**
 * This class functions as the base converter of units.
 * In this case, Inches will be converted to Centimeters
 * @author Nouraldin Hassan
 */
public class UnitConverter {
    private IConvert iConvert;
    
    /**
    * This constructor creates a new InCmConverter() object for use in this class
    */
    public UnitConverter() {
        iConvert = new InCmConverter();
    }
    /**
    * Executes the Converter
    */
    public void executeConverter() {
        iConvert.convert(1);
        //System.out.println("Conversion: " + iConvert.convert(1) + " from 1"); // Commented out but kept for reference
    }
    /** THIS IS EXTRA CONTENT
    * Executes the display and display type of a value (I.e. 1 Inches, 1 Inches from Centimeters, etc.)
    * @param valueType the unit of measurement
    * @return the value to display, including the unit of measurement that you provide
    */
    public String executeValueDisplay(String valueType) {
        return iConvert.showValue(1) + " " + valueType;
    }
    /** THIS IS EXTRA CONTENT
    * Same function as executeValueDisplay() but displays converted value
    * @param valueType the unit of measurement
    * @return the converted value to display, including the unit of measurement that you provide
    */
    public String executeConverterAndDisplay(String valueType) {
        return iConvert.convert(1) + " " + valueType;
    }
    /**
    * Sets a new conversion type (I.e. Centimeters to Inches)
    * Use a class that implements IConvert
    * @param newConvert the new conversion type you want to use
    */
    public void setConvert(IConvert newConvert) {
        iConvert = newConvert;
    }
}