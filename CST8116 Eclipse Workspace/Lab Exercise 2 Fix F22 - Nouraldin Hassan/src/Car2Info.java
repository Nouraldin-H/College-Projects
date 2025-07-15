
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
public class Car2Info {
	private String vin; // Don't actually leave class-level variables like this
	private double mileage; // and don't leave that
	private double invoiceprice; // and that too. Have them set to private with GetSets
	// default constructors. sets make and model to "" and year to 0
	// constructor must have the exact same name as the class name
	public Car2Info() {
		this("",0,0);
	}
	// overloaded constructors. sets make, model, and year based on parameter list
	
	public Car2Info(String vin, double mileage, double invoiceprice) {
		this.vin = vin;
		this.mileage = mileage;
		this.invoiceprice = invoiceprice;
	}
	// accessors and mutators (getters and setters)
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public double getInvoiceprice() {
		return invoiceprice;
	}

	public void setInvoiceprice(double invoiceprice) {
		this.invoiceprice = invoiceprice;
	}
	
	// work method that prints out each property value to console, with labels
	// see below for the work method
	
	public String toString() {
		String report;
		report = String.format("%s, %.1fkm, $%.2f ", vin, mileage, invoiceprice);
		/* Output should  format the mileage to 1 decimal place (%.1f) and the invoice to 2 decimal places (%.2f).
		 * Each value is separated with a comma and are in order. First 3 formats correspond to the last 3 fields.
		 * ($%.2f) means that the value will have $ preceded and .2f is after.
		 * %.1fkm means that floating point value will be applied to the actual value and km will be followed (e.g. 800.00km)
		*/
		// report = String.format("VIN: " + "+vin+", "Mileage (km): " + "+mileage+", "Invoice Price: " + "+invoiceprice+"); is a pseudocode type line
		return report;
	}
	
}
