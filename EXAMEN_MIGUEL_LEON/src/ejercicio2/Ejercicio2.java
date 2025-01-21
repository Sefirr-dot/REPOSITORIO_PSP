package ejercicio2;

import java.util.Random;

public class Ejercicio2 extends Thread {

	public static int CAJA =0;
	public static boolean ocupado = false;
	private String nombreString;
	Random rdRandom = new Random();
	public Ejercicio2(String nombreString) {
		super();
		this.nombreString = nombreString;
	}
	
	public synchronized void atender() throws InterruptedException {
		while(ocupado) {
			wait();
		}
		ocupado = true;
		int aportacion = rdRandom.nextInt(5)+1;
		
		CAJA = CAJA + aportacion;
		salir();
	}
	
	public synchronized void salir() {
		ocupado = false;
		notifyAll();
	}
	
	@Override
	public void run() {
		for(int i=1;i<25;i++) {
			try {
				atender();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Ejercicio2 e1 = new Ejercicio2("hola");
		Ejercicio2 e2 = new Ejercicio2("hola");
		e1.start();
		e2.start();
		
		e1.join();
		e2.join();
		System.out.println("La caja ha recaudado: "+CAJA);
	}
	
}
