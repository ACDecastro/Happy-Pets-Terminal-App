
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Antonio Decastro <acd005@mcdaniel.edu>
 * 
 */

public class HappyPets {
	/**
	 * This contains the number of the option that the user wishes execute.
	 */
	private static int choice; 
	
	
	/**
	 * isNumeric method: <br />
	 * This method makes sure the input is actually a number
	 * <p>this same method is present in the Printer class
	 * 
	 * @param testString String that may or may not be a number
	 * @return			 true if the string contains a single numeric value and nothing else, otherwise false
	 */
	public static boolean isNumeric(String testString){  
		try {  
			double testDouble = Double.parseDouble(testString);  
		}  
	 	catch(NumberFormatException nfe) {  
	 		return false;  
	 	}  
	 	return true;  
	}
	
	
	/**
	 * numberSelector method: <br />
	 * Ensures that the user's input is an integer. 
	 * <p>takes input (of a String that could be a null, non-numeric string, fractional value, negative number, 
	 * a number greater than 5, or a valid selection and returns a number between 0 and 4
	 * @param command			The user's input for the option they want to execute. 
	 * @param commandModifier	Scanner object that allows the user to change their option if it is not an integer.
	 * @param prompt			A message that lets the user know they need to enter a new number
	 * @return					An integer if the user eventually enters a valid value. Otherwise, this method will continue to prompt the user to enter an integer until they do so.
	 */
	public static int numberSelector(String command, Scanner commandModifier, String prompt) {
		do {
			System.out.println(prompt);
			command = commandModifier.next();
		}
		while(!isNumeric(command));
		//Past this point, command is at least a number
		double commandDouble = Double.parseDouble(command);
		int selection;
		if (commandDouble == Math.floor(commandDouble))
			selection = (int) commandDouble;
		else 
			selection = numberSelector(command, commandModifier, prompt);
		//past this point, command is at least an integer
		if ((selection < 0) || (selection > 4))
			selection = numberSelector(command, commandModifier, prompt);
		//past this point command is a valid integer between 0 and 4
		return selection;
	}
	
	
	public static void main(String[] args) {
		
		
		/**
		 * Welcomes the user to the program, shows them the program's available functions, and prompts them for input
		 */
		String menu = ("********************************************** \n"
				+ "Happy Pets Animal Hospital \n"
				+ "********************************************** \n"
				+ "Please select from the following menu options \n"
				+ "1) Print total patient count \n"
				+ "2) Print a list of patients by type \n"
				+ "3) Search for a pet by name \n"
				+ "4) Search for a pet by ID \n"
				+ "0) Exit \n"
				+ "Please enter a selection:" );
		
		/**
		 * Contains the values that the user entered. Can be letters, numbers, etc.
		 */
		Scanner userInput = new Scanner(System.in);
		
		/**
		 * String that is later used in the numberSelector and isNumeric methods so that it may be parsed into numbers.
		 */
		String command = null;
		
		choice = numberSelector(command, userInput, menu);
		
		/**
		 * This switch statement creates Printer objects and calls Printer methods based on the value of the user's choice
		 */
		do {
		switch (choice) {
		case 0: //exits the program
				System.exit(0);
		case 1: //print total patient count
				Printer patientCount = new Printer();
				patientCount.printPatientCount();
				break;
		case 2: //print list of patients by type
				Printer typePrinter = new Printer();
				typePrinter.printByType();
				break;
		case 3: //search for a pet by pet name
				Printer nameSearcher = new Printer();
				nameSearcher.searchByName();
				break;
		case 4: //search for a pet by ID
				Printer IDSearcher = new Printer();
				IDSearcher.searchByID();
				break;
		default: choice=numberSelector(command, userInput, menu);
				break; 
		}
		choice = numberSelector(command, userInput, menu);
		}
		while (choice != 0);
		
		
	}

}
