package w23assignment2;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/** This class gathers the current time based on the time zone you are in.
 * @author Nouraldin Hassan
*/
public class Clock
{ 
	/** Gets the specified time based on time location with use of .toString().
	 * NOTE: Time is gathered as a string.
	 * @return full time, in this case of gathering system default or system set time.
	 */
	public String getTime() {
		return LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toString();
	}
	/** Gets the specified hour of the time based on time location with use of .toString() and .substring to gather approximate hour.
	 * NOTE: Time is gathered as a string.
	 * @return hour of the time, in this case of gathering system default or system set time.
	 */
	public String getHours() {
		return LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toString().substring(11, 13);
	}
	/** Gets the specified minute of the time based on time location with use of .toString() and .substring to gather approximate minute.
	 * NOTE: Time is gathered as a string.
	 * @return minute of the time, in this case of gathering system default or system set time.
	 */
	public String getMinutes() {
		return LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toString().substring(14, 16);
	}
	/** Gets the specified hour and minute of the time based on time location with use of .toString() and .substring to gather approximate hour and minute.
	 * NOTE: Time is gathered as a string.
	 * @return hour and of the time, in this case of gathering system default or system set time in hh:mm format via substring.
	 */
	public String getHoursAndMinutes() {
		return LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toString().substring(11, 16);
	}
	// BELOW IS FOR DEBUGGING PURPOSES
	/** Gets the specified hour of the time based on time location with use of .toString() and .substring to gather approximate hour.
	 * This also includes further information of time within the hour (that being hours, minutes and seconds).
	 * NOTE: Time is gathered as a string.
	 * @return hour of the time, in this case of gathering system default or system set time.
	 */
	public String getHoursWithTime() {
		return LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toString().substring(11, 19);
	}
	/** Gets the specified minute of the time based on time location with use of .toString() and .substring to gather approximate minute.
	 * This also includes further information of time within the minute (that being minutes and seconds).
	 * NOTE: Time is gathered as a string.
	 * @return minute of the time, in this case of gathering system default or system set time.
	 */
	public String getMinutesWithTime() {
		return LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toString().substring(14, 19);
	}
	/**
     * This method gathers the string representation of the object.
     * @return a string representation of the object, set by the defined string.
	 */
	public String toString()
	{  
		return String.format("Clock [time=%s]", getHoursAndMinutes());
	}
}
