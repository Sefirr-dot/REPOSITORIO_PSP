package ejercicioTipoExamen2;

public class Ejercicio {

	public static void main(String[] args) throws InterruptedException {
		Acumula a1 = new Acumula(0);
		
		Hilo h1 = new Hilo(a1);
		Hilo h2 = new Hilo(a1);
		
		try {
			h1.start();
			h2.start();
		

		} catch (Exception e) {
			System.out.println("Error");
		} finally {
			
			h1.join();
			h2.join();
		}
		System.out.println(a1.getSuma_acumula());
		System.out.println("FIN DE LA APP");
	}

}
