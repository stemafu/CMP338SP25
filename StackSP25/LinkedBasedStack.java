import java.util.Iterator;

public class LinkedBasedStack<E> implements StackInterface<E> {
	
	private Node<E> top;
	private int size;
	
	LinkedBasedStack(){
		this.top = null;
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
		return this.size == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
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
			throw new NullPointerException("The parameter you provided is null");
		}
		
		Node<E> newNode = new Node<E>(e);
		
		if(this.isEmpty()) {
			this.top = newNode;
			this.size++;	
		}else{
			/*
			 * Set next node of the current top to the newnode
			 */
			this.top.setNext(newNode);
			
			/*
			 * Set previous node of the newnode to the current top
			 */
			newNode.setPrevious(top);
			
			// Update top
			this.top = newNode;
			
			// Update size
			this.size++;
			
		}
	}

	@Override
	public E peek() {
		
		if(this.isEmpty()) {
			return null;
		}{
			return this.top.getData();
		}
	}

	@Override
	public E pop() {
		
		if(this.isEmpty()) {
			return null;
		}else {
			E removedElement = this.peek();
			
			if(this.size == 1) {
				this.clear();
			}else {
				this.top = this.top.getPrevious();
				this.top.setNext(null);
				this.size--;
			}
			return removedElement ;
		}
	}

	@Override
	public void clear() {
		this.top = null;
		this.size = 0;
	}
	
	

}
