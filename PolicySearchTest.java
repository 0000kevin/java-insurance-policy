/**
 * 
 */
package insurancePolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import insurancyPolicy.MotorPolicy;
import insurancyPolicy.MotorType;
import insurancyPolicy.Policy;
import insurancyPolicy.PolicySearch;

/**
 * Tests the search methods in the Policy Search class
 * 
 * @author Kevin O'Shea 40348252
 *
 */
class PolicySearchTest {
	// Set up test ArrayLists & data
	ArrayList<Policy> policies = new ArrayList<Policy>();
	ArrayList<MotorPolicy> motorPolicies = new ArrayList<MotorPolicy>();
	ArrayList<Policy> nullPolicy = new ArrayList<Policy>();
	ArrayList<MotorPolicy> nullMotorPolicies = new ArrayList<MotorPolicy>();

	MotorPolicy mp1, mp2, mp3, mp4;

	// test vars for search by age
	int lowerAgeRangeValid, upperAgeRangeValid, lowerAgeRangeInvalid, upperAgeRangeInvalid;

	// test var for search by motor type
	MotorType motorType;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// create test data
		mp1 = new MotorPolicy("ValidSurname1", 18, MotorType.BUS);
		mp2 = new MotorPolicy("ValidSurname2", 21, MotorType.CAR);
		mp3 = new MotorPolicy("ValidSurname3", 31, MotorType.TAXI);
		mp4 = new MotorPolicy("ValidSurname4", 41, MotorType.BUS);

		lowerAgeRangeValid = 20;
		upperAgeRangeValid = 30;
		lowerAgeRangeInvalid = 30;
		upperAgeRangeInvalid = 20;

		motorType = MotorType.BUS;

		policies.add(mp1);
		policies.add(mp2);
		policies.add(mp3);
		policies.add(mp4);

		motorPolicies.add(mp1);
		motorPolicies.add(mp2);
		motorPolicies.add(mp3);
		motorPolicies.add(mp4);
	}

	/**
	 * Test method for
	 * {@link insurancyPolicy.PolicySearch#searchByAge(java.util.ArrayList, int, int)}.
	 * Tests the search by age method with a valid ArrayList and valid age ranges.
	 */
	@Test
	void testSearchByAgeValid() {
		ArrayList<Policy> policiesByAge = PolicySearch.searchByAge(policies, lowerAgeRangeValid, upperAgeRangeValid);

		assertTrue(policiesByAge.size() == 1 && policiesByAge.contains(mp2));
	}

	/**
	 * Test method for
	 * {@link insurancyPolicy.PolicySearch#searchByAge(java.util.ArrayList, int, int)}.
	 * Tests the exception thrown for the search by age method with an invalid age range
	 */
	@Test
	void testSearchByAgeInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayList<Policy> policiesByAge = PolicySearch.searchByAge(policies, lowerAgeRangeInvalid,
					upperAgeRangeInvalid);
		});
	}

	/**
	 * Test method for
	 * {@link insurancyPolicy.PolicySearch#searchForAllByMotorPolicyType(java.util.ArrayList, insurancyPolicy.MotorType)}.
	 * Tests the search by motor type with a valid ArrayList and motor type ENUM.
	 */
	@Test
	void testSearchForAllByMotorPolicyType() {
		ArrayList<MotorPolicy> motorPoliciesByMotorType = PolicySearch.searchForAllByMotorPolicyType(motorPolicies,
				motorType);

		assertTrue(motorPoliciesByMotorType.size() == 2 && motorPoliciesByMotorType.contains(mp1)
				&& motorPoliciesByMotorType.contains(mp4));
	}

	/**
	 * Tests the exceptions thrown when search methods are used on an empty
	 * ArrayList
	 */
	@Test
	void testSearchMethodsWithNullArrayLists() {
		assertThrows(NullPointerException.class, () -> {
			ArrayList<Policy> policiesByAge = PolicySearch.searchByAge(nullPolicy, lowerAgeRangeValid,
					upperAgeRangeValid);
		});

		assertThrows(NullPointerException.class, () -> {
			ArrayList<MotorPolicy> motorPoliciesByMotorType = PolicySearch
					.searchForAllByMotorPolicyType(nullMotorPolicies, motorType);
		});
	}

}
