package tarea2.servidor;

import java.net.SocketException;

public class MainB {
	private final static int PUERTO = 12345;
	public static void main(String[] args) {
		B terminalB = null;
		
		try {
			terminalB = new B(PUERTO);
		} catch (SocketException ex) {
			System.err.println("No se ha podido crear el DatagramSocket");
			System.err.println(ex.getMessage());
			System.exit(-1);
		}
		String mensaje = terminalB.getData();
		terminalB.sendData(mensaje);
	}
}
