/*
 * Assessment: Exercise 01-1 - 2022-09-09 - My First Java Program (Greetings)
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 331
 * Due Date: N/A
 * Created: September 09
 * Modified: September 09
 * Description: Hybrid 01 Practice Demonstration File
*/

import java.util.Date;
import java.text.DateFormat;
/* A simple class that outputs a greeting to the console. Class_Header_Comment */
public class Greeting {
/* Entry point for the application. Method-header_comment _for_method_main */
	public static void main(String[] args) {
Date todayDateTime = new Date();
DateFormat dateFormat = DateFormat.getDateTimeInstance();
System.out.println("Hello, my author's name is " + "Nouraldin Hassan");
System.out.println("Today is: " + dateFormat.format(todayDateTime));
}
}

/* The format below is hard to read
 * public static void main(String args[]) {
Date todayDateTime = new Date();
DateFormat dateFormat = DateFormat.getDateTimeInstance();
System.out.println("Hello, my author's name is " + "Nouraldin Hassan");
System.out.println("Today is: " + dateFormat.format(todayDateTime));
}
}
 */
/* The format below is easy to read because of corrected indentation
 * public class Greeting {	
	public static void main(String args[]) {
		Date todayDateTime = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance();
		System.out.println("Hello, my author's name is " + "Nouraldin Hassan");
		System.out.println("Today is: " + dateFormat.format(todayDateTime));
	}
}
 * Indentation is important for readability
 */