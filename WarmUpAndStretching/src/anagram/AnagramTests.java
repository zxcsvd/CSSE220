package anagram;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Test;

/**
 * Tests Anagram.
 * 
 * @author Claude Anderson.
 */
public class AnagramTests {
	private static float points = 0;
	
	
	/**
	 * Tests {@link Anagram#isAnagram(String, String)}.
	 */
	@Test
	public void testAnagram1() {
		assertFalse(Anagram.isAnagram("a", "b"));
		assertTrue(Anagram.isAnagram("a", "a"));
		points += 1.5;
	}

	/**
	 * Tests {@link Anagram#isAnagram(String, String)}.
	 */
	@Test
	public void testAnagram2() {
		assertFalse(Anagram.isAnagram("a", "b"));
		assertTrue(Anagram.isAnagram("a", "A"));
		points += 1.5;
	}

	/**
	 * Tests {@link Anagram#isAnagram(String, String)}.
	 */
	@Test
	public void testAnagram3() {
		assertFalse(Anagram.isAnagram("a", "b"));
		assertTrue(Anagram.isAnagram("ab", "ba"));
		points += 1.5;
	}

	/**
	 * Tests {@link Anagram#isAnagram(String, String)}.
	 */
	@Test
	public void testAnagram4() {
		assertFalse(Anagram.isAnagram("a", "b"));
		assertTrue(Anagram.isAnagram("abc", "cba"));
		points += 1.5;
	}

	/**
	 * Tests {@link Anagram#isAnagram(String, String)}.
	 */
	@Test
	public void testAnagram5() {
		assertFalse(Anagram.isAnagram("a", "b"));
		assertTrue(Anagram.isAnagram("abc", "bca"));
		points += 1.5;
	}

	/**
	 * Tests {@link Anagram#isAnagram(String, String)}.
	 */
	@Test
	public void testAnagram6() {
		assertFalse(Anagram.isAnagram("aabb", "bbbaa"));
		assertTrue(Anagram.isAnagram("Claude Anderson", "Nuanced Ordeals"));
		assertTrue(Anagram.isAnagram("Matt Boutell", "Total Tumble"));
		assertTrue(Anagram.isAnagram("Curt Clifton", "Conflict Rut"));
		assertTrue(Anagram.isAnagram("Delvin Defoe", "Defend Olive")); // like Popeye!
		assertTrue(Anagram.isAnagram("Dave Fisher", "Evader Fish"));
		assertTrue(Anagram.isAnagram("Dave Mutchler", "Traveled Much"));
		assertTrue(Anagram.isAnagram("  Wollowski", "Silk Owl Ow"));
		points += 1.5;
	}

	/**
	 * Tests {@link Anagram#isAnagram(String, String)}.
	 */
	@Test
	public void testAnagram7() {
		assertTrue(Anagram.isAnagram("aabb", "bbaa"));
		assertFalse(Anagram.isAnagram("Claude Anderson", "Nuanced  Ordeals"));
		assertFalse(Anagram.isAnagram("MA", "LB"));
		assertFalse(Anagram.isAnagram("ay", "bx"));
		assertFalse(Anagram.isAnagram("ab", "c"));
		points += 1.5;
	}
	
	@AfterClass
	public static void showPoints() {
		System.out.printf("ANAGRAM POINTS = %.1f of 10.5\n", points);
	}
	
}
