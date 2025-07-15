/*
 * Assessment: Lab Exercise 1 - 2023-01-11
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Dave Houtman, Sandra Iroakazi
 * Lab Section Number: 300/301
 * Due Date: ???
 * Created: January 13
 * Modified: January 18
 * Description: Lab Exercise 1, the main class for printing first and last name of a student, and their student number.
*/

/**
* TASK: Remember to include all necessary headers for your Javadoc, descriptions and explanations of what you have done in the appropriate places.
* ENSURE that you add appropriate Javadoc style comments to relevant parts of this code as you update this program to show that you understand it.
*
* @author - Nouraldin Hassan
* 
*/
/**CovidStatistics class refers to providing the information of patients from different Canadian provinces that had COVID and patients that have recovered from COVID, using nested loops for making calculations of recovered patients*/
public class CovidStatistics
{
/** The main method, which handles I/O, variables, method calls, and such.
 * @param args the arguments
 */
public static void main(String[] args)
 {
   final int ROWS = 7;
   final int COLUMNS = 8;
   /***/
   int[][] patients = 
      { 
         {  2200, 1100, 1200, 1000, 1015, 2000, 1092, 2204 },
         {  5020, 6105, 2009, 9047, 1016, 2014, 2708, 2308 }, 
         {  1720, 2406, 3054, 1018, 1023, 3100, 1406, 1502 }, 
         {  1490, 2002, 2016, 5008, 2044, 1055, 1607, 2201 },
         {  1520, 1007, 1092, 2065, 1023, 1010, 1046, 1502 },
         {  1670, 1201, 2008, 2001, 1086, 1009, 1041, 1706 },
	     {  1870, 2001, 2078, 1006, 1053, 1702, 1009, 1406 }
         
      };

   String[] provinces = 
      { 
         "Ontario", 
         "Quebec", 
         "Nova Scotia",
         "New Brunswick", 
         "Manitoba", 
         "British Columbia",
	     "Prince Edward Island"         
      };
   
   System.out.println("              Month      Feb    March    April   May   June   July    Aug     Sept");
   System.out.println();

   /** TASK: It is important to know the number of patients per province. So you need to print out the number of patients for all provinces (content of the array) for each month.
   * Update the code in this section by using a nested for loop. 
   * 
   */
   
   int vert = 0; //Vertical Control 
   for (int i = 0; i < ROWS; i++) {
	   System.out.printf("%20s", provinces[i]);
	   for (int j = 0; j < COLUMNS; j++) {
		   System.out.printf("	%-6d", patients[i][j]); }
	   vert++;
	   System.out.println();
   }

   /** TASK: Update the code in this section by writing a nested for loop (for the columns and rows of the array) to compute the sum (column). 
   * Print the column sum using printf. Check the sample output file (CovidSample) to see the expected pattern to print the details using printf.
   */ 
   
   System.out.println();
   System.out.print("  Recovered Patients");

   int hori = 0; //Horizontal Control 
   int total = 0;
   for (int i = 0; i < COLUMNS; i++) {
    	for (int j = 0; j < ROWS; j++) {
    		total += patients[j][hori]; }
    	System.out.printf("	%-6d", total);
    	hori++;
    	total = 0; //reset total count after total is printed to prevent reuse of already-counted total and messing up the statistics.
   }

   System.out.printf("%n         Eastern Canada Summer Stats:   %-6d %n", eastCanadaSummerStats(patients)); 
   System.out.println(); 
   System.out.println("               Vaccinate and maintain good health practices!" );
   System.out.println("\nProgram created by Nouraldin Hassan");
 }
 /**
 * Gets the patients for the summer months June, July, and August for Eastern Canada Provinces Ontario, Quebec, Nova Scotia, and New Brunswick.
 * @param patients the patients, as also declared in the main method
 * @return total
 */
public static int eastCanadaSummerStats(int[][] patients) {
	 System.out.println();
	 int total = 0;
	   for (int i = 0; i < 4; i++) {
		   //System.out.printf("%20s", provinces[i]);
		   for (int j = 4; j < 7; j++) {
			   total += patients[i][j];}
		   //System.out.printf("	%-6d", total);
	   }
	 return total;
 }
}
