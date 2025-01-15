package ejercicioTipoExamen;

public class ExamenPrueba {

	public static void main(String[] args) throws InterruptedException {
		
		String nombreString = args[0];
		
		int duracion = Integer.parseInt(args[1]);
		
		Hilo h1 = new Hilo(nombreString);
		
		try {
			h1.start();
			Thread.sleep(duracion*1000);
			h1.interrupt();
		} catch (Exception e) {
			
		} finally {
			System.out.println("La muerte es el comienzo de la inmortalidad");
			h1.join();
		}
		System.out.println("FIN DE LA APP");
	}
}
