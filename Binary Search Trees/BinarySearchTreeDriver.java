
public class BinarySearchTreeDriver {
	
	public static void main(String [] args) {
		BinarySearchTree<Person<Integer>, Integer> bst;
		bst = new BinarySearchTree<Person<Integer>, Integer>();
		
		Person<Integer> p1 = new Person<Integer>("A", 1, 30);
		Person<Integer> p2 = new Person<Integer>("B", 3, 25);
		Person<Integer> p3 = new Person<Integer>("C", 10, 50);
		Person<Integer> p4 = new Person<Integer>("C", 20, 60);
		
		bst.insert(p1);
		bst.insert(p2);
		bst.insert(p3);
		bst.insert(p4);
		
		System.out.println(bst.find(50).toString());
		
		System.out.println(bst.height());
		
		
	}

}
