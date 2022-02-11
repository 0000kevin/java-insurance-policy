/**
 * 
 */
package insurancyPolicy;

/**
 * This class represents an abstract policy in the system. It will be extended
 * by other policy types which will use the surname and age instance vars. 
 * 
 * @author Kevin O'Shea 40348252
 *
 */
public abstract class Policy {
	// constants to store values to implement business rules
	private static final int MIN_NAME_LENGTH = 3;
	private static final int MAX_NAME_LENGTH = 20;
	private static final int MIN_AGE = 18;
	private static final int MAX_AGE = 50;

	// Surname: min length 3 chars, max length 20 chars
	private String surname;
	// Age: 18 - 50 inclusive
	private int age;

	/**
	 * Default policy constructor, used to create a Policy.
	 */
	public Policy() {

	}

	/**
	 * Policy constructor using argument, used to create a Policy based on arguments
	 * passed. Will be called by subclasses in their constructors.
	 * 
	 * @param surname - between 3 & 20 chars inclusive
	 * @param age     - between 18 & 50 inclusive
	 * @throws IllegalArgumentException
	 */
	public Policy(String surname, int age) throws IllegalArgumentException {
		this.setSurname(surname);
		this.setAge(age);
	}

	/**
	 * Gets the surname of the policy holder
	 * 
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the surname of the policy holder. Min length 3, max length 20 Exception
	 * thrown for invalid lengths used
	 * 
	 * @param surname - the surname to set, String.
	 * @throws IllegalArgumentException
	 */
	public void setSurname(String surname) throws IllegalArgumentException {
		if (surname.length() >= MIN_NAME_LENGTH && surname.length() <= MAX_NAME_LENGTH) {
			this.surname = surname;
		} else {
			throw new IllegalArgumentException("INVALID SURNAME LENGTH");
		}
	}

	/**
	 * Gets the age of the policy holder
	 * 
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age of the policy holder. Must be between 18 - 50 inclusive
	 * Exception thrown for invalid age ranges
	 * 
	 * @param age - the age to set, int.
	 * @throws IllegalArgumentException
	 */
	public void setAge(int age) throws IllegalArgumentException {
		if (age >= MIN_AGE && age <= MAX_AGE) {
			this.age = age;
		} else {
			throw new IllegalArgumentException("INVALID AGE LENGTH");
		}
	}

	/**
	 * Display All method prints all information for the instance of policy in the console.
	 */
	public void displayAll() {
		System.out.println("Surname:	" + this.surname);
		System.out.println("Age:		" + this.age);
	}

}
