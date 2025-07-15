package car;
/*
 * Author: Stanley Pieda
 * Date: Sept 13, 2020
 * Description: Demonstration of importance of testing class to detect bugs.
 * Hint: look at the getModel() method carefully.
 */
/*
 * Class car models a car, with make, model, and year.
 */
public class Car {
	private String make;
	private String model;
	private int year;
	/*
	 * Default constructor, sets make to "", model to "", year to 0
	 */
	public Car() {
		this("","",0);
	}
	/*
	 * Overloaded constructor, sets make, model and year based on parameter list
	 */
	public Car(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}
	/*
	 * accessor for make
	 */
	public String getMake() {
		return make;
	}
	/*
	 * mutator for make
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/*
	 * accessor for model
	 */
	public String getModel() {
		return make;
	}
	/*
	 * mutator for model
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/*
	 * accessor for year
	 */
	public int getYear() {
		return year;
	}
	/*
	 * mutator for year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/*
	 * work method that prints out each property value to console,
	 * with labels.
	 */
	public void printProperties() {
		System.out.println("Make: " + make);
		System.out.println("Model: " + model);
		System.out.println("Year: " + year);
	}
}
/*
 * Author: Stanley Pieda
 * Date: Sept 13, 2020
 * Description: Demonstration of importance of testing class to detect bugs.
 * Hint: look at the getModel() method carefully.
 */
/*
 * Class that launches the program, contains method main.
 */
