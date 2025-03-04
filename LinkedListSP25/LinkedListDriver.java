
public class LinkedListDriver {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i = 0; i <= 100; i++) {
			list.add(i);
		}
	
		
	
		
		list.remove(0);
		
		for(int i = 0; i < 100; i++) {
			list.remove(0);
			//System.out.println(list.get(i));
		}
		
		for(int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i));
		}
		
		System.out.println(list.isEmpty());

	}

}
