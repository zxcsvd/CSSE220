/**
 * 
 */
package hardysTaxi;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import java.util.List;

/**
 * @author anderson  November, 2010.
 *
 */
public class HardyTests {
	
	private static int points = 0;
	
	
	private static int[] tenToThe = {1, 10, 100, 1000, 10000, 100000};
	
	private static int kthDigitOf(int n, int k) {
		return n/tenToThe[k] % 10;
	}
	
	/**
	 * Test method for {@link hardysTaxi.Hardy#hardySolutionsLessThan(int)}.
	 */
	@Test
	public void testHardySolutionsLessThan_1729() {
		List<TaxicabNumber> hl = Hardy.hardySolutionsLessThan(1729);
		assertTrue(hl.isEmpty());
		points += 2;
	}
	
	

	/**
	 * Test method for {@link hardysTaxi.Hardy#hardySolutionsLessThan(int)}.
	 */
	@Test
	public void testHardySolutionsLessThan_1730() {
		List<TaxicabNumber> hl = Hardy.hardySolutionsLessThan(1730);
		System.out.println(hl);
		assertEquals(1,hl.size());
		assertEquals(1729, hl.get(0).getS());
		points += 2;
	}
	
	/**
	 * Test method for {@link hardysTaxi.Hardy#hardySolutionsLessThan(int)}.
	 */
	@Test
	public void testHardySolutionsLessThan_5000() {
		List<TaxicabNumber> hl = Hardy.hardySolutionsLessThan(5000);
		assertEquals(2,hl.size());
		// A way of checking your answer without giving it away:
		assertEquals(1,kthDigitOf(hl.get(1).getS(), 2));
		assertEquals(5,kthDigitOf(hl.get(1).getD(), 0));
		points += 2;
	}
	
	/**
	 * Test method for {@link hardysTaxi.Hardy#hardySolutionsLessThan(int)}.
	 */
	@Test
	public void testHardySolutionsLessThan_25000() {
		List<TaxicabNumber> hl = Hardy.hardySolutionsLessThan(25000);
		assertEquals(4,hl.size());
		assertEquals(4,kthDigitOf(hl.get(2).getB(), 0));
		assertEquals(9,kthDigitOf(hl.get(3).getC(), 0));
		assertEquals(6,kthDigitOf(hl.get(3).getS(), 2));
		assertEquals(2,kthDigitOf(hl.get(3).getS(), 4));
		points += 2;
	}

	@AfterClass
	public static void showPoints() {
		System.out.printf("HARDY POINTS = %d of 8\n", points);
	}

	
}
