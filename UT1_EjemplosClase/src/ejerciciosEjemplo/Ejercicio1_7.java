package ejerciciosEjemplo;

import java.io.IOException;

//ejemplo terminacion procesos
public class Ejercicio1_7 {
	
	private static final String CHROME_STRING = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
	private static final String[] CALC = {"C:\\Windows\\System32\\calc.exe"};
	private static final String[] CHROMEA = {"C:\\Program Files\\Google\\Chrome"};
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec(CALC);
			Process process2 = runtime.exec(CHROME_STRING);
			Thread.sleep(6000);
			process.destroy();
			Thread.sleep(6000);
			process2.destroy();
		} catch (IOException ex) {
			System.err.println("Excepción de E/S!!");
			System.exit(-1);
		}
	}

}