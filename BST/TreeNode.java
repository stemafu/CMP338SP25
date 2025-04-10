
public class TreeNode<E extends 
KeyedElementInterface<K>,K extends 
Comparable<? super K>>{
	
	private TreeNode<E, K> leftChild;
	private E element;
	private TreeNode<E, K> rightChild;
	
	public TreeNode(E element) {
		this.element = element;
		this.leftChild = null;
		this.rightChild = null;
	}

	public TreeNode<E, K> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode<E, K> leftChild) {
		this.leftChild = leftChild;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public TreeNode<E, K> getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode<E, K> rightChild) {
		this.rightChild = rightChild;
	}
	
	
}
