import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Antonio Decastro <acd005@mcdaniel.edu>
 *
 */

/**
 * 
 * This is an abstract class that the Bird.java, Cat.java, and Dog.java classes inherit from
 *
 */
public class Pet {


	public enum Genders{ MALE, FEMALE }
	
	/**
	 * Each line of the pet txt files are separated into their individual elements and those elements are added to this ArrayList
	 */
	protected ArrayList<String> petInfo = new ArrayList<>();
	
	protected int ID;
	protected String name;
	protected double weight;
	protected String owner;
	protected Genders gender;
	protected String species;
	
	
	/**
	 * getID method: <br />
	 * Returns an int the ID number of this pet
	 * @return 		int of this pet's ID number
	 */
	public int getID() {
		return ID;
	}
	
	
	/**
	 * getName method: <br />
	 * Returns String of this pet's name
	 * @return 		String of this pet's name
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * getWeight method: <br />
	 * Returns this pet's weight as a double
	 * @return 		Double of this pet's weight
	 */
	public double getWeight() {
		return weight;
	}
	
	
	/**
	 * getOwner method: <br />
	 * Returns String of this pet's owner's name
	 * @return 		String of this pet's owner's name
	 */
	public String getOwner() {
		return owner;
	}
	
	
	/**
	 * getGender method: <br />
	 * Returns gender of this pet as a Genders enum object
	 * @return 		Genders object of this pet's gender
	 */
	public Genders getGender() {
		return gender;
	}
	
	
	/**
	 * getSpecies method: <br />
	 * Returns a String of the name of this pet's species
	 * @return 		String of this pet's species
	 */
	public String getSpecies() {
		return species;
	}
	
	
	
	/**
	 * setID method: <br />
	 * Sets the ID number of this pet
	 * @param id 		int of this pet's ID number
	 */
	public void setID(int id) {
		ID = id;
	}
	
	
	/**
	 * setName method: <br />
	 * Sets the name of this pet
	 * @param monicker 		String of this pet's name
	 */
	public void setName(String monicker) {
		name = monicker;
	}
	
	
	/**
	 * setWeight method: <br />
	 * Sets the weight of this pet
	 * @param heft 		Double of the number of kilograms this pet weighs
	 */
	public void setWeight(double heft) {
		weight = heft;
	}
	
	
	/**
	 * setOwner method: <br />
	 * Sets the name of the owner of this pet
	 * @param human 	String that contains this pet's owner's name
	 */
	public void setOwner(String human) {
		owner = human;
	}
	
	
	/**
	 * setGender method: <br />
	 * Sets the gender of this pet
	 * @param gndr		Genders object that determines this pet's gender
	 */
	public void setGender(Genders gndr) {
		gender = gndr;
	}
	
	
	/**
	 * setSpecies method: <br />
	 * Sets this pet's species
	 * @param specie 	String that describes this pet's species
	 */
	public void setSpecies(String specie) {
		species = specie;
	}
	
	
	/**
	 * determineGender method: <br />
	 * Converts a string into a Genders object
	 * @param gender	A String that determines the gender enum value of this pet
	 * @return 			Genders object of this pet's gender
	 */
	public Genders determineGender(String gender) {
		gender = gender.toUpperCase();
		if (gender.equals("MALE"))
			return Genders.MALE;
		else if (gender.equals("FEMALE"))
			return Genders.FEMALE;
		else {
			System.err.println("This is not a valid entry for pet's gender");
			return null;
		}
	}
	
	
	/**
	 * Class Constructor <br />
	 * <p>Separates each line at the commas and puts the Strings between the commas into an ArrayList that is then used to populate the fields of this pet object.
	 * @param scannerEntry 		String of one line of a pet text file
	 */
	public Pet (String scannerEntry) {
			Scanner entry = new Scanner(scannerEntry);
			entry.useDelimiter(",");
			while(entry.hasNext()) {
				petInfo.add(entry.next());
			}
			entry.close();
			
			int IDNumber = Integer.parseInt(petInfo.get(0));
			setID(IDNumber);
			setName(petInfo.get(1));
			double weight = Double.parseDouble(petInfo.get(2));
			setWeight(weight);
			setOwner(petInfo.get(3));
			setGender(determineGender(petInfo.get(4)));
			setSpecies(petInfo.get(5));
	}
	
	
	/**
	 * printFields method: <br />
	 * 
	 * Provides a string of the first six attributes that all types of pets have in common
	 * @return 		A formatted string the pet's first six attributes
	 */
	public String printFields() {
		return ("ID Number: " + getID() +"\n"
				+ "Name: " + getName() + "\n"
				+ "Weight: " + getWeight() + "kg \n"
				+ "Owner: " + getOwner() + "\n"
				+ "Gender: " + getGender() + "\n"
				+ "Species: " + getSpecies() +"\n");
	}
	
	
	/**
	 * inNamePresent method: <br />
	 * 
	 * Checks to see if the provided name is the same as this particular pet's name. 
	 * <p>Takes into account both whitespace and capitalization.
	 * 
	 * @param searchedName String of the name of a pet that the user is searching for
	 * @return			   true if the name in question is the same as this pet's name, returns false otherwise
	 */
	public boolean isNamePresent(String searchedName) {
		return (this.name.toUpperCase().trim().equals(searchedName));
	}
	
	
	/**
	 * isIDPresent method: <br />
	 * 
	 * Checks to see if the provided ID is the same as this particular pet's name. 
	 * 
	 * @param searchedID int of the ID number of a pet that the user is searching for
	 * @return			 true if the searched ID on question is the same as this pet's ID, returns false otherwise
	 */
	public boolean isIDPresent(int searchedID) {
		return (getID() == searchedID);
	}
}
