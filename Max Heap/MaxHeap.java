
public class MaxHeap implements HeapInterface{
	private int [] heap;
	private int size;
	private final int capacity = 10;
	
	public MaxHeap() {
		this.heap = new int[capacity];
		this.size = 0;
	}

	public MaxHeap(int capacity) {
		this.heap = new int[capacity];
		this.size = 0;
	}
	
	
	@Override
	public void insert(int key) {
		
		if(this.size == this.heap.length) {
			// This means the heap is full
			// We can resize
		}
		
		this.heap[this.size] = key;
		this.heapifyUp();
		this.size++;	
	}

	@Override
	public int remove() throws NullPointerException{
		
		if(this.isEmpty()) {
			throw new NullPointerException("The heap is empty. You cannot remove from an empty heap");
		}
		
		
		int removedElement = this.heap[0];
		
		
		this.heap[0] = this.heap[this.size - 1];
		this.size--;
		
		this.heapifyDown();
		
		
		
		return removedElement;
	}

	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}

	@Override
	public int size() {
		return  this.size;
	}
	
	private void heapifyUp() {
		
		int childIndex = this.size;
		
		while(childIndex > 0) {
			int parentIndex = (childIndex - 1) / 2;
			if(this.heap[childIndex] > this.heap[parentIndex]) {
				// Swap
				int temp = this.heap[childIndex];
				this.heap[childIndex] = this.heap[parentIndex];
				this.heap[parentIndex] = temp;
				childIndex = parentIndex;
			}else {
				break;
			}
		}
		
	}
	
	public void printHeap() {
		
		for(int i = 0; i < this.size; i++) {
			System.out.println(this.heap[i]);
		}
	}
	
	private void heapifyDown() {
		int index = 0;
		while(true) {
			
			int leftChildIndex = (index * 2) + 1;
			int rightChildIndex = (index * 2) + 2;
			int largestIndex = index;
			
			if( (leftChildIndex < this.size) && this.heap[leftChildIndex] > this.heap[largestIndex]) {
				largestIndex = leftChildIndex;
			}
			
			if(rightChildIndex < this.size && this.heap[rightChildIndex] > this.heap[largestIndex]) {
				largestIndex = rightChildIndex;
			}
			
			if(largestIndex != index ) {
				
				int temp = this.heap[index];
				this.heap[index] = this.heap[largestIndex];
				this.heap[largestIndex] = temp;
				
				
				index = largestIndex;
			}else {
				break;
			}
			
		}
	}
	
	public static void main(String [] args) {
		MaxHeap heap = new MaxHeap();
		heap.insert(4);
		heap.insert(10);
		heap.insert(8);
		heap.insert(5);
		heap.insert(15);
		heap.printHeap();
	}

}
