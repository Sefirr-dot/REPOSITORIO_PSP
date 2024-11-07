package ejercicio3;

import java.util.Random;

public class PH {

	public static void main(String[] args) {
		
		Random rdRandom = new Random();
		int numeroPar = rdRandom.nextInt(10)+1;
		numeroPar = numeroPar*2; // para que siempre sean pares
		
		System.out.println(numeroPar);

	}

}
