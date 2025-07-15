package w23assignment1;
/*
 * Assessment: Lab Assignment 1
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Dave Houtman, Sandra Iroakazi
 * Lab Section Number: 300/301
 * Due Date: Feb 24, 2023
 * Description: 
 */
import java.time.LocalDateTime;
// THIS IS THE IMPROVED CLASS OF Patient.java
/**
 * This class maintains important health information about a patient
 * @author Nouraldin Hassan
 */

public class Patient2 {
	LocalDateTime time = LocalDateTime.now();
	private String firstName;
	private String lastName;
	private String gender;
	private int birthYear;
	private int birthMonth;
	private int birthDay;
	private double height; // in inches
	private double weight; // in pounds

	/**
	 * Sets all variables for initialization via input <p>
	 * CODE ISSUES: <ul><li>
	 * You can enter anything for "gender", which is not supposed to happen. <li>
	 * entering negative birth times, height, and weight is possible (Math.abs fixes this issue for the output) <li>
	 * You can enter birth times at any range, which is not supposed to happen. </ul>
	 */
public Patient2() {
	setFirstName(firstName); // sets the first name to itself. The user would input the patient's first name in this context.
	setLastName(lastName); // same as above but with last name.
	setGender(gender); // same as above but with gender.
	setBirthYear(Math.abs(birthYear)); // same as above but with birth year.
	setBirthMonth(Math.abs(birthMonth)); // same as above but with birth month.
	setBirthDay(Math.abs(birthDay)); // same as above but with birth day.
	setHeight(Math.abs(height)); // same as above but with height.
	setWeight(Math.abs(weight)); // same as above but with weight.
}

/** Used for constructor chaining.
 * @see #Patient2()
 * @param firstName the first name of the patient 
 * @param lastName the last name of the patient 
 * @param gender the gender of the patient 
 * @param birthYear the birth year of the patient 
 * @param birthMonth the birth month of the patient 
 * @param birthDay the birth day of the patient 
 * @param height the height of the patient  (in inches)
 * @param weight the weight of the patient  (in pounds)
 */
public Patient2(String firstName, String lastName, String gender, int birthYear, int birthMonth, int birthDay, double height, double weight) {
	this(); // needed to utilize the constructor chaining process from empty to full.
	this.firstName = firstName;
	this.lastName = lastName;
	this.gender = gender;
	this.birthYear = birthYear;
	this.birthMonth = birthMonth;
	this.birthDay = birthDay;
	this.height = height;
	this.weight = weight;
}

/**
 * @return firstName of the patient
 */
public String getFirstName() {
	return firstName;
}
/**
 * @param firstName of the patient
 */
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
/**
 * @return lastName of the patient
 */
public String getLastName() {
	return lastName;
}
/**
 * @param lastName of the patient
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}
/**
 * @return gender of the patient
 */
public String getGender() {
	return gender;
}
/**
 * @param gender of the patient
 */
public void setGender(String gender) {
	this.gender = gender;
}
/**
 * @return birthYear of the patient
 */
public int getBirthYear() {
	return birthYear;
}
/**
 * @param birthYear of the patient
 */
public void setBirthYear(int birthYear) {
	this.birthYear = birthYear;
}
/**
 * @return birthMonth of the patient
 */
public int getBirthMonth() {
	return birthMonth;
}
/**
 * @param birthMonth of the patient
 */
public void setBirthMonth(int birthMonth) {
	this.birthMonth = birthMonth;
}
/**
 * @return birthDay of the patient
 */
public int getBirthDay() {
	return birthDay;
}
/**
 * @param birthDay of the patient
 */
public void setBirthDay(int birthDay) {
	this.birthDay = birthDay;
}
/**
 * @return height of the patient
 */
public double getHeight() {
	return height;
}
/**
 * @param height of the patient
 */
public void setHeight(double height) {
	this.height = Math.abs(height);
}
/**
 * @return weight of the patient
 */
public double getWeight() {
	return weight;
}
/**
 * @param weight of the patient
 */
public void setWeight(double weight) {
	this.weight = Math.abs(weight);
}

// THIS RETURNS THE PATIENT'S Body Mass Index (BMI) AND IT IS PROVIDED HERE FOR YOU. DO NOT CHANGE THIS PIECE OF CODE!

/**
 * @return (getWeight * 703) divided by (getHeight * getHeight)
 */
public double getBMI() { // left unchanged
   return (getWeight() * 703) / (getHeight() * getHeight()); // left unchanged
} 

/** Calculates the age of the patient based on their birth times. <p>
 * CODE ISSUES: <ul><li> When you enter the same year, the month higher than the current month, but the day is the same, the age returns as -1.
 * <li> The birth month itself isn't checked, only the month and day is checked.
 * <li> When you enter the same month, but the day is different, the age is returned higher by 1. </ul>
 * @return age of the patient
 */
public int Age() {
	int age = time.getYear() - birthYear;
	int month = time.getMonthValue();
	int day = time.getDayOfMonth();
	if (month < birthMonth && day < birthDay) age -= 1;
	else if (month == birthMonth && day < birthDay) age -= 1;
	return age;
}
/** Calculates the maximum heart rate of the patient based on their age.
 * @return heartRate as Heart Rate of the patient
 */
public int MaximumHeartRate() {
	//int age = time.getYear() - birthYear; // kept for reference
	int heartRate = 220 - Age();
	return Math.abs(heartRate);
}

/** Calculates the minimum heart rate of the patient based on half of the maximum heart rate
 * @return heartRate as Heart Rate of the patient, divided by 50%
 * <br> example: <b>220 - 30</b> (years old) <b>= 190</b>.
 * <b>190 / 2 </b><i><b>= 95.</b></i>
 * <br> <b>190 / 2</b> is the same as <b>190 * 0.5</b>, or <b>190 / 50% </b>in this case.
 */
public int MinimumHeartRate() {
	return MaximumHeartRate() / 2;
}

/** Calculates the target heart rate of the patient based on their heart rate statistics.
 * @return targetHeartRate as Target Heart Rate of the patient
 */
public int TargetHeartRate() {
	int maxTargetHeartRate = (int)Math.ceil(MaximumHeartRate() * (17/20.0)); //float used because value doesn't need to be long
	int targetHeartRate = (maxTargetHeartRate + MinimumHeartRate()) / 2; // basically TargetHR is the average of Maximum and Minimum Heart Rates.
	return Math.abs(targetHeartRate);
}

/**
 * prints health information for the patient, based on the inputs.
 */
public void displayMyHealthData() 
{ 

System.out.printf("%nDATA VALUES %nFull Name: %s %s %nGender: %s %nBirth Date: %d/%d/%d %nHeight: %.2f in. %nWeight: %.2f lbs.%n", firstName, lastName, gender, birthYear, birthMonth, birthDay, height, weight);
System.out.printf("%nHEALTH VALUES %nAge: %d %nBMI: %.2f %nMaximum Heart Rate: %d %nTarget Heart Rate: %d %n%n", Age(), getBMI(), MaximumHeartRate(), TargetHeartRate());
   
// Below is to be kept as is.

   System.out.println("BMI VALUES");
   System.out.println("Underweight: less than 18.5");
   System.out.println("Normal:      between 18.5 and 24.9");
   System.out.println("Overweight:  between 25 and 29.9");
   System.out.println("Obese:       30 or greater");   
} 
} // end class Patient

