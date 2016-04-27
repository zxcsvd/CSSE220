import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Evener class.
 * 
 * @author Ryan Matthys, updated by David Mutchler. Created March 12, 2009,
 *         updated December 4, 2009.
 */
public class EvenerTest {
	private Evener evener;

	/**
	 * Runs before each test, constructing for each test an Evener.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.evener = new Evener();
	}

	/**
	 * Test method for {@link Evener#transform(java.lang.String)}. Tests that an
	 * Evener does short Strings correctly, even if repeated.
	 */
	@Test
	public void testShortString() {
		assertEquals("oetotrefu 680 **", this.evener
				.transform("one two three four 567890  *****"));
		assertEquals("oetotrefu 680 **", this.evener
				.transform("one two three four 567890  *****"));
		assertEquals("oetotrefu 680 ***", this.evener
				.transform("one two three four 567890  ******"));
		assertEquals("oetotrefu 680 ***", this.evener
				.transform("one two three four 567890  ******"));
	}

	/**
	 * Test method for {@link Evener#transform(java.lang.String)}. Tests that an
	 * Evener does empty Strings correctly, even if repeated.
	 */
	@Test
	public void testStringOfZeroLength() {
		assertEquals("", this.evener.transform(""));
		assertEquals("", this.evener.transform(""));
	}

	/**
	 * Test method for {@link Evener#transform(java.lang.String)}. Tests that an
	 * Evener works correctly with a very long String.
	 */
	@Test
	public void testLongString() {
		int stringLength = 10000; // Should be an even number.
		// Dont' make this too big, since students solutions may be very slow
		// (building up Strings instead of using a character array - we have not
		// done arrays yet).

		char[] longStringOfMixedCase = new char[stringLength];
		char[] answer = new char[stringLength / 2];

		for (int k = 0; k < stringLength / 2; k += 2) {
			longStringOfMixedCase[k] = 'x'; // note lower case
			longStringOfMixedCase[k + 1] = 'X';
			answer[k / 2] = 'x';
		}

		String mixedCase = new String(longStringOfMixedCase);

		assertEquals(new String(answer), this.evener.transform(mixedCase));
	}
}
