package ejercicioListasCliente;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Cliente c1 = new Cliente("localhost", 55555);
		
		Scanner scanner = new Scanner(System.in);
		int num=10;
		while(num!=0) {
			System.out.println("Di una opcion:\n"
					+ "1.Añadir nombre a la lista\n"
					+ "2.Mostrar la lista\n"
					+"0.Salir");
			num = scanner.nextInt();
			String numeroInteger = Integer.toString(num);
			c1.enviar(numeroInteger);
			if(num==1) {
				System.out.println("Di el nombre a añadir ");
				String nombreString = scanner.next();
				c1.enviar(nombreString);
				c1.recibir();
			}
			if(num==2) {
				System.out.println(c1.recibir());
			} 
			
		}
		System.out.println("Adios!");
		
	}
}
