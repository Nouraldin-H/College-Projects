package Task2;

import java.io.PrintStream;

/*
 * Assessment: Lab Exercise 3 - 2022-10-20 - Task 2-A
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 330/331
 * Due Date: October 23, 11:59 PM
 * Created: October 23
 * Modified: October 20
 * Description: Lab Exercise 3, Task 1 File
*/
public class HardBreadProgram {
	public static void main(String[]args)
	{
		PrintStream out = System.out; //Experimental/Test import of PrintStream to only call out.print instead of 
		
		double volume;
		String report;
		
		HardBread hardBread1 = new HardBread();
		HardBread hardBread2 = new HardBread(2.5, 5.75, 3.45, true); //Don't worry, it won't change HardBread, it will just make and assign hardBread2.
		volume = hardBread1.calculateVolume(); //Getting calculateVolume from HardBread class.
		report = hardBread1.toString();
		System.out.print("Hard Bread 1: \nvolume: "); //Using /n for a new line instead of adding another print method.
		hardBread1.setLength(HardBread.MAX_LENGTH); //Try to get length from HardBreadInfo.
		System.out.printf("%.2f %n", volume); // should format to 2 decimal places, and using setLength above as test and example.
		System.out.println("reported: " + report + "salted bread: " + hardBread1.isSalted());
		System.out.println(); //line separation for easy reading.
		volume = hardBread2.calculateVolume();
		report = hardBread2.toString();
		out.print("Hard Bread 2: \nvolume: "); //Also trying import PrintStream and method shortening.
		out.printf("%.2f %n", volume);
		out.println("reported: " + report + "salted bread: " + hardBread2.isSalted());
		out.print("Program by Nouraldin Hassan");
	}
}
