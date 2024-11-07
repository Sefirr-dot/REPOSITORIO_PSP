package procesos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Lenguaje {

	public static void main(String[] args) throws IOException {
		
		int numPalabras = Integer.parseInt(args[0]);
		
		FileWriter fw = new FileWriter(new File(".\\" + args[1]) , true);
		
		BufferedWriter bf = new BufferedWriter(fw);
		
		for (int i = 0; i < numPalabras; i++) {
			
			String palabraString = generarPalabra();
			
			//System.out.println(palabraString);
			
			bf.write(palabraString);
			bf.newLine();
			
		}
		
		bf.close();
		fw.close();
		

		//BufferedWriter bf = new BufferedWriter(new FileWriter(archivo , true));
		
	}
	
	private static String generarPalabra() {
		
		String palabra = "";
		
		Random nRandom = new Random();
		
		for (int i = 0; i < nRandom.nextInt(10)+4; i++) {
			
			int nRand = 97 + nRandom.nextInt(122 - 97 + 1);
			
			char c = (char) nRand;
			
			palabra = palabra + c;
			
		}
		
		return palabra;
		
	}

}
