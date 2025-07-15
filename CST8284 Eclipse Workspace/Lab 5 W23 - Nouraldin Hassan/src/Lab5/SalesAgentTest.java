package Lab5;
/*
 * Assessment: Lab Exercise 5
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Dave Houtman, Sandra Iroakazi
 * Lab Section Number: 300/301
 * Due Date: See CSI
 * Description:
 */

/**
   This program is the first test for the SalesAgent class including the subclass.
   @author Nouraldin Hassan
*/
public class SalesAgentTest
{  
	 /** This main method prints out two constructor variables' string representation of assigned values.
	 * @param args the string arguments part of the main method
	 */
   public static void main(String[] args)
   {
	   SalesAgent salesagent = new SalesAgent("Andrew", 42);
	   SalesSupervisor salessupervisor = new SalesSupervisor("James", 26, "Perth");
	   
	   System.out.println(salesagent.toString());
	   System.out.println(salessupervisor.toString());
   }
}  