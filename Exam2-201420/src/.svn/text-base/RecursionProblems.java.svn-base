
public class RecursionProblems {

	/**
	 * 
	 * Odd factorial is computed by multiplying all
	 * ODD numbers from 1 to the given number together.
	 * 
	 * Even fact
	 * 
	 * For example:
	 * 
	 * oddFactorial(5) = 1*3*5 = 15
	 * evenFactorial(7) = 1*3*5*7 = 105
	 * evenFactorial(8) = 1*3*5*7 = 105
	 * evenFactorial(1) = 1
	 * 
	 * @param number
	 * @return
	 */
	public static int oddFactorial(int number) {
		if(number <=1){
			return 1;
		}
		if (number % 2 == 0){
			return oddFactorial(number - 2) * (number - 1);
		}
		return oddFactorial(number - 2) * number;
	}
	
	/**
	 * 	A "spaced pair" in a string is two instances of a char separated by a char. 
	 *  So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA" contains 3 pairs -- 2 for A and 1 for x. 
	 *  
	 *  The function counts the number of spaced pairs in the given string
	 *  
	 *  countSpacedPairs("axa") returns 1 
	 *  countSpacedPairs("axax") returns 2
	 *  countSpacedPairs("axbx") returns 1
	 *  conntSpacedPairs("aa") returns 0
	 */

	public static int countSpacedPairs(String input) {
		if (input.length()<=2){
			return 0;
		}
		if(input.charAt(0) == input.charAt(2)){
			return 1+ countSpacedPairs(input.substring(1, input.length()));
		}
		return countSpacedPairs(input.substring(1, input.length()));
	}
	
	
	/**
	 * 
	 * Returns the number of positions where the two given strings have different characters.
	 * So abC and abD have 1 difference
	 * 
	 * Note that if one string is shorter than the other, all the remaining
	 * characters count as differences.  So a and xzy have 3 differences.
	 * 
	 * 
	 * Examples
	 *   numberOfDifferences("abc","abc") returns 0
	 *   numberOfDifferences("abcd","dcba") returns 4
	 *   numberOfDifferences("axbc","aybc") returns 1 
	 *   numberOfDifferences("cats","cat") returns 1
	 *   numberOfDifferences("","cats") returns 4
	 *   numbrtOfDifferences("","") returns 0
	 * 
	 * @param length
	 * @return
	 */
	public static int numberOfDifferences(String input1, String input2) {
		int first = input1.length();
		int second = input2.length();
		int abs = Math.abs(first-second);
		if(input1.isEmpty()||input2.isEmpty()){
			return abs;
		}
		if(input1.charAt(0) == input2.charAt(0)){
			return numberOfDifferences(input1.substring(1, first), input2.substring(1, second));
		}
		else{
			return 1 + numberOfDifferences(input1.substring(1, first), input2.substring(1, second));
		}
	}
	
}
