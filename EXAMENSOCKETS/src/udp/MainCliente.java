package udp;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MainCliente {

	public static void main(String[] args) throws SocketException, UnknownHostException, InterruptedException {
		ClientU c1 = new ClientU(InetAddress.getByName("localhost"), 55555);
		
		
		Scanner scanner = new Scanner(System.in);
		
		int opcion = 10;
		while(opcion!=0) {
			System.out.println("Elige una opcion:\n"
					+ "1.Mandar nombres\n"
					+ "2.Recibir nombres\n"
					+ "0.Salir");
			opcion = scanner.nextInt();
			
			switch (opcion) {
			case 1:
				String nombreString = "";
				System.out.println("Di el nombre que quieres mandar: ");
				while(nombreString.isBlank()) {
					
					nombreString = scanner.nextLine();
				}
				
				c1.sendData(String.valueOf(opcion));
				c1.sendData(nombreString);
				c1.getData();
				break;
			case 2:
				c1.sendData(String.valueOf(opcion));

				String cadenaString = c1.getData();
				System.out.println(cadenaString);
			default:
				//c1.sendData(String.valueOf(opcion));
				break;
			}
		}
		
		
		
		
		

	}

}
