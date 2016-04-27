/**
 * 
 */
package hardysTaxi;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import org.junit.Test;

/**
 * @author anderson  November, 2010
 *
 */
public class TaxicabNumberTests {

	/**
	 * Test methods for {@link hardysTaxi.TaxicabNumber#TaxicabNumber(int, int, int, int, int)}.
	 */
	@Test
	public void testTaxicabNumber() {
		TaxicabNumber tn = new TaxicabNumber(1729, 12, 1, 9, 10);
		assertEquals("1729 = 1^3 + 12^3 = 9^3 + 10^3", tn.toString());
	}
	
	/**
	 * Tests to make sure this Taxicab number is caught as illegal.
	 */
	@Test(expected = HardyException.class)		
	public void testTaxicabNumberIllegal_1() {
		new TaxicabNumber(1729, 12, 2, 9, 10);
	}
	
	/**
	 * Tests to make sure this Taxicab number is caught as illegal.
	 */
	@Test(expected = HardyException.class)
	public void testTaxicabNumberIllegal_2() {
		new TaxicabNumber(1729, 12, 1, 8, 10);
	}
	
	/**
	 * Tests to make sure this Taxicab number is caught as illegal.
	 */
	@Test(expected = HardyException.class)
	public void testTaxicabNumberIllegal_3() {
		new TaxicabNumber(1729, 12, 1, 1, 12);
	}
	

	/**
	 * Test methods for {@link hardysTaxi.TaxicabNumber#equals(hardysTaxi.TaxicabNumber)}.
	 */
	@Test
	public void testEqualsTaxicabNumber_1() {
		assertTrue(new TaxicabNumber(1729, 12, 1, 9, 10).equals(
				     new TaxicabNumber(1729, 9, 10, 12, 1)));
	}
	
	/**
	 * Tests to make sure these Taxicab number are considered equal.
	 */
	@Test
	public void testEqualsTaxicabNumber_2() {
		assertTrue(new TaxicabNumber(1729, 12, 1, 9, 10).equals(
				     new TaxicabNumber(1729, 12, 1, 9, 10)));
	}

	/**
	 * Tests to make sure these Taxicab number are considered equal.
	 */
	@Test
	public void testEqualsTaxicabNumber_3() {
		assertTrue(new TaxicabNumber(1729, 12, 1, 9, 10).equals(
				     new TaxicabNumber(1729, 10, 9, 1, 12)));
	}

}
