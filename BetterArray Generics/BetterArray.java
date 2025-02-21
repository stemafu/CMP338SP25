
public class BetterArray <I extends Comparable<? super I>> implements ListInterface<I> {
	public final int default_size = 10;
	private Object [] elements;

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
		this.elements = new Object[default_size];
		this.numElements = 0;
	}

	public BetterArray(int initial_size) {
		this.elements = new Object[initial_size];
		this.numElements = 0;
	}		


	@Override
	public ListInterface<I> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return this.numElements;
	}

	@Override
	public boolean isEmpty() {

		return (this.numElements == 0);
	}

	@Override
	public void add(I element) {
		if(element == null) {
			return;
		}
		if(this.isFull()){
			// resize when the array is full.
			this.resize();
		}
		this.elements[this.numElements] = element;
		this.numElements++;

	}

	@Override
	public void add(I element, int index) throws IndexOutOfBoundsException {

		if(element == null){
			return;
		}

		if(index < 0 || index > this.elements.length || index > this.numElements) {
			throw new IndexOutOfBoundsException("This index is invalid");
		}else {

			if(this.isEmpty() || index == this.numElements ) {
				this.add(element);
			}else {
				
				if(this.isFull()) {
					this.resize();
				}
				
				for(int i = this.numElements ; i > index; i--) {
					this.elements[i + 1] = this.elements[i];
				}
				
				this.elements[index] = element;
				this.numElements++;	
			}

		}


	}

	@Override
	public void addSorted(I element) {
		// TODO Auto-generated method stub

	}

	@Override
	public I get(int index) throws IndexOutOfBoundsException {
		if(this.isInvalidIndex(index)) {
			throw new ArrayIndexOutOfBoundsException("You provided an invalid index " + index);
		}
		
		return (I)this.elements[index];
	}

	@Override
	public I replace(I element, int index) throws IndexOutOfBoundsException {
		if(this.isInvalidIndex(index)) {
			new ArrayIndexOutOfBoundsException("You provided a wrong index " + index);
		}
		I replacedElement = (I)this.elements[index];
		this.elements[index] = element;

		return replacedElement;
	}

	@Override
	public I remove(int index) throws IndexOutOfBoundsException {
		if(this.isInvalidIndex(index) || this.isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("You provided an invalid index " + index);
		}
		
		I removeElement = (I)this.elements[index];
		if(index == (this.numElements - 1)) {
			this.numElements--;
			return removeElement;
		}
		else {
			// shift
			for(int i = index; i < this.numElements - 1; i++) {
				this.elements[i] = this.elements[i + 1];
			}
			
			this.numElements--;
			
			return removeElement;
		}
	}

	@Override
	public void removeAll() {
		this.numElements = 0;
		this.elements = new Object[this.elements.length];

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

	private void resize() {
		Object [] temp = new Object[this.elements.length * 2];

		for(int i = 0; i < this.numElements; i++) {
			temp[i] = this.elements[i];
		}
		this.elements = temp;
	}
}
