package ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;

public class PP {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ArrayList<String> listaNumeroStrings = new ArrayList<String>();
		
		File path = new File(".\\bin\\");
		String claseString = "ejercicio2.PH";
		String claseString2 = "ejercicio2.PH2";
		ProcessBuilder pBuilder;
		ProcessBuilder pBuilder2;
		Process p1=null;
		Process p2 = null;
		String cadena="";
		Boolean parBoolean = false;
		
		pBuilder = new ProcessBuilder("java",claseString).directory(path).redirectErrorStream(true);
		pBuilder2 = new ProcessBuilder("java",claseString2).directory(path).redirectErrorStream(true);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Random rdRandom = new Random();
		int vecesDeNumeroIntroducidas = rdRandom.nextInt(8)+2;
		System.out.println("Vas a introducir "+vecesDeNumeroIntroducidas+" numeros");
		for(int i = 0; i< vecesDeNumeroIntroducidas; i++) {
			System.out.println("Introduce: ");
			cadena = br.readLine();
			listaNumeroStrings.add(cadena);
		}
		br.close();

		for (String string : listaNumeroStrings) {
			
			p1 = pBuilder.start();
			InputStream iStream = p1.getInputStream();
			BufferedReader br1 = new BufferedReader(new InputStreamReader(iStream));

			
			OutputStream os = p1.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);

			bw.write(string+"\n");
			bw.flush();

			while ((cadena=br1.readLine())!=null) {
				p2 = pBuilder2.start();
				InputStream iStream2 = p2.getInputStream();
				BufferedReader br2 = new BufferedReader(new InputStreamReader(iStream2));

				
				OutputStream os2 = p2.getOutputStream();
				OutputStreamWriter osw2 = new OutputStreamWriter(os2);
				BufferedWriter bw2 = new BufferedWriter(osw2);
				bw2.write(cadena+"\n");
				bw2.flush();
				cadena=br2.readLine();
				System.out.println(cadena);
			}
		}		
		
	}

}
