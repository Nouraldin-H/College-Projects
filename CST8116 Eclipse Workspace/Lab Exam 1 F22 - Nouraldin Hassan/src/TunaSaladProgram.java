
/*
 * Assessment: Lab Exam 1 - 2022-10-14 - Task 1
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Stanley Pieda
 * Lab Section Number: 330/331
 * Due Date: October 14, 8:50 AM
 * Created: October 14
 * Modified: October 14
 * Description: Lab Exam 1, Task 1 File
*/

public class TunaSaladProgram {
	private double weight;
	private int calories;
	
	public TunaSaladProgram() {
		this(0.0, 0);
	}

	public TunaSaladProgram(double weight, int calories) {
		this.weight = weight;
		this.calories = calories;
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	public double calculateTotalCalories() {
		double totalCalories;
		totalCalories = weight * calories;
		return totalCalories;
	}
	
	public String toString() {
		String report;
		report = String.format("%.2f, %n",
				weight, calories);
		return report;
	}
}
