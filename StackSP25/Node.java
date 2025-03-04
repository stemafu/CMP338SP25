
public class Node <E>{
	
	private Node<E> next;
	private E data;
	private Node<E> previous;
	
	public Node(E data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<E> previous) {
		this.previous = previous;
	}
	
	

}
