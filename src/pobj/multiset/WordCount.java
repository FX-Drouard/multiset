package pobj.multiset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class WordCount {
	public static void wordcount(MultiSet<String> ms) throws IOException {
		//Attention : Le path du fichier dépend de l'hôte a modifier en fonction de la machine
		String file ="/home/alex/git/multiset/data/MonFichier.txt"; //"MonFichier.txt";
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line;
		while((line=br.readLine())!=null) {
			for(String word: line.split("\\P{L}+")) {
				if(word.equals("")) continue;
				ms.add(word);
			}
		}
		br.close();
		
		List<String> elements = new ArrayList<>();
		elements=ms.elements();
		
		Collections.sort(elements, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(ms.count(s1)>ms.count(s2)) {
					return 1;
				}else if(ms.count(s1)<ms.count(s2)) {
					return -1;
				}else {
					return s1.compareTo(s2);
				}
			}
		});
		
		Collections.reverse(elements);
		
		for(int i=0;i<10;i++) {
			System.out.println(elements.get(i));
		}
	}
	
	public static void wordcount2(MultiSet<String> ms) throws IOException {
		//Attention : Le path du fichier dépend de l'hôte a modifier en fonction de la machine
		String file ="/home/alex/git/multiset/data/MonFichier.txt"; //"MonFichier.txt";
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line;
		while((line=br.readLine())!=null) {
			for(String word: line.split("\\P{L}+")) {
				if(word.equals("")) continue;
				ms.add(word);
			}
		}
		br.close();
		
		List<String> elements=((NaiveMultiSet<String>) ms).sortFreq();
		
		for(int i=0;i<10;i++) {
			System.out.println(elements.get(i));
		}
	}
	
	public static void main(String[] args) throws IOException{
		MultiSet<String> mset= new HashMultiSet<>();
		wordcount(mset);
		
		System.out.println("\nOn saute une ligne\n");
		MultiSet<String> nset= new NaiveMultiSet<>();
		wordcount2(nset);
	}
		
	
}
