import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;


public class PartATest {

	
	@Test
	public void testFindLargest() {
		Assert.assertEquals(3, PartA.findLargest(1, 2, 3));
		Assert.assertEquals(3, PartA.findLargest(3, 2, 1));
		Assert.assertEquals(3, PartA.findLargest(1, 3, 2));
		Assert.assertEquals(5, PartA.findLargest(5, 5, 5));
		Assert.assertEquals(2, PartA.findLargest(-1, 2, -1));
	}
	
	@Test
	public void testMultiplyImaginary() {
		ImaginaryNum test1 = new ImaginaryNum(1,2);
		ImaginaryNum result = PartA.multiplyImaginaryByReal(test1, 2);
		Assert.assertEquals(2.0, result.getReal());
		Assert.assertEquals(4.0, result.getImaginary());
		
		//Your code should create a new number not modify the existing one
		Assert.assertEquals(1.0, test1.getReal());
		Assert.assertEquals(2.0, test1.getImaginary());
		
		ImaginaryNum test2 = new ImaginaryNum(0,0);
		result = PartA.multiplyImaginaryByReal(test2, 2);
		Assert.assertEquals(0.0, result.getReal());
		Assert.assertEquals(0.0, result.getImaginary());

	}
	
	@Test
	public void testCombineStrings() {
		String[] test1 = {"A","B","C"};
		assertEquals("A,B,C", PartA.combineStrings(test1));
		String[] test2 = {"aB Ba", "", "  ", "@%$"};
		assertEquals("aB Ba,,  ,@%$", PartA.combineStrings(test2));
		String[] test3 = {};
		assertEquals("", PartA.combineStrings(test3));

	}
	
	@Test
	public void testFirstLetterMatches() {
		String[] test1 = {"Afoo", "Blah", "Andy", "QQQ"};
		ArrayList<String> result = PartA.findFirstLetterMatches(test1, 'A');
		Assert.assertEquals(2, result.size());
		Assert.assertEquals("Afoo", result.get(0));
		Assert.assertEquals("Andy", result.get(1));
		result = PartA.findFirstLetterMatches(test1, 'Z');
		Assert.assertEquals(0, result.size());
		String[] empty = {};
		result = PartA.findFirstLetterMatches(empty, 'A');
		Assert.assertEquals(0, result.size());
	}
	

	@Test
	public void testCount4s() {
		int[][] test1 = {{1,2,3,4}};
		int[][] test2 = {{4},{2},{3},{4}};
		int[][] test3 = {{4,4,4},{4,0,4},{4,4,4}};
		Assert.assertEquals(1, PartA.count4s(test1));
		Assert.assertEquals(2, PartA.count4s(test2));
		Assert.assertEquals(8, PartA.count4s(test3));
	}
}
