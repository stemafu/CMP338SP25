import java.util.Iterator;

public class HashTableUsingChaining <E extends KeyedElementInterface<K>, K>
implements HashTableInterface<E, K> {
	private static int NUM_BUCKETS = 7;
	private LinkedList [] hashTable;
	private int numElements;
	
	public HashTableUsingChaining() {
		this.numElements = 0;
		this.hashTable = new LinkedList[NUM_BUCKETS];
		
		for(int i = 0; i <hashTable.length; i++) {
			this.hashTable[i] = new LinkedList();
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HashTableInterface<E, K> copy() throws InstantiationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E insert(E element) {
	    
		K key = element.getKey();
		int hashCodeIndex = key.hashCode() % this.hashTable.length;
		
		if(!this.hashTable[hashCodeIndex].isEmpty()) {
			/* check if the the linked list at this bucket already
			has this key
			
			search for the existence of the key inside the list
			
			
		
			
		
			*/
			
			
			LinkedList list = this.hashTable[hashCodeIndex];
		
			int index = 0;
			while(index < list.size()) {
				
				if( ((E)this.hashTable[hashCodeIndex].get(0)).getKey().equals(key)) {
					/*
					 Get the element at this index an
					
					E oldElement = get(int index) t
							If it has the they key replace it
					 	replace(element, index)
			
			return the oldElement;
					 */
					
					
				}
			}
		
		}

		
		
		/*
		 * If the key is not already in use, just add the element.
		 */
		
		return null;
	}

	@Override
	public E get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSizeOfLargestBucket() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAverageBucketSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] getBuckets() {
		// TODO Auto-generated method stub
		return null;
	}
}
