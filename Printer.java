import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Antonio Decastro <acd005@mcdaniel.edu>
 *
 */

/**
 * 
 * This class contains all the methods that make HappyPets.java work
 *
 */
public class Printer {
	
	/**
	 * File containing the information on all the birds currently in Happy Pets Animal Hospital
	 */
	File birdsFile = new File("birds.txt");
	
	/**
	 * File containing the information on all the cats currently in Happy Pets Animal Hospital
	 */
	File catsFile = new File("cats.txt");
	
	/**
	 * File containing the information on all the dogs currently in Happy Pets Animal Hospital
	 */
	File dogsFile = new File("dogs.txt");
	
	/**
	 * Scanner object that makes the information in birdsFile usable
	 */
	private Scanner birdScanner;
	
	/**
	 * Scanner object that makes the information in catsFile usable
	 */
	private Scanner catScanner;
	
	/**
	 * Scanner object that makes the information in dogsFile usable
	 */
	private Scanner dogScanner;
	
	
	/**
	 * isNumeric method: <br />
	 * This method makes sure the input is actually a number
	 * <p>this same method is present in the HappyPets class
	 * 
	 * @param testString String that may or may not be a number
	 * @return			 true if the string contains a single numeric value and nothing else, otherwise false
	 */
	public boolean isNumeric(String str){  
		try {  
			double d = Double.parseDouble(str);  
		}  
	 	catch(NumberFormatException nfe) {  
	 		return false;  
	 	}  
	 	return true;  
	}
	
	
	/**
	 * Printer method: <br />
	 * Class constructor that instantiates the birdScanner, catScanner, and dogScanner objects and links them to the appropriate files
	 * 
	 * @exception FileNotFoundException 		If any of the pet files are not present, exits the program entirely after letting you know which one is missing
	 */
	public Printer() {
		birdScanner = null;
		try {
			birdScanner = new Scanner(birdsFile);
		} 
		catch (FileNotFoundException e) {
			System.err.print("Error. Birds file not Found. Ensure all appropriate files are loaded");
			System.exit(-1);
		}
		
		catScanner = null;
		try {
			catScanner = new Scanner(catsFile);
		} 
		catch (FileNotFoundException e) {
			System.err.print("Error. Cats file not Found. Ensure all appropriate files are loaded");
			System.exit(-2);
		}
		
		dogScanner = null;
		try {
			dogScanner = new Scanner(dogsFile);
		} 
		catch (FileNotFoundException e) {
			System.err.print("Error. Dogs file not Found. Ensure all appropriate files are loaded");
			System.exit(-3);
		}
	}
	
	
	/**
	 * reset method: <br />
	 * 
	 * This method is used within other methods. Once those methods iterate through the pet scanner objects, this method makes the objects usable again.
	 * <p>The body is identical to the class constructor
	 * 
	 * @exception FileNotFoundException 		If any of the pet files are not present, exits the program entirely after letting you know which one is missing
	 */
	public void reset() {
		birdScanner = null;
		try {
			birdScanner = new Scanner(birdsFile);
		} 
		catch (FileNotFoundException e) {
			System.err.print("Error. Birds file not Found. Ensure all appropriate files are loaded");
			System.exit(-1);
		}
		
		catScanner = null;
		try {
			catScanner = new Scanner(catsFile);
		} 
		catch (FileNotFoundException e) {
			System.err.print("Error. Cats file not Found. Ensure all appropriate files are loaded");
			System.exit(-2);
		}
		
		dogScanner = null;
		try {
			dogScanner = new Scanner(dogsFile);
		} 
		catch (FileNotFoundException e) {
			System.err.print("Error. Dogs file not Found. Ensure all appropriate files are loaded");
			System.exit(-3);
		}
	}
	
	
	/**
	 * printPatientCount method: <br />
	 * 
	 * Prints out the total number of patients as wells as the number of patients of each species
	 */
	public void printPatientCount() {
		int totalCount = 0;
		int birdCount = 0;
		int catCount = 0;
		int dogCount = 0;
		
		while(birdScanner.hasNextLine()) {
			birdScanner.nextLine();
			++totalCount;
			++birdCount;
		}
		
		while(catScanner.hasNextLine()) {
			catScanner.nextLine();
			++totalCount;
			++catCount;
		}
		
		while(dogScanner.hasNextLine()) {
			dogScanner.nextLine();
			++totalCount;
			++dogCount;
		}
		
		System.out.println("Total Patients: " + totalCount);
		System.out.println("\t Dogs: " + dogCount);
		System.out.println("\t Cats: " + catCount);
		System.out.println("\t Birds: " + birdCount);
	}
	
	
	/**
	 * birdPrinter method: <br />
	 * 
	 * Uses the birdScanner object to read through the birds.txt file. 
	 * Uses the information in each line of the file to make a Bird.java object, then prints out all the information of that object in a readable format.
	 */
	public void birdPrinter() {
		int patientNum = 1;
		
		while(birdScanner.hasNextLine()) {
			String scannerEntry = birdScanner.nextLine();
			System.out.println("Patient #" + patientNum);
			Bird patient = new Bird(scannerEntry);
			patient.printBirdFields();
			patientNum++;
		}
	}
	
	
	/**
	 * catPrinter method: <br />
	 * 
	 * Uses the catScanner object to read through the cats.txt file. 
	 * Uses the information in each line of the file to make a Cat.java object, then prints out all the information of that object in a readable format.
	 */
	public void catPrinter() {
		int patientNum = 1;
		while(catScanner.hasNextLine()) {
			String scannerEntry = catScanner.nextLine();
			System.out.println("Patient #" + patientNum);
			Cat patient = new Cat(scannerEntry);
			patient.printCatFields();
			patientNum++;
		}
	}
	
	
	/**
	 * dogPrinter method: <br />
	 * 
	 * Uses the dogScanner object to read through the birds.txt file. 
	 * Uses the information in each line of the file to make a Bird.java object, then prints out all the information of that object in a readable format.
	 */
	public void dogPrinter() {
		int patientNum = 1;
		while(dogScanner.hasNextLine()) {
			String scannerEntry = dogScanner.nextLine();
			System.out.println("Patient #" + patientNum);
			Dog patient = new Dog(scannerEntry);
			patient.printDogFields();
			patientNum++;
		}
	}
	
	
	/**
	 * printByType method: <br />
	 * 
	 * Asks the user what type of pet they want to review the records of, the prints the information of all the pets of that type.
	 */
	public void printByType(){
		System.out.println("What type of pet would you like to list (Dog, Cat, or Bird)? ");
		
		Scanner scan = new Scanner(System.in);
		String type = scan.next();
		type = type.toUpperCase();
		
		switch(type) {
		case "DOG": dogPrinter();
					break;
		case "CAT": catPrinter();
					break;
		case "BIRD": birdPrinter();
					 break;
		default: printByType();
				 break;
		}
	}
	
	
	/**
	 * searchByName method: <br />
	 * 
	 * Asks the user for a pet name, then checks all the pet text files if a pet with that name exists. 
	 * If there is a record of a pet with that name, this method prints out the information of that pet. 
	 * If no such pet exists, rests the pet Scanner objects and prompts the user to enter a new name to search for.
	 */
	public void searchByName() {
		System.out.println("What is the name of the pet?");
		Scanner nameScan = new Scanner(System.in);
		String name = nameScan.nextLine();
		name = name.toUpperCase().trim();
		boolean isPresent = false;
		
		while(dogScanner.hasNextLine()) {
			String scannerEntry = dogScanner.nextLine();
			Dog patient = new Dog(scannerEntry);
			if (patient.isNamePresent(name)) {
				isPresent = true;
				patient.printDogFields();
			}
		}
		
		while(catScanner.hasNextLine()) {
			String scannerEntry = catScanner.nextLine();
			Cat patient = new Cat(scannerEntry);
			if (patient.isNamePresent(name)) {
				isPresent = true;
				patient.printCatFields();
			}
		}
		
		while(birdScanner.hasNextLine()) {
			String scannerEntry = birdScanner.nextLine();
			Bird patient = new Bird(scannerEntry);
			if (patient.isNamePresent(name)) {
				isPresent = true;
				patient.printBirdFields();
			}
		}
		
		if(isPresent == false) {
			System.out.println("Record not found");
			reset();
			searchByName();
		}
	}
	
	
	/**
	 * searchByID method: <br />
	 * 
	 * Asks the user for a pet's ID number, then checks all the pet text files if a pet with that ID exists. 
	 * If there is a record of a pet with that ID, this method prints out the information of that pet. 
	 * If no such pet exists, resets the pet Scanner objects and prompts the user to enter a new ID to search for.
	 * 
	 * @exception InputMismatchException 		If the user inputs a decimal, non-numeric String, or other non-decimal value, skips to the end of the method and asks for new ID.
	 */
	public void searchByID() {
		String query = "What is the ID of the pet?";
		System.out.println(query);
		Scanner IDScan = new Scanner(System.in);
		int ID = 0;
		
		try {
			ID = IDScan.nextInt();
		}
		catch (InputMismatchException mismatch) {
			System.err.println("Input mismatch. Input must be integer");
			ID=0;
		}
	
		boolean isPresent = false;
		
		while(dogScanner.hasNextLine()) {
			String scannerEntry = dogScanner.nextLine();
			Dog patient = new Dog(scannerEntry);
			if (patient.isIDPresent(ID)) {
				isPresent = true;
				patient.printDogFields();
			}
		}
		
		while(catScanner.hasNextLine()) {
			String scannerEntry = catScanner.nextLine();
			Cat patient = new Cat(scannerEntry);
			if (patient.isIDPresent(ID)) {
				isPresent = true;
				patient.printCatFields();
			}
		}
		
		while(birdScanner.hasNextLine()) {
			String scannerEntry = birdScanner.nextLine();
			Bird patient = new Bird(scannerEntry);
			if (patient.isIDPresent(ID)) {
				isPresent = true;
				patient.printBirdFields();
			}
		}
		
		if(isPresent == false) {
			System.out.println("Record not found");
			reset();
			searchByID();
		}
	}
}
