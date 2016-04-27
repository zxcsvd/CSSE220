package sll;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a collection of test cases for the {@link LinkedList} class.
 * 
 * @author defoe. Created Nov 7, 2013.
 */
public class LinkedListTest {

	private LinkedList<Integer> list1, list2, list3;

	/**
	 * Sets up a few {@link LinkedList} instances to test the {@link LinkedList}
	 * class.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.list1 = new LinkedList<Integer>();
		this.list2 = new LinkedList<Integer>();
		this.list3 = new LinkedList<Integer>();
	}

	/**
	 * Tests the {@link LinkedList#add(Object)} method.
	 * 
	 */
	@Test
	public void testAdd() {
		assertEquals("[]", this.list1.toString());
		this.list2.add(5);
		assertEquals("[5]", this.list2.toString());
		this.list1.add(2);
		assertEquals("[2]", this.list1.toString());
		this.list1.add(6);
		assertEquals("[2, 6]", this.list1.toString());
		this.list1.add(7);
		assertEquals("[2, 6, 7]", this.list1.toString());
	}

	/**
	 * Tests the {@link LinkedList#size()} method. This method assumes that the
	 * {@link LinkedList#add(Object)} method works.
	 * 
	 */
	@Test
	public void testSize() {
		assertEquals(0, this.list1.size());
		this.list2.add(5);
		assertEquals(1, this.list2.size());
		this.list1.add(2);
		assertEquals(1, this.list1.size());
		this.list1.add(6);
		assertEquals(2, this.list1.size());
		this.list1.add(7);
		assertEquals(3, this.list1.size());
	}

	/**
	 * Tests the {@link LinkedList#add(int, Object)} method.
	 * 
	 */
	@Test
	public void testAddInt() {
		this.list1.add(2);
		this.list1.add(6);
		this.list1.add(1, 7);
		assertEquals("[2, 7, 6]", this.list1.toString());
		this.list1.add(0, 8);
		assertEquals("[8, 2, 7, 6]", this.list1.toString());
		this.list1.add(4, 9);
		assertEquals("[8, 2, 7, 6, 9]", this.list1.toString());
		this.list3.add(0, 7);
		assertEquals("[7]", this.list3.toString());
	}

	/**
	 * Tests the {@link LinkedList#add(int, Object)} method for bad cases.
	 * 
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddIntTBad() {
		this.list1.add(2);
		this.list1.add(6);
		this.list1.add(1, 7);
		this.list1.add(0, 8);
		this.list1.add(6, 10);
	}

	/**
	 * Tests the {@link LinkedList#contains(Object)} method.
	 * 
	 */
	@Test
	public void testContains() {
		this.list1.add(2);
		this.list1.add(6);
		this.list1.add(1, 7);
		this.list1.add(0, 8);
		this.list1.add(4, 9);
		assertTrue(this.list1.contains(2));
		assertTrue(this.list1.contains(6));
		assertTrue(this.list1.contains(7));
		assertTrue(this.list1.contains(8));
		assertTrue(this.list1.contains(9));
		assertFalse(this.list1.contains(4));
		assertFalse(this.list2.contains(4));
		assertFalse(this.list3.contains(4));
	}

	/**
	 * Tests the {@link LinkedList#remove(Object)} method. This method assumes
	 * that {@link LinkedList#add(Object)}, {@link LinkedList#add(int, Object)},
	 * and {@link LinkedList#size()} all work.
	 * 
	 */
	@Test
	public void testRemove() {
		this.list1.add(2);
		this.list1.add(6);
		this.list1.add(1, 7);
		this.list1.add(0, 8);
		this.list1.add(4, 9);
		this.list1.add(7);
		assertTrue(this.list1.remove(6));
		assertEquals(5, this.list1.size());
		assertTrue(this.list1.remove(7));
		assertEquals(4, this.list1.size());
		assertTrue(this.list1.remove(7));
		assertEquals(3, this.list1.size());
		assertTrue(this.list1.remove(8));
		assertEquals(2, this.list1.size());
		assertFalse(this.list1.remove(8));
		assertFalse(this.list3.remove(4));
	}

	/**
	 * Tests the {@link LinkedList#get(int)} method. This method assumes that
	 * {@link LinkedList#add(Object)} and {@link LinkedList#add(int, Object)}
	 * work.
	 */
	@Test
	public void testGet() {
		this.list1.add(2);
		this.list1.add(6);
		this.list1.add(1, 7);
		this.list1.add(0, 8);
		this.list1.add(4, 9);
		this.list1.add(7);
		assertEquals(new Integer(2), this.list1.get(1));
		assertEquals(new Integer(7), this.list1.get(2));
	}

