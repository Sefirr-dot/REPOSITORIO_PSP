package examen1;

public class Tortuga_con_Prioridad extends Thread {

	String nombreString;

	public Tortuga_con_Prioridad(int prioridad, String nombreString) {
		this.nombreString = nombreString;
		setPriority(prioridad);
	}
	
	@Override
	public void run() {

		for(int c = 1; c<=30; c++) {
			System.out.println(c+" metros");
			Thread.yield();
		}
		System.out.println("\n LLego a la meta "+ nombreString);
	}
	
	static Tortuga_con_Prioridad liebreHilo;
	static Tortuga_con_Prioridad conejoHilo;
	static Tortuga_con_Prioridad tortugaHilo;
	
	public static void main(String[] args) throws InterruptedException {
		conejoHilo = new Tortuga_con_Prioridad(1, "zorro");
		liebreHilo = new Tortuga_con_Prioridad(5,"liebre");
		tortugaHilo = new Tortuga_con_Prioridad(8,"tortuga");
		
		conejoHilo.start();
		liebreHilo.start();
		tortugaHilo.start();
		
		conejoHilo.join();
		liebreHilo.join();
		tortugaHilo.join();
	}
	
}
