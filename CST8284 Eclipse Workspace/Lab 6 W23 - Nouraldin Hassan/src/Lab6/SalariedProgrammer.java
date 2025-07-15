package Lab6;

/** This class gathers weekly salary information of a programmer.
 * @author Nouraldin Hassan
 */
public class SalariedProgrammer extends Programmer  {
	/**The programmer's weekly salary*/
	private double weeklySalary;

	/** This constructor passes full name, SSN, month, year, and weekly salary of the programmer.
	 * full name and SSN is gathered from the superclass.
	 * @param firstName the first name of the programmer
	 * @param lastName the last name of the programmer
	 * @param socialSecurityNumber the SSN of the programmer
	 * @param month the month of the programmer
	 * @param year the year of the programmer
	 * @param weeklySalary the weekly salary of the programmer
	 * @exception IllegalArgumentException Weekly salary must be >= 0.0
	 */
	public SalariedProgrammer(String firstName, String lastName, String socialSecurityNumber, int month, int year, double weeklySalary) {
		super(firstName, lastName, socialSecurityNumber); 

		if (weeklySalary < 0.0) {
			throw new IllegalArgumentException(
					"Weekly salary must be >= 0.0");
		}

		this.weeklySalary = weeklySalary;
	} 

	/** sets the weekly salary of the programmer
	 * @param weeklySalary the weekly salary
	 */
	public void setWeeklySalary(double weeklySalary) {
		if (weeklySalary < 0.0) {
			throw new IllegalArgumentException(
					"Weekly salary must be >= 0.0");
		}

		this.weeklySalary = weeklySalary;
	} 

	/** gets the weekly salary of the programmer
	 * @return the weekly salary
	 */
	public double getWeeklySalary() {
		return weeklySalary;
	} 

	//calculate earnings; override abstract method earnings in Programmer
	/**
	 * gets the payment due or earnings of the Programmer.
	 * @return the payment due, or the weekly salary in this case
	 */
	@Override                                                           
	public double getPaymentAmount() {    // CHANGED FROM earnings()
		return getWeeklySalary();                                        
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
	 * @return the string representation of the first name, last name, SSN, Weekly Salary, Payment Amount, and Deductions/Income Tax methods.
	 */
	@Override      
	public String toString() {
		return String.format("Salaried Programmer: %s %s\nSocial Security Number: %s \nWeekly Salary: %.2f\nPayment Due: %.2f\nIncome Tax: %.2f\n", getFirstName(), getLastName(), getSocialSecurityNumber(), getWeeklySalary(), getPaymentAmount(), getDeductions());
	}

}

