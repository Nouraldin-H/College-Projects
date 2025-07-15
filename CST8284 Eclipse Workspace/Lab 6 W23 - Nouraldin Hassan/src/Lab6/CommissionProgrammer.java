package Lab6;

/** This class gathers gross sales and commission rate information of a programmer.
 * @author Nouraldin Hassan
 */
public class CommissionProgrammer extends Programmer { 
	/**the programmer's gross weekly sales*/
	private double grossSales;
	/**the programmer's commission rate percentage*/
	private double commissionRate;

	/** This constructor passes full name, SSN, month, year, gross sales, and commission rate of the programmer.
	 * full name and SSN is gathered from the superclass.
	 * @param firstName the first name of the programmer
	 * @param lastName the last name of the programmer
	 * @param socialSecurityNumber the SSN of the programmer
	 * @param month the month of the programmer
	 * @param year the year of the programmer
	 * @param grossSales the gross weekly sales per hour of the programmer
	 * @param commissionRate the commission rate percentage of the programmer
	 * @exception IllegalArgumentException Commission rate must be > 0.0 and {@literal <} 1.0
	 * @exception IllegalArgumentException Gross sales must be >= 0.0
	 */
	public CommissionProgrammer(String firstName, String lastName, String socialSecurityNumber, int month, int year, double grossSales, double commissionRate) {
		super(firstName, lastName, socialSecurityNumber);

		if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate 
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}

		if (grossSales < 0.0) { // validate
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}

		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	} 

	/** sets the gross sales amount of the programmer, in the case of the creaton of apps.
	 * @param grossSales the gross sales
	 */
	public void setGrossSales(double grossSales) {
		if (grossSales < 0.0) { // validate
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}

		this.grossSales = grossSales;
	} 

	/** gets the gross sales amount of the programmer, in the case of the creaton of apps.
	 * @return the gross sales amount
	 */
	public double getGrossSales() {
		return grossSales;
	} 

	/** sets the commission rate of the programmer.
	 * @param commissionRate the commissison rate
	 */
	public void setCommissionRate(double commissionRate) {
		if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate
			throw new IllegalArgumentException(
					"Commission rate must be > 0.0 and < 1.0");
		}

		this.commissionRate = commissionRate;
	} 

	/** gets the commission rate of the programmer.
	 * @return the commission rate
	 */
	public double getCommissionRate() {
		return commissionRate;
	} 

	//calculate earnings; override abstract method earnings in Programmer.
	/**
	 * gets the payment due or earnings of the Programmer.
	 * @return the payment due, or the commission rate * gross sales in this case.
	 */
	@Override                                                           
	public double getPaymentAmount() {   // CHANGED FROM earnings()
		return getCommissionRate() * getGrossSales();                    
	}
	/**
	 * gets the deductions or loss of the Programmer
	 * @return the deductions, or the payment amount * 0.3 in this case
	 */
	@Override
	public double getDeductions() {
		return getPaymentAmount() * 0.3;
	}
	
	/**
	 * This method overrides the existing toString method in {@link Programmer}
	 * formats the string from this class to match the required output of information with full name and SSN among other information.
	 * @see Programmer#toString()
	 * @return the string representation of the first name, last name, SSN, Gross Sales, Commission Rate, Payment Amount, and Deductions methods.
	 */
	@Override      
	public String toString() {
		return String.format("Commission Programmer: %s %s\nSocial Security Number: %s \nGross Sales: %.2f; Commission Rate: %.2f\nPayment Due: %.2f\nIncome Tax: %.2f\n", getFirstName(), getLastName(), getSocialSecurityNumber(), getGrossSales(), getCommissionRate(), getPaymentAmount(), getDeductions());
	}  

}

