
public class BinarySearchTree <E extends KeyedElementInterface<K>, 
K extends Comparable<? super K>>implements BinarySearchTreeInterface<E, K>{

	/*
	 * All trees need to have a root.
	 * 
	 * When a tree is empty, the root is null.
	 */
	TreeNode<E, K> root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	
	@Override
	public TreeNode<E, K> getRoot() {
		
		return this.root;
	}

	@Override
	public void setRoot(TreeNode<E, K> root) {
		this.root = root;
	}

	@Override
	public boolean isEmpty() {
		return (this.root == null);
	}

	@Override
	public void makeEmpty() {
		this.root = null;
	}

	@Override
	public BinarySearchTreeInterface copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E find(K key) {
		
		TreeNode<E, K> node = this.findNode(key);
		
		if(node == null) {
			return null;
		}
		
		return node.getElement();
	}

	@Override
	public void insert(E element) {
		// check to see if the element is null. You can throw an exception
		
		/*
		 * Given an element, we will create a new node for the element.
		 * 
		 */
		TreeNode<E, K> node = new TreeNode<E, K>(element);
		K nodeKey = element.getKey();
		
		if(this.isEmpty()) {
			this.root = node;
		}else {
			/* If we are here we know that the tree is not empty.
			 * So we have to search for the correct location where we
			 * have to insert the element.
			 */
			TreeNode<E, K> currentNode = this.root;
			
			while(currentNode != null) {
				
				K currentNodeKey = currentNode.getElement().getKey();
	
				
				if(this.compareKeys(currentNodeKey, nodeKey ) > 0) {
					
					if(currentNode.getLeftChild() != null) {
						currentNode = currentNode.getLeftChild();
					}else {
						/* If the left child of the current node is null,
						we found where to insert
						*/
						currentNode.setLeftChild(node);
						return;
					}
				}else  {
					
					if(currentNode.getRightChild() != null) {
						currentNode = currentNode.getRightChild();
					}else {
						/* We found the location to insert the new node
						 * 
						 */
						currentNode.setRightChild(node);
						return;
					}
					
				}
			}
			
		}
		
	}
	
	

	@Override
	public void delete(K key) throws TreeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isBalanced() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void balance() {
		// TODO Auto-generated method stub
		
	} 

	
	/*
	 * helper methods
	 */
	
	public int compareKeys(K key1, K key2) {
		
		/*if(key1 > key2) {
			// positive number
		}else if (key1 == key2) {
			// return 0
		}else {
			// return negative number
		}*/
		
		return key1.compareTo(key2);
	}
	
	public TreeNode<E, K> findNode(K Key){
		TreeNode<E, K> currentNode = this.root;
		
		while(currentNode != null) {
			
			K currentNodeKey = currentNode.getElement().getKey();
			if(this.compareKeys(currentNodeKey, Key) == 0) {
				return currentNode;
			}else if(this.compareKeys(currentNodeKey, Key) > 0) {
				currentNode = currentNode.getLeftChild();
			}else {
				currentNode = currentNode.getRightChild();
			}
			
		}
		
		return null;
	}


}
