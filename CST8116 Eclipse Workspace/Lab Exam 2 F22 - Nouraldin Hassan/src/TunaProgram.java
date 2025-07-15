import java.util.Scanner;

public class TunaProgram {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TunaSalad tunasalad = new TunaSalad(); //call class into variable
		boolean endProgram = false;
		while (endProgram == false) { /*making sure endProgram is false*/
			System.out.print("Enter weight in grams: ");
			double weight = scanner.nextDouble();
			tunasalad.setWeight(weight); //call setter and assign weight
			System.out.print("Enter calories per gram: ");
			double calories = scanner.nextDouble();
			tunasalad.setCalories(calories); //call setter and assign calories
			System.out.println(tunasalad.checkTotalCalories()); //prints the calorie checking method
			scanner.nextLine(); // fix input skips
			System.out.println("Program by Nouraldin Hassan");
			boolean isProgramContinueNotValid = false; /*loop block is from Assignment02.java*/
			do {
				System.out.print("Continue Program (yes/no)? ");
				String programContinue = scanner.nextLine(); /*prompts the user to input a string value*/
				if ("yes".equalsIgnoreCase(programContinue) || "y".equalsIgnoreCase(programContinue)) { /*typing YES or yEs or simply y works*/
					endProgram = false; /*program will keep running*/
					isProgramContinueNotValid = false; /*program continue is valid*/
					System.out.println("Program will now continue");
				}
				else if ("no".equalsIgnoreCase(programContinue) || "n".equalsIgnoreCase(programContinue)) {
					System.out.println("Program will now stop");
					endProgram = true;
					isProgramContinueNotValid = false;
				}
				else {
					System.out.println("Invalid input");
					endProgram = false;
					isProgramContinueNotValid = true; /*at that point, you will have to go through the loop until you enter yes or no*/
				}
			} while (isProgramContinueNotValid == true); /*== true isn't needed in this case but it's good for clarity*/
		}
		scanner.close();
	}
}
