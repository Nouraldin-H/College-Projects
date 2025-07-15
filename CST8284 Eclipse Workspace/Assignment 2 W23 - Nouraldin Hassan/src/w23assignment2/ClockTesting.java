package w23assignment2;

/** Tests all clock classes.
 * @author Nouraldin Hassan
 *
 */
public class ClockTesting {

	/** This main method tests all of the clock classes
	  * All assigned variables are declared in a Clock array variable and printed in a loop.
	 * @param args the string arguments for the main method.
	 */
	public static void main(String[] args)
	{
		Clock clock1 = new Clock();
		WorldClock worldclock1 = new WorldClock(3);
		AlarmClock alarmclock1 = new AlarmClock(5, 30);

		Clock[] allclocks = {clock1, worldclock1, alarmclock1};

		for (int h = 0; h < 3; h++) {
			System.out.println(allclocks[h].toString());
		}
	}
}
