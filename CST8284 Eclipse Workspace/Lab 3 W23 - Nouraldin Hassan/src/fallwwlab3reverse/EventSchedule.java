package fallwwlab3reverse;
import java.time.LocalDateTime;
import java.util.Calendar;

/* Q: Can reverse chaining be used to initialize the fields in the chain reliably and without unnecessary steps?
 * A: Yes. The chaining can be done either straightforward or in reverse, as shown in the lab.
 *    What needs to change is the order of overloaded constructors from the most parameters to the least parameters.
 *    This can be done from the way that `this()` is used, which would be to use `this(value1, value2)` in the constructor `MyConstruct(value1, value2, value3)` body.
 *    In other words, use `this()` and add all constructor parameters except for the last parameter.
 *    That will make the constructor display order show from least parameters to more parameters, shown in print.
 */
/**
 * This program depicts Overloaded constructor calls.
 * It shows the chaining of overloaded constructors using "this" keyword.
 * This lab has been completed for demo by: Nouraldin Hassan. 
 */

/**
 * This class is named EventSchedule Class. It shows constructor chaining using keyword "this".
 * In this code, the simpler constructors all call the more complex one, thereby
 * chaining the calls 'DOWNWARDS' (from the one with the most arguments to the
 * default constructor. Ensure that you implement it in this order). 
 * <p>
 * EventSchedule(int, int, int) just assigns the values.
 * <br>
 * EventSchedule(int, int) calls EventSchedule(int, int, int), program flow
 * returns to EventSchedule(int, int) and exits the constructor.
 * <br>
 * EventSchedule(int) calls EventSchedule(int, int, int), program flow returns
 * to EventSchedule(int) and exits the constructor.
 *  <p>
 * EventSchedule() calls EventSchedule(int, int, int), program flow returns to
 * EventSchedule() and exits the constructor.
 * <p>
 * NOTE: The constructors in this code have System.out.println(a message) in them,
 *       for demonstration purposes only. DO NOT PUT input / output
 *       into constructors in real production code!!!
 * 
 * @see TestDemo
 * @author Nouraldin Hassan
 */
public class EventSchedule {
LocalDateTime time = LocalDateTime.now();
//Calender datetime = Calendar;
	/**
	 * name component of the name for EventSchedule. Initialized to "unknown"
	 */
	private String regName = "unknown";
	/**
	 * year component of the date of the time for EventSchedule.
	 */
	private int year;
	
	/**
	 * month component of the date of the time for EventSchedule.
	 */
	private int month;
	
	/**
	 * day component of the date of the time for EventSchedule.
	 */
	private int day;
	
	/**This constructor sets the year as passed, month as passed,
	 * day as passed, and name as passed.
	 * <br> This constructor only accepts the order int, int, int, String.
	 * @param year The year for this EventSchedule.
	 * @param month The month for this EventSchedule.
	 * @param day The day for this EventSchedule.
	 * @param regName The name for this EventSchedule.
	 */
	public EventSchedule(int year, int month, int day, String regName) {
		//this(year, month, day); // gathers the parameters (except for the last parameter) for use as the final step in constructor chaining.
		this.year = year; // fully declares year to the constructor, part of the last step in constructor chaining
		this.month = month; // same as above but for month
		this.day = day; // same as above but for day
		this.regName = regName.trim(); // same as above but for regName
		System.out.println("EventSchedule(int, int, int, String) was called"); // for debugging purposes
	}
	
	/**
	 * This constructor sets the year as passed, month as passed,
	 * day as passed, and name to the initialized name.
	 * <br> This constructor only accepts the order int, int, int.
	 * @param year The year for this EventSchedule.
	 * @param month The month for this EventSchedule.
	 * @param day The day for this EventSchedule.
	 */
	
	public EventSchedule(int year, int month, int day) {
		this(year, month, day, "unknown"); // use all parameters except for the last parameter for the sake of better constructor chaining showcase/display
		//setname("unknown"); // removing this line changes all printed `regName` to display the name set from EventSchedule().
		//setday(time.getDayOfMonth());
		//this.year = year; // previously for the final constructor chaining step.
		//this.month = month; // same as above
		//this.day = day; // same as above
		System.out.println("EventSchedule(int, int, int) was called"); // for debugging purposes
	}
	
