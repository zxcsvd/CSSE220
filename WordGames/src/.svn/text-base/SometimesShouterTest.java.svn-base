import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the SometimesShouter class.
 * 
 * @author Ryan Matthys, updated by David Mutchler. Created March 12, 2009,
 *         updated December 4, 2009.
 */
public class SometimesShouterTest {
	private SometimesShouter shoutEveryTwo;
	private SometimesShouter shoutEveryFive;

	/**
	 * Runs before each test, constructing for each test two SometimesShouters:
	 * one that shouts every other time (the default) and another that shouts
	 * every 5th time.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.shoutEveryTwo = new SometimesShouter();
		this.shoutEveryFive = new SometimesShouter(5);
	}

	/**
	 * Test method for {@link SometimesShouter#transform(java.lang.String)}.
	 * Tests that a default SometimesShouter does short Strings correctly.
	 */
	@Test
	public void testDefaultShoutValue() {
		assertEquals("Hello", this.shoutEveryTwo.transform("Hello"));
		assertEquals("HELLO", this.shoutEveryTwo.transform("Hello"));
		assertEquals("Hello", this.shoutEveryTwo.transform("Hello"));
		assertEquals("HELLO", this.shoutEveryTwo.transform("Hello"));
		assertEquals("Hello", this.shoutEveryTwo.transform("Hello"));
		assertEquals("HELLO", this.shoutEveryTwo.transform("Hello"));
	}

	/**
	 * Test method for {@link SometimesShouter#transform(java.lang.String)}.
	 * Tests that a non-default SometimesShouter does short Strings correctly.
	 */
	@Test
	public void testNonDefaultShoutValue() {
		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("HELLO", this.shoutEveryFive.transform("Hello"));

		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("HELLO", this.shoutEveryFive.transform("Hello"));

		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("HELLO", this.shoutEveryFive.transform("Hello"));
	}

	/**
	 * Test method for {@link SometimesShouter#transform(java.lang.String)}.
	 * Tests that empty Strings are handled correctly, even after many calls.
	 */
	@Test
	public void testEmptyStrings() {
		for (int k = 0; k < 10000; ++k) {
			assertEquals("", this.shoutEveryTwo.transform(""));
			assertEquals("", this.shoutEveryFive.transform(""));
		}
	}

	/**
	 * Test method for {@link SometimesShouter#transform(java.lang.String)}.
	 * Tests that Strings are handled correctly, even after many calls.
	 */
	@Test
	public void testManyCalls() {
		int numberOfCalls = 1000000;	// One million.
		
		for (int k = 0; k < numberOfCalls; ++k) {
			this.shoutEveryTwo.transform("hello there");
			this.shoutEveryFive.transform("hello there");
		}
		
		// The following assumes that the above loop "reset" the SometimesShouters back to their start state.
		this.testDefaultShoutValue();
		this.testNonDefaultShoutValue();
	}
	
	/**
	 * Test method for {@link SometimesShouter#transform(java.lang.String)}. Tests that two
	 * SometimesShouter's work independently.
	 */
	@Test
	public void testIndependantSometimers() {
		assertEquals("Hello", this.shoutEveryTwo.transform("Hello"));
		assertEquals("HELLO", this.shoutEveryTwo.transform("Hello"));
		assertEquals("Hello", this.shoutEveryTwo.transform("Hello"));
		assertEquals("HELLO", this.shoutEveryTwo.transform("Hello"));
		assertEquals("Hello", this.shoutEveryTwo.transform("Hello"));
		
		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("HELLO", this.shoutEveryFive.transform("Hello"));
		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		
		assertEquals("HELLO", this.shoutEveryTwo.transform("Hello"));
		assertEquals("Hello", this.shoutEveryTwo.transform("Hello"));
		assertEquals("HELLO", this.shoutEveryTwo.transform("Hello"));
		assertEquals("Hello", this.shoutEveryTwo.transform("Hello"));
		assertEquals("HELLO", this.shoutEveryTwo.transform("Hello"));

		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("Hello", this.shoutEveryFive.transform("Hello"));
		assertEquals("HELLO", this.shoutEveryFive.transform("Hello"));
	}
}
