package testJUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.Assert.*; commented out because it is unused, but kept for reference
import org.junit.Test;

/**
 * This class, named TestPerson, contains code utilized for JUnit to
 * test for getting and setting first name. <br>
 * CODE ISSUES: <ul><li> the strings tested literally say "first" and "last" instead of the actual names of people.
 * </ul> @author Nouraldin Hassan
 */
public class TestPerson {
	// The code block below this code line was written for reference and for testing purposes from scratch.
	/*@Test
	public void testGetFullName() {
		Person test = new Person();
		String resultfirst = test.getFirstName();
		test.setFirstName("fname");
		assertEquals("Testing for first name", test, resultfirst);
	}*/
	/**
	 * This method tests for the first and last name, and checks to see if
	 * the internal methods result in the same data value.
	 * <br> Should the setters and expected full name match, the test will succeed.
	 */
	@Test
	public void testGetFullName() {
	// set up the test
	Person person = new Person();
	person.setFirstName("first");
	person.setLastName("last");
	// expected value or result
	final String expectedFullName = "first" + "last"; // Fixed space, now concatenates.
	String actualFullName = person.getFullName(); // Initializes actualFullName to FullName getter
	assertEquals(expectedFullName, actualFullName, "getFirstName() return value does not match expectations");
	// tear down resources i.e. make avail for Garbage Collector
	person = null;
	}
}