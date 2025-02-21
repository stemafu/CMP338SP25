
public class BetterArray implements ListInterface {
	
	public final int default_size = 10;
	
	private int [] elements;
	
	/*
	 * We will use the following variable to keep track of the
	 * number of elements that have been added to the array or
	 * removed from the array.
	 */
	private int numElements;
	
	/*
	 * A constructor is a special method that has the same name
	 * as the class but has not return type. 
	 * 
	 * A class is used when an object is being created.
	 * A constructor initializes the object such as giving
	 * default values to the object.
	 */
	
	public BetterArray() {
		this.elements = new int[default_size];
		this.numElements = 0;
	}
	
	public BetterArray(int initial_size) {
		this.elements = new int[initial_size];
		this.numElements = 0;
	}	
	
	@Override
	public int size() {
		return this.numElements;
	}

	@Override
	public boolean isEmpty() {
		
		/*if(this.numElements == 0) {
			return true;
		}
		
		return false;
		*/
		
		return (this.numElements == 0);
	}

	@Override
	public void add(int element) {
	
		/*if(element == null) {
			we will address this issue very soon.
		}*/
		
		if(this.isFull()){
			// resize when the array is full.
			
			int [] temp = new int[this.elements.length * 2];
			
			for(int i = 0; i < this.numElements; i++) {
				temp[i] = this.elements[i];
			}
			this.elements = temp;
		}
		
		this.elements[this.numElements] = element;
		this.numElements++;
	}

	@Override
	public int get(int index) throws ArrayIndexOutOfBoundsException {
		if(this.isInvalidIndex(index)) {
			throw new ArrayIndexOutOfBoundsException("You provided an invalid index " + index);
		}
		
		return this.elements[index];
	}

	@Override
	public int remove() throws ArrayIndexOutOfBoundsException{
		
		if(this.isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Your list is empty");	
		}
		
		int removeElement = this.elements[this.numElements - 1];
		this.numElements--;
		
		
		return removeElement;
	}

	@Override
	public int remove(int index) throws ArrayIndexOutOfBoundsException {
		
		if(this.isInvalidIndex(index) || this.isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("You provided an invalid index " + index);
		}
		
		
		if(index == (this.numElements - 1)) {
			return this.remove();
		}
		else {
			int removeElement = this.elements[index];
			
			// shift
			for(int i = index; i < this.numElements - 1; i++) {
				this.elements[i] = this.elements[i + 1];
			}
			
			this.numElements--;
			
			return removeElement;
		}

	}

	@Override
	public void replace(int index, int element) throws ArrayIndexOutOfBoundsException {
		
		if(index < 0 || index >= this.numElements) {
			new ArrayIndexOutOfBoundsException("You provided a wrong index " + index);
		}
		
		this.elements[index] = element;
	}
	
	
	/*
	 * This method returns true if the array is full
	 */
	private boolean isFull() {
		return (this.numElements == this.elements.length);
	}
	
	private boolean isInvalidIndex(int index) {
		return (index < 0 || index >= this.numElements);
	}
	
	
	public static void main(String [] args) {
		BetterArray myList = new BetterArray();
		int num = 50;
		System.out.println("before size()!" + myList.size());
		System.out.println("before isEmpty()!" + myList.isEmpty());
		for(int i = 0; i < 5; i++) {
			myList.add(num);
			
			num = num + 10;
		}
		System.out.println("done!" + myList.size());
		System.out.println("before isEmpty()!" + myList.isEmpty());
		//for(int i = 0; i < 5; i++) {
			System.out.println(myList.remove(0));
		//}
		System.out.println(myList.remove());
		System.out.println("done!" + myList.size());
	
	}

	@Override
	public boolean contains(int num) {
		
		if(this.isEmpty()) {
			return false;
		}
		
		for(int i = 0; i <this.numElements; i++) {
			if(this.elements[i] == num) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void clear() {
		this.numElements = 0;
		this.elements = new int[this.elements.length];
		
	}

}
