package gameOfLifeWithIO;
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
		ArrayList<Coordinates> coordList = new ArrayList<Coordinates>();
		coordList.add(new Coordinates(0, 0));
		coordList.add(new Coordinates(1, 1));

		GameOfLife game = new GameOfLife(coordList);

		assertTrue(game.isOccupied(0, 0));
		assertTrue(game.isOccupied(1, 1));
		assertFalse(game.isOccupied(0, 1));
		assertFalse(game.isOccupied(1, 0));
	}

	/**
	 * Test method for {@link GameOfLife#nextGeneration()}.
	 */
	@Test
	public void testNextGen() {
		ArrayList<Coordinates> coordList = new ArrayList<Coordinates>();
		coordList.add(new Coordinates(0, 0));
		coordList.add(new Coordinates(0, 1));
		coordList.add(new Coordinates(2, 0));

		GameOfLife game = new GameOfLife(coordList);

		assertTrue(game.isOccupied(0, 0));
		assertTrue(game.isOccupied(0, 1));
		assertFalse(game.isOccupied(1, 0));
		assertFalse(game.isOccupied(1, 1));
		assertTrue(game.isOccupied(2, 0));
		assertFalse(game.isOccupied(2, 1));

		game.nextGeneration();
		assertFalse(game.isOccupied(0, 0));
		assertFalse(game.isOccupied(0, 1));
		assertTrue(game.isOccupied(1, 0));
		assertTrue(game.isOccupied(1, 1));
		assertFalse(game.isOccupied(2, 0));
		assertFalse(game.isOccupied(2, 1));

		game.nextGeneration();
		assertFalse(game.isOccupied(0, 0));
		assertFalse(game.isOccupied(0, 1));
		assertFalse(game.isOccupied(1, 0));
		assertFalse(game.isOccupied(1, 1));
		assertFalse(game.isOccupied(2, 0));
		assertFalse(game.isOccupied(2, 1));
	}

	/**
	 * Test method for {@link GameOfLife#getNeighborCount(int, int)}.
	 */
	@Test
	public void testGetNeighborCount() {
		ArrayList<Coordinates> coordList = new ArrayList<Coordinates>();
		coordList.add(new Coordinates(0, 0));
		coordList.add(new Coordinates(0, 1));
		coordList.add(new Coordinates(1, 1));

		GameOfLife game = new GameOfLife(coordList);

		int[] expectedCounts = { 2, 2, 2, 3, 2, 2, 1, 1, 1 };
		int ecIndex = 0;
		for (int r = 0; r <= 2; r++) {
			for (int c = 0; c <= 2; c++) {
				int count = game.getNeighborCount(r, c);
				assertEquals(expectedCounts[ecIndex], count);
				ecIndex++;
			}
		}
	}
}
