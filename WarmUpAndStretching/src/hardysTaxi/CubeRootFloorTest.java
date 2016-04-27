package hardysTaxi;

import static org.junit.Assert.*;

import org.junit.Test;

// These JUnit tests do not count toward your grade, since they are testing something that you did not write.

/**
 * TODO Put here a description of what this class does.
 *
 * @author anderson.
 *         Created Mar 8, 2012.
 */
public class CubeRootFloorTest {

	/**
	 * Test method for {@link hardysTaxi.Hardy#cubeRootFloor(int)}.
	 */
	@Test
	public void testCubeRootFloor() {
		assertEquals(0, Hardy.cubeRootFloor(0));
		assertEquals(1, Hardy.cubeRootFloor(1));
		assertEquals(1, Hardy.cubeRootFloor(2));
		assertEquals(1, Hardy.cubeRootFloor(7));
		assertEquals(2, Hardy.cubeRootFloor(8));
		assertEquals(2, Hardy.cubeRootFloor(9));
		assertEquals(12, Hardy.cubeRootFloor(1729));
	}

}
