package udpEjerAmpliacion.cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client {
	private final InetAddress IP_DESTINO;
	private final int PUERTO_DESTINO;
	private final DatagramSocket socket;
	private final int MAX_SIZE = 1024;
	
	public Client(InetAddress iP_DESTINO, int pUERTO_DESTINO) throws SocketException {
		this.IP_DESTINO = iP_DESTINO;
		this.PUERTO_DESTINO = pUERTO_DESTINO;
		this.socket = new DatagramSocket();
		//establece un puerto aleatorio que esté libre para recibir informacion
	}
	
	public void sendData(String message) {
		byte[] buffer = message.getBytes();
		if (buffer.length>1024) {
			System.out.println("El mensaje es demasiado largo");
			return;
		}
		DatagramPacket datagramPacket = new DatagramPacket(buffer,buffer.length,IP_DESTINO,PUERTO_DESTINO);
		try {
			socket.send(datagramPacket);
		} catch (IOException e) {
			System.err.println("No se ha podido enviar el mensaje");		
		}
	}
	
	public void getData() {
		byte[] bytes = new byte[MAX_SIZE];
		DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
		
		try {
			socket.receive(datagramPacket);
		} catch (IOException e) {
			System.err.println("No se ha podido recibir el mensaje del servidor");		
			System.err.println(e.getMessage());
			return;
		}
		String data = new String(datagramPacket.getData()).trim();
		System.out.println(data);
	}
}
