package ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class PP {

	public static void main(String[] args) throws IOException {
		
		File path = new File(".\\bin\\");
		String claseString = "ejercicio3.PH";
		ProcessBuilder pBuilder;
		Process p1=null;
		pBuilder = new ProcessBuilder("java",claseString).directory(path).redirectErrorStream(true);
		Scanner scanner = new Scanner(System.in);
		
		String cadenaString = "";
		
		while(!cadenaString.equals("fin")) {
			String cadena = "";
			System.out.println();
			cadenaString=scanner.next();
			if(cadenaString.equals("fin")) {
				System.out.println("ADIOS!");
			} else {
			p1 = pBuilder.start();
			InputStream iStream = p1.getInputStream();
			BufferedReader br1 = new BufferedReader(new InputStreamReader(iStream));

			
			OutputStream os = p1.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			cadena=br1.readLine();
			System.out.println(cadena);
			}
		}

	}

}
