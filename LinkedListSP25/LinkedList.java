
public class LinkedList <I extends Comparable<? super I>>
implements ListInterface<I> {
	
	private Node<I> head;
	private Node<I> tail;
	int size;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	

	@Override
	public ListInterface<I> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}

	@Override
	public void add(I element) {
		
		// parameter check
		Node<I> newNode = new Node<I>(element);
		if(this.isEmpty()) {
			this.head = newNode;
			//this.tail = newNode;
			//this.size++;
		}else {
			this.tail.setNextNode(newNode);
			//this.tail = newNode;
			//this.size++;
		}
		this.tail = newNode;
		this.size++;
		
	}

	@Override
	public void add(I element, int index) throws IndexOutOfBoundsException {
		
		if(index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("invalid index");
		}
		
		if((this.isEmpty() && index == 0 )|| (index == this.size)) {
			this.add(element);
		}else if(index == 0 && !this.isEmpty()) {
			Node<I> newNode = new Node<I>(element);
			newNode.setNextNode(this.head);
			this.head = newNode;
			this.size++;
		}else {
			Node<I> newNode = new Node<I>(element);
			Node<I> previousNode = null;
			Node<I> currentNode = this.head;
			int currentNodeIndex = 0;
			
			while(currentNodeIndex != index) {
				previousNode = currentNode;
				currentNode = currentNode.getNextNode();
				currentNodeIndex++;
			}
			
			
			previousNode.setNextNode(newNode);
			newNode.setNextNode(currentNode);
			this.size++;	
		}
		
	}

	@Override
	public void addSorted(I element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public I get(int index) throws IndexOutOfBoundsException {
		
		if(this.isInvalidIndex(index)) {
			throw new IndexOutOfBoundsException("invalid index");
		}
		
		Node<I> currentNode = this.head;
		int currentNodeIndex = 0;
		
		while(currentNodeIndex != index) {
			currentNode = currentNode.getNextNode();
			currentNodeIndex++;
		}
		
		return (I)currentNode.getData();
	}

	@Override
	public I replace(I element, int index) throws IndexOutOfBoundsException {
		if(this.isInvalidIndex(index)) {
			throw new IndexOutOfBoundsException("Invalid index " + index);
		}
		
		
		Node<I> currentNode = this.head;
		int currentNodeIndex = 0;
		
		while(currentNodeIndex != index) {
			currentNode = currentNode.getNextNode();
			currentNodeIndex++;
		}
		
		I oldElement = (I)currentNode.getData();
		currentNode.setData(element);
		
		return oldElement;
	}

	@Override
	public I remove(int index) throws IndexOutOfBoundsException {
		
		if(this.isInvalidIndex(index)) {
			throw new IndexOutOfBoundsException("Invalid index " + index);
		}
		
		if(index == 0) {
			
			I removedElement = (I)this.head.getData();
			
			if(this.size == 1) {
				this.removeAll();
			}else {
				this.head = this.head.getNextNode();
				this.size--;
			}
			
			return removedElement;
		}else if(index == this.size -1) {
		
			Node<I> previousNode = null;
			Node<I> currentNode = this.head;
			int currentNodeIndex = 0;
			
			while(currentNodeIndex != index) {
				previousNode = currentNode;
				currentNode = currentNode.getNextNode();
				currentNodeIndex++;
			}
			
			I removedElement = (I)currentNode.getData();
			
			this.tail = previousNode;
			this.tail.setNextNode(null);
			this.size--;
			
			return removedElement;
		}else {
			
			Node<I> previousNode = null;
			Node<I> currentNode = this.head;
			int currentNodeIndex = 0;
			
			while(currentNodeIndex != index) {
				previousNode = currentNode;
				currentNode = currentNode.getNextNode();
				currentNodeIndex++;
			}
			previousNode.setNextNode(currentNode.getNextNode());
			this.size--;
			
			I removedElement = (I)currentNode.getData();
			return removedElement;
		}
	}

	@Override
	public void removeAll() {
		this.head = null;
		this.tail = null;
		this.size = 0;
		
	}
	
	private boolean isInvalidIndex(int index) {
		return (index < 0 || index >= this.size);
	}

}
