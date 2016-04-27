package sll;

/**
 * Has a factory method for creating an Iterator.
  * @param <T>
 *            The type of elements in the list
 *
 * @author defoe.
 *         Created Nov 7, 2013.
 *         
 */
public interface Iterable<T> {
	
	/**
	 * Returns an iterator over the elements in this collection. 
	 * There are no guarantees concerning the order in which 
	 * the elements are returned (unless this collection is an 
	 * instance of some class that provides a guarantee). 
	 * @return an Iterator over the elements in this collection
	 */
	Iterator<T> iterator();

}
