import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Repeater class.
 * 
 * @author Ryan Matthys, updated by David Mutchler. Created March 12, 2009,
 *         updated December 4, 2009.
 */
public class RepeaterTest {
	private Repeater repeater;

	/**
	 * Runs before each test, constructing for each test a Repeater.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.repeater = new Repeater();
	}

	/**
	 * Test method for {@link Repeater#transform(java.lang.String)}. Tests that
	 * a Repeater does short Strings correctly, even if repeated.
	 */
	@Test
	public void testDefaultShoutValue() {
		assertEquals("HelloHelloHelloHelloHello", this.repeater
				.transform("Hello"));
		assertEquals("HelloHelloHelloHelloHello", this.repeater
				.transform("Hello"));
		assertEquals("HelloHelloHelloHelloHello", this.repeater
				.transform("Hello"));

		assertEquals("bytebytebytebyte", this.repeater.transform("byte"));
		assertEquals("bytebytebytebyte", this.repeater.transform("byte"));
		assertEquals("bytebytebytebyte", this.repeater.transform("byte"));
		assertEquals("bytebytebytebyte", this.repeater.transform("byte"));
		assertEquals("bytebytebytebyte", this.repeater.transform("byte"));
	}

	/**
	 * Test method for {@link Repeater#transform(java.lang.String)}.
	 * Tests that empty Strings are handled correctly, even after many calls.
	 */
	@Test
	public void testEmptyStrings() {
		for (int k = 0; k < 1000000; ++k) {
			assertEquals("", this.repeater.transform(""));
		}
	}

	/**
	 * Test method for {@link Repeater#transform(java.lang.String)}. Tests that
	 * Repeater works correctly with a very long String.
	 */
	@Test
	public void testLongString() {
		int stringLength = 300; // Should be an even number.

		char[] longStringOfMixedCase = new char[stringLength];

		for (int k = 0; k < stringLength / 2; k += 2) {
			longStringOfMixedCase[k] = 'x'; // note lower case
			longStringOfMixedCase[k + 1] = 'X';
		}

		String mixedCase = new String(longStringOfMixedCase);
		String result = "";
		
		for (int k = 0; k < stringLength; ++k) {
			result += mixedCase;
		}
		assertEquals(result, this.repeater.transform(mixedCase));
		assertEquals(result, this.repeater.transform(mixedCase));
		assertEquals(result, this.repeater.transform(mixedCase));
	}

	/**
	 * Test method for {@link Repeater#transform(java.lang.String)}.
	 * Tests that special character Strings are handled correctly.
	 */
	@Test
	public void testSpecialCharacters() {
		assertEquals("!@#$!@#$!@#$!@#$", this.repeater.transform("!@#$"));
	}
}
