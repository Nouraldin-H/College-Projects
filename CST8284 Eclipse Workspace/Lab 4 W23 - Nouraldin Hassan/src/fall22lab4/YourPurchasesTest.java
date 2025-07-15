package fall22lab4;
/*
 * Assessment: Lab Exercise 4
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Dave Houtman, Sandra Iroakazi
 * Lab Section Number: 300/301
 * Due Date: Feb 24, 2023
 * Description: 
 */
import org.junit.Test;
import org.junit.Assert;

/** This class quite literally tests the purchases that you have made, in the case of `twoPurchases()`.
 * You would use the money and have it counted at the register, and excess cash is returned to you if needed.
 * @see #twoPurchases()
 * @author Nouraldin Hassan
 */
public class YourPurchasesTest
{
   private static final double EPSILON = 1E-12;

   /**
	 * Tests the method `giveChange` as part of the variable `register`. <br>
	 * NOTE: when debugging, payment and purchase will be re-initialized to 0 from the method `giveChange()`,
	 * which is why it is hard to catch on to what makes the test succeed. <br>
	 * CODE ISSUES: <ul><li> Setting expected to negative value makes the test fail.
	 * </ul> @see {@link fall22lab4.YourPurchases#giveChange()}
	 */
   public @Test void twoPurchases()
   {
      YourPurchases register = new YourPurchases();
      register.recordPurchase(0.75);
      register.recordPurchase(1.50);
      register.receivePayment(2, 0, 5, 0, 0);
      double expected = 0.25; // value is the difference between recordPurchase() and receivePayment(), or 2.25 - 2.5 to absolute value.
      Assert.assertEquals(expected, register.giveChange(), EPSILON);
    }
   
  // There was no error upon initial testing, and therefore no changes are required here. Everything works as expected.
     
   }

