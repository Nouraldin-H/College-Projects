package sandbox;

import java.util.*;

/**
 * @author Nouraldin Hassan
 *
 */
public class DiceGame {
	static boolean loop = true;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (loop == true) {
		System.out.println("Enter the sides of the dice you want to use");
		int sides = sc.nextInt();
		Random rand = new Random();
		int roll = rand.nextInt(sides) + 1; //can be 6 by default + 1
		System.out.println("You rolled a " + roll);
		}
		sc.close();
	}
}
