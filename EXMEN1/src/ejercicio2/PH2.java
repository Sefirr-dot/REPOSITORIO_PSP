package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PH2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String siOno = bReader.readLine();
		
		if(siOno.equals("SI")) {
			System.out.println("PARiendo cincos");
		} else {
			System.out.println("sIMPARticos cincos");
		}
	}

}
