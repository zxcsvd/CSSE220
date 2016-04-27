import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Tests GameOfLife.
 * 
 * @author Curt Clifton. Created Sep 24, 2008.
 */
public class GameOfLifeTest {

	/**
	 * Test method for {@link GameOfLife#GameOfLife(java.util.ArrayList)} and
	 * {@link GameOfLife#isOccupied(int, int)}.
	 */
	@Test
	public void testGameOfLife() {
		// TODO 4: Test constructor and isOccupied()
		Coordinates one = new Coordinates(5, 9);
		Coordinates two = new Coordinates(6, 3);
		Coordinates three = new Coordinates(19, 0);
		ArrayList<Coordinates> testCord = new ArrayList<Coordinates>();
		testCord.add(one);
		testCord.add(two);
		testCord.add(three);
		GameOfLife test1 = new GameOfLife(testCord);
		assertTrue(test1.isOccupied(5, 9));
		assertFalse(test1.isOccupied(8, 8));
		assertTrue(test1.isOccupied(19, 0));
	}

	/**
	 * Test method for {@link GameOfLife#getNeighborCount(int, int)}.
	 */
	@Test
	public void testGetNeighborCount() {
		// TODO 5: Test getNeighborCount
		Coordinates one = new Coordinates(5, 9);
		Coordinates two = new Coordinates(5, 8);
		Coordinates three = new Coordinates(6, 8);
		Coordinates result1 = new Coordinates(4, 7);
		Coordinates result2 = new Coordinates(3, 10);
		
		ArrayList<Coordinates> testCord = new ArrayList<Coordinates>();
		testCord.add(one);
		testCord.add(two);
		testCord.add(three);
		testCord.add(result1);
		testCord.add(result2);
		GameOfLife test1 = new GameOfLife(testCord);
		assertEquals(0 , test1.getNeighborCount(3, 10));
		assertEquals(3, test1.getNeighborCount(5, 8));
		assertEquals(1, test1.getNeighborCount(4, 7));
		
	}

	/**
	 * Test method for {@link GameOfLife#nextGeneration()}.
	 */
	@Test
	public void testNextGen() {
		Coordinates one = new Coordinates(5, 9);
		Coordinates two = new Coordinates(5, 8);
		Coordinates three = new Coordinates(6, 8);
		Coordinates result1 = new Coordinates(4, 7);
		Coordinates result2 = new Coordinates(3, 10);
		
		ArrayList<Coordinates> testCord = new ArrayList<Coordinates>();
		testCord.add(one);
		testCord.add(two);
		testCord.add(three);
		testCord.add(result1);
		testCord.add(result2);
		GameOfLife test1 = new GameOfLife(testCord);
		
		test1.nextGeneration();
		assertTrue(test1.isOccupied(4, 8));
		assertFalse(test1.isOccupied(3, 7));
		assertTrue(test1.isOccupied(5, 8));
	
		// TODO 6: test nextGen
	}

}
