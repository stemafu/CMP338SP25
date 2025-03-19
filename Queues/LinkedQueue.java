import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements QueueInterface<E> {

	/**
	 * A queue has a front (head)
	 * A queue has a back(rear or tail)
	 * size, which keep track of the count of elements in the queue
	 */
	
	private Node<E> front = null;
	private Node<E> back = null;
	private int count = 0;
	
	public LinkedQueue() {
		this.front = null;
		this.back = null;
		this.count = 0;
	}
	/**/
	
	
	
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (this.count == 0);
	}

	@Override
	public int size() {
		
		return this.count;
	}

	@Override
	public QueueInterface<E> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enqueue(E element) throws IllegalStateException, NullPointerException {
		
		if (element == null) {
			throw new NullPointerException("the parameter is null");
		}
		
		Node<E> newNode = new Node<E>(element);
		if(this.isEmpty()) {
			this.front = newNode;
			this.back = newNode;
			this.count++;
		}else {
			newNode.setPrevious(this.back);
			this.back.setNext(newNode);
			this.back = newNode;
			this.count++;
		}
		
	}

	@Override
	public E peek() {
		
		if(this.isEmpty()) {
			return null;
		}else {
			return this.front.getData();
		}
	}

	@Override
	public E dequeue() {
		if(this.isEmpty()) {
			return null;
		}else {
			E removedElement =  this.peek();
			
			if(this.count == 1) {
				this.removeAll();
			}else {
			
				//Node <E> newFront = this.front.getNext();
				//this.front = newFront;
				this.front = this.front.getNext();
				this.front.setPrevious(null);

				this.count--;
			}
			
			return removedElement;
		}
		
	}

	@Override
	public E dequeue(int index) throws NoSuchElementException {
		
		if(index < 0 || index >= this.count) {
			throw new NoSuchElementException("Bad index");
		}else if(index == 0) {
			return this.dequeue();
		}else if(index == (this.count - 1)) {
			E removedElement = this.back.getData();
			this.back = this.back.getPrevious();
			this.back.setNext(null);
			this.count--;
			
			return removedElement;
		}else {
			
			Node<E> currentNode = this.front;
			int currentNodeIndex = 0;
			
			while(currentNodeIndex != index) {
				currentNode = currentNode.getNext();
				currentNodeIndex++;
			}
			E removedElement = currentNode.getData();
			Node<E> previousNodeOfCurr = currentNode.getPrevious();
			Node<E> nextNodeOfCurr = currentNode.getNext();
			
			previousNodeOfCurr.setNext(nextNodeOfCurr);
			nextNodeOfCurr.setPrevious(previousNodeOfCurr);
			
			this.count--;
			
			return removedElement ;
		}
		
	}

	@Override
	public void removeAll() {
		this.front = null;
		this.back = null;
		this.count = 0;		
	}
	


}
