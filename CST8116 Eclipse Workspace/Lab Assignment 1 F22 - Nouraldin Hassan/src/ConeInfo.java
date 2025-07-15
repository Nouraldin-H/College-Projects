import java.math.*;
/*
 * Assessment: Lab Assignment 1 - 2022-10-06 - Task 2
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 330/331
 * Due Date: October 07, 11:59 PM
 * Created: October 06
 * Modified: October 07
 * Description: Lab Assignment 1, Task 2-B File
*/
public class ConeInfo {
	private double height;
	private double radius;
	// ~~~~~~ Skip from here if you only want the getters and setters
	/*
	Coded and declared information about the Cone (Cone.java). Declares height and radius
	ConeInfo() followed by this(value,value) is a constructor, for default values of declared values (string would be "" and float would be 0.0f)
	Reference: [1]"Cone Volume Calculator," . (From Omni Calculator), following the formula to get the Volume.
	 */
	public ConeInfo() { 
		this(0.0,0.0);
	}
	// ConeInfo(double value, double value) followed by this.value = value is also a constructor.
	// This is part of the above constructor to make an overloaded constructor.
	public ConeInfo(double height, double radius) {
		this.height = height;
		this.radius = radius;
	}
	// ~~~~~~ Skip to here
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public String toString() {
		String report;
		report = String.format("%.2, %.2 ", height, radius);
		return report;
	}
}
