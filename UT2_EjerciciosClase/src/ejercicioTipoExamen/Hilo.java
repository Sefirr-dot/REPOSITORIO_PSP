package ejercicioTipoExamen;

public class Hilo extends Thread {

	private String nombreString;
	private boolean activo;

	public Hilo(String nombreString) {
		super();
		this.nombreString = nombreString;
		this.activo = true;
	}


	@Override
	public void run() {
		while(!currentThread().isInterrupted()) {
			if(nombreString.equals("Vanesa")) {
				System.out.println("Soy "+nombreString+", el hilo inmortal.");
			}
		}
		
	}
	
	
}
