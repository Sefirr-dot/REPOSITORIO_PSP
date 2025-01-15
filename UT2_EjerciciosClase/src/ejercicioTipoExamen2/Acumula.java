package ejercicioTipoExamen2;

public class Acumula {

	private int suma_acumula;

	public Acumula(int suma_acumula) {
		super();
		this.suma_acumula = suma_acumula;
	}
	
	public synchronized void sumar() {
		this.suma_acumula++;
	}

	public int getSuma_acumula() {
		return suma_acumula;
	}

	public void setSuma_acumula(int suma_acumula) {
		this.suma_acumula = suma_acumula;
	}
	

}
