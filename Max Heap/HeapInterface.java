
public interface HeapInterface {
	
	/**
	 * This method inserts the given key into the heap.
	 * Our is implemented using an array.
	 * When we insert the new value, we must maintain the heap property.
	 * 
	 * @param key
	 */
	public void insert(int key);
	
	/**
	 * removes and return the item or the element that is at the top of the
	 * heap. 
	 * 
	 * In max heap, this is the largest value in the heap.
	 * 
	 * In a mean heap, this would mean removing the smallest value.
	 * 
	 * Our example is based on the max heap.
	 * 
	 * @return
	 */
	public int remove() throws NullPointerException;
	
	public boolean isEmpty();
	
	public int size();

}
