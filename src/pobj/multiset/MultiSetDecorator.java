package pobj.multiset;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;



public class MultiSetDecorator<T> extends AbstractCollection<T> implements MultiSet<T> {
	private MultiSet<T> decorated;
	
	

	public MultiSetDecorator(MultiSet<T> m){
		this.decorated=m;
	}
	
	
	@Override
	public boolean add(T e, int count) throws IllegalArgumentException{
		assert(this.decorated.isConsistent());
		return this.decorated.add(e,count);
	}
	@Override
	public boolean add(T e) {
		assert(this.decorated.isConsistent());
		//System.out.println("Passé\n");
		return this.decorated.add(e);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object e, int count) throws IllegalArgumentException{
		assert(this.decorated.isConsistent());
		return this.decorated.remove(e,count);
	}
	
	public boolean remove(Object e) {
		assert(this.decorated.isConsistent());
		return this.remove(e);
	}
	
	@Override
	public int count(T o) {
		return this.decorated.count(o);
	}
	@Override
	public void clear() {
		this.decorated.clear();
		assert(this.decorated.isConsistent());
		
	}
	@Override
	public int size() {
		
		return this.decorated.size();
	}


	@Override
	public Iterator<T> iterator() {
		return this.decorated.iterator();
	}


	@Override
	public List<T> elements() {
		return this.decorated.elements();
	}
	
	@Override
	public String toString() {
		return this.decorated.toString();
	}
	
	//???
	public boolean isConsistent() {
		
		return this.decorated.isConsistent();
	}

}
