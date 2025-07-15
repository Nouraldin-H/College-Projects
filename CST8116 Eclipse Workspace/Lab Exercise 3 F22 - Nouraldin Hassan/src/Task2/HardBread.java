package Task2;
/*
 * Assessment: Lab Exercise 3 - 2022-10-20 - Task 2-B
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 330/331
 * Due Date: October 23, 11:59 PM
 * Created: October 23
 * Modified: October 20
 * Description: Lab Exercise 3, Task 1 File
*/
public class HardBread {
	public static final double MAX_LENGTH = 10.5; //static is used, because it makes this a part of the class.
	public static final double MAX_WIDTH = 10.5;
	public static final double MAX_DEPTH = 5.5;
	private double length;
	private double width;
	private double depth;
	private boolean isSalted;
	
	public HardBread() {
		this(MAX_LENGTH,MAX_WIDTH,MAX_DEPTH,false);
	}

	public HardBread(double length, double width, double depth, boolean isSalted) {
		this.length = length;
		this.width = width;
		this.depth = depth;
		this.isSalted = isSalted;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public boolean isSalted() {
		return isSalted;
	}

	public void setSalted(boolean isSalted) {
		this.isSalted = isSalted;
	}
	
	public double calculateVolume() {
		
		double totalVolume;
		totalVolume = length * width * depth;
		return totalVolume;
	}
	
	public String toString() {
		String report;
		//String volume; //You don't need it.
		report = String.format("%s %.2f, %s %.2f, %s %.2f %n", "Length:", length, "Width:", width, "Depth:", depth); //Also formats text to add as part of the report.
		//report = String.format("%.2f, %.2f, %.2f %n", length, width, depth); //Would format only numbers in output.
		//volume = String.format("%.2f", totalVolume); //Unreliable, you would need to declare TotalVolume.
		return report;
		//return volume; //Not really needed, as printf in main method can work fine.
	}
}
