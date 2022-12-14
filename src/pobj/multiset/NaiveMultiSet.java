package pobj.multiset;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
;
public class NaiveMultiSet<T> extends AbstractCollection<T> implements MultiSet<T>{
	private List<T> ls;
	private List<Integer> freq;
	
	public NaiveMultiSet() {
		this.ls= new ArrayList<>();
		this.freq= new ArrayList<>();
	}

	public boolean add(T e, int count) {
		if(count<=0) {
			return false;
		}
		
		int ind=ls.indexOf(e);
		int freqP=0;
		
		if(ind!=-1) {
			freqP=freq.get(ind);
			freq.set(ind, freqP+count);
		}else {
			ls.add(e);
			freq.add(count);
		}
		return true;
	}
	public boolean add(T e) {
		return add(e,1);
	}
	public boolean remove(Object e) {
		if(e==null) {
			return false;
		}
		return remove(e,1);
	}
	public boolean remove(Object e, int count) {
		if(count <=0) {
			return false;
		}
		
		int ind = ls.indexOf(e);
		if(ind==-1) {
			return false;
		}
		int freqP= freq.get(ind);
		if(freqP>count) freq.set(ind, freqP-count);
		else {
			ls.remove((ind));
			freq.remove(ind);
		}
		return true;
	}
	public int count(T o) {
		if(o==null)return 0;
		int ind = ls.indexOf(o);
		if(ind ==-1)return 0;
		return freq.get(ind);		
	}
	public void clear() {
		ls.clear();
		freq.clear();
	}
	public int size() {
		int cpt=0;
		for(Integer i:freq) {
			cpt+=i;
		}
		return cpt;
	}
	public List<T> elements(){
		return ls;
	}
	
	public List<T> sortFreq(){
		List<T> res= new ArrayList<>();
		List<Integer>tmp=new ArrayList<>();
		List<T>tmpel=new ArrayList<>();
		for(Integer i: freq) {
			tmp.add(i);
		}
		for(T t:ls) {
			tmpel.add(t);
		}
		
		int ite=ls.size();
		while(ite>0) {
			//On initialise le max au premier élément
			Integer fmax=tmp.get(0);
			T elmax=tmpel.get(0);
			//On parcourt toute la liste pour chercher un max et on remplace si c'est le cas
			for(int i=1;i<tmp.size();i++) {
				if(tmp.get(i)>fmax) {
					elmax=tmpel.get(i);
					fmax=tmp.get(i);
				}
			}
			//On ajoute à la liste resultat
			tmp.remove(fmax);
			tmpel.remove(elmax);
			res.add(elmax);
			//On décrémente 1 à l'itération
			ite--;
		}
		return res;
	}

	
	
	@Override
	public String toString() {
		return "NaiveMultiSet [ls=" + ls + ", freq=" + freq + "]";
	}

	//Ne fait rien ?
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
		
	

}
