package task3;
/*
 * Assessment: Lab Assignment 2 - 2022-11-23
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 330/331
 * Due Date: November 25, 11:59 PM
 * Created: November 22
 * Modified: November 23
 * Description: Lab Assignment 2, A2 File
 */

//ToDo: Supervisor wants programmer comments (use /* */ comment)
public class Assignment02 {

	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	public static void main(String[] args) {
		CircularSawBlade blade = new CircularSawBlade(); /*create new method by assigning blade from CSB to the CSB constructor*/
		// (other variables as needed)
		int bladecount = 0; /*for how many blades (diameter, kerf) are entered*/
		boolean endProgram = false;
		while (endProgram == false) { /*making sure endProgram is false*/

			System.out.print("Enter measured diameter: ");
			double inposdiam = User.inputPositiveDouble(); /*assign a new value, "inposdiam" means inputted positive diameter*/
			blade.setDiameter(inposdiam);

			System.out.print("Enter measured kerf: ");
			double inposkerf = User.inputPositiveDouble(); /*assign a new value, "inposkerf" means inputted positive kerf */
			blade.setKerf(inposkerf);

			String result = blade.toString(); /*format string call from blade, and note how earlier CSB blade was assigned. blade is part of another method in another class and used here to call toString()*/
			/*System.out.printf("diameter: %.4f, width: %.4f", inposdiam, inposkerf);*/
			System.out.printf("%s%n",result); /*formats result, and in the result, the values are formatted via toString()*/

			// set the diameter and kerf into an instance of CircularSawBlade

			// use the toString method of class CircularSawBlade
			// to output the information for the blade.


			boolean bladediam = CircularSawBladeVerifier.isDiameterInTolerance(blade); /*assign bladediam to CSBV isDiameterInTolerance(blade) to check if diameter is tolerant from the boolean*/
			if (bladediam) {System.out.println("Diameter is in tolerance");} /*if bladediam is true, the diameter is tolerant*/
			else {System.out.println("Diameter is not in tolerance");}

			boolean bladekerf = CircularSawBladeVerifier.isKerfInTolerance(blade);
			if (bladekerf) {System.out.println("Kerf is in tolerance");}
			else {System.out.println("Kerf is not in tolerance");}
			// Use the CircularSawBladeVerifier methods to obtain a true/false regarding if the
			// blade is within specifications for diameter and kerf.
			// by passing the CircularSawBlade reference-value as an argument into each.
			// output a message for diameter and kerf to tell the user if they are within tolerance
			// e.g.
			// diameter is within tolerance
			// kerf is within tolerance

			// collect a count of, and display to the user:
			// the number of blades entered
			// the number of diameters out of tolerance
			// the number of kerfs out of tolerance
			System.out.println("blades counted/entered: " + ++bladecount); /*increase bladecount and then call it*/
			System.out.println("number of untolerated diameters: " + CircularSawBladeVerifier.diamUntoleranceCount);
			System.out.println("number of untolerated kerfs: " + CircularSawBladeVerifier.kerfUntoleranceCount);


			// print out your name on screen
			System.out.println("Program by Nouraldin Hassan");
			// using a loop ask if there is more data to enter (yes, no) and continue
			// only if the user enters some form of yes
			// e.g. "YES" "yEs" "yeS" would be acceptable (any capitalization)
			// if yes, processing should repeat starting with the output of the user-instructions.
			boolean isProgramContinueNotValid = false; /*this worked great, but renaming the boolean and setting values oppositely didn't work*/
			do {
				System.out.print("Continue Program (yes/no)? ");
				String programContinue = User.inputString(); /*prompts the user to input a string value*/
				if ("yes".equalsIgnoreCase(programContinue) || "y".equalsIgnoreCase(programContinue)) { /*typing YES or yEs or simply y works*/
					endProgram = false; /*program will keep running*/
					isProgramContinueNotValid = false; /*program continue is valid*/
					System.out.println("Program will now continue");
				}
				else if ("no".equalsIgnoreCase(programContinue) || "n".equalsIgnoreCase(programContinue)) {
					System.out.println("Program will now stop");
					endProgram = true;
					isProgramContinueNotValid = false;
				}
				else {
					System.out.println("Invalid input");
					endProgram = false;
					isProgramContinueNotValid = true; /*at that point, you will have to go through the loop until you enter yes or no*/
				}
			} while (isProgramContinueNotValid == true); /*== true isn't needed in this case but it's good for clarity*/
			
		}
		// you can use any decision structure or loop for this program,
		// however a for-loop is not recommended for the main-method logic.

	}
}

/*
 * References:
 * [1] C. Baylor. What Does the Term "Kerf" Mean in Woodworking?. thesprucecrafts.com.
 * https://www.thesprucecrafts.com/definition-of-kerf-3536563 (Accessed Oct 28, 2022).
 */