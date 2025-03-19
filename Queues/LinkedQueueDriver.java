
public class LinkedQueueDriver {

	public static void main(String[] args) {
		
		
		LinkedQueue<Integer> q = new LinkedQueue<Integer>();
		
		for(int i = 0; i < 1000; i++) {
			q.enqueue(i);
		}

		System.out.println(q.isEmpty());
		System.out.println(q.size());
		
		
		for(int i = 0; i < 1000; i++) {
			System.out.println(q.dequeue());
		}
		System.out.println(q.isEmpty());
		System.out.println(q.size());
		
		
		for(int i = 0; i < 1000; i++) {
			q.enqueue(i);
		}
		
		System.out.println(q.dequeue(10));
		
		
	}

}
