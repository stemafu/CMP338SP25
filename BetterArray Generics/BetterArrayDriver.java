
public class BetterArrayDriver {

	public static void main(String[] args) {
		
		BetterArray<Integer> nums = new BetterArray<Integer>();
		//int num = 50;
		for(int i = 0; i < 100; i++) {
			nums.add(i);
		
		}
		
		
		
		
		System.out.println("size is " + nums.size());
		System.out.println("value is " + nums.get(50));
		System.out.println("value is " + nums.get(0));
	}

}
