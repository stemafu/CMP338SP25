import java.util.Iterator;

public class ArrayBasedStack<E> implements StackInterface<E> {
	private final int default_array_capacity = 10;
	private Object [] elements;
	private int size;
	
	public ArrayBasedStack() {
		elements = new Object[default_array_capacity];
		this.size = 0;
	}
	
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (this.size == 0);
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public StackInterface<E> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(E e) throws IllegalStateException, NullPointerException {
	
		if(e == null) {
			throw new NullPointerException("You cannot add a null");
		}
		
		if(this.size == this.elements.length) {
		//throw new IllegalStateException("the array is full"); //fixed size
			
			resize(); // dynamic size
		}
		
		this.elements[size] = e;
		this.size++;
	}

	@Override
	public E peek() {
		if(this.isEmpty()) {
			return null;
		}
		return (E)this.elements[size - 1];
	}

	@Override
	public E pop() {
		
		if(this.isEmpty()) {
			return null;
		}
		
		E lastElement = this.peek();
		this.size--;
		
		return lastElement;
	}

	@Override
	public void clear() {
		this.elements = new Object[this.elements.length];
		this.size = 0;
		
	}
	
	private void resize() {
		Object [] elementsCopy = new Object[this.elements.length * 2];
		
		for(int i = 0; i < this.size; i++) {
			elementsCopy[i] = elements[i];
		}
		
		elements = elementsCopy;
	}

}
