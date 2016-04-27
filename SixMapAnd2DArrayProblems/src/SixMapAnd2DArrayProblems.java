import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


/**
 * Some practice problems with 2d arrays and hashmaps
 * Actually includes 6 regular problems and one bonus problem
 *
 * @author hewner.
 *         Created Dec 31, 2013.
 */
public class SixMapAnd2DArrayProblems {
	
	/**
	 * Given one string, return the most common character.
	 * 
	 * Example:
	 *   mostCommonCharacter("aaab") returns 'a'
	 *   mostCommonCharacter("abcbcdc") returns 'c'
	 * 
	 * You can assume that your string will not be empty and that
	 * one character will be more common than all the others (i.e. there
	 * won't be a tie for the most common character)
	 * 
	 * Your solution should use hashmaps, NOT nested for loops.
	 * You'll need one for loop though.
	 *
	 * @param input - string to find most common character of
	 * @return most common character
	 * 
	 */
	
	public static char mostCommonCharacter(String input) {
		
		int count = 0;
		int num = 0;	
		char result = input.charAt(0);
		char present = input.charAt(0);
		char tran = input.charAt(0);
		for(int j=0; j<input.length(); j++){
	
			count = 0;
			for(int i=0; i<input.length(); i++){
				present = input.charAt(i);
				if(present == input.charAt(j)){
					 count++;	 
				}
				tran = input.charAt(j);
			}

			if(count > num){
				result = tran;
				num = count;
				
			}
		}
		return result;
	}
	
	/**
	 * 
	 * Reverses (i.e. exchanges the keys and values) a hashmap which 
	 * may contain multiple keys with the same value.  Because of this,
	 * the values of the reversed map will be a list.
	 * 
	 * 
	 * For example:
	 * {1=A,2=A,3=B} yields {A=[1,2], B=[3]}
	 * 
	 * The initial hashmap maps Integers to Strings.
	 * The reversed hashmap will map Strings to ArrayLists of Integers/
	 * 
	 * @param initialMap the HashMap to be reversed
	 * @return a copy of the hashmap with keys and values exchanged
	 */
	public static HashMap<String,ArrayList<Integer>> reverseHashmap(HashMap<Integer,String> initialMap) {
		HashMap<String,ArrayList<Integer>> result = new HashMap<String,ArrayList<Integer>>();
		Set<Integer> keys = initialMap.keySet();
		for(int key: keys){
			
			String temp = initialMap.get(key);
			int count = 0;
			ArrayList<Integer> numList = new ArrayList<Integer>();
			for(int a: keys){
				if(initialMap.get(a) == temp){
					numList.add(a);
				}
			}
			
			result.put(temp, numList);
		}
		return result;
		
		
	}
	
	/**
	 * Given a map of people to their mothers, returns the common
	 * female ancestor of two people (tracking only the mother's line).
	 * 
	 * So for example, imagine a family tree (mothers only) that looks like this:
	 * 
	 *    E-+---\        G
	 *   /   \   \      / \
	 *  A    B    C    H   I
	 *      / \
	 *     D   F
	 * 
	 * So B is the mother of D and F.  E is D and F's maternal grandmother, etc.
	 * 
	 * This would be represented in a map like this:
	 * 
	 * {E=null,A=E,B=E,C=E,D=B,F=B,G=null,H=G,I=G}
	 *  
	 * getCommonMother(map,D,F) yields B
	 * getCommonMother(map,D,C) yields E
	 * getCommonMother(map,E,F) yields E
	 * getCommonMother(map,D,I) yields null (because D and I are not related)
	 *  
	 * @param motherMap map of a person's name to their mother's name
	 * @param person1 
	 * @param person2
	 * @return common female ancestor of both people, or null if no common ancestor exists
	 */
	public static String getCommonMother(HashMap<String,String> motherMap, String person1, String person2) {
		Set<String> keys = motherMap.keySet();
		String mother1 = person1;
		String mother2 = person2;
		
		ArrayList <String> first = new ArrayList<String>();
		ArrayList <String> second = new ArrayList<String>();
		first.add(person1);
		second.add(person2);
		
		for(String motherIfExist:keys){
			if(motherMap.containsKey(person1)){
				mother1 = motherMap.get(person1);
				person1 = mother1;
				first.add(mother1);
			}
		}
		for(String motherIfExists:keys){
			if(motherMap.containsKey(person2)){
				mother2 = motherMap.get(person2);
				person2 = mother2;
				second.add(mother2);
			}
		}
		for(int i=0; i<first.size(); i++){
			for(int j=0; j<second.size(); j++){
				if (first.get(i) == second.get(j)){
					return first.get(i);
				}
			}
		}
		return null;

	}
	
	/**
	 * 
	 * Given a square array, determines if is diagonal
	 * That is, returns true if all values in the array are 0 
	 * except the main diagonal.  The main diagonal is entries of the form
	 * data[i][j] where i == j.  Elements on the main
	 * diagonal can be 0 or any other number.
	 * 
	 * Examples:
	 * {{1,0,0},
	 *  {0,2,0}
	 *  {0,0,3}} yields true
	 *  
	 * {{1,0,9},
	 *  {0,2,0},
	 *  {0,0,3}} yields false because 0,2 is nonzero
	 * 
	 * {{0,0,0},
	 *  {0,0,0},
	 *  {0,0,3}} yields true because there can be 0
	 *                  entries on the diagonal if desired
	 * @param data input array
	 * @return true if it is diagonal, false otherwise
	 */
	public static boolean isDiagonal(int[][] data) {
		for(int i=0 ; i<data.length; i++){
			for(int j=0; j<data[0].length; j++){
				if(i != j){
					if(data[i][j]!=0){
						return false;
					}					
				}
			}
		}
		return true;
	}
	
