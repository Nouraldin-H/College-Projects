package w23assignment3;

/** Name of the handler as "Fish" for testing exception-throwing rethrow exceptions via methods
 * @author Nouraldin Hassan
 */
public class FishHandler {
	
	/** This method is meant to throw an unchecked exception
	 * @throws NullPointerException in method
	 */
	public static void easterEnding(){
		throw new NullPointerException("Exception thrown in easterEnding");
	}
	/** This method is meant to throw a checked exception
	 * @throws NullPointerException from easterEnding()
	 */
	public static void easterStarting(){ //checked exception
		try {
		System.err.println("running easterStarting method");
		easterEnding();
		}
		catch (NullPointerException e){
			System.err.println("catching NullPointerException");
			throw e;
		}
	}
	
	/** This main method tries the NullPointer exception throws in the code.
	 * NOTE: NullPointerException thrown in easterStarting method
	 * @param args the string arguments for the main method
	 */
	public static void main(String[] args) {
		try {
			easterStarting();
		}catch(NullPointerException exceptionEasterStart){
			exceptionEasterStart.printStackTrace();
			System.err.println("--easter start caught");
		}
	}
}
