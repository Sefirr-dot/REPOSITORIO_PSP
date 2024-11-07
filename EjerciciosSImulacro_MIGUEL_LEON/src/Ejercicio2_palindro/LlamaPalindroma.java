package Ejercicio2_palindro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class LlamaPalindroma {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String claseHija="Ejercicio2_palindro.Palindroma";
		File path = new File(".\\bin\\");
		ProcessBuilder pb = null;
		Process p = null;
		
		String cadena = "";
		int exitValue = -1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Introduce  una cadena por teclado: ");
		cadena = br.readLine();
			
		
		pb = new ProcessBuilder("java",claseHija).directory(path).redirectErrorStream(true);
		
		//Comprueba que la ruta introducida existe y es un directorio.
		if(	path.exists() && path.isDirectory()	) {
			
			try {
				p = pb.start();
				
			} catch (IOException e) {	
				System.out.println("Error al crear el proceso");
			}
			
			OutputStream os = p.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			try {
				bw.write(cadena);
				bw.flush();
			} catch (IOException e) {
				System.out.println("Error al pasar la cadena al proceso hijo");
			}
			bw.close();

			try {
				 exitValue = p.waitFor();
			} catch (InterruptedException e) {
				System.out.println("El proceso hijo no ha terminado");
			}

			if (exitValue == 1) 
				System.out.println("La cadena estaba vacía");
			else if (exitValue == 2) 
				System.out.println("La cadena es palíndroma");
			else if (exitValue == 3) 
				System.out.println("La cadena no es palíndroma");
			
			/*
			InputStream is = p.getInputStream();
			 
			InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
			BufferedReader brp = new BufferedReader(isr);
			try {
				while((salida = brp.readLine()) != null ) {
					System.out.println(salida);
				}
			} catch (IOException e) {
				System.out.println("Error al leer la salida del proceso hijo");
			}
			*/
			
		}else {
			System.out.println("El directorio no existe");
		}
		
		System.out.println("Fin programa");		

	}

}
