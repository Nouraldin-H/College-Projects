package w23assignment2;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests/Demonstrates the Clock class.
 * @author Nouraldin Hassan
 */
public class ClockDemo
{
	/** This main method tests the Clock class, the hours, minutes, and full time in this case.
	  * CODE ISSUES: <ul> <li>
	  * You can only receive the time zone information of your current location.
	  * </ul>
	 * @param args the string arguments for the main method.
	 */
   public static void main(String[] args)
   {
      //test Clock
      System.out.println("Testing Clock class");
      Clock clock = new Clock();
      System.out.println("Hours: " + clock.getHours());
      System.out.println("Minutes: " + clock.getMinutes());
      System.out.println("Time: " + clock.getTime());
      System.out.println("[Debug] Hour with Time: " + clock.getHoursWithTime());
      System.out.println("[Debug] Minute with Time: " + clock.getMinutesWithTime());
   }
   
   /**
 * Tests the Clock and WorldClock classes via JUnit.
 * CODE ISSUES: <ul> <li> The test fails despite both times being the same, because of different string values. </ul>
 */
public @Test void ClockTestCase() {
	   Clock clock1 = new Clock();
	   WorldClock wclock1 = new WorldClock(-4);
	   assertEquals(clock1,wclock1);
	   System.out.println("assertEquals test completed");
   }
}
