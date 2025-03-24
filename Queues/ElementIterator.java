import java.util.Iterator;
import java.util.Vector;

public class ElementIterator implements Iterator{
	
	Vector vector;
	public ElementIterator(Vector e) {
		this.vector = e;
	}
	
	
	@Override
	public boolean hasNext() {

		return !vector.isEmpty();
	}

	@Override
	public Object next() {
		
		Object remove = this.vector. remove(0);
		
		return remove;
	}

}
