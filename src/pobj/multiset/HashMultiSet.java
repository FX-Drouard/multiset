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
	public boolean add(T e, int count) {
		// TODO Auto-generated method stub
		//On ajoute rien
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
		return true;
	}
	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		if(muset.containsKey(e)) {
			muset.put(e, muset.get(e).intValue()+1);
		}else {
			muset.put(e, 1);
		}
		size++;
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object e) {
		// TODO Auto-generated method stub
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
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object e, int count) {
		// TODO Auto-generated method stub
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
		
		return true;
	}
	@Override
	public int count(T o) {
		// TODO Auto-generated method stub
		if(!muset.containsKey(o)) {
			return 0;
		}
		int res=muset.get(o).intValue();
		return res;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		muset.clear();
		this.size=0;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return new HashMultiSetIterator();
	}


	@Override
	public List<T> elements() {
		List<T> res=new ArrayList<>();
		for(T e:muset.keySet()) {
			res.add(e);
		}
		// TODO Auto-generated method stub
		return res;
	}
}
