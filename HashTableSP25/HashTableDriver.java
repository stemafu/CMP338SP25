
public class HashTableDriver {

	public static void main(String[] args) {
		
		HashTable <Person<Integer>, Integer> table = new HashTable<Person<Integer>, Integer>();

		
		Person<Integer> p1 = null;
		p1 = new Person("Drink Water", "LC", 50);
		
		
		table.insert(p1);
	}

}
