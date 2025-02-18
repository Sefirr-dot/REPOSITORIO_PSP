package udpEjerAmpliacion.servidor;

import java.net.SocketException;

public class Main {
	private final static int PUERTO = 12345;
	public static void main(String[] args) {
		Server server = null;
		
		try {
			server = new Server(PUERTO);
		} catch (SocketException ex) {
			System.err.println("No se ha podido crear el DatagramSocket");
			System.err.println(ex.getMessage());
			System.exit(-1);
		}
		while(true) {
			server.getData();
		}
		
	}
}
