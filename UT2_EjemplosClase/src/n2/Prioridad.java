package n2;

class hiloPrioridad extends Thread {

	public hiloPrioridad(String name) {
		super(name);
	}
	
	public void run() {
		System.out.println("iniciado hilo: "+ this);
		while(true);
	}
}
public class Prioridad {
	public static void main(String[] args) {
		hiloPrioridad hpClase = new hiloPrioridad("Lento");
		hpClase.setPriority(Thread.MIN_PRIORITY);
		hpClase.start();
		
		hpClase = new hiloPrioridad("Rapido");
		hpClase.setPriority(Thread.MAX_PRIORITY);
		hpClase.start();
	}
}