import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;


@SuppressWarnings("javadoc")
public class SixMapAnd2DArrayProblemsTest {

	@Test
	public void testMostCommonCharacter() {
		assertEquals('a', SixMapAnd2DArrayProblems.mostCommonCharacter("aaab"));
		assertEquals('a', SixMapAnd2DArrayProblems.mostCommonCharacter("bbaaa"));
		assertEquals('c', SixMapAnd2DArrayProblems.mostCommonCharacter("abcbcdc"));
		assertEquals('a', SixMapAnd2DArrayProblems.mostCommonCharacter("a"));
		assertEquals('l', SixMapAnd2DArrayProblems.mostCommonCharacter("hello"));
	}

	@Test
	public void testReverseHashmap() {
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "B");
		map.put(2, "B");
		map.put(3, "C");
		map.put(9, "foo");
		map.put(10, "foo");
		map.put(11, "foo");
		map.put(12, "foo");
		
		//It's unlikely (but possible) that your version of the hashmap
		//has the correct results but in different order
		// e.g. B = [2,1] rather than [1,2]
		// if so just put a comment saying as much in your source code
		// and it's fine.
		
		ArrayList<Integer> correct = new ArrayList<Integer>();
		correct.add(3);
		HashMap<String,ArrayList<Integer>> reverse = SixMapAnd2DArrayProblems.reverseHashmap(map);
		assertEquals(correct,reverse.get("C"));
		correct = new ArrayList<Integer>();
		correct.add(1);
		correct.add(2);
		assertEquals(correct, reverse.get("B"));
		correct = new ArrayList<Integer>();
		correct.add(9);
		correct.add(10);
		correct.add(11);
		correct.add(12);
		assertEquals(correct, reverse.get("foo"));
		//just making sure there's no extra keys in the map
		assertEquals(reverse.size(), 3);
		//try with extra map
		reverse = SixMapAnd2DArrayProblems.reverseHashmap(new HashMap<Integer,String>());
		assertEquals(reverse.size(), 0);
	}

	@Test
	public void testGetCommonMother() {
		HashMap<String,String> mothers = new HashMap<String,String>();
		mothers.put("A","B");
		mothers.put("C","B");
		mothers.put("B", "Q");
		mothers.put("D", "Q");
		mothers.put("Q", "Eve");
		mothers.put("E", null);
		mothers.put("Al", "Eve");
		mothers.put("X", "foo");
		mothers.put("Y", "foo");
		mothers.put("Z", "foo");
		mothers.put("foo", null);
		assertEquals("B",SixMapAnd2DArrayProblems.getCommonMother(mothers, "A", "C"));
		assertEquals("Q",SixMapAnd2DArrayProblems.getCommonMother(mothers, "A", "D"));
		assertEquals("Q",SixMapAnd2DArrayProblems.getCommonMother(mothers, "A", "Q"));
		assertEquals(null,SixMapAnd2DArrayProblems.getCommonMother(mothers, "A", "E"));
		assertEquals("Eve",SixMapAnd2DArrayProblems.getCommonMother(mothers, "Al", "A"));
		assertEquals("foo",SixMapAnd2DArrayProblems.getCommonMother(mothers, "X", "Z"));
		assertEquals(null,SixMapAnd2DArrayProblems.getCommonMother(mothers, "X", "C"));
	}

	@Test
	public void testIsDiagonal() {
		int[][] array = {{1,0,0},{0,2,0},{0,0,3}};
		assertTrue(SixMapAnd2DArrayProblems.isDiagonal(array));
		array[0][2] = 44;
		assertFalse(SixMapAnd2DArrayProblems.isDiagonal(array));
		int[][] array2 = {{0,0},{0,99}};
		assertTrue(SixMapAnd2DArrayProblems.isDiagonal(array2));
		array2[1][0] = 5;
		assertFalse(SixMapAnd2DArrayProblems.isDiagonal(array2));
		int[][] array3 = {{1,0,0,0},{0,2,0,0},{0,0,3,0},{0,0,0,4}};
		assertTrue(SixMapAnd2DArrayProblems.isDiagonal(array3));
		array3[0][0] = 0;
		array3[0][3] = 5;
		assertFalse(SixMapAnd2DArrayProblems.isDiagonal(array3));
	}

	@Test
	public void testLongestRepeatSequence() {
		char[][] foo = {{'a','b','c'},{'d','d','e'}};
		assertEquals(2,SixMapAnd2DArrayProblems.longestRepeatSequence(foo));

		char[][] foo2 = {{'a','b','b'},{'b','e','f'}};
		assertEquals(3,SixMapAnd2DArrayProblems.longestRepeatSequence(foo2));

		char[][] foo3 = {{'a','b','b'},{'b','e','f'},{'b','e','f'},{'b','e','f'}};
		assertEquals(3,SixMapAnd2DArrayProblems.longestRepeatSequence(foo3));
		
		char[][] foo4 = {{'a','b','b'},{'b','e','f'},{'b','e','q'},{'q','q','q'}};
		assertEquals(4,SixMapAnd2DArrayProblems.longestRepeatSequence(foo4));
		
	}

	private char[][] strArrayToCharArray(String[] input) {
		char[][] result = new char[10][10];
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				result[i][j] = input[i].charAt(j);
			}
		}
		return result;
	}
	
	@Test
	public void testDistanceArray() {
		
		 String[] test1 = {
		 ".x........",
		 "xxx.......",
		 ".x........",
		 "..........",
		 "..........",
		 "..........",
		 "..........",
		 "..........",
		 "..........",
		 "..........",
		 };
		assertArrayEquals(strArrayToCharArray(test1), SixMapAnd2DArrayProblems.distanceArray(1, 1, 1));

		 String[] test2 = {
		 "xx........",
		 "x.........",
		 "..........",
		 "..........",
		 "..........",
		 "..........",
		 "..........",
		 "..........",
		 "..........",
		 "..........",
		 };
		assertArrayEquals(strArrayToCharArray(test2), SixMapAnd2DArrayProblems.distanceArray(0, 0, 1));

		String[] test3 = {
		 ".....xxx..",
		 "....xxxxx.",
		 ".....xxx..",
		 "......x...",
		 "..........",
		 "..........",
		 "..........",
		 "..........",
		 "..........",
		 ".........."};

		assertArrayEquals(strArrayToCharArray(test3), SixMapAnd2DArrayProblems.distanceArray(1, 6, 2));

		String[] test4 = {
				 "..........",
				 "..........",
				 "..........",
				 "..........",
				 "......x...",
				 ".....xxx..",
				 "....xxxxx.",
				 ".....xxx..",
				 "......x...",
				 ".........."};

		assertArrayEquals(strArrayToCharArray(test4), SixMapAnd2DArrayProblems.distanceArray(6, 6, 2));
	}

	@Test
	public void testBallRestElevation() {
		int[][] array1 = {
				{9,9,9,9,9,9},
				{9,8,5,4,9,9},
				{9,7,9,9,9,9},
				{9,7,5,2,2,9},
				{9,9,9,9,9,9}};
		assertEquals(4,SixMapAnd2DArrayProblems.ballRestElevation(array1));
		
		int[][] array3 = {
				{9,9,9,9,9,9},
				{9,8,9,4,1,9},
				{9,7,9,9,2,9},
				{9,6,5,4,3,9},
				{0,9,9,9,9,9}};
		assertEquals(1,SixMapAnd2DArrayProblems.ballRestElevation(array3));
		
		int[][] array2 = {
				{9,9,9,9,9,9},
				{9,8,6,4,9,9},
				{9,5,9,9,9,9},
				{9,5,5,2,2,9},
				{9,9,9,9,9,9}};
		assertEquals(5,SixMapAnd2DArrayProblems.ballRestElevation(array2));
		

	}

}
