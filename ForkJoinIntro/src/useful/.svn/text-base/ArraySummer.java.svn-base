package useful;

import java.util.concurrent.RecursiveTask;

/**
 * Recursive task to sum the elements of an array, based on Dan Grossman's
 * "useful example".
 * 
 * @author Dan Grossman and Curt Clifton.  Jan 10, 2011
 */
public class ArraySummer extends RecursiveTask<Long> {
	// TODO: experiment with varying this value
	/**
	 * Arrays smaller than this length are just summed without using recursion
	 * or parallel tasks.
	 */
	private static final int SEQUENTIAL_THRESHOLD = 10000000;
	
	private int[] array;
	private int low;
	private int high;
	
	/**
	 * Constructs a new ArraySummer for the given array.
	 *
	 * @param array
	 */
	public ArraySummer(int[] array) {
		this(array, 0, array.length);
	}
	
	/**
	 * Constructs a new ArraySummer for the portion of the given array from index
	 * low up to but not including index high. 
	 *
	 * @param array
	 * @param low
	 * @param high
	 */
	private ArraySummer(int[] array, int low, int high) {
		// This constructor is private, so it can only be used from inside this
		// class.  That's intentional!  This ensures that other code uses the
		// other constructor, which is simpler and just takes the array.
		this.array = array;
		this.low = low;
		this.high = high;
	}

	@Override
	protected Long compute() {
		int length = this.high - this.low;
		
		// Base case
		if (length <= SEQUENTIAL_THRESHOLD) {
			long sum = 0;
			for(int i=this.low; i < this.high; i++) {
				sum += this.array[i];
			}
			return sum;
		}
		
		// Recursive case
		int mid = this.low + length / 2;
		ArraySummer left = new ArraySummer(this.array, this.low, mid);
		ArraySummer right = new ArraySummer(this.array, mid, this.high);
		left.fork();
		long rightAns = right.compute();
		long leftAns = left.join();
		return leftAns + rightAns;
	}

}
