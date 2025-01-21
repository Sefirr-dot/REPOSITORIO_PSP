package examen1;

public class Hilo extends Thread {

	private static String ganadorString = null;
	private String nombreString;
	private int espera;
	
	public Hilo(String nombreString, int espera) {
		super();
		this.nombreString = nombreString;
		this.espera = espera;
	}
	
	@Override
	public void run() {
		for (int i = 1; i < 21; i++) {
						
			try {
				System.out.println(nombreString  + " ha recorrido "+i+" metros");
				Thread.sleep(espera);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\n"+ nombreString + " ha llegado a la meta.");
		
		synchronized (this) {
			if(ganadorString == null) {
				ganadorString = nombreString;
			}
		}
	}
	
	public static void main(String[] args) {
		Hilo  h1 = new Hilo("Tortuga", 1000);
		Hilo h2 = new Hilo("Liebre", 1500);
		Hilo h3 = new Hilo("Guepardo", 2000);
		
		h1.start();
		h2.start();
		h3.start();
		
		try {
			h1.join();
			h2.join();
			h3.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("El ganador es: "+ ganadorString);
	}
}
