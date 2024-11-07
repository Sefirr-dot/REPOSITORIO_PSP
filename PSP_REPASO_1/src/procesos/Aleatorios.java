package procesos;

import java.util.Random;

public class Aleatorios {

	public static void main(String[] args) {

		Random nRandom = new Random();
		
		for (int i = 0; i < 40; i++) {
			
			int number = nRandom.nextInt(100);
			
			System.out.println(number);
			
		}

	}

}
