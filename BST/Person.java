
public class Person<K> implements KeyedElementInterface<K>{
	private String name;
	private int age;
	private K key;
	
	
	public Person(String name, int age, K key) {
		super();
		this.name = name;
		this.age = age;
		this.key= key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}
	@Override
	public KeyedElementInterface<K> copy() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", key=" + key + "]";
	}
	
	
	
	

}
