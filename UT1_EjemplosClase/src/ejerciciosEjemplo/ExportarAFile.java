package ejerciciosEjemplo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ExportarAFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (InputStreamReader ipsr = new InputStreamReader(System.in, Charset.forName("UTF-8"));
		BufferedReader bReader = new BufferedReader(ipsr);
		
				
		FileWriter fw = new FileWriter(new File("..\\"+args[0]));
		BufferedWriter bWriter = new BufferedWriter(fw)) {
			String lineString = "";
			do {
				lineString = bReader.readLine();
				bWriter.write(lineString);
				bWriter.newLine();
			} while(!lineString.isBlank());
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
	}

}
