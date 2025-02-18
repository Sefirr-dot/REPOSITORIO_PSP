package udp;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerU {

	private int PUERTO_DESTINO;
	private InetAddress iP_DESTINO;
	private final DatagramSocket socket;

	public ServerU(int port) throws SocketException {
		this.PUERTO_DESTINO = port;
		this.socket = new DatagramSocket(port);
		System.out.println("Server Iniciado");
	}
	public void sendData(String mensaje) {
		byte[] buffer = mensaje.getBytes();
		if(buffer.length >1024) {
			System.out.println("El mensaje es demasiado largo");
			return;
		}
		DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length,iP_DESTINO,PUERTO_DESTINO);
		try {
			socket.send(datagramPacket);
			
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}
	
	public String getDataString() {
		byte[] bytes = new byte[1024];
		DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
		try {
			socket.receive(datagramPacket);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return "";
		}
		iP_DESTINO = datagramPacket.getAddress();
		PUERTO_DESTINO = datagramPacket.getPort();
		String dataString = new String(datagramPacket.getData()).trim();
		return dataString;
	}
}
