package ejerciciosEjemplo;

import java.io.IOException;
import java.util.Arrays;

public class Ejercicio1_6 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		if( args.length<=0) {
			System.out.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		ProcessBuilder pb = new ProcessBuilder(args);
		
		Process process = pb.start();
		int retorno = process.waitFor();
		
		System.out.println("La ejecucion de "+Arrays.toString(args)+" devuelve "+ retorno);

	}

}
