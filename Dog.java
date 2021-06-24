/**
 * 
 * @author Antonio Decastro <acd005@mcdaniel.edu>
 *
 */

/**
 * 
 * This class creates and modifies Dog objects, which extend the Pet class
 *
 */
public class Dog extends Pet{
	
	/**
	 * Dog method: <br />
	 * Adds to the constructor from Pet.java by setting the unique houseDog and workingDog attributes
	 * Class constructor 
	 * @param scannerEntry 		String from a line from dogs.txt
	 */
	public Dog(String scannerEntry) {
		super(scannerEntry);
		String house = petInfo.get(6);
		if(house.toUpperCase().equals("TRUE"))
			setHouseDog(true);
		else if(house.toUpperCase().equals("FALSE"))
			setHouseDog(false);
		else {
			System.err.println("Not a valid entry for dog's housebroken status. Must be true or false");
		}
		
		String works = petInfo.get(7);
		if(works.toUpperCase().equals("TRUE"))
			setWorkingDog(true);
		else if(works.toUpperCase().equals("FALSE"))
			setWorkingDog(false);
		else {
			System.err.println("Not a valid entry for dog's working status. Must be true or false");
		}	
	}
	
	
	/**
	 * printDogFields method: <br />
	 * Prints the string from the printFields method from Pet.java as well as the values of the houseDog and workingDog attributes
	 */
	public void printDogFields() {
		System.out.println(printFields()
				+ "House Dog?: " + isHouseDog() +"\n"
				+ "Work Dog?: " + isWorkingDog() + "\n");
	}
	
	protected boolean houseDog;
	protected boolean workingDog;
	
	
	/**
	 * isHouseDog method: <br />
	 * Returns the value of this dog's houseDog attribute
	 * @return 		boolean value of houseDog
	 */
	public boolean isHouseDog() {
		return houseDog;
	}
	
	
	/**
	 * isWorkingDog method: <br />
	 * Returns the value of this dog's workingDog attribute
	 * @return 		boolean value of workingDog
	 */
	public boolean isWorkingDog() {
		return workingDog;
	}
	
	
	/**
	 * setWorkingDog method: <br />
	 * Sets the value of workingDog attribute
	 * @param works 	boolean value that determines statues of workingDog attribute
	 */
	public void setWorkingDog(boolean works) {
		workingDog = works;
	}
	
	
	/**
	 * setHouseDog method: <br />
	 * Sets the value of houseDog attribute
	 * @param housebroken 		boolean value that determines value of houseDog attribute
	 */
	public void setHouseDog(boolean housebroken) {
		houseDog = housebroken;
	}
	

}
