/*
 * Author/modified by: 
 * Professor:
 * Date: 
 * Description: Lab Exam 02
 */

 /*
  * This class represents a tuna salad
  */
public class TunaSalad{
    private double weight;
    private double calories;

    /*
     * No argument constructor
     */
    public TunaSalad(){
        weight = 0;
        calories = 0;
    }

    /*
     * accessor for weight
     */
    public double getWeight(){
        return weight;
    }

    /*
     * mutator for weight
     */
    public void setWeight(double weight){
        this.weight = weight;
    }

        /*
     * accessor for calories
     */
    public double getCalories(){
        return calories;
    }

    /*
     * mutator for calories
     */
    public void setCalories(double calories){
        this.calories = calories;
    }

    /*
     * worker method for total calories
     */
    public double calculateTotalCalories(){
        double number;
        number = weight * calories;
        return number;
    }

    /*
     * ToDo write programmer comments here
     */
    public String checkTotalCalories(){
        String report;
        //ToDo: call calculateTotalCalories to obtain the value
        // decide on the report to return, a value less than zero reports "total calories invalid",
        // a value more than 331 reports "total calories too high", a value between 0 to 331 (inclusive)
        // would report "total calories within range".
        /*boolean calorieLimit = (double)calculateTotalCalories() > 331;*/
        /*boolean calorieInvalid = (double)calculateTotalCalories() < 0;*/ //This would be less efficient. Using calculateTotalCalories() < or > number is good enough
        if ((double)calculateTotalCalories() > 331){
        	report = "total calories is too high";
        }
        else if ((double)calculateTotalCalories() < 0) { // using numbers also works
        	report = "total calories is invalid";
        }
        else {
        	report = "total calories is within range";
        }

        return report; // return the actual report
    }

}