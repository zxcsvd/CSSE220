
public class Part2 {

	/**
	 * 
	 * Recursively returns the number of capital Ts in the given string.
	 * Do not use any loop structures - only recursion.
	 * 
	 * @param input
	 */
	public int countTs(String input)
	{
		if(input.length()<=0){
			return 0;
		}
		String first = input.substring(0, 1);
		if(first.equals("T")){
			return 1 +  countTs(input.substring(1, input.length()));
		}
		return countTs(input.substring(1, input.length()));	
	}

	/**
	 * 
	 * Takes a given string and reflects it, making it a palindrome 
	 * (a string that reads the same backwards and forward).
	 * So for example "abcd" becomes "abcdcba".  Note that the last character
	 * of the string is not duplicated - it becomes the center character
	 * of the palindrome.
	 * 
	 * Do not use any loop structures - only recursion.
	 * 
	 * @param input
	 */
	public String makePalindrome(String input)
	{
		if(input.length()<=1){
			return input;
		}
		String first = input.substring(0, 1);
		String remain = input.substring(1, input.length());
		return first + makePalindrome(remain) + first;
	}
	
	/**
	 * 
	 * Given a number, returns true if that number consists of strictly
	 * increasing digits.  So for example, the number 12345 consists of
	 * increasing digits, as does the number 3589.  The number 12314 does
	 * not, because 3 to 1 is a decrease.  The number 11 does not, because
	 * 1 to 1 is not a strict increase.  Note that one digit numbers are
	 * always considered strictly increasing.
	 * 
	 * Hint: you can extract the rightmost digit of a number by using
	 * % 10.  For example 123 % 10 = 3.  You can reduce a number by one
	 * digit by dividing by 10.  For example 123 / 10 = 12.
	 * 
	 *  Do not use any loop structures, only recursion.
	 *  
	 */
	public boolean hasStrictlyIncreasingDigits(int num)
	{
		if(num<10){
			return true;
		}
		int currentInt = num % 10;
		int previousInt = (num / 10) % 10;
		int remain = num / 10;
		if(currentInt > previousInt){
			return true && hasStrictlyIncreasingDigits(remain);
		}
		return false;
		
	}
}
