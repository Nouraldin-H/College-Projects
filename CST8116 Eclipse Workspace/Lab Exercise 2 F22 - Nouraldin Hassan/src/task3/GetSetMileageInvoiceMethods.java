package task3;

import task1.Car2Info;
/*
 * Assessment: Lab Exercise 2.3 - 2022-09-29 - Task 3: Pseudocode
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 330/331
 * Due Date: September 16, 11:59 PM
 * Created: September 29
 * Modified: September 29
 * Description: Lab Exercise 2, Task 3 File
*/

/*
 * new pseudocode for Task 3:
 * 
 *  getInvoicePrice()
	return invoicePrice

	setInvoicePrice(num invoicePrice)
    	this.invoicePrice = invoicePrice
	return
	
	getMileage()
	return mileage

	setMileage(double mileage)
    	this.mileage = mileage
	return
	
	toString()
		declarations
			String report
		report = format vin + "," + mileage + "," + invoicePrice + "," // Mileage should be formatted to 1 decimal place, invoice price to 2 decimal places.
	return report
 */

public class GetSetMileageInvoiceMethods {
	// private double mileage; //since mileage was already assigned in task1

	public double getMileage() {
		return Car2Info.mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	public String toString() {
		String report;
		report = String.format("%s, %.1fkm, $%.2f ", vin, mileage, invoiceprice);
		return report;
	}

}
