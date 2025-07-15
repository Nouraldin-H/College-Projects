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
   This program is the second test for the SalesAgent class including the subclasses.
   @author Nouraldin Hassan
*/
public class SalesAgentTest2
{  
 /** This main method prints out four constructor variables' string representation of assigned values.
 * All assigned variables are declared in a SalesAgent array variable and printed in a loop.
 * @param args the string arguments part of the main method
 */
public static void main(String[] args)
   {
	   SalesAgent salesagent = new SalesAgent("Peter", 56);
	   SalesAgent salesagent2 = new SalesAgent("John", 48);
	   SalesSupervisor salessupervisor = new SalesSupervisor("Ifeoma", 53, "Toronto");
	   SalesChief saleschief = new SalesChief("Ndidi Oma", 35, "Ottawa", "Paperwork");
	   
	   SalesAgent[] salesall = {salesagent, salesagent2, salessupervisor, saleschief};
	   
	   for (int h = 0; h < 4; h++) {
		   System.out.println(salesall[h]);
	   }
   }
}  