import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Doubler class.
 * 
 * @author Ryan Matthys, updated by David Mutchler. Created March 12, 2009,
 *         updated December 4, 2009.
 */
public class DoublerTest {
	private Doubler doubler;

	/**
	 * Runs before each test, constructing for each test a Doubler.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.doubler = new Doubler();
	}

	/**
	 * Test method for {@link Doubler#transform(java.lang.String)}. Tests that a
	 * Doubler does short Strings correctly.
	 */
	@Test
	public void testShortString() {
		assertEquals("Hello Hello", this.doubler.transform("Hello"));
	}

	/**
	 * Test method for {@link Doubler#transform(java.lang.String)}. Tests that a
	 * Doubler does an already-doubled String correctly.
	 */
	@Test
	public void testAlreadyDoubled() {
		assertEquals("Hello Hello Hello Hello", this.doubler
				.transform("Hello Hello"));
	}

	/**
	 * Test method for {@link Doubler#transform(java.lang.String)}. Tests that a
	 * Doubler does an empty String correctly, and continues correctly when
	 * called repeatedly on the result.
	 */
	@Test
	public void testEmptyString() {
		String doubleOnce = this.doubler.transform("");
		String doubleTwice = this.doubler.transform(doubleOnce);
		String doubleThreeTimes = this.doubler.transform(doubleTwice);

		assertEquals(" ", doubleOnce);
		assertEquals("   ", doubleTwice);
		assertEquals("       ", doubleThreeTimes);
	}

	/**
	 * Test method for {@link Doubler#transform(java.lang.String)}. Tests that
	 * special characters are left unchanged.
	 */
	@Test
	public void testSpecialCharacters() {
		assertEquals("!@#$%^&*(){}1234567890[] !@#$%^&*(){}1234567890[]",
				this.doubler.transform("!@#$%^&*(){}1234567890[]"));
	}

	/**
	 * Test method for {@link Doubler#transform(java.lang.String)}. Tests that
	 * Doubler works correctly with a very long String.
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

		assertEquals(mixedCase + " " + mixedCase, this.doubler
				.transform(mixedCase));
	}
}
