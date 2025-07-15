package fallwwlab3reverse;

/**
 * WELCOME TO LAB 3!
 * The essence of this lab is to work with constructors and to show overloaded constructor calls.
 * It demonstrates chaining overloaded constructors using "this" keyword.
 * It helps to consolidate understanding of the chaining rules learned in the theory class
 * This program also displays a good example of writing comments in your code using the Javadoc style.  
 */

/**
 * This is the driver class for this program. This means that it just runs the application with a method
 * main.
 * @author Nouraldin Hassan.
 */
public class TestDemo {

	/**
	 * This is the entry point for the application, it instantiates 5 EventSchedule
	 * objects to show-case the constructors. Anonymous objects are used and
	 * each one is only retained long enough to call method create report on
	 * each. No variable names were used, just new Constructor().methodCall().
	 * @param args Command line arguments are not used by this program.
	 */

	public static void main(String[] args) {

		System.out.println("Just creating 5 EventSchedules \n");
		EventSchedule Event1 = new EventSchedule(); //make new EventSchedule call under Event1 variable.
		System.out.println(Event1.createReport()); //print the report for the specified event.
		System.out.println();
		
		EventSchedule Event2 = new EventSchedule(6); //EventSchedule(int year)
		System.out.println(Event2.createReport());
		System.out.println();
		
		EventSchedule Event3 = new EventSchedule(7, 8); //EventSchedule(int year, int month)
		System.out.println(Event3.createReport());
		System.out.println();
		
		EventSchedule Event4 = new EventSchedule(4, 5, 6); //EventSchedule(int year, int month, int day)
		System.out.println(Event4.createReport());
		System.out.println();
		
		EventSchedule Event5 = new EventSchedule(4, 5, 6, "Nouraldin"); //EventSchedule(int year, int month, int day, String regName)
		System.out.println(Event5.createReport());
		System.out.println();

		System.out.println("Now creating 5 EventSchedules in a different way \n"); // Start to display Events in reverse order
		EventSchedule Event1r = new EventSchedule(-7, -8, -9, "Admin"); //r in Event1r stands for reverse.
		System.out.println(Event1r.createReport());
		System.out.println();
		
		EventSchedule Event2r = new EventSchedule(-9, -8, -7);
		System.out.println(Event2r.createReport());
		System.out.println();
		
		EventSchedule Event3r = new EventSchedule(-4, -5);
		System.out.println(Event3r.createReport());
		System.out.println();
		
		EventSchedule Event4r = new EventSchedule(-3);
		System.out.println(Event4r.createReport());
		System.out.println();
		
		EventSchedule Event5r = new EventSchedule();
		System.out.println(Event5r.createReport());
		System.out.print("Program by Nouraldin Hassan");

	}
/**What happens if I add spaces in EventSchedule() with a string value inside?
 * For EventSchedule(1, 2, 3, "name"), changing the provided string value to "     name     " will make
 * the name appear spaced out. There shouldn't be extra spaces inputted.
 * String.trim() exists as part of regName to eliminate the extra spaces in EventSchedule(1, 2, 3, "name")
 * In other words, EventSchedule(1, 2, 3, "    name      ") becomes EventSchedule(1, 2, 3, "name")*/
}
