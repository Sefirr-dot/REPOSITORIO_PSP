package sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket serverSocket;
	private int puerto;
	
	public Server(int puerto) throws IOException {
		super();
		this.puerto = puerto;
		this.serverSocket = new ServerSocket(puerto);
	}
	
	public void conectar() throws IOException {
		
		while(true) {
			Socket s1 = serverSocket.accept();
			
			Hilo hilo = new Hilo(s1);
			
			hilo.start();
		}
		
		
	}
}
