package Ejercicio2_palindro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Palindroma {
	public static void main (String[] args) throws IOException {
		String cadena = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		cadena = br.readLine();
		
		if (cadena.length() == 0) {
			System.exit(1);
		} else if (EsPalindroma(cadena)) {
			System.exit(2);
		} else System.exit(3);
	}

	public static boolean EsPalindroma(String cad) {
		boolean res = true;
		int lonCad = cad.length()/2;
		int i = 0;

		while (res && i<=lonCad) {
			if (cad.charAt(i) != cad.charAt(cad.length()-1-i)) res = false;
			i++;
		}
		return res;
	}
}
