package w23assignment3;

import java.io.IOException;

/** Name of the handler as "Dog" for testing exception-throwing multiple exceptions and catching superclass exception.
 * @author Nouraldin Hassan
 */
public class DogHandler {

	/** This main method tries exception throws in the code. <p>
	 * NOTE: <ul> <li> ExceptionDog thrown in main method
	 * <li> ExceptionPuppy thrown in main method
	 * <li> NullPointerException thrown in main method
	 * <li> IOException thrown in main method </ul>
	 * @param args the string arguments for the main method
	 */
	public static void main(String[] args) {
		try {
			throw new ExceptionDog();
		}catch(Exception exceptionDog){
			//System.err.println("--catching dog");
			//exceptionDog.printStackTrace();
			System.err.println("--caught dog, Line 19 thrown, Line 20 caught");
		}
		try {
			throw new ExceptionPuppy();
		}catch(Exception exceptionPuppy){
			//System.err.println("--catching puppy");
			//exceptionPuppy.printStackTrace();
			System.err.println("--caught puppy, Line 26 thrown, Line 27 caught");
		}
		try {
			throw new NullPointerException();
		}catch(Exception nullPointerException){
			//System.err.println("--catching null");
			//nullPointerException.printStackTrace();
			System.err.println("--caught null, Line 33 thrown, Line 34 caught");
		}
		try {
			throw new IOException();
		}catch(Exception iOException){
			//System.err.println("--catching io");
			//iOException.printStackTrace();
			System.err.println("--caught io, Line 40 thrown, Line 41 caught");
		}
	}
	/**
	 * This class extends Exception and prints the class' name.
	 * Note: This is for debugging purposes and is supposed to be empty in real life usage.
	 * @author Nouraldin Hassan
	 */
	static class ExceptionDog extends Exception {
		 {
			 System.out.println("exception dog");
		 }
	}
	/**
	 * This class extends ExceptionDog and prints the class' name.
	 * Note: This is for debugging purposes and is supposed to be empty in real life usage.
	 * @author Nouraldin Hassan
	 */
	 static class ExceptionPuppy extends ExceptionDog {
		 {
			 System.out.println("exception puppy");
		 }
	}
	
}
