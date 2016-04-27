
/**
 * Several small problems for demonstrating the use of unit testing
 *
 * @author defoe.
 *         Created Dec 6, 2013.
 */
public class UnitTestingExamples {
	
	
	/**
	 * Computes the area of a rectangle with given width and height
	 *
	 * @param width
	 * @param height
	 * @return area of rectangle
	 */
	public static int findRectangleArea(int width, int height){
		if (width < 0 || height < 0)
			return -1;
		
		return width * height;
	}
	
	/**
	 * Computes the mean of several scores
	 *
	 * @param scores array of scores
	 * @return the mean of scores
	 */
	public static double computeMean(double[] scores){
		double sum = 0;
		for(int i = 0; i < scores.length; i++){
			sum += scores[i];
		}
		if(scores.length > 0){
		return sum / (scores.length);
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Returns the first word in a given string
	 *
	 * @param str
	 * @return first word in str
	 */
	public static String firstWord(String str){
		if (str == null){
			return null;
		}
		String[] strings = str.split("\\s+");
		System.out.println(strings[strings.length - 1]);
		return strings[strings.length - 1];
	}
	
	
	/**
	 * Determine whether the list of words contains the given word
	 *
	 * @param words
	 * @param word
	 * @return True if words contains word, false otherwise
	 */
	public static boolean contains(String words[], String word){
		if (words == null){
			return false;
		}
		
		for(int i = 0; i < words.length; i++){
			if(words[i].equals(word)){
				return true;
			}
		}
		return false;
		
	}

}
