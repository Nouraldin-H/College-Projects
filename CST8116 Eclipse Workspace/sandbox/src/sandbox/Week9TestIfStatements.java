package sandbox;

import java.util.Scanner;

public class Week9TestIfStatements {
	public static void main(String[]args) {
		int grade;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter grade mark");
		grade = sc.nextInt();

		if (grade >= 80) {
			System.out.println("A");
		}
		else if (grade >= 70) {
			System.out.println("B");
		}
		else if (grade >= 60) {
			System.out.println("C");
		}
		else if (grade >= 50) {
			System.out.println("D");
		}
		else {
			System.out.println("F");
		}
	}	
} // using else if, the code lines go from 34 to 28. Nested if's use more code lines.