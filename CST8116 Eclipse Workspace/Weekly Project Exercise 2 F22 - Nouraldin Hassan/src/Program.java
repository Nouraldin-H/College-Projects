import java.util.Scanner;
public class Program {
	
	public static void main(String[] args) {
		Circle circle = new Circle();
		
		Scanner keyboard = new Scanner(System.in);
		double userInput;
		double radius;
		double circumference;
		double area;
		String report;
		
		System.out.print("Enter radius: ");
		userInput = keyboard.nextDouble();
		
		circle.setRadius(userInput); //was circle.radius = 5.0;
		
		circumference = circle.calculateCircumference();
		area = circle.calculateArea();
		
		System.out.printf("circumference: %.2f %n", circumference);
		System.out.printf("area: %.2f %n", area); //printf fix: restart eclipse. If doesn't work, make new project and copy the code to there
		
		double test;
		
		test = circle.getRadius();
		
		System.out.println(test);
	}
}
