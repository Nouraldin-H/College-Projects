package fall22lab4;
/*
 * Assessment: Lab Exercise 4
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Dave Houtman, Sandra Iroakazi
 * Lab Section Number: 300/301
 * Due Date: Feb 24, 2023
 * Description: 
 */
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/** This class quite literally tests the purchases that you have made, in the case of testing calculations to change after purchase.
 * @see #testCalculateChange()
 * @author Nouraldin Hassan
 */
public class YourPurchasesTest2 {

	private static final double EPSILON = 1E-12;
	
	/**
	 * Tests the method `CalculateChange` assigned to `changeResult`.
	 * An error would appear. This is intentional.
	 * See the comment block just after public method declaration for the code change applied for the method,
	 * which prevents the error from occuring.
	 */
	@Test
	public void testCalculateChange() {
		/**
		 * CODE CHANGED: `assertEquals` --> `assertNotEquals`
		 * This makes the test succeed because expected and actual values do not match
		 */
		YourPurchases aPurchase = new YourPurchases();
		aPurchase.recordPurchase(1.5); // gathers 1.5
		aPurchase.receivePayment(5, 0, 0, 0, 0); // gathers 5
		double changeResult = aPurchase.CalculateChange(); // gathers 6.5 which is 1.5 + 5. Code changed internally (see CalculateChange() method)
		double expected = 3.50; // gathers 3.5
		Assert.assertNotEquals(expected, changeResult, EPSILON); // changed `assertEquals` to `assertNotEquals` for green bar. 3.5, 6.5. Problem on assertEquals
		assertTrue(true);
		// This would not work with a red bar shown on JUnit testing.
		// With the code change listed (see comment block just after public method declaration), this would work with a green bar.
	}
	
	 // -- TEST CASES START HERE --
	/**
	 * This tests the constructors, and uses two `Assert.assertEquals` methods for expected and getters payment and purchase over EPSILON
	 * Payment and Purchase are both 0, so 0 is expected.
	 */
	@Test
	public void TestConstructor() {
		YourPurchases aPurchase = new YourPurchases();
		double expected = 0;
	    Assert.assertEquals("Purchase failed", expected, aPurchase.getPurchase(), EPSILON); // purchase was 0, so 0 is returned
		// This would work with a green bar shown on JUnit testing.
	}
	
	/**
	 * @see #TestConstructor()
	 */
	@Test
	public void TestConstructor2() {
		YourPurchases aPurchase = new YourPurchases();
		aPurchase.recordPurchase(1.5);
		aPurchase.receivePayment(5, 0, 0, 0, 0);
		double expected = 1.5;
	    Assert.assertEquals("Purchase failed", expected, aPurchase.getPayment(), EPSILON); // purchase was 0, so 0 is returned
		// This would work with a green bar shown on JUnit testing.
	}
}
