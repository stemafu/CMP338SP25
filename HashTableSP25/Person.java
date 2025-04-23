
public class Person <K> implements KeyedElementInterface<K>{
	private String name;
	private String address;
	private K key;
	
	
	public Person(String name, String address, K key) {
		this.key = key;
		this.name = name;
		this.address = address;
	}
	
	
	public void setKey(K key) {
		this.key = key;
		
	}
	
	public K getKey() {
		return this.key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public KeyedElementInterface<K> copy() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
