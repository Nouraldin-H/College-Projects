package w23assignment2;

/**
 * Tests/Demonstrates the AlarmClock Class.
 * @author Nouraldin Hassan
 */
public class AlarmClockDemo {
	 /** This main method tests the AlarmClock class, the hours and minutes pre-defined by the alarm clock in this case.
	  * CODE ISSUES: <ul> <li>
	  * You cannot use floats or doubles for timezones that use 30 minute time differences.
	  * <li> You are able to enter any hour or minute value you want for AlarmClock, even though you are not supposed to.
	  * </ul>
	 * @param args the string arguments for the main method.
	 */
	public static void main(String[] args) {
		System.out.println("");
		System.out.println("Testing AlarmClock class");
		AlarmClock aclock = new AlarmClock(14, 55);
	    Clock clock = new Clock();
		System.out.println("Alarm Set: " + aclock.getAlarm());
		System.out.println("Hours: " + aclock.getHours());
		System.out.println("Minutes: " + aclock.getMinutes());
		System.out.println("Time: " + aclock.getTime());
		System.out.println("Alarm After: " + aclock.getAlarm());
	    System.out.println("Default Time: " + clock.getHoursAndMinutes());
	}
}
