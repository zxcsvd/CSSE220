package edu.roseHulman.csse220.charges;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the LinearCharge class.
 * 
 * @author cclifton. Created Oct 7, 2008.
 */
public class LinearChargeTest {
	/*
	 * Very coarse epsilon for comparisons because step-wise "integration" in
	 * LinearCharge is coarse to keep it fast.
	 */
	private static final double EPSILON = 0.02;
	private LinearCharge longHorizontal;
	private LinearCharge longVertical;

	/**
	 * Sets up some linear charges for testing.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.longHorizontal = new LinearCharge(-100, 0, 100, 0, 100.0);
		this.longVertical = new LinearCharge(0, -100, 0, 100, -100.0);
	}

	/**
	 * Test method for
	 * {@link edu.roseHulman.csse220.charges.LinearCharge#forceAt(int, int)}.
	 */
	@Test
	public void testForceAt() {
		Vector v;

		v = this.longHorizontal.forceAt(0, 1);
		assertEquals(0.0, v.getXComponent(), EPSILON);
		assertEquals(1.0, v.getYComponent(), EPSILON);

		v = this.longHorizontal.forceAt(0, -1);
		assertEquals(0.0, v.getXComponent(), EPSILON);
		assertEquals(-1.0, v.getYComponent(), EPSILON);

		v = this.longVertical.forceAt(1, 0);
		assertEquals(-1.0, v.getXComponent(), EPSILON);
		assertEquals(0.0, v.getYComponent(), EPSILON);

		v = this.longVertical.forceAt(-1, 0);
		assertEquals(1.0, v.getXComponent(), EPSILON);
		assertEquals(0.0, v.getYComponent(), EPSILON);
	}

}
