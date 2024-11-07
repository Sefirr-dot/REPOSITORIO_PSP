package procesos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Tercera {

	public static void main(String[] args) throws IOException, InterruptedException {

		File pathFile = new File(".\\bin\\");
		
		Process p1 = new ProcessBuilder("java" , "procesos.Aleatorios").redirectErrorStream(true).directory(pathFile).start();
		Process p2 = new ProcessBuilder("java" , "procesos.OrdenarNumeros").redirectErrorStream(true).directory(pathFile).start();
		
		InputStream isProcTrStream = p1.getInputStream();
		OutputStream osP2 = p2.getOutputStream();
		InputStream isP2 = p2.getInputStream();
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(isProcTrStream));
		BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(osP2));
		
		String linea = "";
		
		while(((linea = br.readLine())!= null)) {
			
			System.out.println("Recibido: " + linea);
			
			bf.write((linea + "\n"));
			bf.flush();
			
		}
		
		osP2.close();
		
		System.out.println("----------------------------------------------");
		
		BufferedReader br2 = new BufferedReader(new InputStreamReader(isP2));
		
		String linea2 = "";
		
		while(((linea2 = br2.readLine())!= null)) {
			
			//linea2 = br2.readLine();
			
			System.out.println("Ordenado: " + linea2);
			
		}
		
		p1.waitFor();
        p2.waitFor();
		
		System.out.println("Proceso Finalizado");

	}

}
