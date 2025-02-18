package udpEjerAmpliacion.cliente;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {
	public static void main(String[] args) {
		Client client = null;
		try {
			client = new Client(InetAddress.getByName("localhost"), 12345);
		} catch (UnknownHostException e) {
			System.err.println("No se ha encontrado el host especificado");
			System.err.println(e.getMessage());
			System.exit(-1);
		} catch (SocketException ex) {
			System.err.println("No se ha podido crear el DatagramSocket");
			System.err.println(ex.getMessage());
			System.exit(-2);
		}
		int opcion;
		do {
			opcion = Menu.show();
			switch (opcion) {
			case 0:
				System.out.println("Gracias por usar la aplicación");
				System.exit(0);
				//break;
			case 1:
				System.out.println("Has elegido la suma");
				break;
			case 2:
				System.out.println("Has elegido la resta");
				break;
			case 3:
				System.out.println("Has elegido la multiplicacion");
				break;
			case 4:
				System.out.println("Has elegido la division");
				break;
			case 5:
				System.out.println("Has elegido el resto");
				break;

			}
			int num1 = Teclado.getNum();
			int num2 = Teclado.getNum();
			String msg = opcion+":"+num1+":"+num2;
			client.sendData(msg);
			client.getData();
		}while (opcion != 0);
	}
}
