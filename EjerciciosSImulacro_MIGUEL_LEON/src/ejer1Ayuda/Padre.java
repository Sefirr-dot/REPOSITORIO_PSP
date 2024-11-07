package ejer1Ayuda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Padre {

	public static void main(String[] args) throws IOException, InterruptedException {
		String claseRandom="ejer1Ayuda.Aleatorios";
		String claseOrden="ejer1Ayuda.OrdenarNumero";
		
		ProcessBuilder pb1 = null;
		ProcessBuilder pb2 = null;
		Process p1 = null;
		Process p2 = null;
		
		File path = new File(".\\bin\\");
		
		pb1 = new ProcessBuilder("java",claseRandom).directory(path).redirectErrorStream(true);
		pb2 = new ProcessBuilder("java",claseOrden).directory(path).redirectErrorStream(true);
		
		p1 = pb1.start();
		p2 = pb2.start();
		
		InputStream iStream = p1.getInputStream();
		BufferedReader br1 = new BufferedReader(new InputStreamReader(iStream));
		String lineaString = "";
		
		
		InputStream iStream2 = p2.getInputStream();
		BufferedReader br2 = new BufferedReader(new InputStreamReader(iStream2));
		String lineaString2 = "";
		
		
		OutputStream os = p2.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		while((lineaString = br1.readLine())!=null) {
	
			System.out.println(lineaString);
			bw.write(lineaString);
			bw.newLine();
			bw.flush();
			
		}
		bw.close();
		while ((lineaString2 = br2.readLine())!=null) {
			System.out.println("NUMERO ORDENADOS:"+lineaString2);
		}
		br2.close();

		int contF=0;
		String ficheroEntrada = args[0];
    	int pos = ficheroEntrada.indexOf(".");
    	String nombreFichero = ficheroEntrada.substring(0, pos);
    	contF++;
    	String fichSalida = nombreFichero + contF+"S.txt";
    	String fichError = nombreFichero + contF+"E.txt";
    	
    	
    	FileWriter fwS = new FileWriter(new File(fichSalida));
    	BufferedWriter bwS = new BufferedWriter(fwS);
    	PrintWriter pw = new PrintWriter(fwS);

    	FileReader fileReader = new FileReader(ficheroEntrada);
    	BufferedReader br = new BufferedReader(fileReader);
	}

}
