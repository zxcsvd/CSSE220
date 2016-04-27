package sll;

/**
 * This is a representation of a node for a singly linked list. A node has an
 * element and a pointer to the next node in the list.
 * 
 * @author defoe. Created Nov 7, 2013.
 * @param <T>
 */
public class ListNode<T> {
	private T element;
	private ListNode<T> next;

	/**
	 * Constructs a node with the given element and the next node to point to.
	 * 
	 * @param e
	 *            Element to store in this node.
	 * @param n
	 *            The next node to point to.
	 */
	public ListNode(T e, ListNode<T> n) {
		this.setElement(e);
		this.setNext(n);
	}

	/**
	 * Constructs a node with the given element. There is no next node to point
	 * to.
	 * 
	 * @param e
	 */
	public ListNode(T e) {
		this(e, null);
	}

	/**
	 * Constructs an empty node.
	 * 
	 */
	public ListNode() {
		this(null, null);
	}

	/**
	 * Returns the value of the field called 'element'.
	 * 
	 * @return Returns the element.
	 */
	public T getElement() {
		return this.element;
	}

	/**
	 * Sets the field called 'element' to the given value.
	 * 
	 * @param element
	 *            The element to set.
	 */
	public void setElement(T element) {
		this.element = element;
	}

	/**
	 * Returns the value of the field called 'next'.
	 * 
	 * @return Returns the next.
	 */
	public ListNode<T> getNext() {
		return this.next;
	}

	/**
	 * Sets the field called 'next' to the given value.
	 * 
	 * @param next
	 *            The next to set.
	 */
	public void setNext(ListNode<T> next) {
		this.next = next;
	}
}
