package w23assignment2;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/** This class inherits Clock and overrides Clock itself to provide examples of regional clocks.
 * NOTE: UTC is disregarded for that matter, local timezone (EST-4) will act as UTC-0.
 * @author Nouraldin Hassan
 */
public class WorldClock extends Clock {
	/**The time zone offset (such as UTC-3 where -3 is the offset)*/
	int offset;
	/**
	 * @param offset the timezone offset, such as UTC-4 or UTC+1.
	 */
	public WorldClock(int offset) {
		super();
		this.offset = offset;
	}
	/**
	 * Checks the offset of the specified clock so the offset can work properly.
	 * This is needed for time zone determination so UTC+2 and UTC-4 is a 6-hour difference instead of a 0-hour difference.
	 * @return the withheld offset in either + or - depending on the offset declared in and for {@link WorldClockDemo}.
	 */
	private String offsetCheck() {
		String hold = "";
		if (offset >= 0) hold += "+" + offset;
		else hold += "" + offset;
		return hold;
	}
	/** Gets the specified time in hours and minutes
	 * @see Clock#getTime()
	 * @return hours and minutes in hh:mm format.
	 */
	public @Override String getTime() {
		return String.format("%s:%s", getHours(), getMinutes()); //LocalDateTime.ofInstant(Instant.now(), ZoneId.of("UTC" + offsetCheck())).toString();
	}
	/** Gets the specified hours for the time
	 * @see Clock#getHours()
	 * @return hours
	 */
	public @Override String getHours() {
		int time = Integer.parseInt(super.getHours());
		time += Integer.parseInt(offsetCheck());
		return String.format("%02d", time); //LocalDateTime.ofInstant(Instant.now(), ZoneId.of("UTC" + offsetCheck())).toString().substring(11, 13);
	}
	/** Gets the specified minutes for the time
	 * @see Clock#getMinutes()
	 * @return minutes
	 */
	public @Override String getMinutes() {
		int time = Integer.parseInt(super.getMinutes());
		return String.format("%02d", time); //LocalDateTime.ofInstant(Instant.now(), ZoneId.of("UTC" + offsetCheck())).toString().substring(14, 16);
	}
	
	public @Override String toString() {
		String worldClock = super.toString();
		
		return String.format("World Clock [super=%s, offset=%d, time=%s]", worldClock, offset, getTime());
	}
}
