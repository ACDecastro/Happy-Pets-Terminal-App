/**
 * 
 * @author Antonio Decastro <acd005@mcdaniel.edu>
 *
 */

/**
 * 
 * This class creates and modifies Cat objects, which extend the Pet class
 *
 */
public class Cat extends Pet{
	
	private boolean houseCat;
	
	
	/**
	 * Cat method: <br />
	 * Adds to the constructor from Pet.java by setting the unique houseCat attribute
	 * Class constructor 
	 * @param scannerEntry 		String from a line from cats.txt
	 */
	public Cat(String scannerEntry) {
		super(scannerEntry);
		String house = petInfo.get(6);
		if(house.toUpperCase().equals("TRUE"))
			setHouseCat(true);
		else if(house.toUpperCase().equals("FALSE"))
			setHouseCat(false);
		else {
			System.err.println("Not a valid entry for cat's housebroken status. Must be true or false.");
		}
	}
	
	
	/**
	 * isHouseCat method: <br />
	 * Returns value of this cat's houseCat attribute
	 * @return 		boolean value of houseCat attribute
	 */
	public boolean isHouseCat() {
		return houseCat;
	}
	
	
	/**
	 * setHouseCat: <br />
	 * Sets the value of the houseCat attribute
	 * @param tame 		boolean value that determines the value of the houseCat attribute
	 */
	public void setHouseCat(boolean tame) {
		houseCat = tame;
	}
	
	
	/**
	 * printCatFields method: <br />
	 * Prints the string from the printFields method from Pet.java as well as the value of the houseCat attribute
	 */
	public void printCatFields() {
		System.out.println(printFields()
				+"House Cat?: " + isHouseCat() +"\n");
	}

}
