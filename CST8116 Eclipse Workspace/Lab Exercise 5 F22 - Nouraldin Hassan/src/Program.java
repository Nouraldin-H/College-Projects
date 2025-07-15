
/*
 * Student Name: 
 * Lab Professor: 
 * Due Date: 
 * Description: 
 */
public class Program {

	/*
	 * Add programmer comments here.
	 */
	public static void main(String[] args) {
		final int ENTER_VALUES = 1;
		final int DISPLAY_REPORT = 2;
		final int RESET_VALUES = 3;
		final int EXIT_PROGRAM = 4;
		int option = 0;
		DiceChecker diceChecker = new DiceChecker();

		boolean inMainMenu = false;
		boolean endProgram = false;
		while (endProgram == false) {
			// do while loop
			//     output menu options
			//     get user option
			//     use switch, delegate actions to diceChecker as needed
			// output your name at end of program
			do {
				System.out.println("**********MAIN MENU********** \nEnter a number below for the following options: ");
				System.out.println(ENTER_VALUES + ". Enter Values\n" + DISPLAY_REPORT + ". Display report\n" + RESET_VALUES + ". Reset Values\n" + EXIT_PROGRAM + ". Exit Program");
				//User.inputInteger();
				switch (User.inputInteger("", ENTER_VALUES, EXIT_PROGRAM)) {
				case 1:
					option = 1;
					inMainMenu = false;
					break;
				case 2:
					option = 2;
					inMainMenu = false;
					break;
				case 3:
					option = 3;
					inMainMenu = false;
					break;
				case 4:
					option = 4;
					inMainMenu = false;
					break;
				}
			} while (inMainMenu);
			
			if (option == 1) {
				diceChecker.enterData();
				inMainMenu = true;
			}
			else if (option == 2) {
				diceChecker.printReport();
				inMainMenu = true;
			}
			else if (option == 3) {
				diceChecker.resetData();
				System.out.println("Values have been reset");
				inMainMenu = true;
			}
			else {
				inMainMenu = false;
				System.out.println("Program shutting down \nProgram by Nouraldin Hassan");
				endProgram = true;
			}
			//System.out.print(option);
			
			/* ******PROGRAM CONTINUE USER QUERY STARTS HERE****** */
			/* Continue Program Code Taken from Assignment 02*/
			
//			boolean isProgramContinueNotValid = false; /*this worked great, but renaming the boolean and setting values oppositely didn't work*/
//			do {
//				System.out.print("Continue Program (yes/no)? ");
//				String programContinue = User.inputString(); /*prompts the user to input a string value*/
//				if ("yes".equalsIgnoreCase(programContinue) || "y".equalsIgnoreCase(programContinue)) { /*typing YES or yEs or simply y works*/
//					endProgram = false; /*program will keep running*/
//					isProgramContinueNotValid = false; /*program continue is valid*/
//					System.out.println("Program will now continue");
//				}
//				else if ("no".equalsIgnoreCase(programContinue) || "n".equalsIgnoreCase(programContinue)) {
//					System.out.println("Program will now stop");
//					endProgram = true;
//					isProgramContinueNotValid = false;
//				}
//				else {
//					System.out.println("Invalid input");
//					endProgram = false;
//					isProgramContinueNotValid = true; /*at that point, you will have to go through the loop until you enter yes or no*/
//				}
//			} while (isProgramContinueNotValid == true); /*== true isn't needed in this case but it's good for clarity*/
		}
	}

}
