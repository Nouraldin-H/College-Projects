package Lab6;

/** This class gathers base salary information of a Commission Programmer.
 * @author Nouraldin Hassan
 */
public class BasePlusCommissionProgrammer extends CommissionProgrammer { 
	/**The programmer's base salary per week*/
	private double baseSalary;

	/** This constructor passes full name, SSN, month, year, gross sales, commission rate, and base salary of the programmer.
	 * full name and SSN is gathered from the superclass.
	 * @param firstName the first name of the programmer
	 * @param lastName the last name of the programmer
	 * @param socialSecurityNumber the SSN of the programmer
	 * @param month the month of the programmer
	 * @param year the year of the programmer
	 * @param grossSales the gross weekly sales per hour of the programmer
	 * @param commissionRate the commission rate percentage of the programmer
	 * @param baseSalary the base salary of the programmer
	 * @exception IllegalArgumentException Base salary must be >= 0.0
	 */
	public BasePlusCommissionProgrammer(String firstName, String lastName, String socialSecurityNumber, int month, int year, double grossSales, double commissionRate, double baseSalary) {
		super(firstName, lastName, socialSecurityNumber, month, year, grossSales, commissionRate);

		if (baseSalary < 0.0) { // validate baseSalary                  
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;
	}

	/** sets the base salary amount of the programmer.
	 * @param baseSalary the base salary
	 */
	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0) { // validate baseSalary                  
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;                
	} 
	/** gets the base salary amount of the programmer.
	 * @return the base salary
	 */
	//return base salary
	public double getBaseSalary() {
		return baseSalary;
	}

	//calculate earnings; override method earnings in CommissionProgrammer
	/**
	 * gets the payment due or earnings of the Programmer.
	 * @return the payment due, or the base salary * superclass payment due in this case.
	 */
	@Override                                                            
	public double getPaymentAmount() {     // CHANGED FROM earnings()
		return getBaseSalary() + super.getPaymentAmount();                        
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
	 * This method overrides the existing toString method in {@link CommissionProgrammer}
	 * formats the string from this class to match the required output of information with full name and SSN among other information.
	 * @see Programmer#toString()
	 * @return the string representation of the first name, last name, SSN, Gross Sales, Commission Rate, Base Salary, and Deductions methods.
	 */
	@Override      
	public String toString() {
		return String.format("Base-Plus Commission Programmer: %s %s\nSocial Security Number: %s \nGross Sales: %.2f; Commission Rate: %.2f; Base Salary: %.2f\nIncome Tax: %.2f\n", getFirstName(), getLastName(), getSocialSecurityNumber(), getGrossSales(), getCommissionRate(), getBaseSalary(), getDeductions());
	}

}



