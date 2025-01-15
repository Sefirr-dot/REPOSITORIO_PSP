package ejercicioTipoExamen2;

public class Hilo extends Thread {
	
	private static final int NUMERO = 100000000;
	
	private Acumula acumula;

	public Hilo(Acumula acumula) {
		super();
		this.acumula = acumula;
	}
	
	@Override
	public void run() {
		int i = 0;
		while(i<NUMERO) {
			i++;
			acumula.sumar();
		}
	}

}
