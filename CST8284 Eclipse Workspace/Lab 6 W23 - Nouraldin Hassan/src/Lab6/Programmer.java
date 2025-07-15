package Lab6;

/** This abstract class implements the Payme Interface for initial declaration for different types of programmers.
 * @author Nouraldin Hassan
 */
public abstract class Programmer implements Payme {
/**The first name of the programmer*/
	private String firstName;
/**The last name of the programmer*/
	private String lastName;
/**The social security number of the programmer*/
	private String socialSecurityNumber;

	/** This constructor is used for assigning the basic values and information of the programmer for later extension on other subclasses.
	 * @param first the first name
	 * @param last the last name
	 * @param ssn the social security number
	 */
	public Programmer(String first, String last, String ssn) {
		firstName = first;
		lastName = last;
		socialSecurityNumber = ssn;
	}

	/** gets the first name of the programmer
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}
	/** sets the first name of the programmer
	 * @param firstName the first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/** gets the last name of the programmer
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}
	/** sets the last name of the programmer
	 * @param lastName the last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/** gets the social security number of the programmer
	 * @return the social security number
	 */
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	/** sets the social security number of the programmer
	 * @param socialSecurityNumber the last name
	 */
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	/** formats the string from this class to match the required output of information with full name and SSN.
	 * @return the string representation of the first name, last name, and SSN methods
	 */
	@Override
	public String toString() {
		return String.format("%s %s\n%s: %s\n%s: %s", getFirstName(), getLastName(), getSocialSecurityNumber());
	} 
// Below methods are already documented in the interface
	public abstract double getPaymentAmount();
	public abstract double getDeductions();

} 