	/**
	 * 
	 * Given a 2D array populated with a sequence of characters 
	 * that wrap from the rightmost position to the leftmost position 
	 * on the next row, find the length the longest sequence of repeated 
	 * characters. 
	 * 
	 * For example
	 * 
	 * abba
	 * dafa
	 * 
	 * Has a longest sequence of 2 for the 2 repeated
	 * bs
	 * 
	 * 2 Bs yield the longest repeat sequence here. Note that the As do not 
	 * follow after each other and hence, do not get considered.
	 * 
	 * The array is considered to "wrap" 
	 * from the rightmost position to the leftmost
	 * position on the next line.
	 * 
	 * For example:
	 * 
	 * abcdd
	 * ddefg
	 * 
	 * Is considered to have a longest sequence of 4
	 * because the two ds on the right "wrap around"
	 * to connect with the two ds on the next line 
	 * 
	 * @param data
	 * @return the length of the longest sequence
	 */
	public static int longestRepeatSequence(char[][] data) {
		char indicator = data[0][0];
		char temp = data[0][0];
		int counter = 0;
		int result = 0;
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data[0].length; j++){
				list.add(data[i][j]);
			}
		}	
		for(int k=0; k<list.size(); k++){
			temp = list.get(k);
			if (temp == indicator){
				counter++;
				if(counter > result){
					result = counter;
				}
			}
			else{
				indicator = temp;
				if(counter > result){
					result = counter;
				}
				counter = 1;
			}
		}
		return result;
	}
	
	
	/**
	 * Given A specific starting position and distance
	 * returns a 10x10 character array with all positions
	 * that are less than or equal to that manhattan distance 
	 * from the starting position marked with an x.
	 * 
	 * Recall the manhattan distance is the distance
	 * in terms of number of direct steps North South East West.
	 *
	 * You can compute the manhanttan distance with this formula
        * distance = |x1 - x2| + |y1 - y2|
	 * 
	 * Unmarked cells should be filled with a period '.'
	 * 
	 * For example, given row=1,col=1,distance 1
	 * .x........
	 * xxx.......
	 * .x........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * 
	 * For example, given row=1,col=6,distance 2
	 * .....xxx..
	 * ....xxxxx.
	 * .....xxx..
	 * ......x...
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........

	 * 
	 * @param row starting position row
	 * @param col starting position col
	 * @param distance
	 * @return new 10x10 char array with correct squares marked
	 */
	public static char[][] distanceArray(int row, int col, int distance) {
		char[][] resultArray = new char[10][10];
		
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				resultArray[i][j] = '.';
			}
		}
		for(int a=-distance; a<=distance; a++){
			for(int b=-distance; b<=distance; b++){
				int stepH = Math.abs(a);
				int stepV = Math.abs(b);
				if(stepH + stepV <= distance){
					if (row+a>=0 && row+a<=10 && col+b>=0 && col+b<=10){
						resultArray[row+a][col+b] = 'x';
					}
											
				}
			}
		}
		return resultArray;
	}
	
	/**
	 * BONUS: Extra credit problem
	 * 
	 * Feel free to skip this one if you don't have time.
	 * It's a little harder.
	 * 
	 * You are given a map indicating the elevation of
	 * a small area like a desk.  A ball is placed on the desk.
	 * The ball will roll downhill going north south east or west.
	 *
	 * The ball always starts at position 1,1
	 *
	 * It will always choose the path of steepest descent.
	 * It will eventually come to rest when it is at a position
	 * where all neighboring positions are higher/equal.  
	 * Return the elevation of that position.
	 * 
	 * You can assume that map will be such that the ball
	 * will always come to rest without moving through an edge
	 * 
	 * You can assume there will always be one steepest
	 * position for the ball to go to
	 * 
	 * For example, in an array like this:
	 * 9999
	 * 9549
	 * 9999 yields 4
	 * The ball would start in 1,1 (5) rolls to 4 and stops
	 * 
	 * 99999999999
	 * 98711111199
	 * 96999999999
	 * 95444444399
	 * 99999999999 yields 4
	 * The ball starts at 8, follows steepest decent to 6
	 * Then at the first 4 there is no lower position so it
	 * stops
	 * 
	 * @param map map indicating elevation
	 * @return height where the ball stops
	 */
	public static int ballRestElevation(int[][] map) {
		int col = 1;
		int row = 1;
		int now = map[1][1];
		int up = map[1][1];
		int down = map[1][1];
		int left = map[1][1];
		int right = map[1][1];
		int min = now;
		int[] nextPosition = new int[5];
		
		
		while (true){
			int count = 0;
			nextPosition[0] = map[row][col];
			nextPosition[1] = map[row-1][col];
			nextPosition[2] = map[row+1][col];
			nextPosition[3] = map[row][col-1];
			nextPosition[4] = map[row][col+1];
			int index = 0;
			
			for(int i=0; i<5; i++){
				if (nextPosition[i] < min){
					min = nextPosition[i];
					index = i;
				}
			}
			for(int j=0; j<5; j++){
				if(nextPosition[j] == min){
					count++;
				}
			}
			if(count >= 2){
				return min;
			}
			else{
				if (index == 0){
					return nextPosition[index];
				}
				if (index == 1){
					row--;
				}
				if (index == 2){
					row++;
				}
				if (index == 3){
					col--;
				}
				if (index == 4){
					col++;
				}
			}
		}
	}
}