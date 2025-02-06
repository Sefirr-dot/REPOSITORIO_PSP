package ejercicioBasico;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerS {
	private final ServerSocket serverSocket;
	private final int PORT = 54321;
	private DataInputStream recibirDatos = null;
	private DataOutputStream enviarDatos = null;
	public ServerS() throws IOException {
		this.serverSocket = new ServerSocket(PORT);
	}
	
	public void waitConnections () throws IOException {
		System.out.println("Esperar conexiones de clientes");
		Socket socket = serverSocket.accept();
		System.out.println("Cliente conectado correctamente");
		System.out.println("Enviar y recibir mensajes del cliente");

		//recibirDatos del servidor trabaja contra enviarDatos del cliente
		//recibirDatos del cliente trabaja contra enviarDatos del servidor
		recibirDatos = new DataInputStream(socket.getInputStream());
		enviarDatos = new DataOutputStream(socket.getOutputStream());
		//recibirDatos.read();
		writeUTF("Bienvenido a tu servidor favorito");
		readUTF();
		System.out.println("Adios!!");
		
	}
	
	private void readUTF() {
		try {
			System.out.println(Colors.ANSI_YELLOW + "CLIENT: "+ recibirDatos.readUTF()+Colors.ANSI_RESET);
		}catch(IOException ex) {
			System.err.println("Error al leer datos del servidor");
			System.err.println(ex.getMessage());
			System.exit(-2);
		}
		
	}
	
	private void writeUTF(String s) {
		try {
			enviarDatos.writeUTF(s);;
		}catch(IOException ex) {
			System.err.println("Error al enviar datos al servidor");
		}
		
	}
}
