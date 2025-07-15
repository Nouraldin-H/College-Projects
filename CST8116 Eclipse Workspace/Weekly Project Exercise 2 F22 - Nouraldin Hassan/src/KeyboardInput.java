/*
 * Author: Stanley Pieda
 * Date: Sept 15, 2020
 * Description: Demonstration of using class Scanner for program inputs
 */
import java.util.Scanner;
public class KeyboardInput {
	private Scanner keyboard = new Scanner(System.in);
	
	public String inputText() {
		String inputValue = keyboard.nextLine();
		return inputValue;
	}
	
	public int inputInteger() {
		int inputValue = keyboard.nextInt();
		keyboard.nextLine();
		return inputValue;
	}
	
	public double inputDouble() {
		double inputValue = keyboard.nextDouble();
		keyboard.nextLine();
		return inputValue;
	}
}
