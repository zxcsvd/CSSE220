package mergesort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import useful.ArraySummer;
import util.ArrayGenerator;
import util.StopWatch;

/* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 * NOTE WELL: To run this in Eclipse you have to customize the run configuration.
 * 
 * 1. Choose Run As -> Run Configurations.
 * 2. In the Arguments tab, type the following EXACTLY in the VM Arguments 
 *    section:
 *                -Xbootclasspath/p:jsr166.jar
 * 3. Click Run
 * 
 * For subsequent runs you can just run like normal; Eclipse will remember the
 * configuration for this file.
 * 
 * You can also increase the amount of memory allocated by adding an additional
 * VM Argument.  For example, to allocate 1 GB of memory to the VM, use:
 * 
 *                -Xmx1G
 * 
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! */

/**
 * This class tests various implementations of merge sort.
 * 
 * @author Curt Clifton. Created Jan 10, 2011.
 */
public class Main {
	/**
	 * Largest random number to generate, exclusive.
	 */
	private static final int RANDOM_MAX = 100;

	/**
	 * Number of times to repeat the test when collecting timing information.
	 */
	private static final int TEST_ITERATIONS = 1000;

	/**
	 * Pool to manage/schedule tasks.
	 */
	private static ForkJoinPool fjPool = new ForkJoinPool();

	// TODO: experiment with varying this value
	/**
	 * Size the arrays to use in testing.
	 */
	private static int SIZE = 100000;
	/**
	 * Starts the tests.
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {
		System.out
				.printf("Generating random arrays with %,d elements.%n", SIZE);
		int[] array1 = ArrayGenerator.getRandomArray(SIZE, RANDOM_MAX);
		int[] array2 = Arrays.copyOf(array1, array1.length);

		System.out.println("Testing algorithms");
		
		SequentialMergeSorter sms = new SequentialMergeSorter(array1);
		
		StopWatch timer = new StopWatch();
		System.out.println("Beginning timing tests.");
		timer.start();
		for (int i = 0; i < TEST_ITERATIONS; i++) {
			sms = new SequentialMergeSorter(array1);
			sms.sort();
			
		}
		if (isSorted(array1)) {
			System.out.println("Sequential Success!");
		} else {
			System.out.println("Sequential result was not sorted. :-(");
		}
		timer.stop();
		System.out.printf(
				"Calculated in an average time of %.2f ms over %d tests%n",
				timer.getElapsedTime() / (double) TEST_ITERATIONS,
				TEST_ITERATIONS);
		
		
		

		
		StopWatch timer2 = new StopWatch();
		System.out.println("Beginning timing tests.");
		timer2.start();
		for (int i = 0; i < TEST_ITERATIONS; i++) {
			ParallelMergeSorter pms = new ParallelMergeSorter(array2);
			array2 = fjPool.invoke(pms);
		}

		
		if (isSorted(array2)) {
			System.out.println("Parallel Success!");
		} else {
			System.out.println("Parallel result was not sorted. :-(");
		}
		timer2.stop();
		System.out.printf(
				"Calculated in an average time of %.2f ms over %d tests%n",
				timer2.getElapsedTime() / (double) TEST_ITERATIONS,
				TEST_ITERATIONS);
		
		
		
		// TODO: Add code to run timing tests on SequentialMergeSorter and
		// ParallelMergeSorter AS DESCRIBED IN THE HOMEWORK.
	}

	/**
	 * @param array
	 * @return true iff the given array is sorted in ascending order
	 */
	private static boolean isSorted(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				return false;
			}
		}
		return true;
	}

}
