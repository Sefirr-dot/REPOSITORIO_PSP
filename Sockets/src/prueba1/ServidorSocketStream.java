package prueba1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetSocketAddress;

public class ServidorSocketStream {

	public static void main(String[] args) {
		try {
			System.out.println("Creando socket servidor");
			ServerSocket serverSocket = new ServerSocket();
			System.out.println("Realizando el bind");
			
			InetSocketAddress addr = new InetSocketAddress ("192.168.1.106", 5555);
			serverSocket.bind(addr);
			System.out.println("Aceptando conexiones");
			
			Socket newSocket = serverSocket.accept();
			
			System.out.println("Conexión recibida");
			
			InputStream is = newSocket.getInputStream();
			OutputStream os = newSocket.getOutputStream();
			
			byte[] mensaje = new byte[25];
			is.read(mensaje);
			System.out.println("Mensaje recibido: " + new String(mensaje));
			
			System.out.println("Cerrando el nuevo socket");
			
			newSocket.close();
			System.out.println("Cerrando el socket servidor");
			serverSocket.close();
			System.out.println("Terminado");
			
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
