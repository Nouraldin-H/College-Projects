package car;
/*
 * Author: Stanley Pieda
 * Date: Sept 13, 2020
 * Description: Demonstration of importance of testing class to detect bugs.
 * Hint: look at the getModel() method carefully.
 */
/*
 * Class that launches the program, contains method main.
 */
public class CarTest {
	/*
	 * entry point for the program
	 */
	public static void main(String[] args) {
		System.out.println("Test default constructor and printProperties() method");
		System.out.println("Expecting empty strings for make, model, zero for year.");
		Car car1 = new Car();
		car1.printProperties();
		System.out.println(); // line to separate tests
		System.out.println("Test overloaded constructor and printProperties() method");
		System.out.println("Expecting MyMake, MyModel, and 2000 for make, model, year");
		Car car2 = new Car("MyMake","MyModel",2000);
		car2.printProperties();
		System.out.println(); // line to separate tests
		System.out.println("Test setMake() and getMake()");
		Car car3 = new Car();
		System.out.println("Make should be: Car 3 Make");
		car3.setMake("Car 3 Make");
		System.out.println("make is: " + car3.getMake());
		System.out.println(); // line to separate tests
		System.out.println("Test setModel() and getModel()");
		Car car4 = new Car();
		System.out.println("Model should be: Car 4 Model");
		car4.setModel("Car 4 Model");
		System.out.println("model is: " + car4.getModel());
		System.out.println(); // line to separate tests
		System.out.println("Test setYear() and getYear()");
		Car car5 = new Car();
		System.out.println("Year should be: 2020, for car 5");
		car5.setYear(2020);
		System.out.println("car 5 year is: " + car5.getYear());
		System.out.println(); // line to separate tests
	}
}
