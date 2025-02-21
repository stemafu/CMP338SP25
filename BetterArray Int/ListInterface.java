
public interface ListInterface {
	
	/*
	 * This method returns the size of the list
	 */
	public int size();
	
	
	/* 
	 * Returns true if the list is empty, otherwise false
	 * 
	 */
	public boolean isEmpty();
	
	/* 
	 * This method appends this element to the list
	 * To add the element at the next available index.
	 * 
	 * If the array is full, resize the array and add the element
	 * 
	 * You cannot add a null element.
	 */
	public void add(int element);
	
	/* This method returns an element at an index
	 * If the index that is provided is not valid,
	 * the method throws ArrayIndexOutOfBounds
	 */
	public int get(int index) throws ArrayIndexOutOfBoundsException;
	
	/*
	 * This removes the last element in the list.
	 * 
	 * What is the list is empty? We may have to throw an exception.
	 */
	public int remove() throws ArrayIndexOutOfBoundsException;
	
	/* This method removes an element at the specified index
	 * 
	 * What if the index is not valid? We can put out an exception.
	 * ArrayIndexOutOfBoundsException
	 */
	public int remove(int index) throws ArrayIndexOutOfBoundsException;
	
	
	/* This method replaces the element at the given index 
	 * with the given element.
	 * 
	 * What if the index is not valid? We can put out an exception.
	 * ArrayIndexOutOfBoundsException
	 */
	public void replace(int index, int element) throws ArrayIndexOutOfBoundsException;

	
	public boolean contains(int num);
	
	public void clear();
}
