package task2;
/*
 * Assessment: Lab Exercise 4 - 2022-11-10 - Task 2-A
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 330/331
 * Due Date: November ??, 11:59 PM
 * Created: November 10
 * Modified: November 16
 * Description: Lab Exercise 4, Task 2 File
*/

//Pseudocode starts here
/*	
*	start
*		declarations
*			private int size
*			double cost 		// from costPerApple()
*		Apple()
*		Apple(int size)
*		getSize
*		setSize
*		double costPerApple()
*			switch size
*				size 163:
*					cost = 0.061
*				size 150:
*					cost = 0.061
*				// and so on.
*				default:
*					cost = 0.0
*				return cost
*			end
*		end
*	stop
*/
public class Apple {
	private int size;
	
	public Apple() { //Get Apple()
		this(0);
	}
	public Apple(int size) { //Declare size in Apple()
		this.size = size;
	}
	public int getSize() { //Getter
		return size;
	}
	public void setSize(int size) { //Setter
		this.size = size;
	}
	public double costPerApple() { //Creating method with switch.
		double cost;
		switch (size) {
		case 163:
			cost = 0.061;
			break;
		case 150:
			cost = 0.067;
			break;
		case 138:
			cost = 0.072;
			break;
		case 125:
			cost = 0.080;
			break;
		case 113:
			cost = 0.088;
			break;
		case 100:
			cost = 0.100;
			break;
		case 88:
			cost = 0.114;
			break;
		case 80:
			cost = 0.125;
			break;
		default:
			cost = 0.0;
			break;
		}
		
		return cost; //return what was declared so the logic works.
	}
	/*public double calculateAppleCost() {
		double cost;
		cost = costPerApple(); //The intent is to get the cost from costPerApple() provided the size is inputted in the main method
		return cost;
	}*/ //This isn't needed anymore since using this causes errors
}
