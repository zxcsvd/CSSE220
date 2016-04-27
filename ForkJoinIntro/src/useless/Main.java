package useless;

import java.util.concurrent.ForkJoinPool;

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
 * 
 * You can also increase the amount of memory allocated by adding an additional
 * VM Argument.  For example, to allocate 1 GB of memory to the VM, use:
 * 
 *                -Xmx1G
 * 
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! */

/**
 * This class runs the "useless" example from Dan Grossman's Beginners Introduction
 * to the Java ForkJoin Framework.
 *
 * @author Curt Clifton.
 *         Created Jan 10, 2011.
 */
public class Main {
	private static ForkJoinPool fjPool = new ForkJoinPool();

	/**
	 * Starts the example.
	 *
	 * @param args ignored
	 */
	public static void main(String[] args) {
		// SEE THE BIG COMMENT AT THE TOP OF THE FILE FOR HELP ON RUNNING THIS.
		Incrementor incrementor = new Incrementor(42);
		int nextNumber = fjPool.invoke(incrementor);
		
		System.out.println("The answer is " + nextNumber);
	}

}
