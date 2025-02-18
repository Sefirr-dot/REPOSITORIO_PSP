package tarea2.cliente;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MainA {
	public static void main(String[] args) {
		A terminalA = null;
		try {
			terminalA = new A(InetAddress.getByName("localhost"), 12345);
		} catch (UnknownHostException e) {
			System.err.println("No se ha encontrado el host especificado");
			System.err.println(e.getMessage());
			System.exit(-1);
		} catch (SocketException ex) {
			System.err.println("No se ha podido crear el DatagramSocket");
			System.err.println(ex.getMessage());
			System.exit(-2);
		}
		
		Scanner entrada = new Scanner(System.in);
		String mess = entrada.nextLine();
		terminalA.sendData(mess);
		terminalA.getData();
		entrada.close();
	}
}
