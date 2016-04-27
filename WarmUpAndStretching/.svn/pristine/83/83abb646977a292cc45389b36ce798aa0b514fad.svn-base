package priorityQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;


/**
 * Tests PQ.
 */
public class PQTests {

	private PQ<Integer> empty;
	private PQ<Character> singleElt;
	private PQ<Character> twoElt;
	private PQ<Character> twoEltAgain;
	private PQ<Integer> multiElt;

	private static float points = 0;
	
	/**
	 * Creates a variety of PQs for testing.
	 */
	@Before
	public void setup() {
		this.empty = new PQ<Integer>();

		this.singleElt = new PQ<Character>();
		this.singleElt.insert(4, 'R');

		this.twoElt = new PQ<Character>();
		this.twoElt.insert(4, 'R');
		this.twoElt.insert(5, 'H');

		this.twoEltAgain = new PQ<Character>();
		this.twoEltAgain.insert(5, 'H');
		this.twoEltAgain.insert(4, 'R');

		this.multiElt = new PQ<Integer>();
		this.multiElt.insert(5, 4);
		this.multiElt.insert(4, 5);
		this.multiElt.insert(6, 3);
		this.multiElt.insert(6, 12);
		this.multiElt.insert(3, 6);
	}

	/**
	 * Tests {@link PQ}.
	 */
	@Test
	public void testEmptyPQ() {
		try {
			this.empty.findMin();
			fail("Should have thrown exception");
		} catch (NoSuchElementException e) {
			points += 1.5;
		}
	}

	/**
	 * Tests {@link PQ}.
	 */
	@Test
	public void testSingleElementPQ1() {
		char c = this.singleElt.findMin();
		assertEquals('R', c);
		points += 1.5;
	}

	/**
	 * Tests {@link PQ}.
	 */
	@Test
	public void testSingleElementPQ2() {
		try {
			this.singleElt.deleteMin();
			this.singleElt.findMin();
			fail("Should have thrown exception");
		} catch (NoSuchElementException e) {
			points += 1.5;
		}
	}

	/**
	 * Tests {@link PQ}.
	 */
	@Test
	public void testTwoElementPQ1() {
		char c = this.twoElt.findMin();
		assertEquals('R', c);
		this.twoElt.deleteMin();
		c = this.twoElt.findMin();
		assertEquals('H', c);
		points += 1.5;
	}

	/**
	 * Tests {@link PQ}.
	 */
	@Test
	public void testTwoElementPQ2() {
		try {
			this.twoElt.deleteMin();
			this.twoElt.deleteMin();
			this.twoElt.findMin();
			fail("Should have thrown exception");
		} catch (NoSuchElementException e) {
			points += 1.5;
		}
	}

	/**
	 * Tests {@link PQ}.
	 */
	@Test
	public void testTwoElementPQ3() {
		char c = this.twoEltAgain.findMin();
		assertEquals('R', c);
		this.twoEltAgain.deleteMin();
		c = this.twoEltAgain.findMin();
		assertEquals('H', c);
		points += 1.5;
	}

	/**
	 * Tests {@link PQ}.
	 */
	@Test
	public void testMultiElementPQ1() {
		int i = this.multiElt.findMin();
		assertEquals(6, i);
		this.multiElt.deleteMin();
		this.multiElt.insert(2, 7);
		i = this.multiElt.findMin();
		assertEquals(7, i);
		this.multiElt.deleteMin();
		i = this.multiElt.findMin();
		assertEquals(5, i);
		this.multiElt.deleteMin();
		i = this.multiElt.findMin();
		assertEquals(4, i);
		this.multiElt.deleteMin();
		i = this.multiElt.findMin();
		assertEquals(3, i);
		this.multiElt.deleteMin();
		i = this.multiElt.findMin();
		assertEquals(12, i);
		points += 1.5;
	}

	/**
	 * Tests {@link PQ}.
	 */
	@Test
	public void testMultiElementPQ2() {
		try {
			this.multiElt.deleteMin();
			this.multiElt.deleteMin();
			this.multiElt.deleteMin();
			this.multiElt.deleteMin();
			this.multiElt.deleteMin();
			this.multiElt.findMin();
			fail("Should have thrown exception");
		} catch (NoSuchElementException e) {
			points += 1.5;
		}
	}
	
	@AfterClass
	public static void showPoints() {
		System.out.printf("PRIORITY QUEUE POINTS = %.1f of 12\n", points);
	}
}
