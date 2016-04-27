import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the NameDropper class.
 * 
 * @author Ryan Matthys, updated by David Mutchler. Created March 12, 2009,
 *         updated December 4, 2009.
 */
public class NameDropperTest {
	private NameDropper nameDropper;
	
	/**
	 * Runs before each test, constructing for each test three new NameDropper's
	 * to use. One drops the default name ("Madonna"), another drops
	 * "BillyBobJoe", and the third drops a String with special characters and
	 * spaces.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.nameDropper = new NameDropper();
	}

	/**
	 * Test method for {@link NameDropper#transform(java.lang.String)}. Tests that a
	 * short String drops the right name.
	 */
	@Test
	public void testShortString() {
		assertEquals("Madonna says Give 'em Hell!", this.nameDropper
				.transform("Give 'em Hell!"));
	}

	/**
	 * Test method for {@link NameDropper#transform(java.lang.String)}. Tests that
	 * special characters are left unchanged.
	 */
	@Test
	public void testSpecialCharacters() {
		assertEquals("Madonna says this is 123!", this.nameDropper
				.transform("this is 123!"));

		String special = "h333Ll0 *!@#$%^&*()_+{}|:\"<>?[]\\;',./1234567890-=qwerty";
		String specialDropped = "Madonna says h333Ll0 *!@#$%^&*()_+{}|:\"<>?[]\\;',./1234567890-=qwerty";

		assertEquals(specialDropped, this.nameDropper.transform(special));
	}

	/**
	 * Test method for {@link NameDropper#transform(java.lang.String)}. Tests that an
	 * empty string stays that way.
	 */
	@Test
	public void testEmptyString() {
		assertEquals("Madonna says ", this.nameDropper.transform(""));
	}

	/**
	 * Test method for {@link NameDropper#transform(java.lang.String)}. Tests that
	 * NameDropper works correctly with a very long String.
	 */
	@Test
	public void testLongString() {
		int stringLength = 1000000; // Should be an even number. One million.

		char[] longStringOfAsterisksAndAs = new char[stringLength];

		for (int k = 0; k < stringLength / 2; k += 2) {
			longStringOfAsterisksAndAs[k] = '*';
			longStringOfAsterisksAndAs[k + 1] = 'a';
		}

		String longString = new String(longStringOfAsterisksAndAs);

		assertEquals("Madonna says " + longString, this.nameDropper
				.transform(longString));
	}
}
