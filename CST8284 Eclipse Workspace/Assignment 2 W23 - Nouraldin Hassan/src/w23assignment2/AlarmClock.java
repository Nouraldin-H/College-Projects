package w23assignment2;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/** This class inherits Clock and overrides Clock itself to provide examples of pre-defined alarm clocks.
 * NOTE: This will only gather pre-defined time.
 * @author Nouraldin Hassan
 */
public class AlarmClock extends Clock {
	/**The pre-defined hours*/
	int hours;
	/**The pre-defined minutes*/
	int minutes;
	/**The pre-defined overminutes.
	 * @see #convertMinutesToHours()*/
	int overminutes;
	/**
	 * @param hours the hours of the alarm clock
	 * @param minutes the minutes of the alarm clock
	 */
	public AlarmClock(int hours, int minutes) {
		super();
		setAlarm(hours, minutes);
		hours += convertMinutesToHours(); //adds the conversion if needed, say if minutes is 61 on testing
	}
	/** Gets the alarm set from hours and minutes.
	 * NOTE: same function as {@link WorldClock#getTime()}
	 * @return hours and minutes in hh:mm format.
	 */
	public String getAlarm() {
		return String.format("%s:%s", hours, minutes);
	}
	/** Sets the alarm to a pre-defined value.
	 * @param hours the hours of the alarm clock
	 * @param minutes the minutes of the alarm clock
	 */
	public void setAlarm(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}
	/** Converts minutes above 60 to an hour, followed by extra minutes (120 minutes to 1 hour and 30 minutes)
	 * @return the converted minutes
	 */
	public int convertMinutesToHours() {
		if (minutes == 60) {
			minutes -= 60;
			hours += 1;
		}
		else if (minutes > 60) {
			hours += minutes / 60;
			overminutes = minutes % 60; //minutes - 60;
			minutes = overminutes;
		}
		return minutes;
	}
	/** Gets the specified time in hours and minutes for the alarm clock.
	 * Also supplies function to the alarm clock.
	 * @see Clock#getTime()
	 * @return hours and minutes in hh:mm format, and extra text if needed to indicate alarm cleared as a result of time reached or exceeded
	 */
	public @Override String getTime() {
		String currentHours = getHours();
		String currentMinutes = getMinutes();
		String givenTime = getAlarm();
		int parsedCurrentHours = Integer.parseInt(currentHours);
		int parsedCurrentMinutes = Integer.parseInt(currentMinutes);
		if (hours < parsedCurrentHours || (hours <= parsedCurrentHours && minutes <= parsedCurrentMinutes)) {
			setAlarm(0, 0);
			return givenTime + " Alarm" + " Cleared";
		}
		return givenTime;
	}
	
	public @Override String toString() {
		String alarmclock = super.toString();
		
		return String.format("Alarm Clock [super=%s, hours=%d, minutes=%d, time=%s]", alarmclock, hours, minutes, getTime());
	}
}
