
public class StaackDriver {

	public static void main(String[] args) {
		
		LinkedBasedStack<Integer> stack = new LinkedBasedStack<Integer>();
		stack.push(50);
		stack.push(80);
		System.out.println(stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
