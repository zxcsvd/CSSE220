package sll;

/**
 * An ordered collection (also known as a sequence). 
 * The user of this interface has precise control over 
 * where in the list each element is inserted. 
 * The user can access elements by their integer 
 * index (position in the list), and search for elements in the list.
 * 
 * This interface contains a subset of the methods of java.util.List
 * 
 * @author anderson
 * 
 * @param <T> The type of the elements in the list.
 */
public interface List<T> extends Collection<T> {
	
	
	/**
	 * Inserts the specified element at the specified position in this list (optional operation).
	 * @param i index where x should be inserted
	 * @param x the item to insert
	 * @throws IndexOutOfBoundsException
	 */
	void add(int i, T x) throws IndexOutOfBoundsException;
	
	/**
	 * 
	 * @param index
	 * @return the element at this index
	 * @throws IndexOutOfBoundsException
	 */
	T get(int index) throws IndexOutOfBoundsException;
	
	/**
	 * 
	 * @param x the object to look for
	 * @return Returns the index of the first occurrence of x in this list, 
	 *         or -1 if this list does not contain x.
	 */
	int indexOf(T x);
	
	/**
	 * Replaces the element at the specified position in this list with 
	 * the specified element 
	 * @param index index of the element to replace
	 * @param element the element to be stored at the specified position 
	 * @return the element previously at the specified position 
	 * @throws IndexOutOfBoundsException
	 */
	T set(int index, T element) throws IndexOutOfBoundsException;
}
