package procesos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Colaborar {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		File patFile = new File(".\\bin\\");

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime el número de iteraciones: (al menos 10)");
		
		int iteraciones = sc.nextInt();
		
		int iteracionesLenguaje = 10;
		
		if(iteraciones >= 10) {
			
			for (int i = 0; i < iteraciones; i++) {
				
				Process pcProcess = new ProcessBuilder("java" , "procesos.Lenguaje" , Integer.toString(iteracionesLenguaje) , "..\\miFichero.txt")
						.redirectErrorStream(true).directory(patFile).start();
				
				iteracionesLenguaje+=10;
				
			}
			
		} else {
			
			System.out.println("El número de iteraciones no es al menos de 10");
			
		}
		
		System.out.println("Terminó el proceso");

	}

}
