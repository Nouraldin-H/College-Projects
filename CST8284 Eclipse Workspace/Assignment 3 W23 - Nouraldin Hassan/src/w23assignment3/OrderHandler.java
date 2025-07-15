package w23assignment3;

import java.io.IOException;

/** Name of the handler as "Order" for testing exception-throwing super/sub classes throws.
 * @author Nouraldin Hassan
 */
public class OrderHandler {
	
	/** This main method tries exception throws in the code of super and sub classes. <br>

	 * NOTE: <ul> <li> IOException must start first to prevent a compilation error
	 * <li> IOException thrown in main method </ul>
	 * @param args the string arguments for the main method
	 */
	public static void main(String[] args) {
		
		try {
            throw new IOException("Exception"); 
        }
		catch (IOException io_exception) { //IOException must start first to prevent a compilation error
            System.err.println("Caught IOException: " + io_exception.getMessage());
        }
		catch (Exception exception) {
            System.err.println("Caught Exception: " + exception.getMessage()); // catches superclass exception after subclass exception
        }
		// Below doesn't work but kept for reference
//		try {
//            throw new IOException("Exception"); 
//        }
//		catch (Exception exception) { //IOException must start first to prevent a compilation error
//            System.out.println("Caught IOException: " + exception.getMessage());
//        }
//		catch (IOException io_exception) {
//            System.out.println("Caught Exception: " + io_exception.getMessage()); // catches superclass exception after subclass exception
//        }
	}
}
