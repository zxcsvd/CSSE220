
/**
 * A class for linked list problems.
 * 
 * A few methods have already been written for you.
 * 
 * Note that you should feel free to add new methods
 * (e.g. utility methods like size() or recursive helper
 * methods) if they will help you solve the problems.
 * 
 * @author TODO <YOUR_NAME_GOES_HERE>
 *
 */
public class StringLinkedList {

	private class Node {
		
		public Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		public String data;
		public Node next;
		
	}
	
	private Node first;
	
	/**
	 * Default constructor.
	 *
	 */
	public StringLinkedList()
	{
		this.first = null;
	}
	
	/**
	 * Adds a string as the new first element of this list
	 * 
	 * Note - you should not need to modify this method!
	 * 
	 * @param newData 
	 * 
	 */
	public void addFirst(String newData)
	{
		Node newNode = new Node(newData, this.first);
		this.first = newNode;
	}
	
	/**
	 * Removes the last element of this list
	 * Returns the data of the element that is removed
	 * 
	 * If the list is empty, returns null
	 * 
	 * Note - you should not need to modify this method!
	 * 
	 * @return the data of the element that is removed
	 * 
	 */
	public String removeLast()
	{
		//zero element list
		if(this.first == null) return null;
		
		//one element list
		if(this.first.next == null) {
			String data = this.first.data;
			this.first = null;
			return data;
		}
		
		//the rest
		Node current = this.first;
		while(current.next.next != null) {
			current = current.next;
		}
		String data = current.next.data;
		current.next = null;
		return data;
	}
	
	/**
	 * Removes all elements after a particular max size.
	 * 
	 * So for example, if the list max size was 2:
	 * 
	 * "1"->"2"->"3"->"4" becomes "1"->"2"
	 * "a"->"b"->"c" becomes "a"->"b"
	 * "a" becomes "a"
	 * 
	 * Note that you'll need a special case for when maxSize = 0
	 * 
	 * 
	 * @param maxSize
	 */
	public void limitToSize(int maxSize) {

		
		int counter = 1;
		Node current = this.first;
		while(counter < maxSize){
			current= current.next;
			counter++;
			

		}
		current.next = null;
		
		if(maxSize == 0){
			this.first = null;
		}
	}
	 
	/**
	 * Returns true if the list is sorted, false otherwise.
	 * 
	 * For example:
	 * 
	 * The list "apple"->"bacon"->"ninja" would return true
	 * This list "bigger"->"badder" would return false
	 * 
	 * Use string's compareTo method to compare strings
	 * 
	 * An empty list or a list with one element is always considered sorted
	 * 
	 * @return true if list is sorted
	 */
	public boolean isSorted() {
//		Node previous = this.first;
		if(this.first == null){
			return true;
		}
		int counter= 0;
		Node current = this.first;
		
		
		
		while(current.next!= null) {
			if(current.data.compareTo(current.next.data) <= 0){
				current = current.next;
				counter++;
			}
			else{
				break;
			}
		}
		if(counter == this.size() - 1){
			return true;
		}
		return false;
	}
	
	public int size(){
		if(this.first == null){
			return 0;
		}
		
		int counter = 1;
		Node current = this.first;
		while(current.next!= null) {
			counter++;
			current = current.next;
		}
//		System.out.println(counter);
		return counter;
	}
	/**
	 * 
	 * Takes a list of strings and converts it to a list of strings
	 * such that each string is one (or zero) characters long.
	 * 
	 * So for example:
	 * "foo"->"bar" yields "f"->"o"->"o"->"b"->"a"->"r"
	 * "a"->""->"bc" yields "a"->""->"b"->"c"
	 * 
	 * Note that the empty string stays the empty string.
	 * 
	 * Also recall that you can convert a character to a string by adding ""
	 * String s = 'a' + "";
	 */
	public void explodeStrings() {
		if(this.first == null){
			return;
		}
		Node current = this.first;
		Node subfirst = null;
		Node subfirstF = null;
		Node subcurrent = null;
		String firstData = current.data;

		for (int i=0; i< firstData.length(); i++){
			String presentString = new String(firstData.substring(i, i+1));
			Node subPresent = new Node(presentString, null);
//			String nextString = null;
			
			if(i>=1 && i<firstData.length()){
				subcurrent.next = subPresent;
				subcurrent = subcurrent.next; 
			}
			
			if(i == 0){
				String firstChar = new String(firstData.substring(0,1));
				subfirstF = new Node(firstChar, null);
				subcurrent = subfirstF;
			}
			
//			if(i == firstData.length() -1){
//				subcurrent.next = subPresent;
//			}
			
		}
//		subcurrent = subcurrent.next;
		
		
		
		
		while(current.next!= null) {

			current = current.next;
			
			String stringData = new String (current.data);
			
			if(stringData.equals("")){
				String presentString = new String("");
				Node subPresent = new Node(presentString, null);
				subcurrent.next = subPresent;
				subcurrent = subcurrent.next;
			}
			
			for (int i=0; i< stringData.length(); i++){
				String presentString = new String(stringData.substring(i, i+1));
				Node subPresent = new Node(presentString, null);
//				String nextString = null;
				
				if(i>=1 && i<stringData.length()){
					subcurrent.next = subPresent;
//					subcurrent = subcurrent.next; 
				}
				
				if(i == 0){
					String firstChar = new String(stringData.substring(0,1));
					subfirst = new Node(firstChar, null);
					subcurrent.next = subfirst;
				}
				subcurrent = subcurrent.next;
//				if(i == stringData.length() -1){
//					subcurrent.next = subPresent;
//				}
				
			}
	
		}
		this.first = subfirstF;
		
		current = this.first;
		while(current!= null){
			System.out.println(current.data);
			current = current.next;
		}
		
		
		
	}
	
//	public void changeAllToChar(Node change){
//		Node next;
//		if(change.next!= null){
//			next = new Node(change.next.data, change.next.next);
//		}
//		else{
//			next = null;
//		}
//		String data = change.data;
//		Node newFirst = null;
//		Node current = null; 
//		if(change.data.length() == 0){
//			
//		}
//		if(change.data.length() >= 1){
//			newFirst = new Node(data.substring(0, 1), null);
//			current = newFirst;
//		}
//
//		for(int i=1; i<data.length(); i++){
//			String present = data.substring(i, i+1);
//			Node presentNode = new Node(present, null);
//			current.next = presentNode;
//			current = current.next;
//		}
//		current.next = next;
//	}
	
}
