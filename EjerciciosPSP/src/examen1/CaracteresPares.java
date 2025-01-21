package examen1;

import java.util.concurrent.Semaphore;

public class CaracteresPares extends Thread {

	private int tipo;
	private Semaphore semaphore;
	
	public CaracteresPares(int tipo, Semaphore sem) {
		super();
		this.tipo = tipo;
		this.semaphore = sem;
	}

	@Override
	public void run() {
		
		try {
			semaphore.acquire();
			if(this.tipo == 0) {
				mostrarNumeros();
			} else if(this.tipo == 1) {
				mostrarAbecedario();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		semaphore.release();
	}
	
	private static void mostrarNumeros() {
		for (int i = 1; i <= 30; i++) {
			System.out.println(i);
		}
	}
	
	private static void mostrarAbecedario() {
		char[] abecedario = {
		                    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
		                    'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
		};
		
		for (int i = 0; i < abecedario.length; i++) {
			System.out.println(abecedario[i]);
		}
	}
	
}