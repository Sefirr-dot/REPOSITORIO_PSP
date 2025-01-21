package ejercicio1;

public class Ejercicio1 extends Thread {
	public static String ganadorString = null;
	private String nombreAnimal;
	private int tiempoCarrera;
	
	public Ejercicio1(String nombreAnimal, int tiempoCarrera) {
		super();
		this.nombreAnimal = nombreAnimal;
		this.tiempoCarrera = tiempoCarrera;
	}
	@Override
	public void run() {
		for(int i=0;i<31;i++) {
			System.out.println(nombreAnimal+" corre un metro");
			try {
				Thread.sleep(tiempoCarrera*100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		synchronized (this) {
			if(ganadorString==null) {
				ganadorString = nombreAnimal;
			}
		}
		
		
	}
	public static void main(String[] args) throws InterruptedException {
		Ejercicio1 ejercicio1 = new Ejercicio1("Zorro", 1);
		Ejercicio1 ejercicio2 = new Ejercicio1("Liebre", 5);
		Ejercicio1 ejercicio3 = new Ejercicio1("Tortuga", 8);
		
		ejercicio1.start();
		ejercicio2.start();
		ejercicio3.start();
		
		ejercicio1.join();
		ejercicio2.join();
		ejercicio3.join();
		
		System.out.println("El ganador es: "+ ganadorString);
		
	}
	
}
