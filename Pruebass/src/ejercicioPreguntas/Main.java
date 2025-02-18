package ejercicioPreguntas;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Cliente c1 = new Cliente("localhost", 55555);
		
		Scanner scanner  = new Scanner(System.in);
		System.out.println("Di la pregunta");
		String cadenaString = scanner.nextLine();
		c1.enviar(cadenaString);
		System.out.println(c1.recibir());

	}

}
