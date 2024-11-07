package ejercicioAuxilio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Padre {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String claseProcesa="ejercicioAuxilio.Hijo";
		File path = new File(".\\bin\\");
		ProcessBuilder pb = null;
		Process p = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cadena = "";
		
		
		System.out.println("Introduce un numero: ");
		cadena = br.readLine();

		
		pb = new ProcessBuilder("java",claseProcesa).directory(path).redirectErrorStream(true);
		
		p = pb.start();
		
		OutputStream os = p.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write(cadena);
		bw.newLine();
		bw.flush();
		

		bw.flush();
		
		InputStream iStream = p.getInputStream();
		BufferedReader br1 = new BufferedReader(new InputStreamReader(iStream));
		String lineaString = "";
		
		
		 while ((lineaString=br1.readLine())!=null) {
			 System.out.println(lineaString);
		}

		 
		
		
		bw.close();
	}

}
