package useful;

import java.util.concurrent.ForkJoinPool;

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
 * This class runs the "useful" example from Dan Grossman's Beginners
 * Introduction to the Java ForkJoin Framework.
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
	private static int SIZE = 10000000;

	/**
	 * Starts the example.
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {
		// SEE THE BIG COMMENT AT THE TOP OF THE FILE FOR HELP ON RUNNING THIS.
		
		System.out.printf("Testing with arrays of size %,d%n", SIZE);
		int[] values = ArrayGenerator.getOnesArray(SIZE);
		ArraySummer sa = new ArraySummer(values);
		long result = fjPool.invoke(sa);
		System.out.printf("The sum is %,12d%n", result);

		System.out.println("Generating random array.");
		values = ArrayGenerator.getRandomArray(SIZE, RANDOM_MAX);
		// Runs the summation multiple times so:
		// - JVM has a chance to optimize the code, simulating a long-running
		// program
		// - timing information will average out "noise" from other tasks on the
		// system
		StopWatch timer = new StopWatch();
		System.out.println("Beginning timing tests.");
		timer.start();
		for (int i = 0; i < TEST_ITERATIONS; i++) {
			sa = new ArraySummer(values);
			result = fjPool.invoke(sa);
		}
		timer.stop();
		System.out.printf("The sum is %,12d%n", result);
		System.out.printf(
				"Calculated in an average time of %.2f ms over %d tests%n",
				timer.getElapsedTime() / (double) TEST_ITERATIONS,
				TEST_ITERATIONS);
	}
}
