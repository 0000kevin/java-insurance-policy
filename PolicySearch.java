/**
 * 
 */
package insurancyPolicy;

import java.util.ArrayList;

/**
 * This class supports search methods for policies in the system.
 * 
 * @author Kevin O'Shea 40348252
 *
 */
public class PolicySearch {

	/**
	 * This method searches through a given ArrayList of policies, for policies in a
	 * given age range of specified values. Returns an ArrayList of results. Throws
	 * an exception is the ArrayList is null or if the Age Range is
	 * invalid(i.e. ageLower>ageUpper).
	 * 
	 * @param policies - ArrayList to be searched through
	 * @param ageLower - Lower end of age range (inclusive), must be less than
	 *                 ageUpper
	 * @param ageUpper - Upper end of age range (inclusive), must be greater than
	 *                 ageLower
	 * @return an ArrayList of the search results
	 * @throws NullPointerException
	 */
	public static ArrayList<Policy> searchByAge(ArrayList<Policy> policies, int ageLower, int ageUpper)
			throws IllegalArgumentException, NullPointerException {
		// Policy type used for ArrayList here so it can be used across all Policy subclasses in the system
		ArrayList<Policy> resultsByAge = new ArrayList<Policy>();
		// check that ArrayList is not empty and age range is valid
		if (!policies.isEmpty() && ageLower < ageUpper) {
			for (Policy policy : policies) {
				if (policy.getAge() >= ageLower && policy.getAge() <= ageUpper) {
					resultsByAge.add(policy);
				}
			}
			return resultsByAge;
		} else if (ageLower > ageUpper) {
			throw new IllegalArgumentException("INVALID AGE RANGE");
		} else {
			throw new NullPointerException("ARRAY LIST IS NULL");
		}
	}

	/**
	 * This method searches through a given ArrayList of MotorPolicies, for policies
	 * with a specified Motor Type. Returns an ArrayList of results. Throws
	 * exception if ArrayList is null.
	 * 
	 * @param motorPolicies - ArrayList to be searched through
	 * @param motorType     - MotorType to search for
	 * @return an ArrayList of the search results
	 * @throws NullPointerException
	 */
	public static ArrayList<MotorPolicy> searchForAllByMotorPolicyType(ArrayList<MotorPolicy> motorPolicies,
			MotorType motorType) throws NullPointerException {
		// MotorPolicy used here since it's specific to that class
		ArrayList<MotorPolicy> resultsByMotorType = new ArrayList<MotorPolicy>();
		// check that ArrayList is not empty
		if (!motorPolicies.isEmpty()) {
			for (MotorPolicy motorPolicy : motorPolicies) {
				if (motorPolicy.getMotorType() == motorType) {
					resultsByMotorType.add(motorPolicy);
				}
			}
			return resultsByMotorType;
		} else {
			throw new NullPointerException("ARRAY LIST IS NULL");
		}
	}

}
