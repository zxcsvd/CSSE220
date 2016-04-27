package mergesort;

import java.util.Arrays;

/**
 * An implementation of the classic merge sort algorithm, based on one from Cay
 * Horstmann's Big Java.  It's modified to use our naming and code formatting
 * conventions.
 * 
 * @author Cay Horstmann and Curt Clifton. Created Jan 10, 2011.
 */
public class SequentialMergeSorter {

	private int[] array;

	/**
	 * Constructs a SequentialMergeSorter for the given array.
	 * 
	 * @param array
	 */
	public SequentialMergeSorter(int[] array) {
		this.array = array;
	}

	/**
	 * Causes the stored array to be sorted.
	 */
	public int[] sort() {
		if (this.array.length <= 1) {
			return this.array;
		}

		int[] firstHalf = Arrays.copyOfRange(this.array, 0,
				this.array.length / 2);
		int[] secondHalf = Arrays.copyOfRange(this.array,
				this.array.length / 2, this.array.length);

		SequentialMergeSorter firstHalfSorter = new SequentialMergeSorter(
				firstHalf);
		SequentialMergeSorter secondHalfSorter = new SequentialMergeSorter(
				secondHalf);

		firstHalfSorter.sort();
		secondHalfSorter.sort();

		merge(firstHalf, secondHalf);
		return this.array;
	}

	/**
	 * Merges two sorted arrays into the array managed by this merge sorted.
	 * 
	 * @param first
	 *            must be sorted
	 * @param second
	 *            must be sorted
	 */
	private void merge(int[] first, int[] second) {
		int indexFirst = 0; // index to consider next in first array
		int indexSecond = 0; // index to consider next in second array
		int indexToStore = 0; // next open position in this.array to which to
								// store

		// Keep moving the smallest value into the result until we exhaust
		// one of the input arrays.
		while (indexFirst < first.length && indexSecond < second.length) {
			if (first[indexFirst] < second[indexSecond]) {
				this.array[indexToStore] = first[indexFirst];
				indexFirst++;
			} else {
				this.array[indexToStore] = second[indexSecond];
				indexSecond++;
			}
			indexToStore++;
		}

		// One of the two inputs has been exhausted, so only one of the two
		// loops below does any work.
		while (indexFirst < first.length) {
			this.array[indexToStore] = first[indexFirst];
			indexFirst++;
			indexToStore++;
		}
		
		while (indexSecond < second.length) {
			this.array[indexToStore] = second[indexSecond];
			indexSecond++;
			indexToStore++;
		}

	}

}