	/**
	 * Tests the {@link LinkedList#get(int)} method for a bad case. This method
	 * assumes that {@link LinkedList#add(Object)} and
	 * {@link LinkedList#add(int, Object)} work.
	 * 
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetBad1() {
		this.list1.add(2);
		this.list1.add(6);
		this.list1.add(1, 7);
		this.list1.add(0, 8);
		this.list1.add(4, 9);
		this.list1.add(7);
		this.list1.get(-3);
	}

	/**
	 * Tests the {@link LinkedList#get(int)} method for another bad case. This
	 * method assumes that {@link LinkedList#add(Object)} and
	 * {@link LinkedList#add(int, Object)} work.
	 * 
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetBad2() {
		this.list1.add(2);
		this.list1.add(6);
		this.list1.add(1, 7);
		this.list1.add(0, 8);
		this.list1.add(4, 9);
		this.list1.add(7);
		this.list1.get(-8);
	}

	/**
	 * Tests the {@link LinkedList#get(int)} method for yet another bad case.
	 * This method assumes that {@link LinkedList#add(Object)} and
	 * {@link LinkedList#add(int, Object)} work.
	 * 
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetBad3() {
		this.list3.get(-0);
	}

	/**
	 * 
	 * Tests the {@link LinkedList#indexOf(Object)} method.
	 * 
	 */
	@Test
	public void testIndexOf() {
		this.list1.add(2);
		this.list1.add(6);
		this.list1.add(1, 7);
		this.list1.add(0, 8);
		this.list1.add(4, 9);
		this.list1.add(7);
		assertEquals(1, this.list1.indexOf(2));
		assertEquals(2, this.list1.indexOf(7));
		assertEquals(-1, this.list1.indexOf(12));
		assertEquals(-1, this.list2.indexOf(12));

	}

	/**
	 * Tests the {@link LinkedList#set(int, Object)} method.
	 */
	@Test
	public void testSet() {
		this.list1.add(2);
		this.list1.add(6);
		this.list1.add(1, 7);
		this.list1.add(0, 8);
		this.list1.add(4, 9);
		this.list1.add(7);
		assertEquals(new Integer(6), this.list1.set(3, 12));
		assertEquals(new Integer(12), this.list1.get(3));
	}

	/**
	 * Tests the {@link LinkedList#set(int, Object)} method for a bad case.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetBad1() {
		this.list1.add(2);
		this.list1.add(6);
		this.list1.add(1, 7);
		this.list1.add(0, 8);
		this.list1.add(4, 9);
		this.list1.add(7);
		this.list1.set(-8, 5);
	}

	/**
	 * Tests the {@link LinkedList#set(int, Object)} method for another bad
	 * case.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetBad2() {
		this.list1.add(2);
		this.list1.add(6);
		this.list1.add(1, 7);
		this.list1.add(0, 8);
		this.list1.add(4, 9);
		this.list1.add(7);
		this.list1.set(12, 5);
	}

	/**
	 * Tests the {@link LinkedList#set(int, Object)} method for yet another bad
	 * case.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetBad3() {
		this.list3.set(0, 5);
	}

	/**
	 * 
	 * Tests the {@link LinkedList#iterator()} method.
	 */
	@Test
	public void testIterator() {
		this.list1.add(2);
		this.list1.add(6);
		this.list1.add(7);
		Iterator<Integer> itr = this.list1.iterator();
		assertEquals(new Integer(2), itr.next());
		itr.remove();
		assertEquals("[6, 7]", this.list1.toString());
		assertTrue(itr.hasNext());
		assertEquals(new Integer(6), itr.next());
		itr.remove();
		assertEquals("[7]", this.list1.toString());
		assertEquals(new Integer(7), itr.next());
		assertFalse(itr.hasNext());
	}

	/**
	 * 
	 * Tests the {@link LinkedList#iterator()} method for a bad case.
	 */
	@Test(expected = NoSuchElementException.class)
	public void testIteratorBad1() {
		Iterator<Integer> itr = this.list1.iterator();
		itr.next();
	}

	/**
	 * 
	 * Tests the {@link LinkedList#iterator()} method for another bad case.
	 */
	@Test(expected = NoSuchElementException.class)
	public void testIteratorBad() {
		this.list1.add(2);
		Iterator<Integer> itr = this.list1.iterator();
		itr.next();
		itr.next();
	}

	/**
	 * 
	 * Tests the {@link LinkedList#iterator()} method for yet another bad case.
	 */
	@Test(expected = IllegalStateException.class)
	public void testIteratorBad2() {
		this.list1.add(2);
		this.list1.add(6);
		Iterator<Integer> itr = this.list1.iterator();
		itr.next();
		itr.remove();
		itr.remove();

	}

}
