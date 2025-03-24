import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayBasedQueue<E> implements QueueInterface<E> {
	
	private Object [] elements;
	private int size;
	private final int default_array_capacity = 10;
	private int front;
	private int back;
	
	
	public ArrayBasedQueue(){
		this.elements = new Object[default_array_capacity];
		this.size = 0;
		this.front = -1;
		this.back = -1;
	}
	
	
	public ArrayBasedQueue(int capacity){
		this.elements = new Object[capacity];
		this.size = 0;
		this.front = -1;
		this.back = -1;
	}
	
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		
		return (this.size == 0);
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public QueueInterface<E> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enqueue(E element) throws IllegalStateException, NullPointerException {
		
		if(element == null) {
			throw new NullPointerException("You cannot add a null element");
		}
		
		if(this.isFull()) {
			throw new IllegalStateException("You cannot add a new element because the queue is full.");
		}
		
		
		if(this.isEmpty()) {
			this.elements[0] = element;
			this.front = 0;
			this.back = 0;
			this.size++;
		}else {
			
			this.back++;
			this.back = this.back  % this.elements.length;
			this.elements[this.back] = element;
			this.size++;
		}
		
	}

	@Override
	public E peek() {
		
		if(this.isEmpty()) 
			return null;
		else
			return (E)this.elements[this.front];
	}

	@Override
	public E dequeue() {
		
		if(this.isEmpty()) 
			return null;	
		
		else {
			E removedElement = (E)this.elements[this.front];
			
			if(this.size == 1) {
				this.removeAll();
			}else {
				this.front++;
				this.front = this.front % this.elements.length;
				this.size--;
			}
			
			return removedElement;
		}
	}

	@Override
	public E dequeue(int index) throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAll() {
		//this.elements =[]
		this.front = -1;
		this.back = -1;
		this.size = 0;
		
	}
	
	
	private boolean isFull() {
		return (this.size == this.elements.length);
	}

}
