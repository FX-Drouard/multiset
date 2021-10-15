package pobj.multiset;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class HashMultiSet<T> implements MultiSet<T> {
	private HashMap<T,Integer> muset;
	private int size;
	
	public HashMultiSet(){
		this.muset=new HashMap<>();
	}
	
	
	public HashMultiSet(Collection<T> colle) {
		this();
		for (T c:colle) {
			this.add(c);
		}
	}
	
	@Override
	public boolean add(T e, int count) {
		// TODO Auto-generated method stub
		//On ajoute rien
		if(count==0) {
			return false;
		}
		if(muset.containsKey(e)) {
			muset.put(e,muset.get(e).intValue()+count);
		}else {
			muset.put(e, count);
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
		}
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
}
