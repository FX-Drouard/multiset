package pobj.multiset;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Iterator;
import java.util.List;

public class HashMultiSet<T> extends AbstractCollection<T> implements MultiSet<T> {
	private HashMap<T,Integer> muset;
	private int size;
	
	public HashMultiSet(){
		this.muset=new HashMap<T,Integer>();
		size=0;
	}
	
	
	public HashMultiSet(Collection<T> colle) {
		this();
		for (T c:colle) {
			this.add(c);
		}
		size=colle.size();
	}
	
	@Override
	public boolean add(T e, int count) throws IllegalArgumentException{
		
		//On ajoute rien
		if (count<0) {throw new IllegalArgumentException("Count est negatif mec");}
		if(count==0) {
			return false;
		}else {
			if(muset.containsKey(e)) {
				muset.put(e,muset.get(e).intValue()+count);
			}else {
				muset.put(e, count);
				
			}
			size+=count;
		}
		assert(this.isConsistent());
		return true;
	}
	@Override
	public boolean add(T e) {
		
		if(muset.containsKey(e)) {
			muset.put(e, muset.get(e).intValue()+1);
		}else {
			muset.put(e, 1);
		}
		size++;
		assert(this.isConsistent());
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object e) {
		
		if(!muset.containsKey(e)) {
			return false;
		}
		if(muset.get(e).intValue()>1) {
			int val=muset.get(e).intValue();
			val--;
			muset.put((T)e, val);
		}else {
			muset.remove(e);
		}
		size--;
		assert(this.isConsistent());
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object e, int count) throws IllegalArgumentException{
		
		if (count<0) {throw new IllegalArgumentException("Count est negatif mec");}
		if(!muset.containsKey(e)) {
			return false;
		}
		if(muset.get(e).intValue()>count) {
			int val=muset.get(e).intValue();
			val=val-count;
			muset.put((T)e, val);
			size-=count;
		}else {
			muset.remove(e);
			
		}
		assert(this.isConsistent());
		return true;
	}
	@Override
	public int count(T o) {
		
		if(!muset.containsKey(o)) {
			return 0;
		}
		int res=muset.get(o).intValue();
		return res;
	}
	@Override
	public void clear() {
		
		muset.clear();
		this.size=0;
		assert(this.isConsistent());
	}
	@Override
	public int size() {
		
		return this.size;
	}
	
	private class HashMultiSetIterator implements Iterator<T>{
		private int ind=0;
		
		@Override
		public boolean hasNext() {
			return (ind!=size);
		}
		
		public T next() {
			int cpt=0;
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			else {
				for(T k:muset.keySet()) {
					cpt+=count(k);
					if(ind<cpt) {
						ind++;
						return k;
					}
				}
			}
			return null;
		}
		
		
		
		
	}

	@Override
	public Iterator<T> iterator() {
		
		return new HashMultiSetIterator();
	}


	@Override
	public List<T> elements() {
		List<T> res=new ArrayList<>();
		for(T e:muset.keySet()) {
			res.add(e);
		}
		
		return res;
	}
	
	@Override
	public String toString() {
		StringBuilder b= new StringBuilder();
		b.append("multiset: [");
		for (T e:muset.keySet()) {
			b.append(e+":"+muset.get(e).intValue()+"; ");
		}
		b.delete(b.length()-2, b.length());
		b.append("]");
		return b.toString();
	}
	
	public boolean isConsistent() {
		int cpt=0;
		for (T e:muset.keySet()) {
			cpt+=muset.get(e).intValue();
			if (muset.get(e).intValue()<=0) {return false;}
		}
		
		return this.size()==cpt;
	}
}
