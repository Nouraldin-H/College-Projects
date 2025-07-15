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
   This class shows a Sales Agent with a name and age.
   @author Nouraldin Hassan
*/
public class SalesAgent
{  /**Name of the Sales Person*/
   private String name;
   /**Age ofd the Sales Person*/
   private int age;

   /** This constructor passes name and age, declared here as `n` and `a`.
   * @param n the name of the Sales Agent
   * @param a the age of the Sales Agent
   */
   public SalesAgent(String n, int a) {
	   this.name = n;
	   this.age = a;
   }
   /** Compares the declared age and name of SalesAgent to the accessor age and name of SalesAgent.
    *  @param obj the Object
    */
   @Override
   public boolean equals(Object obj){  	// Correct; use this method as your guide
       if (!(obj instanceof SalesAgent)) return false;     // return false if different object types used from 'this'
       SalesAgent salesAgent = (SalesAgent)obj; // otherwise okay to cast obj as SalesAgent
       return (this.age == salesAgent.getAge()) && (this.name).equals(salesAgent.getName());
   }

/** gets the age of the sales person.
  * @return age of the sales person.
  */
   public int getAge() {
	return this.age;
   }
/** gets the name of the sales person.
  * @return name of the sales person.
  */
public String getName() {
		return this.name;
	}

/**
      This portion of code returns the string representation of the object.
      @return a string representation of the object
   */

   public String toString()
   {  
      return "Sales Agent [name=" + name + ",age=" + age + "]";
   }
}