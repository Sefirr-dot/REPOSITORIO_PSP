package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Hilo extends Thread {

	private Socket socket;
	private DataInputStream dataInputStream = null;
	private DataOutputStream dataOutputStream=null;
	private static int cuenta = 0;


	public Hilo(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {

		synchronized (this) {
			cuenta++;

		}
		try {
			enviar("Eres el hilo numero: "+cuenta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void enviar(String mensaje) throws IOException {
		dataOutputStream = new DataOutputStream(socket.getOutputStream());
		dataOutputStream.writeUTF(mensaje);
	}

	public String recibir() throws IOException {
		dataInputStream = new DataInputStream(socket.getInputStream());
		return dataInputStream.readUTF();
	}
}
