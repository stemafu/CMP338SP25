
public class Box <T> {
	private T t;
	
	

	public T getT() {
		return t;
	}



	public void setT(T t) {
		this.t = t;
	}



	public static void main(String[] args) {
		
		Box <Integer> box1 = new Box<Integer>();
		box1.setT(90);
		
		System.out.println(box1.getT());
		
		Box <String> box2 = new Box<String>();
		box2.setT("Lehman");
		
		System.out.println(box2.getT());

	}

}
