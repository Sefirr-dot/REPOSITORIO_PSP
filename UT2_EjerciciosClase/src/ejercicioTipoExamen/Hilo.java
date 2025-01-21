package ejercicioTipoExamen;

public class Hilo extends Thread {

	private String nombreString;
	

	public Hilo(String nombreString) {
		super();
		this.nombreString = nombreString;
		
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
