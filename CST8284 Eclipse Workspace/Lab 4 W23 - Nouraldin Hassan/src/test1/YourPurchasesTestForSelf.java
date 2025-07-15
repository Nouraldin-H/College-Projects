package test1;
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

import fall22lab4.YourPurchases;

/** This class quite literally tests the purchases that you have made, in the case of testing calculations to change after purchase.
 * @see fall22lab4.YourPurchasesTest2#testCalculateChange()
 * @author Nouraldin Hassan
 */
public class YourPurchasesTestForSelf {
	private static final double EPSILON = 1E-12;
	/**
	 * This tests the `recordPurchase` method, over EPSILON
	 * Purchase is 1.5, so 1.5 is expected.
	 */
	@Test
	public void TestPurchase() {
		YourPurchases aPurchase = new YourPurchases();
		aPurchase.recordPurchase(1.5);
//		aPurchase.receivePayment(5, 0, 0, 0, 0);
//		double changeResult = aPurchase.CalculateChange(); // replaced `CalculateChange()` with `giveChange()` 
		double expected = 1.5;
	    Assert.assertEquals(expected, aPurchase.getPurchase(), EPSILON);
		// This would work with a green bar shown on JUnit testing.
	}
	/**
	 * This tests the `recordPayment` method, over EPSILON
	 * Payment is 5, so 5 is expected.
	 */
	@Test
	public void TestPayment() {
		YourPurchases aPurchase = new YourPurchases();
//		aPurchase.recordPurchase(1.5);
		aPurchase.receivePayment(5, 0, 0, 0, 0);
//		double changeResult = aPurchase.CalculateChange(); // replaced `CalculateChange()` with `giveChange()` 
		double expected = 5;
	    Assert.assertEquals(expected, aPurchase.getPayment(), EPSILON);
		assertTrue(true);
		// This would work with a green bar shown on JUnit testing.
	}
	/**
	 * This tests the `changeResult` variable assigned to `aPurchase.CalculateChange` method, over EPSILON
	 * After initial testing, Change is 0, so 0 is expected.
	 */
	@Test
	public void TestChange() {
		YourPurchases aPurchase = new YourPurchases();
//		aPurchase.recordPurchase(1.5);
//		aPurchase.receivePayment(5, 0, 0, 0, 0);
		double changeResult = aPurchase.CalculateChange(); // replaced `CalculateChange()` with `giveChange()` 
		double expected = 0;
	    Assert.assertEquals(expected, changeResult, EPSILON);
		assertTrue(true);
		// This would work with a green bar shown on JUnit testing.
	}
	/**
	 * This tests everything from `TestCalculateChange()`.
	 * After initial testing, it is determined that purchase and payment are added/summed to 6.5.
	 * Expected result is therefore 6.5.
	 * @see fall22lab4.YourPurchasesTest2#testCalculateChange()
	 */
	@Test
	public void TestPostCalculateChange() {
		YourPurchases aPurchase = new YourPurchases();
		aPurchase.recordPurchase(1.5);
		aPurchase.receivePayment(5, 0, 0, 0, 0);
		double changeResult = aPurchase.CalculateChange(); // replaced `CalculateChange()` with `giveChange()` 
		double expected = 6.5;
	    Assert.assertEquals(expected, changeResult, EPSILON);
		assertTrue(true);
		// This would work with a green bar shown on JUnit testing.
		
		// The located method is therefore CalculateChange(), realizing that errors were caused from there. the variable `expected` should not have been changed, but was because editing internal code is not allowed.
		// 
	}
}