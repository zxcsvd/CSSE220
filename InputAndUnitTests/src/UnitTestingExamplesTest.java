import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * TODO Put here a description of what this class does.
 *
 * @author pengb.
 *         Created 2013-12-10.
 */
public class UnitTestingExamplesTest {

	/**
	 * Test method for {@link UnitTestingExamples#findRectangleArea(int, int)}.
	 */
	@Test
	public void testFindRectangleArea() {
		int result1 = UnitTestingExamples.findRectangleArea(3, 5);
		assertEquals(15,result1);

	}

	/**
	 * Test method for {@link UnitTestingExamples#computeMean(double[])}.
	 */
	@Test
	public void testComputeMean() {
		double[] data1 = {1,0};
		assertEquals(-5, UnitTestingExamples.computeMean(data1),.00001);	
	}

	/**
	 * Test method for {@link UnitTestingExamples#firstWord(java.lang.String)}.
	 */
	@Test
	public void testFirstWord() {
		String result = ("aabbc kkasd as");
		assertEquals("aabbc kkasd as", result);
	}

	/**
	 * Test method for {@link UnitTestingExamples#contains(java.lang.String[], java.lang.String)}.
	 */
	@Test
	public void testContains() {
//		String[] result = ;
//		assertQuals()
	}

	/**
	 * Test method for {@link java.lang.Object#Object()}.
	 */
	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#getClass()}.
	 */
	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#equals(java.lang.Object)}.
	 */
	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#clone()}.
	 */
	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#toString()}.
	 */
	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#notify()}.
	 */
	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#notifyAll()}.
	 */
	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#wait(long)}.
	 */
	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#wait(long, int)}.
	 */
	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#wait()}.
	 */
	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#finalize()}.
	 */
	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}

}
