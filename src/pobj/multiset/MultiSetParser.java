package pobj.multiset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MultiSetParser {
	
	public static MultiSet<String> parse(String fileName) throws InvalidMultiSetFormat, IOException {
		MultiSet<String> mset= new HashMultiSet<>();
		//MultiSet<String>res=new MultiSetDecorator<>(mset);
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(fileName));
			String line;
			while((line=br.readLine())!=null) {
				String[] buffer=line.split(":");
				if(buffer.length<=1 || buffer.length>2) {
					throw new InvalidMultiSetFormat("Il n'y a pas de séparateur sur une ligne ou mauvais type de fichier\n");
				}
				if(buffer[0]=="") {
					continue;
				}
				
				Integer verif= Integer.decode(buffer[1]);
				if(verif<0) {
					throw new InvalidMultiSetFormat("Il y a un nombre négatif dans le second champ\n");
				}
				mset.add(buffer[0],verif);
				//OU
				//res.add(buffer[0],Integer.decode(buffer[1]));
			
			}
			
		}catch (IOException io) {
			System.out.println("Erreur sur la lecture du fichier\n");
			io.printStackTrace();
			
			//On convertit l'exception pour le client
			throw new InvalidMultiSetFormat("Voici l'erreur de lecture\n",io);
		}finally {
			if(br!=null) {
				br.close();
			}
		}
		return mset;
	}

}
