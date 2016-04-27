import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the SlowThinker class.
 * 
 * @author Ryan Matthys, updated by David Mutchler. Created March 12, 2009,
 *         updated December 4, 2009.
 */
public class SlowThinkerTest {
	private SlowThinker slowThinkerOne;
	private SlowThinker slowThinkerTwo;

	/**
	 * Runs before each test, constructing for each test two SlowThinkers.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.slowThinkerOne = new SlowThinker();
		this.slowThinkerTwo = new SlowThinker();
	}

	/**
	 * Test method for {@link SlowThinker#transform(java.lang.String)}. Tests that a
	 * SlowThinker does short Strings correctly.
	 */
	@Test
	public void testShortStrings() {
		assertEquals("", this.slowThinkerOne.transform("Return This Later"));
		assertEquals("Return This Later", this.slowThinkerOne
				.transform("One More Time"));
		assertEquals("One More Time", this.slowThinkerOne.transform(""));
	}
	
	/**
	 * Test method for {@link SlowThinker#transform(java.lang.String)}. Tests that a
	 * SlowThinker does long Strings correctly.
	 */
	@Test
	public void testLongStrings() {
		int stringLength = 1000;
		String stringOne = "";
		String stringTwo = "";
		String stringThree = "";

		for (int iter = 1; iter <= stringLength; iter++) {
			stringOne = stringOne.concat("BaloogaWow");
			stringTwo = stringTwo.concat("Glasses");
			stringThree = stringThree
					.concat("Peter Piper Picked a Pack of Pickled Peppers");
		}

		assertEquals("", this.slowThinkerOne.transform(stringOne));
		assertEquals(stringOne, this.slowThinkerOne.transform(stringTwo));
		assertEquals(stringTwo, this.slowThinkerOne.transform(stringThree));
		assertEquals(stringThree, this.slowThinkerOne.transform(""));
		assertEquals("", this.slowThinkerOne.transform("Done"));
	}

	/**
	 * Test method for {@link SlowThinker#transform(java.lang.String)}. Tests that a
	 * SlowThinker does Strings with special characters correctly.
	 */
	@Test
	public void testSpecialCharacters() {
		assertEquals("", this.slowThinkerOne.transform("!@#$%^&*(){}"));
		assertEquals("!@#$%^&*(){}", this.slowThinkerOne.transform("1234567890[]"));
		assertEquals("1234567890[]", this.slowThinkerOne.transform(""));
	}

	/**
	 * Test method for {@link SlowThinker#transform(java.lang.String)}. Tests that two
	 * SlowThinker's work independently.
	 */
	@Test
	public void testIndependantThinking() {
		assertEquals("", this.slowThinkerOne.transform("Return This Later"));
		assertEquals("Return This Later", this.slowThinkerOne
				.transform("One More Time"));
		assertEquals("One More Time", this.slowThinkerOne.transform(""));
		assertEquals("", this.slowThinkerTwo.transform("This is the Last Time"));
	}
}
