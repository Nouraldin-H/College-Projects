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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Nouraldin Hassan
 * This class quite literally tests the purchases that you have made, in the case of testing and comparing purchases. <br>
 * To test individual purchases methods, comment out all methods except for the method you want to test using JUnit
 * @see #TestComparePurchases1()
 */
public class YourPurchasesTest3 {
	
	   /**
		 * Tests the method `giveChange` as part of the variable `register`. <br>
		 * NOTE: when debugging, payment and purchase will be re-initialized to 0 from the method `giveChange()`,
		 * which is why it is hard to catch on to what makes the test succeed. <br>
		 * CODE ISSUES: <ul><li> Setting expected to negative value makes the test fail.
		 * </ul> @see {@link fall22lab4.YourPurchases#giveChange()}
		 */
	   public @Test void TestComparePurchases1()
	   {
	      YourPurchases PurchaseA = new YourPurchases();
	      YourPurchases PurchaseB = new YourPurchases();
	      PurchaseA.receivePayment(0, 0, 1, 0, 0);
	      PurchaseB.receivePayment(0, 0, 0, 1, 5);
	      double expected = 0.10; // value is the difference between recordPurchase() and receivePayment(), or 2.25 - 2.5 to absolute value.
	      /** assertEquals Test doesn't work, because expected value is 0.1 but object comparing only yeilds a true or false */
	      Assert.assertEquals(expected, PurchaseA.getPayment() == PurchaseB.getPayment());
	    }
	   
	 /**
	 * @see #TestComparePurchases1()
	 */
	public @Test void TestComparePurchases2()
	   {
	      YourPurchases PurchaseA = new YourPurchases();
	      YourPurchases PurchaseB = new YourPurchases();
	      PurchaseA.receivePayment(0, 0, 7, 0, 0);
	      PurchaseB.receivePayment(0, 0, 6, 1, 5);
	      double expected = 0.70; // value is the difference between recordPurchase() and receivePayment(), or 2.25 - 2.5 to absolute value.
	      /** assertEquals Test doesn't work, because expected value is 0.1 but object comparing only yeilds a true or false */
	      Assert.assertEquals(expected, PurchaseA.getPayment() == PurchaseB.getPayment());
	    }
	
// BELOW IS KEPT FOR REFERENCE, BECAUSE I DON'T KNOW WHAT TO DO WITH THEM, AND NO INSTRUCTION WAS PROVIDED FOR THOSE METHODS SPECIFICALLY
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	@Test
//	public void test() {
//		fail("Not yet implemented"); // TODO
//	}

}
