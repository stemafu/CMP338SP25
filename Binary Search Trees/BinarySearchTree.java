
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
						node.setParent(currentNode);
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
						node.setParent(currentNode);
						return;
					}
					
				}
			}
			
		}
		
	}
	
	

	@Override
	public void delete(K key) throws TreeException {
		TreeNode <E, K> nodeToDelete = this.findNode(key);
		
		if(nodeToDelete != null) {
			// call a method for deleting the node with the key to be deleted.
			deleteNode(nodeToDelete);
		}
		
	}

	public void inOrder() {
		inOrder(this.root);
	}
	
	
	
	private void inOrder(TreeNode<E, K> node) {
		
		if(node == null) {
			return;
		}
		
		inOrder(node.getLeftChild()); // left visit first
		System.out.println(node.getElement().getKey()); // print
		inOrder(node.getRightChild()); // right visit
	
	}
	
	public void preOrder() {
		preOrder(this.root);
	}
	
	private void preOrder(TreeNode<E, K> node) {
		if(node == null) {
			return;
		}
		System.out.println(node.getElement().getKey()); // print
		preOrder(node.getLeftChild()); // left visit
		preOrder(node.getRightChild()); // right visit
		
	}
	
	
	public void postOrder() {
		postOrder(this.root);
	}
	
	public void postOrder(TreeNode<E, K> node) {
		if(node == null) {
			return;
		}
		
		postOrder(node.getLeftChild()); // left visit
		postOrder(node.getRightChild()); // right visit
		System.out.println(node.getElement().getKey()); // print
	}
	
	@Override
	public int height() {
		return this.height(this.root);
	}
	
	private int height(TreeNode<E, K> node) {
		
		if(node == null) {
			return -1;
		}
		int leftHeight = height(node.getLeftChild());
		int rightHeight = height(node.getRightChild());
		
		return 1 + Math.max(leftHeight, rightHeight);
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


	private void deleteNode(TreeNode <E, K> nodeToBeDeleted) {
		
		TreeNode<E, K> parentOfNodeToBeDeleted = nodeToBeDeleted.getParent();
		
		if(this.isLeafNode(nodeToBeDeleted)) {
			
			if(parentOfNodeToBeDeleted == null) {
				this.root = null;
			}else {
				if(this.isLeftChildOfParentNode(nodeToBeDeleted, parentOfNodeToBeDeleted)){
					parentOfNodeToBeDeleted.setLeftChild(null);
					nodeToBeDeleted.setParent(null);
				}else {
					parentOfNodeToBeDeleted.setRightChild(null);
					nodeToBeDeleted.setParent(null);
				}
			}
		} else if (this.nodeHasLeftChildOnly(nodeToBeDeleted)) {
			/*
			 * to be completed
			 */
			
			if(parentOfNodeToBeDeleted == null) {
				this.root = nodeToBeDeleted.getLeftChild();
				this.root.setParent(null);
				nodeToBeDeleted.setLeftChild(null);
			} else if (this.isLeftChildOfParentNode(nodeToBeDeleted, parentOfNodeToBeDeleted)) {
				// Node to be deleted id the left child of the parent
				parentOfNodeToBeDeleted.setLeftChild(nodeToBeDeleted.getLeftChild());
				nodeToBeDeleted.getLeftChild().setParent(parentOfNodeToBeDeleted);
				nodeToBeDeleted.setLeftChild(null);
				nodeToBeDeleted.setParent(null);
			}else {
				// Node to be deleted happens to be the right child of the parent
				parentOfNodeToBeDeleted.setRightChild(nodeToBeDeleted.getParent());
				nodeToBeDeleted.getLeftChild().setParent(parentOfNodeToBeDeleted);
				nodeToBeDeleted.setParent(null);
			}
			
			
			
		}else if(this.nodeHasRightChildOnly(nodeToBeDeleted)) {
			/*
			 * This part to be completed as part of the homework.
			 * Please refer to to the above part for guidance.
			 */
			if(parentOfNodeToBeDeleted == null) {
				this.root = nodeToBeDeleted.getRightChild();
				this.root.setParent(null);
				nodeToBeDeleted.setRightChild(null);
			} else if (this.isLeftChildOfParentNode(nodeToBeDeleted, parentOfNodeToBeDeleted)) {
				// The node being deleted is the left child of the parent
				parentOfNodeToBeDeleted.setLeftChild(parentOfNodeToBeDeleted);
				nodeToBeDeleted.getRightChild().setParent(parentOfNodeToBeDeleted);
				nodeToBeDeleted.setParent(null);
			}else {
				// The node being deleted if the right child of the parent.
				parentOfNodeToBeDeleted.setRightChild(nodeToBeDeleted.getRightChild());
				nodeToBeDeleted.getRightChild().setParent(parentOfNodeToBeDeleted);
				nodeToBeDeleted.setParent(null);
			}
			
		}else {
			
			// Let us see how to delete a node that has two children.
			
			// 1. Let us get the successor of the nodetobe deleted
			TreeNode<E, K> successor = this.findSuccessor(nodeToBeDeleted);
			
			/*
			 * 2. Once we have located the successor, then we need to 
			 * replace the value of the node of node to be deleted
			 * one of the the successor.
			 */
			nodeToBeDeleted.setElement(successor.getElement());
			
			
			// Step 3: delete the successor
			this.deleteNode(successor);
		}
	}
	
	/*
	 * The following method is used to find the successor of the 
	 * given node.
	 * 
	 * The successor of the given node is the smallest key in the
	 * right subtree of the given node.
	 */
	private TreeNode<E, K> findSuccessor(TreeNode<E, K> node){
		/*
		 *  This initially stores the address of the root of the right subtree of
		 *   the node.
		 */
		TreeNode<E, K> currentNode = node.getRightChild();
		
		/* 
		 * Once we get the root of the right child, then we can
		 * search for the smallest key on the right subtree.
		 */
		
		while(currentNode.getLeftChild() != null) {
			
			currentNode = currentNode.getLeftChild();
		}
		
		return currentNode;
	}
	
	private boolean isLeafNode(TreeNode <E, K> node) {
		return node.getLeftChild() == null && node.getRightChild() == null;
	}
	
	private boolean isLeftChildOfParentNode(TreeNode <E, K> node, TreeNode <E, K> parent ) {
		return parent.getLeftChild() == node;
	}

	private boolean isRightChildOfParentNode(TreeNode <E, K> node, TreeNode <E, K> parent ) {
		return parent.getRightChild() == node;
	}
	
	/* The following method returns true if the given node only has a left
	 * child only.
	 * 
	 */
	private boolean nodeHasLeftChildOnly(TreeNode<E, K> node) {
		return node.getLeftChild() != null && node.getRightChild() == null;
	}
	
	
	/* The following method returns true if the given node only has a right
	 * child only.
	 * 
	 */
	private boolean nodeHasRightChildOnly(TreeNode<E, K> node) {
		return node.getLeftChild() == null && node.getRightChild() != null;
	}	
}
