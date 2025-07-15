package task1;

/*
 * Assessment: Lab Exercise 4 - 2022-11-04 - Task 1-B
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 330/331
 * Due Date: November 06, 11:59 PM
 * Created: November 04
 * Modified: November 04
 * Description: Lab Exercise 4, Task 1 File
*/

/*
 * ToDo: Provide overview of class, and comment all constructors and methods
 */
public class Muskellunge {
	private static final int LIMIT_SIZE = 137; // centimeters [2]
	
	private double length;
	
	public Muskellunge() { // Constructor
		this(0.0); //Was "this(0);". Value is a double, not an int ~Nouraldin
	}
	
	public Muskellunge(double length) { //Overloaded constructor, note the declared value in the parenthesis.
		this.length = length;
	}
	
	public double getLength() { //Getter for length
		return length;
	}
	public void setLength(double length) { //Setter for length
		this.length = length; //Was "length = length" ~Nouraldin
	}
	
	public String catchReport() {
		boolean isOverLimit;
		String report;
		
		isOverLimit = length > LIMIT_SIZE; //Recall that the limit SHOULD be over 137 to keep. ~Nouraldin

		if(isOverLimit == true) { //Was "if(isOverLimit = true)" Note there was 1 equals instead of 2. ~Nouraldin
			report = "Keeper";
		}
		else {
			report = "Release";
		}
		//This means if length > LIMIT_SIZE, isOverLimit is true.
		return report;
	}
}
