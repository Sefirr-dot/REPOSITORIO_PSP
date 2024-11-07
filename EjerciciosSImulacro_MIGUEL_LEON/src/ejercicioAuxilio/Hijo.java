package ejercicioAuxilio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int numfinal = 0;
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println("Hola");
		int num1 = Integer.parseInt(bReader.readLine());

		System.out.println("Adios");
		int num2 = Integer.parseInt(bReader.readLine());
		
		if(num1>0 && num2>0) {
			numfinal=num1+num2;
		}
		System.out.println("La suma es: "+ numfinal);
	}

}
