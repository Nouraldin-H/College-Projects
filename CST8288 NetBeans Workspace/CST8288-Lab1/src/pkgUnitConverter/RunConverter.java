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

import pkgConverterContent.CFconverter;
import pkgConverterContent.CmInConverter;
import pkgConverterContent.FCconverter;

/** 
 * This is the main program that runs the converter
 * @author Nouraldin Hassan
 */
public class RunConverter {
    public static void main(String[] args) {
        UnitConverter unitConverter = new UnitConverter();
        
        unitConverter.executeConverter();
        //System.out.println("InCmConverter Ran");
        System.out.println(unitConverter.executeConverterAndDisplay("Inches from Centimeters"));
        
        CmInConverter x = new CmInConverter();
        unitConverter.setConvert(x);
        
        unitConverter.executeConverter();
        //System.out.println("CmInConverter Ran");
        System.out.println(unitConverter.executeConverterAndDisplay("Centimeters from Inches"));
        
        FCconverter x2 = new FCconverter();
        unitConverter.setConvert(x2);
        
        unitConverter.executeConverter();
        //System.out.println("CmInConverter Ran");
        System.out.println(unitConverter.executeConverterAndDisplay("Fahrenheit from Celsius"));
        
        CFconverter x3 = new CFconverter();
        unitConverter.setConvert(x3);
        
        unitConverter.executeConverter();
        //System.out.println("CmInConverter Ran");
        System.out.println(unitConverter.executeConverterAndDisplay("Celsius from Fahrenheit"));
    }
}
