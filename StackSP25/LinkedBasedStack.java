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
		// TODO Auto-generated method stub
		
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		this.top = null;
		this.size = 0;
	}

}
