
public class Circle {
	private double radius;
	
	// accessor (get)
	public double getRadius() {
		return radius;
	}
	
	// mutator (set)
	public void setRadius(double value) {
		radius = value;
	}
	
	public double calculateCircumference() {
		double circumference;
		circumference = 2 * Math.PI * radius;
		return circumference;
	}
	
	public double calculateArea () {
		double area;
		area = Math.PI * Math.pow(radius, 2);
		return area;
	}
	
	public String toString() {
		String report;
		report = String.format("Circle with radius %.2f", radius);
		return report;
	}
	
}
