package ejercicio2;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Escribe la cadena que quieres ver si es palindroma");
		
		String cadenaString = scanner.next();
		scanner.close();
		cadenaString = cadenaString.trim();

		ProcessBuilder pb = new ProcessBuilder("Java","-cp","bin","ejercicio2.Palindromo",cadenaString);
		Process procesoProcess = pb.start();
		

		procesoProcess.getOutputStream().close();

         // Esperar a que el proceso termine y obtener el código de salida
         int exitCode = procesoProcess.waitFor();
         
         switch (exitCode) {
         case 1:
             System.out.println("La cadena está vacía o solo tiene caracteres en blanco.");
             break;
         case 2:
             System.out.println("La cadena es un palíndromo.");
             break;
         case 3:
             System.out.println("La cadena no es un palíndromo.");
             break;
         default:
             System.out.println("Error inesperado.");
             break;
     }
	}

}
