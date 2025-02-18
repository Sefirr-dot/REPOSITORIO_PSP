package tarea2.servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class B {
	private InetAddress IP_DESTINO;
	private int PUERTO_DESTINO;
	private final DatagramSocket socket;
	private final int MAX_SIZE = 1024;
	
	public B(int pUERTO) throws SocketException {
		this.socket = new DatagramSocket(pUERTO);
		//establecemos puerto para recibir la informacion por él
	}
	
	public void sendData(String message) {
		byte[] buffer = message.getBytes();
		if (buffer.length>1024) {
			System.out.println("El mensaje es demasiado largo");
			return;
		}
		//System.out.println("La ip del cliente es: "+IP_DESTINO);
		//System.out.println("El puerto del cliente es: "+PUERTO_DESTINO);
		DatagramPacket datagramPacket = new DatagramPacket(buffer,buffer.length,IP_DESTINO,PUERTO_DESTINO);
		try {
			socket.send(datagramPacket);
		} catch (IOException e) {
			System.err.println("No se ha podido enviar el mensaje");		
		}
	}
	
	public String getData() {
		byte[] bytes = new byte[MAX_SIZE];
		DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
		
		try {
			socket.receive(datagramPacket);
		} catch (IOException e) {
			System.err.println("No se ha podido recibir el mensaje del cliente");		
			System.err.println(e.getMessage());
			return"";
		}
		//System.out.println("La ip del cliente es: "+IP_DESTINO);
		//System.out.println("El puerto del cliente es: "+PUERTO_DESTINO);
		
		IP_DESTINO = datagramPacket.getAddress();
		PUERTO_DESTINO = datagramPacket.getPort();
		String data = new String(datagramPacket.getData()).trim();
		System.out.println(data);
		//sendData(data);
		return data;
	}
}
