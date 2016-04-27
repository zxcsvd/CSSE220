package examples;

public class SimplePalindrome {
	
	/**
	 * Returns true if the input string is a palindrome
	 * (reads the same backwards and forwards)
	 * 
	 * For example the string "aba" is a palindrome.
	 * The string "abc" is not because abc backwards is cba
	 * 
	 * Spaces are not considered special in this palindrome.
	 * See sentence for a more complex palindrome problem.
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isPalindrome(String input) {
		if (input.length() == 0 || input.length() == 1){
			return true; 
		}
		
		String remain = input.substring(1, input.length()-1);
		Boolean result = (isPalindrome(remain)) && (input.charAt(0) == input.charAt(input.length() - 1));
		return result;
//		if(input.length() <= 1){
//			return true;
//		}
//		if(input.charAt(0) != input.charAt(input.length() - 1)){
//			return false;
//		}
//		String stringWithoutEnds = input.substring(1, input.length() - 1);
//		return isPalindrome(stringWithoutEnds);
	}
	
	/**
	 * Returns true if the input array is a palindrome.
	 * 
	 * For example, the array {1,2,1} is a palindrome.
	 * The array {1,2,3} is not.
	 * 
	 * This problem is much easier with the use of
	 * a helper method.
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isPalindromeIntArray(int[] input) {
		return isPalindromeIntArrayHelper(input, 0, input.length -1);
	}
	public static boolean isPalindromeIntArrayHelper(int[] input, int startingIndex, int endingIndex) {
		if(startingIndex >= endingIndex){
			return true;
		}
		
		if(input[startingIndex]!= input[endingIndex]){
			return false;
		}
		return isPalindromeIntArrayHelper(input, startingIndex +1, endingIndex -1);
	}	
}
