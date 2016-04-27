import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Counter class.
 * 
 * @author Ryan Matthys, updated by David Mutchler. Created March 12, 2009,
 *         updated December 4, 2009.
 */
public class CounterTest {
	private Counter firstCounter;
	private Counter secondCounter;
	private Counter thirdCounter;

	/**
	 * Runs before each test, constructing for each test three Counter's.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.firstCounter = new Counter();
		this.secondCounter = new Counter();
		this.thirdCounter = new Counter();
	}

	/**
	 * Test method for {@link Counter#transform(java.lang.String)}. Tests that a
	 * Counter does short Strings correctly.
	 */
	@Test
	public void testShortStrings() {
		assertEquals("1. First input.", this.firstCounter
				.transform("First input."));
		assertEquals("2. Second input.", this.firstCounter
				.transform("Second input."));
		assertEquals("3. Third input.", this.firstCounter
				.transform("Third input."));
		assertEquals("4. Fourth input.", this.firstCounter
				.transform("Fourth input."));
	}

	/**
	 * Test method for {@link Counter#transform(java.lang.String)}. Tests that
	 * an empty string has just numbers inserted.
	 */
	@Test
	public void testEmptyString() {
		assertEquals("1. ", this.firstCounter.transform(""));
		assertEquals("2. ", this.firstCounter.transform(""));
		assertEquals("3. ", this.firstCounter.transform(""));
		assertEquals("4. ", this.firstCounter.transform(""));
	}

	/**
	 * Test method for {@link Counter#transform(java.lang.String)}. Tests that
	 * special characters are left unchanged.
	 */
	@Test
	public void testSpecialCharacters() {
		assertEquals("1. !@#$%^&*(){}1234567890[]", this.firstCounter
				.transform("!@#$%^&*(){}1234567890[]"));
		assertEquals("2. !@#$%^&*(){}1234567890[]", this.firstCounter
				.transform("!@#$%^&*(){}1234567890[]"));
		assertEquals("3. !@#$%^&*(){}1234567890[]", this.firstCounter
				.transform("!@#$%^&*(){}1234567890[]"));
		assertEquals("4. !@#$%^&*(){}1234567890[]", this.firstCounter
				.transform("!@#$%^&*(){}1234567890[]"));
	}

	/**
	 * Test method for {@link Counter#transform(java.lang.String)}. Tests that
	 * interwoven Counter's are independent of each other.
	 */
	@Test
	public void testSeparateCounting() {
		assertEquals("1. This Should Be Counted", this.firstCounter
				.transform("This Should Be Counted"));
		assertEquals("2. This Should Be Counted", this.firstCounter
				.transform("This Should Be Counted"));
		assertEquals("3. This Should Be Counted", this.firstCounter
				.transform("This Should Be Counted"));

		assertEquals("1. This Should Be Counted", this.secondCounter
				.transform("This Should Be Counted"));

		assertEquals("4. This Should Be Counted", this.firstCounter
				.transform("This Should Be Counted"));

		assertEquals("1. This Should Be Counted", this.thirdCounter
				.transform("This Should Be Counted"));
		assertEquals("2. This Should Be Counted", this.thirdCounter
				.transform("This Should Be Counted"));

		assertEquals("2. This Should Be Counted", this.secondCounter
				.transform("This Should Be Counted"));
		assertEquals("5. This Should Be Counted", this.firstCounter
				.transform("This Should Be Counted"));
	}

	/**
	 * Test method for {@link Counter#transform(java.lang.String)}. Tests that a
	 * Counter that is called many times works correctly, on a String that is
	 * built up to be a very long String.
	 */
	@Test
	public void testCallManyTimes() {
		int callTimes = 10000; // Ten thousand
		
		String stringToTransform = "";
		for (int k = 1; k <= callTimes; ++k) {
			String transformedString = this.thirdCounter.transform(stringToTransform);
			assertEquals(k + ". " + stringToTransform, transformedString);
			
			stringToTransform = transformedString;
		}
	}
}
