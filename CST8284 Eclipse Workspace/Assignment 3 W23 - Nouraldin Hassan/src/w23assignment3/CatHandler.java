package w23assignment3;

/** Name of the handler as "Cat" for testing exception-throwing inheritance classes
 * @author Nouraldin Hassan
 */
public class CatHandler {
	
	/** This main method tries exception throws in the code.
	 * NOTE: ExceptionGammer thrown in main method
	 * @param args the string arguments for the main method
	 */
	public static void main(String[] args) {
		
		try {
			throw new ExceptionGammer();
		}catch(ExceptionAlpha exceptionAlpha){
			exceptionAlpha.printStackTrace();
		}
		try {
			throw new ExceptionBeta();
		}catch(ExceptionAlpha exceptionAlpha){
			exceptionAlpha.printStackTrace();
		}
	}
	/**
	 * This class extends Exception and prints the class' name.
	 * NOTE: This is for debugging purposes and is supposed to be empty in real life usage.
	 * @author Nouraldin Hassan
	 */
	 static class ExceptionAlpha extends Exception {
		 {
			 System.out.println("exception alpha"); // requested by prof.
		 }
	}
	 /**
	 * This class extends ExceptionAlpha and prints the class' name.
	 * NOTE: This is for debugging purposes and is supposed to be empty in real life usage.
	 * @author Nouraldin Hassan
	 */
	 static class ExceptionBeta extends ExceptionAlpha {
		 {
			 System.out.println("exception beta"); // requested by prof.
		 }
	}
	 /**
	 * This class extends Beta and prints the class' name.
	 * NOTE: This is for debugging purposes and is supposed to be empty in real life usage.
	 * @author Nouraldin Hassan
	 */
	 static class ExceptionGammer extends ExceptionBeta {
		 {
			 System.out.println("exception gamma"); // requested by prof.
		 }
	}
}
