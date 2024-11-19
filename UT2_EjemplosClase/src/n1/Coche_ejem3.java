package n1;
import java.util.Random;

public class Coche_ejem3 extends Thread {

	private Random aleatorio = new Random();
	private String nombreString;
	
	
	
	public Coche_ejem3(String nombreString) {
		super();
		this.nombreString = nombreString;
	}



	@Override
	public void run() {
		for (int i=0;i<50;i++) {
			//cada ejecucion esperara un tiempo aleatorio
			try{
				sleep(aleatorio.nextLong(2)*1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("He ganado! "+ " "+this.nombreString);
	}
	
}
