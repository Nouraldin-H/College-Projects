package Lab6;

/** This class gathers wage and hours information of a programmer.
 * @author Nouraldin Hassan
 */
public class HourlyProgrammer extends Programmer {
	/**the programmer's wage per hour*/
	private double wage;
	/**the programmer's hours worked for a week*/
	private double hours;

	/** This constructor passes full name, SSN, month, year, wage, and hours of the programmer.
	 * full name and SSN is gathered from the superclass.
	 * @param firstName the first name of the programmer
	 * @param lastName the last name of the programmer
	 * @param socialSecurityNumber the SSN of the programmer
	 * @param month the month of the programmer
	 * @param year the year of the programmer
	 * @param wage the wage per hour of the programmer
	 * @param hours the work hours per week of the programmer
	 * @exception IllegalArgumentException Hourly wage must be >= 0.0
	 * @exception IllegalArgumentException Hours worked must be >= 0.0 and {@literal <}= 168.0
	 */
	public HourlyProgrammer(String firstName, String lastName, String socialSecurityNumber, int month, int year, double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber);

		if (wage < 0.0) { // validate wage
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		}

		if ((hours < 0.0) || (hours > 168.0)) { // validate hours
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
		}

		this.wage = wage;
		this.hours = hours;
	} 

	/** sets the wage of the programmer
	 * @param wage the wage
	 */
	public void setWage(double wage) {
		if (wage < 0.0) { // validate wage
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		}

		this.wage = wage;
	} 

	/** gets the wage of the programmer
	 * @return the wage
	 */
	public double getWage() {
		return wage;
	} 

	/** sets the work hours of the programmer
	 * @param hours the hours
	 */
	public void setHours(double hours) {
		if ((hours < 0.0) || (hours > 168.0)) { // validate hours
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
		}

		this.hours = hours;
	} 

	/** gets the work hours of the programmer
	 * @return the hours
	 */
	public double getHours() {
		return hours;
	} 

	//calculate earnings; override abstract method earnings in Programmer
	/**
	 * gets the payment due or earnings of the Programmer.
	 * @return the payment due, or the wage * work hours in this case if work hours {@literal <}= 40.
	 * <br> returns 40 * wage + (hours - 40) * wage * 1.5 otherwise
	 */
	@Override
	public double getPaymentAmount() {   // CHANGED FROM earnings()
		if (getHours() <= 40) { // no overtime                           
			return getWage() * getHours();   
		}
		else {                                                             
			return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
		}
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
	 * @return the string representation of the first name, last name, SSN, Hourly Wage, Hours Worked, Payment Amount, and Deductions methods.
	 */
	@Override      
	public String toString() {
		return String.format("Hourly Programmer: %s %s\nSocial Security Number: %s \nHourly Wage: %.2f; Hours Worked: %.2f\nPayment Due: %.2f\nIncome Tax: %.2f\n", getFirstName(), getLastName(), getSocialSecurityNumber(), getWage(), getHours(), getPaymentAmount(), getDeductions());
	}

}

