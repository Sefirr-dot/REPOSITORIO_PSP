package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	private int puerto;
	private String direccion;
	
	private Socket s1;
	private DataOutputStream oStream;
	private DataInputStream inputStream;
	
	public Cliente(String direc,int puerto) throws UnknownHostException, IOException {
		this.s1 = new Socket(direc,puerto);
	}
	
	public void enviar(String mensaje) throws IOException {
		oStream = new DataOutputStream(s1.getOutputStream());
		oStream.writeUTF(mensaje);
	}

	public String recibir() throws IOException {
		inputStream = new DataInputStream(s1.getInputStream());
		return inputStream.readUTF();
	}
}
