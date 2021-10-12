package pobj.multiset;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class HashMultiSet<T> implements MultiSet<T> {
	private Map<T,Integer> muset;
	public HashMultiSet(){
		this.muset=new HashMap<>();
	}
	
	/*public HashMultiSet(HashMultiSet<T> hms) {
		this();
		for (int i=0; i<hms.muset.size();i++) {
			this.muset.put(hms.muset.get(i),i);
		}
	}*/
	
	public HashMultiSet(Collection<T> colle) {
		this();
		for (T c:colle) {
			this.add(c);
		}
	}
	
	@Override
	public boolean add(T e, int count) {
		// TODO Auto-generated method stub
		this.muset.put(e,(Integer)count);
		return true;
	}
	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		this.muset.put(e, (Integer)this.muset.get(e));
		return false;
	}
	@Override
	public boolean remove(Object e) {
		// TODO Auto-generated method stub
		
		return false;
	}
	@Override
	public boolean remove(Object e, int count) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int count(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
