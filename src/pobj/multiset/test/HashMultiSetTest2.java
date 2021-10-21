package pobj.multiset.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import pobj.multiset.*;

public class HashMultiSetTest2 {
	@Test 
	public void testAdd1() throws IllegalArgumentException { 
		MultiSet<String> m = new HashMultiSet<>(); 
		m.add("a"); 
		m.add("a",5); 
		assertEquals(m.count("a"), 6); 
	} 

	@Test(expected = IllegalArgumentException.class) 
	public void testAdd2() throws IllegalArgumentException { 
		MultiSet<String> m = new HashMultiSet<>(); 
		m.add("a"); 
		m.add("a",-1); 
	}
	
	@Test
	public void tdsmRemove1() throws IllegalArgumentException{
		MultiSet<String> m = new HashMultiSet<>(); 
		m.add("a"); 
		m.add("a",5); 
		m.remove("a");
		m.remove("a",4);
		assertEquals(m.count("a"),1);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void tdsmRemove2() throws IllegalArgumentException{
		MultiSet<String> m = new HashMultiSet<>(); 
		m.add("a"); 
		m.add("a",5); 
		m.remove("a");
		m.remove("a",-1);
	}
	
	@Test
	public void tdsmSize() throws IllegalArgumentException{
		MultiSet<String> m = new HashMultiSet<>(); 
		m.add("a"); 
		m.add("a",5); 
		m.remove("a");
		m.remove("a",4);
		assertEquals(m.size(),1);
		m.remove("a");
		assertEquals(m.size(),0);
	}
	
	@Test
	public void tdsmtoString() throws IllegalArgumentException{
		MultiSet<String> m = new HashMultiSet<>(); 
		m.add("a"); 
		m.add("b42",2); 
		m.add("c4",99);
		assertEquals(m.toString(),"multiset: [a:1; b42:2; c4:99]");
	}
	
	@Test
	public void tdsmClear() throws IllegalArgumentException{
		MultiSet<String> m = new HashMultiSet<>(); 
		m.add("a"); 
		m.add("b42",2); 
		m.add("c4",99);
		m.add("La_reponse_a_la_vie_est",42);
		m.clear();
		assertEquals(m.size(),0);
		assertEquals(m.count("La_reponse_a_la_vie_est"),0);
	}
	
	@Test
	public void tdsmAddRemove1() throws IllegalArgumentException{
		MultiSet<String> m = new HashMultiSet<>(); 
		m.add("a"); assertEquals(m.count("a"), 1);
		m.clear();
		assertEquals(m.size(),0);
		assertEquals(m.count("a"),0);
		m.add("a");
		m.remove("a");
		m.add("a",42);
		m.add("b42");
		m.add("b42",2); 
		m.add("c4",99);
		m.add("La_reponse_a_la_vie_est",43);
		m.remove("La_reponse_a_la_vie_est",1);
		assertEquals(m.count("La_reponse_a_la_vie_est"),42);
		System.out.println(m.toString());
		assertEquals(m.toString(),"multiset: [a:42; b42:3; c4:99; La_reponse_a_la_vie_est:42]");
	}
	
	public void tdsmAddRemove2() throws IllegalArgumentException{
		MultiSet<String> m = new HashMultiSet<>(); 
		m.add("a"); assertEquals(m.count("a"), 1);
		m.clear();
		assertEquals(m.size(),0);
		assertEquals(m.count("a"),0);
		m.add("a");
		m.remove("a");
		m.add("a",42);
		m.add("b42");
		m.add("b42",2); 
		m.add("c4",99);
		m.add("c4",0);
		m.add("La_reponse_a_la_vie_est",43);
		m.remove("La_reponse_a_la_vie_est",1);
		assertEquals(m.count("La_reponse_a_la_vie_est"),42);
		//System.out.println(m.toString());
		assertEquals(m.toString(),"multiset: [a:42; b42:3; c4:99; La_reponse_a_la_vie_est:42]");
		m.remove("c4",0);
		assertEquals(m.toString(),"multiset: [a:42; b42:3; c4:99; La_reponse_a_la_vie_est:42]");
	}
}
