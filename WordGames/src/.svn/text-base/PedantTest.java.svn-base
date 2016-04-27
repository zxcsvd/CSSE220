import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Pedant class.
 * 
 * @author Ryan Matthys, updated by David Mutchler. Created March 12, 2009,
 *         updated December 4, 2009.
 */
public class PedantTest {
	private Pedant pedant;

	/**
	 * Runs before each test, constructing for each test a new Pedant to use.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.pedant = new Pedant();
	}

	/**
	 * Test method for {@link Pedant#transform(java.lang.String)}. Tests that
	 * an empty string has only the "Obviously " prefix when transformed.
	 */
	@Test
	public void testEmptyString() {
		assertEquals("Obviously ", this.pedant.transform(""));
	}

	/**
	 * Test method for {@link Pedant#transform(java.lang.String)}. Tests that
	 * a string with "Obviously " gets another one when transformed.
	 */
	@Test
	public void testAlreadyObvious() {
		assertEquals("Obviously Obviously", this.pedant.transform("Obviously"));
	}
	
	/**
	 * Test method for {@link Pedant#transform(java.lang.String)}. Tests
	 * that special characters are left unchanged.
	 */
	@Test
	public void testSpecialCharacters() {
		assertEquals("Obviously this is 123!", this.pedant.transform("this is 123!"));
		assertEquals("Obviously h3lL0 th3R3", this.pedant.transform("h3lL0 th3R3"));

		String special = "h333Ll0 *!@#$%^&*()_+{}|:\"<>?[]\\;',./1234567890-=qwerty";
		String specialObviously = "Obviously h333Ll0 *!@#$%^&*()_+{}|:\"<>?[]\\;',./1234567890-=qwerty";

		assertEquals(specialObviously, this.pedant.transform(special));
	}

	/**
	 * Test method for {@link Pedant#transform(java.lang.String)}. Tests that
	 * Pedant works correctly with a very long String.
	 */
	@Test
	public void testLongString() {
		int stringLength = 1000000; // Should be an even number. One million.

		char[] longStringOfMixedCase = new char[stringLength];

		for (int k = 0; k < stringLength / 2; k += 2) {
			longStringOfMixedCase[k] = 'x'; // note lower case
			longStringOfMixedCase[k + 1] = 'X';
		}

		String mixedCase = new String(longStringOfMixedCase);
		String withObviously = "Obviously " + new String(longStringOfMixedCase);

		assertEquals(withObviously, this.pedant.transform(mixedCase));
	}
}
