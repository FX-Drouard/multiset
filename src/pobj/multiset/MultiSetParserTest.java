package pobj.multiset;

import java.io.IOException;

public class MultiSetParserTest {
	public static void main(String[] args) throws InvalidMultiSetFormat, IOException {
		String file="data/Chaines.txt";
		
		//Un -1 dans un champ
		//String file="data/Chaines2.txt";
		
		
		//Le format n'est pas respectée on a l'utilisation de séparateur dans les chaines
		//String file="data/Chaines3.txt";
		
		MultiSet<String> mset1=MultiSetParser.parse(file);
		System.out.println(mset1.toString());
	}
}
