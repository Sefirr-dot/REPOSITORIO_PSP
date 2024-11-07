package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PH {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String numString = bReader.readLine();
		int numero = Integer.parseInt(numString);
		
		if(numero%5==0) {
			System.out.println("SI");
		} else {
			System.out.println("NO");
		}

		
	}

}
