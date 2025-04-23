
public class Node <I extends Comparable<? super I>> {

	private I data;
	private Node nextNode;
	
	public Node(I data){
		this.data = data;
	}

	public I getData() {
		return data;
	}

	public void setData(I data) {
		this.data = data;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
	
}
