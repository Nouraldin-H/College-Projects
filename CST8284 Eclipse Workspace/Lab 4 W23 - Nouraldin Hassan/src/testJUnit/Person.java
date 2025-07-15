package testJUnit;

/**
 * This class, named Person, serves as a getter/setter initalizer class for use with TestPerson.
 * @see TestPerson
 * @author Nouraldin Hassan
 */
public class Person {
	private String firstName;
	private String lastName;
	/**
	 * Returns the first name for this Person.
	 * @return the first name for this Person.
	 */
	public String getFirstName() {
	return firstName;
	}
	/**
	 * Sets the first name for this Person.
	 * @param firstName to set for this Person.
	 */
	public void setFirstName(String firstName) {
	this.firstName = firstName;
	}
	/**
	 * Returns the last name for this Person.
	 * @return the last name for this Person.
	 */
	public String getLastName() {
	return lastName;
	}
	/**
	 * Sets the last name for this Person.
	 * @param lastName to set for this Person.
	 */
	public void setLastName(String lastName) {
	this.lastName = lastName;
	}
	/**
	 * Returns the full name for this Person.
	 * @return the first and last name for this Person.
	 */
	public String getFullName() {
	return firstName + lastName;
	}
}
