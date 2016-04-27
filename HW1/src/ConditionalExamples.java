/**
 * A class filled with interesting functions for learning.
 * 
 * @author Michael Hewner
 *
 */
public class ConditionalExamples {
	
	public static void main(String[] args){
		System.out.println(ConditionalExamples.computeAverage(4, 4, 5));
		System.out.println(ConditionalExamples.printCubed(5));
		System.out.println(ConditionalExamples.doEquation(3));
		ConditionalExamples.printDivisibleBy3(7);
		ConditionalExamples.guessCubeRoot(9,3);
		System.out.println(ConditionalExamples.isGreaterThan3(1,2,4));
	}
	/**
	 * 
	 * Computes the average of the three input numbers
	 * 
	 * We'll solve this one together
	 */
	public static double computeAverage(int one, int two, int three) {
		double result = ((double)one + two + three)/3;
		return result;
	}
	
	/**
	 * 
	 * Given a number, prints that number cubed (e.g. to the third power)
	 * The output should look like "3 cubed is 27!!!"
	 *
	 * Solve this one yourself
	 */
	public static double printCubed(double numberToCube) {
		double result = numberToCube * numberToCube * numberToCube;
		return result;
	}
	
	/**
	 * 
	 * Computes the function 0.5*x^2 + 3x + 99
	 * 
	 * Solve this one yourself
	 */
	public static double doEquation(int x) {
		return (double) (0.5*x*x + 3*x + 99);
	}
	
	/**
	 * 
	 * If the input number is divisible by 3, prints "divisible by 3!"
	 * Otherwise prints "NOT divisible by 3"
	 * 
	 * We'll solve this one as a group
	 */
	public static void printDivisibleBy3(int number) {
		if (number % 3 == 0){
			System.out.println("divisible by 3!");
		}
		else{
			System.out.println("NOT divisible by 3!");
		}
	}
	
	/**
	 * Takes a number and a guess for what it's cube root ought to be.
	 * If the guess is too high, print "Lower"
	 * if the guess is too low, print "Higher"
	 * If the guess is just right, print "Perfect"
	 * 
	 * So guessCubeRoot(9,2.5) would print "Higher"
	 *    guessCubeRoot(9,3.3) would print "Lower"
	 *    guessCubeRoot(9,3) would print "Perfect"
	 * 
	 * You'll solve this one yourself.  Use > < and ==
	 * 
	 */
	public static void guessCubeRoot(double number, double guess) {
		if (guess * guess * guess == number){
			System.out.println("Perfect");
			return;
		}
		if (guess * guess * guess < number){
			System.out.println("Lower");	
			return;
		}
			System.out.println("Higher");
	}
	
	/**
	 * Returns true if the first number is much larger (at least 100x larger)
	 * than the second.  You can assume the first number is larger than the 
	 * second.
	 * 
	 * We'll solve this one together
	 */
	public static boolean isWayBigger (int bigger, int smaller) {
		boolean result = bigger >= 100 * smaller;
		return result;
	}
	
	/**
	 * Returns true if at least 1 one of the 3 input values is greater than 3
	 * 
	 * hint: you can do a logical OR with the || operator
	 * 
	 * Solve this one yourself
	 */
	public static boolean isGreaterThan3 (int one, int two, int three) {
		boolean result = (one > 3) || (two > 3) || (three > 3);
		return result;
	}
	
	
}
