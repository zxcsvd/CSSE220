import static org.junit.Assert.*;

import org.junit.Test;


public class RecursionProblemsTest {

	@Test
	public void testOddFactorial() {
		assertEquals(1, RecursionProblems.oddFactorial(1));
		assertEquals(1, RecursionProblems.oddFactorial(2));
		assertEquals(3, RecursionProblems.oddFactorial(3));
		assertEquals(15, RecursionProblems.oddFactorial(5));
		assertEquals(15, RecursionProblems.oddFactorial(6));
		assertEquals(105, RecursionProblems.oddFactorial(7));
	}

	@Test
	public void testCountSpacedPairs() {
		assertEquals(1,RecursionProblems.countSpacedPairs("AxA"));
		assertEquals(1,RecursionProblems.countSpacedPairs("AxAA"));
		assertEquals(3,RecursionProblems.countSpacedPairs("AxAxA"));
		assertEquals(1,RecursionProblems.countSpacedPairs("xxx"));
		assertEquals(0,RecursionProblems.countSpacedPairs("a"));
		assertEquals(0,RecursionProblems.countSpacedPairs(""));

	}

	@Test
	public void testNumberOfDifferences() {
		
		assertEquals(0,RecursionProblems.numberOfDifferences("abc", "abc"));
		assertEquals(4,RecursionProblems.numberOfDifferences("abcd", "dcba"));
		assertEquals(1,RecursionProblems.numberOfDifferences("abc", "abd"));
		assertEquals(1,RecursionProblems.numberOfDifferences("abc", "aXc"));
		assertEquals(1,RecursionProblems.numberOfDifferences("abc", "Xbc"));
		assertEquals(1,RecursionProblems.numberOfDifferences("cat", "cats"));
		assertEquals(4,RecursionProblems.numberOfDifferences("cats", ""));
		assertEquals(0,RecursionProblems.numberOfDifferences("", ""));
	}

}
