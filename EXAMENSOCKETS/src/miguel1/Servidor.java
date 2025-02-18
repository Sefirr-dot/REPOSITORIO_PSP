package miguel1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	private int puerto;
	private DataInputStream inputStream = null;
	private DataOutputStream outputStream = null;
	
	private ServerSocket s1;
	
	public Servidor(int puerto) throws IOException {
		this.s1 = new ServerSocket(puerto);
	}
	
	public void conectar() throws IOException {
		while(true) {
			Socket socket = s1.accept();
			inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new DataOutputStream(socket.getOutputStream());
			outputStream.writeUTF("Hola señoritas muy buenas tetas por cierto");
			System.out.println(inputStream.readUTF());
		}
	}
}
