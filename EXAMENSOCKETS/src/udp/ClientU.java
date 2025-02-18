package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ClientU {
	
	private InetAddress IP_DESTINO;
	private int pUERTO_DESTINO;
	private DatagramSocket socket;
	
	public ClientU(InetAddress dir, int port) throws SocketException {
		this.IP_DESTINO = dir;
		this.pUERTO_DESTINO = port;
		this.socket = new DatagramSocket();
		
	}
	
	public void sendData(String mensaje) {
		byte[] buffer = mensaje.getBytes();
		
		if(buffer.length > 1024) {
			System.out.println("El mensaje es demasiado largo");
			return;
		}
		DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length,IP_DESTINO,pUERTO_DESTINO);
		try {
			socket.send(datagramPacket);
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("No se ha podidoo enviar el mensaje");
		}
	}
	
	public String getData() {
		byte[] bytes = new byte[1024];
		DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
		try {
			socket.receive(datagramPacket);
			
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("No se ha podido recibir el mensaje");
		}
		String dataString = new String(datagramPacket.getData()).trim();
		return dataString;
	}

}
