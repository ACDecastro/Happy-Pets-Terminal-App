/**
 * 
 * @author Antonio Decastro <acd005@mcdaniel.edu>
 *
 */

/**
 * 
 * This class creates and modifies Bird objects, which extend the Pet class
 *
 */
public class Bird extends Pet{
	
	/**
	 * Bird method: <br />
	 * Adds to the constructor from Pet.java by setting the unique flies and fowl attributes
	 * Class constructor 
	 * @param scannerEntry 		String from a line from birds.txt
	 */
	public Bird(String scannerEntry) {
		super(scannerEntry);
		
		String flies = petInfo.get(6);
		if(flies.toUpperCase().equals("TRUE"))
			setFlies(true);
		else if(flies.toUpperCase().equals("FALSE"))
			setFlies(false);
		else {
			System.err.println("Not a valid entry for bird's flying status. Must be true or false");
		}
		
		String fowl = petInfo.get(7);
		if(fowl.toUpperCase().equals("TRUE"))
			setFowl(true);
		else if(fowl.toUpperCase().equals("FALSE"))
			setFowl(false);
		else {
			System.err.println("Not a valid entry for bird's fowl status. Must be true or false.");
		}
	}
	
	
	protected boolean flies;
	protected boolean fowl;
	
	
	/**
	 * setFlies method: <br />
	 * Sets the value of flies attribute
	 * @param woosh 		boolean value that determines the value of flies attribute
	 */
	public void setFlies(boolean woosh) {
		flies = woosh;
	}
	
	
	/**
	 * setFowl method: <br />
	 * Sets the value of the fowl attribute
	 * @param fwl 		boolean value that determines the value of the fowl attribute
	 */
	public void setFowl(boolean fwl) {
		fowl = fwl;
	}
	
	
	/**
	 * getFlies method: <br />
	 * Returns value of this bird's flies attribute
	 * @return 		boolean value of flies attribute
	 */
	public boolean getFlies() {
		return flies;
	}
	
	
	/**
	 * getFowl method: <br />
	 * Returns value of this bird's fowl attribute
	 * @return 		boolean value of fowl attribute
	 */
	public boolean getFowl() {
		return fowl;
	}
	
	
	/**
	 * printBirdFields method: <br />
	 * Prints the string from the printFields method from Pet.java as well as the values of the flies and fowl attributes
	 */
	public void printBirdFields() {
		System.out.println(printFields()
				+ "Able to Fly: " + getFlies() +"\n"
				+ "Fowl: " + getFowl() + "\n");		
	}

}
