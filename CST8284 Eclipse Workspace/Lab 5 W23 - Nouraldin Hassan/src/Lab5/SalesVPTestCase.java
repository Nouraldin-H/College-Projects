package Lab5;
import static org.junit.Assert.*;

import org.junit.Test;

/** This class shows a Sales Vice President undergoing a JUnit test case.
 * @author Nouraldin Hassan
 *
 */
public class SalesVPTestCase {

	/** Tests SalesVP stocks with itself.
	 * Uses assertEquals to compare two objects with different or same values.
	 */
	@Test
	public void testAssertEquals(){
	   SalesVP vp1 = new SalesVP("Zhang", 23, "Ottawa", "Sales", 27000); // NOTE: Parsing an int of the same value from numberical only string works.
	   SalesVP vp2 = new SalesVP("Zhang", 23, "Ottawa", "Sales", 28000);
	   assertEquals(vp1,vp2);
	   System.out.println("assertEquals test completed");
	}

}
