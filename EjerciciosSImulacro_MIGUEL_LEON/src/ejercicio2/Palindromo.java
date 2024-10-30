package ejercicio2;

import java.util.Scanner;

public class Palindromo {

	public static void main(String[] args) {
		
		
		String cadenaString = args[0].toLowerCase();
		
		
		if(cadenaString.isEmpty() || cadenaString.isBlank()) {
			System.exit(1);
		}
		String cadenaAuxString = "";
		for(int i =cadenaString.length()-1; i>=0;i--) {
			cadenaAuxString += cadenaString.charAt(i);
		}
		
		if(cadenaString.equals(cadenaAuxString)) {
			System.exit(2);
		} else {
			System.exit(3);
		}
	}
}
