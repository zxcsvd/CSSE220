import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class Part2Test {

	Part2 part2;
	
	@Before
	public void setUp() throws Exception {
		part2 = new Part2();
	}

	@Test
	public void testCountTs() {
		Assert.assertEquals(0, part2.countTs(""));
		Assert.assertEquals(1, part2.countTs("T"));
		Assert.assertEquals(0, part2.countTs("Z"));
		Assert.assertEquals(1, part2.countTs("hello T hello!"));
		Assert.assertEquals(3, part2.countTs("TTT"));
		Assert.assertEquals(3, part2.countTs("TTxT"));
	}

	@Test
	public void testMakePalindrome() {
		Assert.assertEquals("bab", part2.makePalindrome("ba"));
		Assert.assertEquals("abcdcba", part2.makePalindrome("abcd"));
		Assert.assertEquals("xxxxx", part2.makePalindrome("xxx"));
		Assert.assertEquals("a", part2.makePalindrome("a"));
		Assert.assertEquals("", part2.makePalindrome(""));
	}

	@Test
	public void testHasStrictlyIncreasingDigits() {
		Assert.assertEquals(true, part2.hasStrictlyIncreasingDigits(1234));
		Assert.assertEquals(false, part2.hasStrictlyIncreasingDigits(12314));
		Assert.assertEquals(true, part2.hasStrictlyIncreasingDigits(2589));
		Assert.assertEquals(false, part2.hasStrictlyIncreasingDigits(11));
		Assert.assertEquals(true, part2.hasStrictlyIncreasingDigits(1));
		Assert.assertEquals(true, part2.hasStrictlyIncreasingDigits(0));
		Assert.assertEquals(true, part2.hasStrictlyIncreasingDigits(3456789));
	}

}
