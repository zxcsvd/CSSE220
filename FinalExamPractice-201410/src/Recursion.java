import java.util.ArrayList;


public class Recursion {

	/**
	 * 
	 * Returns a string where each character is surrounded by ( and )
	 * For example
	 *    surroundCharactersWithParen("abc") returns "(a)(b)(c)"
	 *    
	 * You must solve this problem with recursion
	 */
	public String surroundCharactersWithParen(String input) {
		if(input.length() ==0){
			return input;
		}
		String first = input.substring(0,1);
		String remain = input.substring(1, input.length());
		
		return "(" + first+ ")" +  surroundCharactersWithParen(remain);
	}
	
	/**
	 * 
	 * Takes in a string that represents a series of wins, losses, and ties.
	 * Returns a score for the overall series where a win is worth 1 point
	 * a tie is worth 0 points and a loss is worth -1 points.  The string
	 * will consist exclusively of Ws, Ls, and Ts (representing wins losses
	 * and ties respectively).
	 * 
	 * For example:
	 *    overallScore("WWL") returns 1
	 *    overallScore("TTLLL") returns -3
	 *    overallScore("") returns 0
	 *    
	 * You must solve this problem with recursion
	 */
	public int overallScore(String series) {
		if(series.length() == 0){
			return 0;
		}
		String current = series.substring(0,1);
		String remain = series.substring(1, series.length());
		int score = 0;
		if(current.equals("W")){
			score = 1;
		}
		if(current.equals("T")){
			score = 0;
		}
		if(current.equals("L")){
			score = -1;
		}
		return score + overallScore(remain);
	}
	
	/**
	 * 
	 * Takes in an ArrayList<Integer> and returns the largest element.
	 * You are allowed to modify the ArrayList and remove elements if 
	 * you wish, but I'll be more impressed with your code if you use
	 * a helper function so that the arraylist does not need to be modified.
	 * (Me being impressed won't score you any more points though)
	 * 
	 * Note that attempting to get the largest element of an empty list
	 * is undefined.  If the function is called with an empty list,
	 * your code should throw an IllegalArguementException
	 * 
	 * For example:
	 * largestElement of [1,2,2,-1] returns 2
	 * largestElement of [-25] returns -25
	 * largestElement of [] throws IllegalArguementException
	 * 
	 * You must solve this problem with recursion
	 */
	public int largestElement(ArrayList<Integer> list) {
//		try{
			if(list.size() == 0){
				throw new IllegalArgumentException();
			}
			if(list.size()==1){
				return list.get(0);
			}

			int first = list.get(0);
			ArrayList<Integer> helper = new ArrayList<Integer>();
			for(int i=1; i< list.size(); i++){
				helper.add(list.get(i));
			}
			if(first >= largestElement(helper)){
				return first;
			}
			else{
				return largestElement(helper);
			}
//		}catch(IllegalArgumentException exception){
//			
//		}
//		return 0;
	}
}
