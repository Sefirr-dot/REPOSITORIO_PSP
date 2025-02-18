package servidor;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

	public static void main(String[] args) {
		ServerS server = null;
		try {
			server = new ServerS();
		}catch(IOException ex) {
			System.err.println("No se ha podido inicializar el servidor");
			System.err.println(ex.getMessage());
			System.exit(-1);
		}
		try {
			server.waitConnections();
		}catch(IOException ex) {
			System.err.println("No se ha podido inicializar la comunicacion con el cliente");
			System.err.println(ex.getMessage());
			System.exit(-2);
		}
		
	}

}
