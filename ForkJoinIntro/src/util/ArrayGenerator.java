package util;

import java.util.Arrays;

/**
 * This utility class has static methods for generating various arrays.
 * 
 * @author Curt Clifton. Created Jan 10, 2011.
 */
public class ArrayGenerator {

	/**
	 * Returns an array initialized with random integers.
	 *
	 * @param length
	 * @param maxRandom maximum value of generated random numbers, exclusive
	 * @return the array
	 */
	public static int[] getRandomArray(int length, int maxRandom) {
		int[] result = new int[length];
		for (int i = 0; i < result.length; i++) {
			result[i] = (int) (Math.random() * maxRandom);
		}
		return result;
	}

	/**
	 * Returns an array initialized with all 1s.
	 *
	 * @param length
	 * @return the array
	 */
	public static int[] getOnesArray(int length) {
		int[] result = new int[length];
		Arrays.fill(result, 1);
		return result;
	}

}
