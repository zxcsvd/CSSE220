package sll;

import java.util.NoSuchElementException;
import java.lang.IllegalStateException;

/**
 * An iterator over a Collection.  This is the same as java.util.Iterator
 * @author anderson, modified by defoe  Nov 7, 2013.
 *
 * @param <T> The type of the elements in the Collection.
 */
public interface Iterator<T> {
	
	/**
	 * 
	 * @return true if the iteration has more elements
	 */
	boolean hasNext() ;
	
	/**
	 * 
	 * @return the next element in the iteration.  
	 * @throws NoSuchElementException 
	 */
	T next() throws NoSuchElementException;
	
	/**
	 * Removes from the underlying collection the last element returned by the iterator (optional operation). 
	 * This method can be called only once per call to next.
	 * @throws IllegalStateException 
	 */
	
	void remove() throws IllegalStateException;

}
