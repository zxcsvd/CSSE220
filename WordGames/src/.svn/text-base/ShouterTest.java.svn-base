import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Shouter class.
 * 
 * @author Ryan Matthys, updated by David Mutchler. Created March 12, 2009,
 *         updated December 4, 2009.
 */
public class ShouterTest {
	private Shouter shouter;

	/**
	 * Runs before each test, constructing for each test a new Shouter to use.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.shouter = new Shouter();
	}

	/**
	 * Test method for {@link Shouter#transform(java.lang.String)}. Tests that a
	 * string in all upper case stays that way.
	 */
	@Test
	public void testAllUpperCase() {
		String upperCase = "CAPS LOCK IS CRUISE CONTROL";

		assertEquals(upperCase, this.shouter.transform(upperCase));
	}

	/**
	 * Test method for {@link Shouter#transform(java.lang.String)}. Tests that a
	 * string in all lower case turns to all upper case.
	 */
	@Test
	public void testAllLowercase() {
		String lowerCase = "caps lock is cruise control";
		String upperCase = "CAPS LOCK IS CRUISE CONTROL";

		assertEquals(upperCase, this.shouter.transform(lowerCase));
	}

	/**
	 * Test method for {@link Shouter#transform(java.lang.String)}. Tests that
	 * an empty string stays that way.
	 */
	@Test
	public void testEmptyString() {
		assertEquals("", this.shouter.transform(""));
	}

	/**
	 * Test method for {@link Shouter#transform(java.lang.String)}. Tests that
	 * Shouter works correctly with a very long String.
	 */
	@Test
	public void testLongString() {
		int stringLength = 1000000; // Should be an even number. One million.

		char[] longStringOfMixedCase = new char[stringLength];
		char[] longStringOfUpperCase = new char[stringLength];

		for (int k = 0; k < stringLength / 2; k += 2) {
			longStringOfMixedCase[k] = 'x'; // note lower case
			longStringOfMixedCase[k + 1] = 'X';

			longStringOfUpperCase[k] = 'X';
			longStringOfUpperCase[k + 1] = 'X';
		}

		String mixedCase = new String(longStringOfMixedCase);
		String upperCase = new String(longStringOfUpperCase);

		assertEquals(upperCase, this.shouter.transform(mixedCase));
	}

	/**
	 * Test method for {@link Shouter#transform(java.lang.String)}. Tests
	 * that special characters are left unchanged.
	 */
	@Test
	public void testSpecialCharacters() {
		assertEquals("THIS IS 123!", this.shouter.transform("this is 123!"));
		assertEquals("H3LL0 TH3R3", this.shouter.transform("h3lL0 th3R3"));

		String special = "h333Ll0 *!@#$%^&*()_+{}|:\"<>?[]\\;',./1234567890-=qwerty";
		String specialShouted = "H333LL0 *!@#$%^&*()_+{}|:\"<>?[]\\;',./1234567890-=QWERTY";

		assertEquals(specialShouted, this.shouter.transform(special));
	}
}
