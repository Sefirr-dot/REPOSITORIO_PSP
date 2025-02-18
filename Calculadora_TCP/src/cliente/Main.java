package cliente;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

	public static void main(String[] args) throws IOException {
		Cliente cliente = null;
		String HOST = "localhsot";
		int PORT = 54322;
		try {
			cliente = new Cliente("localhost", PORT);
		}catch(IOException ex) {
			System.err.println("No se ha podido abrir el cliente contra el HOST: "+HOST+" y el PORT: "+PORT);
			System.err.println(ex.getMessage());
			System.exit(-1);
		}
		try {
			cliente.connect();
		}catch(IOException ex) {
			System.err.println("Error en la comunicacion con el servidor");
			System.err.println(ex.getMessage());
			System.exit(-2);
		}
	
	}

}
