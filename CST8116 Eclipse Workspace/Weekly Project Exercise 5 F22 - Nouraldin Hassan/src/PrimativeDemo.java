
public class PrimativeDemo {
	public static void main(String[] args) {
		byte b =  10;
		short s = 10;
		int i = 10; // (int)3.3; also works but 3.3 gets rounded to a non-decimal value, truncated.
		long l = 214748364755L; //use uppercase to prevent confusion with l and 1.
		float f = 2.2F; //(float)2.2; also works //use uppercase, since there is f assigned as float and some might confuse f with 1 or with l.
		double d = 3.3;
		char c = 'a';
		boolean bool = true;
		
		int answer = (int)Math.sqrt(25);
		double answer2 = Math.sqrt(25);
		System.out.println(answer);
		System.out.println(answer2);
		
		final double SALES_TAX = 0.14; //final turns the variables into a constant
		//SALES_TAX = 5.0; //cannot work because SALES_TAX is declared as a constant, and therefore the value cannot change.
		double total = 42000.0 * SALES_TAX; //Constants are written in all capitals with underscores.
		//final is NOT the same thing as static, even though they are usually infused together.
	
		StaticConstant sc1 = new StaticConstant();
		StaticConstant sc2 = new StaticConstant();
		sc1.age = 10;
		sc2.age = 15;
		//sc1.MAX_SIZE = 45;
		//sc2.MAX_SIZE = 18;
		System.out.println(sc1.age);
		System.out.println(sc2.age);
		//System.out.println(sc1.MAX_SIZE);
		//System.out.println(sc2.MAX_SIZE);
		System.out.println(StaticConstant.MAX_SIZE);
		System.out.println(Math.PI);
		
		double atta = 5 % 2;
		double btta = 1 % 2;
		double ctta = 1/3;
		System.out.println(" " + atta + " " + btta + " " + ctta);
	}
}