	/**
	 * This constructor sets the year as passed, month as passed,
	 * day to current day, and name to the initialized name.
	 * <br> This constructor only accepts the order int, int.
	 * @param year The year for this EventSchedule.
	 * @param month The month for this EventSchedule.
	 */
	
	public EventSchedule(int year, int month) {
		this(year, month, Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		//setday(time.getDayOfMonth()); // sets the day to the current day of the month using the day of month getter inside the setter.
		//setmonth(time.getMonthValue());
		System.out.println("EventSchedule(int, int) was called"); // for debugging purposes
		// Note, "setname" not included. initial value "unknown" will be utilized.
	}
	
	/**
	 * This constructor sets the year as passed, month to current month,
	 * day to current day, and name to the initialized name.
	 * <br> This constructor only accepts the order int.
	 * @param year The year for this EventSchedule.
	 */
	
	public EventSchedule(int year) {
		this(year, Calendar.MONTH); // needed to start the constructor chaining process from empty to full, and will continue with other following constructors.
		//setyear(time.getYear());
		//setmonth(time.getMonthValue()); // sets the month to the current month using the month value getter inside the setter.
		//setday(time.getDayOfMonth()); // same as above but with day
		//setname(regName); // sets name to the string variable, "unknown" in this case
		System.out.println("EventSchedule(int) was called"); // for debugging purposes
	}
	
	/**
	 * The default constructor sets year, month, day to the current date, and name to the initialized variable.
	 * <br> This constructor doesn't need any value, and will only show the default values when printed via {@code createReport()}
	 * @see #createReport()
	 */
	public EventSchedule() {
		
		this(Calendar.getInstance().get(Calendar.YEAR)); // this() is used for chaining to the next constructor. sets `Calendar.YEAR`. this is the first step of constructor chaining from empty to overloaded constuctor display and chaining.
		//setyear(time.getYear()); // sets the year to the current year using the year getter inside the setter.
		//setmonth(time.getMonthValue()); // same as above but with month
		//setday(time.getDayOfMonth()); // same as above but with day
		//setname("Nouraldin"); // sets name to "Nouraldin"
		System.out.println("EventSchedule() was called"); // for debugging purposes
	}
	
	/**
	 * Returns the year for this EventSchedule.
	 * @return the year for this EventSchedule.
	 */
	public int getyear() {
		return year;
	}
	/**
	 * Sets the year for this EventSchedule.
	 * @param year to set for EventSchedule.
	 */
	public void setyear(int year) {
		this.year = year;
	}
	/**
	 * Returns the month for this EventSchedule.
	 * @return the month for this EventSchedule.
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * Sets the month for this EventSchedule.
	 * @param month to set for EventSchedule.
	 */
	public void setmonth(int month) {
		this.month = month;
	}
	
	/**
	 * Returns the day for this EventSchedule.
	 * @return the day for this EventSchedule.
	 */
	public double getday() {
		return day;
	}
	/**
	 * Sets the day for this EventSchedule.
	 * @param day to set for EventSchedule.
	 */
	public void setday(int day) {
		this.day = day;
	}
	
	/**
	 * Returns the name for this EventSchedule.
	 * @return the name for this EventSchedule.
	 */
	public String getname() {
		return regName;
	}
	/**
	 * Sets the name of the user for this EventSchedule.
	 * @param regName the name of the user for this EventSchedule.
	 */
	public void setname(String regName) {
		this.regName = regName; // Was this.regName = regName;
	}
	
	/**
	 * @return A String representation of this EventSchedule, each field is separated 
	 * by a comma in the order of year, month, day, and name (regName)
	 */
	public String createReport() {
		return String.format("EventSchedule, " + "year: %d, Month: %d, Day: %d, Name: %s%n",year,month,day,regName);
	}
}
