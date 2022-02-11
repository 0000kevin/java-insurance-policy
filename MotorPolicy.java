/**
 * 
 */
package insurancyPolicy;

import java.util.Calendar;

/**
 * This class represents a Motor Policy in the system, it extends the Policy
 * abstract superclass.
 * 
 * @author Kevin O'Shea 40348252
 *
 */
public class MotorPolicy extends Policy {
	// motor types stored as ENUMS
	private MotorType motorType;
	// Reference ID made up of first 3 chars of surname, time stamp, & parity
	private String referenceID;

	/**
	 * Default constructor for the Motor Policy
	 */
	public MotorPolicy() {

	}

	/**
	 * Motor Type constructor using arguments, calls on the superclass to set
	 * surname and age.
	 * 
	 * @param surname   - 3-20 chars length (inclusive)
	 * @param age       - 18-50 valid range (inclusive)
	 * @param motorType - ENUM value
	 * @throws IllegalArgumentException
	 */
	public MotorPolicy(String surname, int age, MotorType motorType) throws IllegalArgumentException {
		super(surname, age);
		this.motorType = motorType;
		this.setReferenceID();
	}

	/**
	 * Gets the motor type
	 * 
	 * @return the motorType
	 */
	public MotorType getMotorType() {
		return motorType;
	}

	/**
	 * Sets the motor type
	 * 
	 * @param motorType - the motorType to set
	 */
	public void setMotorType(MotorType motorType) {
		this.motorType = motorType;
	}

	/**
	 * Gets the reference ID
	 * 
	 * @return the referenceID
	 */
	public String getReferenceID() {
		return referenceID;
	}

	/**
	 * Sets the reference ID. Made up of first 3 chars of the surname, time
	 * stamp(year and month), & parity. Format is SURNAME(3 chars),TIME
	 * STAMP,PARITY. Exception thrown if surname is null
	 * 
	 * @param referenceID - the referenceID to set
	 * @throws IllegalArgumentException
	 */
	public void setReferenceID() throws IllegalArgumentException {
		// first check surname is not null
		if (this.getSurname() != null) {
			// generate time stamp numbers
			int year = Calendar.getInstance().get(Calendar.YEAR);
			int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
			// sum of the year and month
			int timeStamp = year + month;
			// if time stamp is even, parity is 0, if it's odd parity is 1
			int parity;
			if (timeStamp % 2 == 0) {
				parity = 0;
			} else {
				parity = 1;
			}
			// create the reference ID based on substring of surname first 3 chars, time stamp and
			// parity as defined above.
			this.referenceID = this.getSurname().substring(0, 3) + timeStamp + parity;
		} else {
			throw new IllegalArgumentException("MISSING SURNAME");
		}
	}

	// NOTE: the display all method below is overridden from the Policy superclass,
	// but if it was more specific to the Motor Policy class alone, it could be set
	// up as an Interface

	/**
	 * Method prints all policy information for the motor policy to the console.
	 * Calls on the super class for surname and age
	 */
	@Override
	public void displayAll() {
		super.displayAll();
		System.out.println("Policy Ref:	" + this.referenceID);
		System.out.println("Motor Type:	" + this.motorType);
	}

}
