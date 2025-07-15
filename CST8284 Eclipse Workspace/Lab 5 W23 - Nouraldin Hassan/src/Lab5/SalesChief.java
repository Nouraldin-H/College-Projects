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
 * This class shows a Sales Chief with a department.
 * Name, age, and location are inherited from {@link SalesSupervisor}, which in turn
 * inherits name and age.
 * @author Nouraldin Hassan
 */
public class SalesChief extends SalesSupervisor{
	/**Department of the Sales Person (e.g. Paperwork, Writing)*/
	private String department;
	
	/** This constructor passes name, age, location, and department.
	 * name, age, and location are gathered from the superclass, and department is declared here as `d`.
	 * @see SalesSupervisor
	 * @param n the name of the Sales Chief
	 * @param a the age of the Sales Chief
	 * @param l the location of the Sales Chief
	 * @param d the department of the Sales Chief
	 */
	public SalesChief(String n, int a, String l, String d) {
		super(n, a, l);
		this.department = d;
	}
	
	/** Compares the declared department of SalesChief to the accessor location of SalesChief.
	 * Also compares the superclass objects to declared objects of this class.
	 *  @param obj the Object
	 */
	@Override
	public boolean equals(Object obj) { // Correct; use this method as your guide
		if (!(obj instanceof SalesSupervisor))
			return false; // return false if different object types used from 'this'
		SalesChief salesChief = (SalesChief) obj; // otherwise okay to cast obj as SalesAgent
		return (this.department).equals(salesChief.getDepartment()) && (super.equals(salesChief));
	}
	/** gets the department of the sales person.
	 * @return department of the sales person.
	 */
	public String getDepartment() {
		return this.department;
	}
	
	/**
	 * This method overrides the existing toString method in {@link SalesSupervisor}
	 * by formatting the strings. A variable must be assigned to the superclass to call 
	 * the superclass' toString method.
	 * @see SalesAgent#toString()
	 */
	public @Override String toString() {
		String salesSupervisor = super.toString();
		
		return String.format("Sales Chief [super=%s,department=%s]", salesSupervisor, department);
	}
}
