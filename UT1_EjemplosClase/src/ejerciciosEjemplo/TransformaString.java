package ejerciciosEjemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class TransformaString {

	public static void main(String[] args) throws IOException {
		InputStreamReader ipsr = new InputStreamReader(System.in, Charset.forName("UTF-8"));
		BufferedReader bReader = new BufferedReader(ipsr);
		
		String lineString = "";
		do {
			lineString = bReader.readLine();
			System.out.println(lineString.toUpperCase());
		} while (!lineString.isBlank());
	}
}
