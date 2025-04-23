import java.util.Iterator;

public class HashTable <E extends KeyedElementInterface<K>, K>
implements HashTableInterface<E, K>{
	private static int NUM_BUCKETS = 7;
	private Bucket [] hashTable;
	private int numElements;
	private int probes;

	// We need a constructor.
	public HashTable() {
		this.numElements = 0;
		this.probes = 0;
		hashTable = new Bucket[NUM_BUCKETS];
		
		for(int i = 0; i < this.hashTable.length; i++) {
			this.hashTable[i] = new Bucket();
			this.hashTable[i].element = null;
			this.hashTable[i].isEmptyFromBeginning = true;
		}
	}
	
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return this.numElements;
	}

	@Override
	public boolean isEmpty() {
		return (this.numElements == 0);
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
		
		
		
		/*
		 * How do we address collisions?
		 * 
		 * 
		 */
		int probeNum = 1;
		while (hashTable[hashCodeIndex].element != null) {
			
			if( ((E)hashTable[hashCodeIndex].element).getKey().equals(element.getKey())){
				E oldElement = (E)hashTable[hashCodeIndex].element;
				this.hashTable[hashCodeIndex].element = element;
				return oldElement;
			}
			
			hashCodeIndex = probes(hashCodeIndex, probeNum);
			probeNum++;
			
		}
		
		this.hashTable[hashCodeIndex].element = element;
		this.hashTable[hashCodeIndex].isEmptyFromBeginning = false;
		this.numElements++;

		return null;
	}
	

	private int probes(int hashCodeIndex, int i) {
		this.probes++;
		
		return (hashCodeIndex + 1) % this.hashTable.length;
	}

	@Override
	public E get(K key) {
		
		
		int hashCodeIndex = key.hashCode() % this.hashTable.length;
		int probeNum = 1; // to be used for quadratic probing
		while( !(((E)this.hashTable[hashCodeIndex].element).getKey().equals(key))) {
			hashCodeIndex = probes(hashCodeIndex, probeNum);
			probeNum++;
		}
		
		return (E)this.hashTable[hashCodeIndex].element;
	}

	@Override
	public E remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAll() {
		this.numElements = 0;
		this.probes = 0;
		hashTable = new Bucket[NUM_BUCKETS];
		
		for(int i = 0; i < this.hashTable.length; i++) {
			this.hashTable[i] = new Bucket();
			this.hashTable[i].element = null;
			this.hashTable[i].isEmptyFromBeginning = true;
		}
		
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


class Bucket{
	public boolean isEmptyFromBeginning;
	public Object element;
}
