/**
 * 
 */
package sll;

/**
 * 
 * @author anderson
 * 
 * This interface contains a subset of the methods of java.util.List
 *
 * @param <T> the type of the elments in this Collection
 */
public interface Collection<T> {
	
	/**
	 * Adds x to this collection
	 * @param x the element to be added
	 * @return true if this collection was changed as a result of this call.  
	 */
	boolean add(T x);
	
	/**
	 * 
	 * @return the number of elemnets in this collection
	 */
	int size();
		
	/**
	 * 
	 * @param x
	 * @return true if this collection contains x
	 */
	boolean contains (T x);
	
	/**
	 * Removes a single instance of the specified element from this 
	 * collection, if it is present  
	 * @param x element to be removed from this collection, if present 
	 * @return true if an element was removed as a result of this call 
	 */
	boolean remove(T x);
		
}
