package priorityQueue;

/**
 * An element node of a Priority Queue.
 * 
 * You should not change this class at all.
 * 
 * @param <T>
 *            the type of elements in the priority queue
 */
public class PQElement<T> implements Comparable<PQElement<T>> {

	private int priority;
	private T element;
	private int creationOrder;
	private static int creationOrderCounter = 0;

	/**
	 * Constructs a priority queue node for the given element with the given
	 * priority.
	 * 
	 * @param priority
	 * @param element
	 */
	public PQElement(int priority, T element) {
		this.priority = priority;
		this.element = element;
		this.creationOrder = creationOrderCounter++;
	}

	/**
	 * @return the priority of the contained element
	 */
	int getPriority() {
		return this.priority;
	}

	/**
	 * @return the contained element
	 */
	T getElement() {
		return this.element;
	}

	/**
	 * Compares the contained element to the given element, first by priority,
	 * and then by node creation order.
	 * 
	 * @param other
	 * @return comparison result according to the
	 *         {@link Comparable#compareTo(Object)} specification.
	 */
	public int compareTo(PQElement<T> other) {
		if (this.priority == other.priority)
			return this.creationOrder - other.creationOrder;
		return this.priority - other.priority;
	}

	@Override
	public String toString() {
		return "(" + this.priority + ", " + this.element + ")";
	}
}
