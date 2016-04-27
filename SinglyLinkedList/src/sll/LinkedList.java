package sll;

import java.util.NoSuchElementException;

/**
 * This class provides a basic implementation of a singly linked list. It's
 * motivated by the implementation in Big Java, 5e, ch. 16.1.
 * 
 * @author TODO <Bo Peng> on <Feb 12th,2014>.
 * @param <T>
 *            The type of elements in the list
 */
public class LinkedList<T> implements List<T>, Iterable<T> {

	private ListNode<T> first;
	// Note that in addition to a head (first) pointer
	// this list contains a last pointer.  Be sure to
	// BOTH first and last up to date in all your code.
	private ListNode<T> last;

	/**
	 * Constructs a new, empty linked list.
	 */
	public LinkedList() {
		this.first = null;
		this.last = null;
	}

	@Override
	public String toString() {
		if (this.first == null) {
			return "[]";
		}
		String result = "[";
		ListNode<T> current = this.first;
		while (current != this.last) {
			result += (current.getElement() + ", ");
			current = current.getNext();
		}
		return result + current.getElement() + "]";
	}

	@Override
	public boolean add(T x) {
		// DONE 01 Implement the add(T x) method.
		ListNode<T> current = this.first;
		if(current == null){
			ListNode<T> newNode = new ListNode<T>(x, this.first); 
			this.first = newNode;
			this.last = newNode;
			return false;
		}
		while(current.getNext()!=null){
			current = current.getNext();
		} 
		ListNode<T> newNode = new ListNode<T>(x, null);
		current.setNext(newNode);
		this.last =newNode;
		return false;
	}

	@Override
	public int size() {
		int size = 0;
		ListNode<T> current = this.first;
		if(current == null){
			return 0;
		}
		while(current.getNext()!=null){
			current = current.getNext();
			size = size + 1;
		}
		size = size + 1;
		return size;
		// DONE 02 Implement the size() method.
	}

	@Override
	public void add(int i, T x) throws IndexOutOfBoundsException {
		ListNode<T> current = this.first;

		if(current == null){
			ListNode<T> newNode = new ListNode<T>(x, this.first); 
			this.first = newNode;
			this.last = newNode;
			return;
		}
		
		if(i == 0){
			ListNode<T> newNode = new ListNode<T>(x, this.first); 
			this.first = newNode;
		}
		else{
			int index = 1;
			while(index != i){
				int size = this.size();
				if(i<0 || i>size){
					throw new IndexOutOfBoundsException();
				}
				index++;
				current = current.getNext();
			} 
			if(index == i){
				
				ListNode<T> newNode = new ListNode<T>(x, current.getNext());
				current.setNext(newNode);
			}
		}
		while(current.getNext()!= null){
			current = current.getNext();
		}
		this.last =current;
		// DONE 03 Implement the add(int i, T x) method.
                // Note that this adds at the specific index
		
	}

	@Override
	public boolean contains(T x) {
		
		
		ListNode<T> current = this.first;
		if(this.size() == 0){
			return false;
		}
		if(current.getElement() == x){
			return true;
		}
		while(current.getNext()!=null){
			current = current.getNext();
			if(current.getElement() == x){
				return true;
			}
		}
		return false;
		

	}

	@Override
	public boolean remove(T x) {
		ListNode<T> current = this.first;
		if(this.contains(x)){
			if(current.getElement() == x){
				this.first = current.getNext();
				return true;
			}
			while(current.getNext()!=null){
				ListNode<T> previous = current;
				current = current.getNext();
				if(current.getElement() == x){
					current = current.getNext();
					previous.setNext(previous.getNext().getNext());
					return true;
				}
			}
		}
		// DONE 05 Implement the remove(T x) method.

		return false;
	}


	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		//		throws IndexOutOfBoundsException
		// DONE 06 Implement the get(int index) method.
//		try{
			int present = 0;
			int size = this.size();
			if(index<0 || index>=size){
				throw new IndexOutOfBoundsException();
			}
			ListNode<T> current = this.first;
			if(current == null){
				throw new IndexOutOfBoundsException();
			}
			if(index == 0){
				return current.getElement();
			}
			while(current.getNext()!=null){
				present = present + 1;
				current = current.getNext();
				if(present == index){
					return current.getElement();
				}
			}
//		}
//		catch (IndexOutOfBoundsException exception){
//			exception.printStackTrace(); 
//		}
//		return null;
			return null;

	}


	@Override
	public int indexOf(T x) {
		// DONE 07 Implement the indexOf(T x) method.
		int size = this.size();
		if(size == 0){
			return -1;
		}
		ListNode<T> current = this.first;
		int index = 0;
		if(current.getElement() == x){
			return index;
		}
		while(current.getNext()!=null){
			index = index + 1;
			current = current.getNext();
			if(current.getElement() == x){
				return index;
			}
		}
		return -1;


	}

	@Override
	public T set(int index, T element) throws IndexOutOfBoundsException {
		// DONE 08 Implement the set(int index, T element) method.
		int present = 0;
		int size = this.size();
		ListNode<T> current = this.first;
		if(index<0 || index>=size){
			throw new IndexOutOfBoundsException();
		}
		if(index == 0){
			T old = current.getElement();
			current.setElement(element);
			return old;
		}
		while(current.getNext()!=null){
			present = present + 1;
			current = current.getNext();
			if(present == index){
				T old = current.getElement();
				current.setElement(element);
				return old;
			}
		}
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	/**
	 * This is an iterator over this list.
	 * 
	 * @author TODO <Bo Peng> on <Feb 12th,2014>.
	 */
	private class LinkedListIterator implements Iterator<T> {

		private ListNode<T> current, previous;

		private LinkedListIterator() {
			this.current = null;
			this.previous = null;
		}

		@Override
		public boolean hasNext() {
			// TODO 09 Implement the hasNext() method.
			
			if(this.current== null){
				return first != null;
			}
			else{
				return current.getNext() != null;
			}
		}

		@Override
		public T next()  {
			// DONE 10 Implement the next() method.
			if(!hasNext()){
				throw new NoSuchElementException();
			}	
			this.previous = this.current;
			if(this.current == null){
				this.current =LinkedList.this.first;
			}else{
				this.current = this.current.getNext();
			}
			return this.current.getElement();
		}

		@Override
		public void remove() {
			// TODO 11 Implement the remove() method.
			if(this.current == this.previous){
				throw new IllegalStateException();
			}
			if(this.current == LinkedList.this.first){
				LinkedList.this.remove(LinkedList.this.first.getElement());
			}
			else{
				this.previous.setNext(this.current.getNext());
			}
			this.current = this.previous;
		}
	}

}
