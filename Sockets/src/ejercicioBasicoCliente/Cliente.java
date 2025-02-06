package ejercicioBasicoCliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	private final String HOST;
	private final int PORT;
	private final Socket socket;
	private DataInputStream recibirDatos = null;
	private DataOutputStream enviarDatos = null;
	public Cliente (String H, int P) throws UnknownHostException, IOException {
		this.HOST=H;
		this.PORT=P;
		System.out.println("Iniciando socket contra el HOST: "+this.HOST+" y el PORT: "+this.PORT);
		
		socket = new Socket(HOST, PORT);
	}
	
	public void connect() throws IOException {
		System.out.println("Enviar y recibir mensajes del server");
		//recibirDatos del servidor trabaja contra enviarDatos del cliente
		//recibirDatos del cliente trabaja contra enviarDatos del servidor
		recibirDatos = new DataInputStream(socket.getInputStream());
		enviarDatos = new DataOutputStream(socket.getOutputStream());
		System.out.println("Leer información del server");
		readUTF();
		writeUTF("Muchas gracias!!");
		System.out.println("Adios!!");
	}
	
	private void readUTF() {
		try {
			System.out.println(Colors.ANSI_CYAN+"SERVER: "+ recibirDatos.readUTF()+Colors.ANSI_RESET);
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
