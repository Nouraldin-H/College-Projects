package task2fix;
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
public class Apple2 {
	private int size;
	
	public Apple2() {
		this(0);
	}
	public Apple2(int size) {
		this.size = size;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public double costPerApple() {
		double cost;
		switch (size) {
		case 163:
			return cost = 0.061;
			//break;
		case 150:
			return cost = 0.067;
		case 138:
			return cost = 0.072;
		case 125:
			return cost = 0.080;
		case 113:
			return cost = 0.088;
		case 100:
			return cost = 0.100;
		case 88:
			return cost = 0.114;
		case 80:
			return cost = 0.125;
		default:
			cost = 0.0;	
			break;
		}
		return cost; //Placing return after every case, initializes the values.
	}
}
