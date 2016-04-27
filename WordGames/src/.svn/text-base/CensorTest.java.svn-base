import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Censor class.
 * 
 * @author Ryan Matthys, updated by David Mutchler. Created March 12, 2009,
 *         updated December 4, 2009.
 */
public class CensorTest {
	private Censor censorEvery_e;
	private Censor censorEvery_a;

	/**
	 * Runs before each test, constructing for each test two new Censor's to
	 * use. One censors the default character ('e') and the other censors an
	 * 'a'.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.censorEvery_e = new Censor();
		this.censorEvery_a = new Censor('a');
	}

	/**
	 * Test method for {@link Censor#transform(java.lang.String)}. Tests that a
	 * string of all 'e's turns into all '*'s.
	 */
	@Test
	public void testAllCensorCharacters() {

		assertEquals("********** **********", this.censorEvery_e
				.transform("eeeeeeeeee eeeeeeeeee"));
	}

	/**
	 * Test method for {@link Censor#transform(java.lang.String)}. Tests that a
	 * string with no 'e's stays unchanged.
	 */
	@Test
	public void testNoCensorCharacters() {
		assertEquals("No charactErs to Transform", this.censorEvery_e
				.transform("No charactErs to Transform"));
	}

	/**
	 * Test method for {@link Censor#transform(java.lang.String)}. Tests that a
	 * string that includes 'a's turns every 'a' into an '*'.
	 */
	@Test
	public void testCensoringAn_a() {
		assertEquals("*re *ny occurrences of * in this", this.censorEvery_a
				.transform("are any occurrences of a in this"));
	}

	/**
	 * Test method for {@link Censor#transform(java.lang.String)}. Tests that a
	 * string that includes upper and lower case e's transforms only the lower
	 * case ones.
	 */
	@Test
	public void testUpperAndLowerCase() {
		assertEquals("capital E's should r*main", this.censorEvery_e
				.transform("capital E's should remain"));
	}

	/**
	 * Test method for {@link Censor#transform(java.lang.String)}. Tests
	 * that special characters are left unchanged.
	 */
	@Test
	public void testSpecialCharacters() {
		assertEquals("this is 123!", this.censorEvery_e.transform("this is 123!"));
		assertEquals("h3lL0 th3R3", this.censorEvery_e.transform("h3lL0 th3R3"));

		String special = "h333Ll0 *!@#$%^&*()_+{}|:\"<>?[]\\;',./1234567890-=qwerty";
		String specialCensored = "h333Ll0 *!@#$%^&*()_+{}|:\"<>?[]\\;',./1234567890-=qw*rty";

		assertEquals(specialCensored, this.censorEvery_e.transform(special));
	}

	/**
	 * * Test method for {@link Censor#transform(java.lang.String)}. Tests
	 * that asterisks are left unchanged.
	 */
	@Test
	public void testWithAsterisks() {
		assertEquals("**********", this.censorEvery_e.transform("***eee***e"));
		assertEquals("****e****e", this.censorEvery_a.transform("***aea***e"));
	}

	/**
	 * Test method for {@link Censor#transform(java.lang.String)}. Tests that
	 * an empty string stays that way.
	 */
	@Test
	public void testEmptyString() {
		assertEquals("", this.censorEvery_e.transform(""));
		assertEquals("", this.censorEvery_a.transform(""));
	}

	/**
	 * Test method for {@link Censor#transform(java.lang.String)}. Tests that
	 * Censor works correctly with a very long String.
	 */
	@Test
	public void testLongString() {
		int stringLength = 1000000; // Should be an even number. One million.

		char[] longStringOfEsAndAs = new char[stringLength];
		char[] longStringOfAsterisksAndAs = new char[stringLength];
		char[] longStringOfAsterisksAndEs = new char[stringLength];
		
		for (int k = 0; k < stringLength / 2; k += 2) {
			longStringOfEsAndAs[k] = 'e';
			longStringOfEsAndAs[k + 1] = 'a';

			longStringOfAsterisksAndAs[k] = '*';
			longStringOfAsterisksAndAs[k + 1] = 'a';
			
			longStringOfAsterisksAndEs[k] = 'e';
			longStringOfAsterisksAndEs[k + 1] = '*';
		}

		String eSandAs = new String(longStringOfEsAndAs);
		String aSandAsterisks = new String(longStringOfAsterisksAndAs);
		String eSandAsterisks = new String(longStringOfAsterisksAndEs);

		assertEquals(aSandAsterisks, this.censorEvery_e.transform(eSandAs));
		assertEquals(eSandAsterisks, this.censorEvery_a.transform(eSandAs));
	}
}
