package w23assignment2;

/**
 * Tests/Demonstrates the WorldClock Class.
 * @author Nouraldin Hassan
 */
public class WorldClockDemo
{
 /** This main method tests the WorldClock class, the time zone offset in this case.
  * CODE ISSUES: <ul> <li>
  * You cannot use floats or doubles for timezones that use 30 minute time differences.
  * <li> You are able to enter any offset you want, even though you are not supposed to.
  * <li> High values of offsets can make the time negative and/or beyond 24 hours and 60 minutes.
  * </ul>
 * @param args the string arguments for the main method.
 */
public static void main(String[] args)
   {
      //test WorldClock
      System.out.println("");
      System.out.println("Testing WorldClock class");
      int offset = -4;
      System.out.println("Offset: " + offset);
      WorldClock wclock = new WorldClock(offset);
      Clock clock = new Clock();
      System.out.println("Hours: " + wclock.getHours());
      System.out.println("Minutes: " + wclock.getMinutes());
      System.out.println("Time: " + wclock.getTime());
      System.out.println("Default Time: " + clock.getHoursAndMinutes());
   }
}
