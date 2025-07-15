package Lab5;
/*
 * Assessment: Lab Exercise 5
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Dave Houtman, Sandra Iroakazi
 * Lab Section Number: 300/301
 * Due Date: See CSI
 * Description: PART B AND TEST CLASS IS HERE!
 */

/**
 * This class shows a Sales Vice President with stocks held.
 * Name, age, location, and department are inherited from {@link SalesChief}, which in turn
 * inherits name, age, and location.
 * @author Nouraldin Hassan
 */
public class SalesVP extends SalesChief{
	/**Stockholdings of the Sales Person (e.g. 5000)*/
private int stocksHeld;
	
	/** This constructor passes name, age, location, department, and stockholdings.
	 * name, age, location, and derpartment are gathered from the superclass, and stocks held is declared here as `s`.
	 * @see SalesChief
	 * @param n the name of the Sales VP
	 * @param a the age of the Sales VP
	 * @param l the location of the Sales VP
	 * @param d the department of the Sales VP
	 * @param s the stocks held of the Sales VP
	 */
	public SalesVP(String n, int a, String l, String d, int s) {
		super(n, a, l, d);
		this.setStocksHeld(s);
	}
	
	/** Compares the declared department of SalesChief to the accessor location of SalesChief.
	 * Also compares the superclass objects to declared objects of this class.
	 *  @param obj the Object
	 *  @return true if stocksHeld matches the stocksHeld accessor, otherwise false. Also returns object superclass equals.
	 */
	@Override
	public boolean equals(Object obj) { // Correct; use this method as your guide
		if (!(obj instanceof SalesSupervisor))
			return false; // return false if different object types used from 'this'
		SalesVP salesVP = (SalesVP) obj; // otherwise okay to cast obj as SalesAgent
		return (this.stocksHeld == salesVP.getStocksHeld()) && (super.equals(salesVP));
	}
	/** Compares only the declared stocks hold with the stockholdings object.
	 * @param obj the Object
	 * @return true if stocksHeld matches the object of StocksHeld accessor, otherwise false.
	 */
	public boolean compareStocksHeld(Object obj) {
		return this.stocksHeld == ((SalesVP)obj).getStocksHeld();
	}
	/** gets the stockholdings of the sales person.
	 * @return stocksHeld of the sales person.
	 */
	public int getStocksHeld() {
		return this.stocksHeld;
	}
	/** sets the stockholdings of the sales person; in this case, for SalesVP.
	 * Inputting a float/double, or any float point values ignores the decimal value as if it was never there. String inputs throws error.
	 * @param stocksHeld of the sales person; SalesVP in this case.
	 */
	public void setStocksHeld(int stocksHeld) {
		this.stocksHeld = stocksHeld;
	}
	
	/**
	 * This method overrides the existing toString method in {@link SalesChief}
	 * by formatting the strings. A variable must be assigned to the superclass to call 
	 * the superclass' toString method.
	 * @see SalesAgent#toString()
	 */
	public @Override String toString() {
		String salesChief = super.toString();
		
		return String.format("Sales Chief [super=%s,stockholdings=%s]", salesChief, stocksHeld);
	}
}
