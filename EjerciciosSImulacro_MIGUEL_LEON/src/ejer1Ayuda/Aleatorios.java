package ejer1Ayuda;

import java.util.Random;

public class Aleatorios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rdRandom = new Random();
		
		for (int i = 0; i < 40; i++) {
			
			System.out.println(rdRandom.nextInt(100));
			
		}
	}

}
