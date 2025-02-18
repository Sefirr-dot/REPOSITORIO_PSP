package miguel1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	
	private String HOST;
	private int PORT;
	private Socket socket;
	private DataInputStream dataInputStream = null;
	private DataOutputStream dataOutputStream = null;
	
	public Cliente(String host,int puerto) throws UnknownHostException, IOException {
		this.socket = new Socket(host,puerto);
	}

	public String recibir() throws IOException {
		dataInputStream = new DataInputStream(socket.getInputStream());
		return dataInputStream.readUTF();
	}
	
	public void enviar(String cadena) throws IOException {
		dataOutputStream = new DataOutputStream(socket.getOutputStream());
		dataOutputStream.writeUTF(cadena);
	}
}
