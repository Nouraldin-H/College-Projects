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
 * This class shows a Sales Supervisor with a location.
 * Name and age are inherited from {@link SalesAgent}.
 * @author Nouraldin Hassan
 */
public class SalesSupervisor extends SalesAgent{
	/**Location of the Sales Person (e.g. Ontario or Los Angeles)*/
	private String location;

	/** This constructor passes name, age, and location.
	 * name and age are gathered from the superclass, and location is declared here as `l`.
	 * @see SalesAgent
	 * @param n the name of the Sales Supervisor
	 * @param a the age of the Sales Supervisor
	 * @param l the location of the Sales Supervisor
	 */
	public SalesSupervisor(String n, int a, String l) {
		super(n, a);
		this.location = l;
	}
	
	/** Compares the declared location of SalesSupervisor to the accessor location of SalesSupervisor.
	 * Also compares the superclass objects to declared objects of this class.
	 *  @param obj the Object
	 */
	@Override
	public boolean equals(Object obj) { // Correct; use this method as your guide
		if (!(obj instanceof SalesSupervisor))
			return false; // return false if different object types used from 'this'
		SalesSupervisor salesSupervisor = (SalesSupervisor) obj; // otherwise okay to cast obj as SalesAgent
		return (this.location).equals(salesSupervisor.getLocation()) && (super.equals(salesSupervisor));
	}
	/** gets the location of the sales person.
	 * @return location of the sales person.
	 */
	public String getLocation() {
		return this.location;
	}
	     
	/**
	 * This method overrides the existing toString method in {@link SalesAgent}
	 * by formatting the strings. A variable must be assigned to the superclass to call 
	 * the superclass' toString method.
	 * @see SalesAgent#toString()
	 */
	public @Override String toString() {
		String salesAgent = super.toString();
		
		return String.format("Sales Supervisor [super=%s,location=%s]", salesAgent, location);
	}
}
