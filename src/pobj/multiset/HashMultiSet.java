package pobj.multiset;

import java.util.HashMap;

public class HashMultiSet<T> implements MultiSet<T> {
	private HashMap<T> bbq;
	public HashMultiset<T> (){
		this.bbq=new HashMap<T, Integer>();
	}
}
