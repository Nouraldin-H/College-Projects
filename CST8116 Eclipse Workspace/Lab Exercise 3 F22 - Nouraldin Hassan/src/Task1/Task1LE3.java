package Task1;
/*
 * Assessment: Lab Exercise 3 - 2022-10-20 - Task 1
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 330/331
 * Due Date: October 23, 11:59 PM
 * Created: October 23
 * Modified: October 20
 * Description: Lab Exercise 3, Task 1 File
*/
public class Task1LE3 {
	public static void main(String[]args) {
		System.out.printf("byte, SIZE: %d, BYTES: %d, MIN_VALUE: %d, MAX_VALUE: %d%n", Byte.SIZE, Byte.BYTES, Byte.MIN_VALUE, Byte.MAX_VALUE);
		System.out.printf("short, SIZE: %d, BYTES: %d, MIN_VALUE: %d, MAX_VALUE: %d%n", Short.SIZE, Short.BYTES, Short.MIN_VALUE, Short.MAX_VALUE);
		System.out.printf("int, SIZE: %d, BYTES: %d, MIN_VALUE: %d, MAX_VALUE: %d%n", Integer.SIZE, Integer.BYTES, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.printf("long, SIZE: %d, BYTES: %d, MIN_VALUE: %d, MAX_VALUE: %d%n", Long.SIZE, Long.BYTES, Long.MIN_VALUE, Long.MAX_VALUE);
		System.out.printf("float, SIZE: %d, BYTES: %d, MIN_VALUE: %e, MAX_VALUE: %e%n", Float.SIZE, Float.BYTES, Float.MIN_VALUE, Float.MAX_VALUE);
		System.out.printf("double, SIZE: %d, BYTES: %d, MIN_VALUE: %e, MAX_VALUE: %e%n", Double.SIZE, Double.BYTES, Double.MIN_VALUE, Double.MAX_VALUE);
		System.out.printf("char, SIZE: %d, BYTES: %d, MIN_VALUE: %d, MAX_VALUE: %d%n", Character.SIZE, Character.BYTES, (int)Character.MIN_VALUE, (int)Character.MAX_VALUE); //Using cast to prevent errors.
		System.out.println("Program by Nouraldin Hassan");
	}
}
