package task1;
/*
 * Assessment: Lab Exercise 2.1-B - 2022-09-23 - Task 1: Problem Solving
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 330/331
 * Due Date: September 30, 11:59 PM
 * Created: September 23
 * Modified: September 29
 * Description: Lab Exercise 2, Task 1 File
*/
public class CarInfo {
	private String make;
	private String model;
	private int year;
	// default constructors. sets make and model to "" and year to 0
	// constructor must have the exact same name as the class name
	public CarInfo() {
		this("","",0);
	}
	int vin; // Don't actually leave class-level variables like this
	private double mileage; // and don't leave that
	double invoiceprice; // and that too. Have them set to private with GetSets
	// overloaded constructors. sets make, model, and year based on parameter list
	
	public CarInfo(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}
	// accessors and mutators (getters and setters)
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	// work method that prints out each property value to console, with labels
	// see below for the work method
	public void printProperties() {
		System.out.println("Make: " + make);
		System.out.println("Model: " + model);
		System.out.println("Year: " + year);
	}
	public String toString() {
		String report;
		report = String.format("VIN: " + "+vin+", "Mileage (km): " + "+mileage+", "Invoice Price: " + "+invoiceprice+");
		return report;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
}
