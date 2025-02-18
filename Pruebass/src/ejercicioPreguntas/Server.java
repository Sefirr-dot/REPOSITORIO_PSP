package ejercicioPreguntas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import ejercicioListasCliente.Hilo;

public class Server {

	private ServerSocket serverSocket;
	private int puerto;
	
	private DataOutputStream oStream;
	private DataInputStream inputStream;

	public Server(int puerto) throws IOException {
		super();
		this.puerto = puerto;
		this.serverSocket = new ServerSocket(puerto);
	}

	public void conectar() throws IOException {
			Socket s1 = serverSocket.accept();
			inputStream = new DataInputStream(s1.getInputStream());
			
			String cadenaString = inputStream.readUTF();
			if(cadenaString.equals("¿Cómo te llamas?")) {
				oStream = new DataOutputStream(s1.getOutputStream());
				oStream.writeUTF("Mi nombre es Ejercicio 4");
			} else {
				if(cadenaString.equals("¿Cuántas líneas de código tienes?")) {
					oStream = new DataOutputStream(s1.getOutputStream());
					oStream.writeUTF("53");
				}
				else {
					if(cadenaString.charAt(cadenaString.length()-1)=='?' || !cadenaString.equals("¿Cuántas líneas de código tienes?") || !cadenaString.equals("¿Cómo te llamas?")) {
						oStream = new DataOutputStream(s1.getOutputStream());
						oStream.writeUTF("No entiendo la pregunta");
					}
				}
			}

	}
}
