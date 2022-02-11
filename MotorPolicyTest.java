/**
 * 
 */
package insurancePolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import insurancyPolicy.MotorPolicy;
import insurancyPolicy.MotorType;

/**
 * Tests the methods and constructors in the Motor Policy Class
 * 
 * @author Kevin O'Shea 40348252
 *
 */
class MotorPolicyTest {
	// Set up test vars
	MotorPolicy mp;
	// Test vars for the surname
	String surnameValidMin, surnameValidMid, surnameValidMax, surnameInvalidShort, surnameInvalidLong;
	// Test vars for the age
	int ageValidLow, ageValidMid, ageValidUpper, ageInvalidLow, ageInvalidUpper;
	// Test vars for the reference ID
	String referenceIDValid;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// Create test data
		mp = new MotorPolicy();

		surnameValidMin = "Val";
		surnameValidMid = "ValidValid";
		surnameValidMax = "ValidValidValidValid";
		surnameInvalidShort = "In";
		surnameInvalidLong = "InvalidInvalidInvalid";

		ageValidLow = 18;
		ageValidMid = 36;
		ageValidUpper = 50;
		ageInvalidLow = 17;
		ageInvalidUpper = 51;

		referenceIDValid = "Val20240";
	}

	/**
	 * Tests Motor Policy Default Constructor
	 */
	@Test
	void testMotorPolicyDefaultConstructor() {
		MotorPolicy mp = new MotorPolicy();
		assertNotNull(mp);
	}

	/**
	 * Tests Motor Policy Constructor with valid arguments
	 */
	@Test
	void testMotorPolicyConstructorWithValidArgs() {
		MotorPolicy mp = new MotorPolicy(surnameValidMid, ageValidMid, MotorType.BUS);
		assertNotNull(mp);
		assertEquals(surnameValidMid, mp.getSurname());
		assertEquals(ageValidMid, mp.getAge());
		assertEquals(MotorType.BUS, mp.getMotorType());
	}

	/**
	 * Tests Motor Policy Constructor with invalid arguments
	 */
	@Test
	void testMotorPolicyConstructorWithInvalidArgs() {
		assertThrows(IllegalArgumentException.class, () -> {
			MotorPolicy mp = new MotorPolicy(surnameInvalidShort, ageValidMid, MotorType.BUS);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			MotorPolicy mp = new MotorPolicy(surnameValidMid, ageInvalidLow, MotorType.BUS);
		});
	}

	/**
	 * Tests valid surname values
	 */
	@Test
	void testGetSetSurnameValid() {
		mp.setSurname(surnameValidMin);
		assertEquals(surnameValidMin, mp.getSurname());
		mp.setSurname(surnameValidMid);
		assertEquals(surnameValidMid, mp.getSurname());
		mp.setSurname(surnameValidMax);
		assertEquals(surnameValidMax, mp.getSurname());
	}

	/**
	 * Tests invalid surname values
	 */
	@Test
	void testGetSetSurnameInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			mp.setSurname(surnameInvalidShort);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			mp.setSurname(surnameInvalidLong);
		});
	}

	/**
	 * Tests valid age values
	 */
	@Test
	void testGetSetAgeValid() {
		mp.setAge(ageValidLow);
		assertEquals(ageValidLow, mp.getAge());
		mp.setAge(ageValidMid);
		assertEquals(ageValidMid, mp.getAge());
		mp.setAge(ageValidUpper);
		assertEquals(ageValidUpper, mp.getAge());
	}

	/**
	 * Tests invalid age values
	 */
	@Test
	void testGetSetAgeInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			mp.setAge(ageInvalidLow);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			mp.setAge(ageInvalidUpper);
		});
	}

	/**
	 * Tests the reference ID is properly created
	 */
	@Test
	void testGetSetReferenceIDValid() {
		MotorPolicy mp = new MotorPolicy(surnameValidMid, ageValidMid, MotorType.BUS);
		assertEquals(referenceIDValid, mp.getReferenceID());
	}

	/**
	 * Tests the exception is thrown when the surname is missing for the reference
	 * ID
	 */
	@Test
	void testGetSetReferenceIDInvalid() {
		MotorPolicy mp = new MotorPolicy();
		assertThrows(IllegalArgumentException.class, () -> {
			mp.setReferenceID();
		});
	}

}
