package Lab5;
/*
 * Assessment: Lab Exercise 5
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Dave Houtman, Sandra Iroakazi
 * Lab Section Number: 300/301
 * Due Date: See CSI
 * Description: PART B
 */

/**
   This program is the third test for the SalesAgent class including the subclasses.
   @author Nouraldin Hassan
*/
public class SalesAgentTest3
{
 /** This main method prints out a comparing value in boolean for Sales VP.
 * All assigned variables are declared in a SalesAgent array variable and printed in a loop.
 * NOTE: Parsing a numberical-only string works (int s, fifth parameter), but a non-parsed numerical string causes an error.
 * @param args the string arguments part of the main method
 */
public static void main(String[] args)
   {
	SalesVP salesVP = new SalesVP("John", 57, "Senegal", "Management", Integer.parseInt("67400"));
	   System.out.println(salesVP.equals(salesVP));
	   System.out.println(salesVP.compareStocksHeld(salesVP));
	   System.out.println(salesVP.toString());
   }
}  