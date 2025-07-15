
public class UnaryDemo {

	public static void main(String[] args) {
		int x = 1;
		System.out.println( x++ ); // print x and then increment.
		System.out.println( ++x ); //increment and then print x.
		System.out.println(x); //print x
		System.out.println( x ); //print x

		int y = +(+x);
		System.out.println(x);
	}
	/*
	 public double operator++(double value){
	 // this is a post-fix operator. ++operator is a pre-fix.
	 	double oldValue = value;
	 	value = value + 1;
	 	return oldValue;
	 }
	 
	 public double ++operator(double value){
	 	value = value + 1;
	 	return value;
	 }
	 */
}
