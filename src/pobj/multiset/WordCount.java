package pobj.multiset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pobj.util.Chrono;

import java.util.Comparator;

public class WordCount {
	public static void wordcount(MultiSet<String> ms) throws IOException {
		//Attention : Le path du fichier dépend de l'hôte a modifier en fonction de la machine

		String file ="data/WarAndPeace.txt"; //"MonFichier.txt";

		BufferedReader br=new BufferedReader(new FileReader(file));
		String line;
		while((line=br.readLine())!=null) {
			for(String word: line.split("\\P{L}+")) {
				if(word.equals("")) continue;
				ms.add(word);
			}
		}
		br.close();
		
		/*List<String> elements = new ArrayList<>();
		elements=ms.elements();
		
		Collections.sort(elements, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(ms.count(s1)>ms.count(s2)) {
					return 1;
				}else if(ms.count(s1)<ms.count(s2)) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		
		Collections.reverse(elements);
		
		for(int i=0;i<10;i++) {
			System.out.println(elements.get(i));
		}*/
	}
	
	/*
	public static void wordcount2(MultiSet<String> ms) throws IOException {
		//Attention : Le path du fichier dépend de l'hôte a modifier en fonction de la machine
		String file ="data/WarAndPeace.txt"; //"MonFichier.txt";
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
	}*/
	
	public static void main(String[] args) throws IOException{
		
		Chrono chrono1= new Chrono();
		MultiSet<String> mset= new HashMultiSet<>();
		MultiSet<String> decoset1= new MultiSetDecorator(mset);
		wordcount(mset);
		wordcount(decoset1);
		chrono1.stop();
		
		System.out.println("\n\n");
		
		Chrono chrono2 = new Chrono();
		
		MultiSet<String> nset= new NaiveMultiSet<>();
		MultiSet<String> decoset2= new MultiSetDecorator(nset);
		//wordcount2(nset);
		wordcount(nset);
		wordcount(decoset2);
		chrono2.stop();
	}
		
	
}
