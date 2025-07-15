/*
 * Author: Stanley Pieda
 * Date: Sept 15, 2020
 * Description: Demonstration of using class Scanner for program inputs
 */
public class RunScannerDemo {

	public static void main(String[] args) {
		
		KeyboardInput input = new KeyboardInput();
		String name = null;
		int favoriteInt = 0;
		double favoriteDouble = 0.0;
		
		System.out.print("Please enter your name: ");
		name = input.inputText();
		
		System.out.print("Please enter your favorite integer number: ");
		favoriteInt = input.inputInteger();
		
		System.out.print("Please enter your favorite double number: ");
		favoriteDouble = input.inputDouble();
		
		System.out.println("Values you entered");
		System.out.println("Name: " + name);
		System.out.println("favorite integer: " + favoriteInt);
		System.out.println("favorite decimal number: " + favoriteDouble);
		
	}
}
