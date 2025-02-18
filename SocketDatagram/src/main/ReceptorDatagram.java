package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class ReceptorDatagram {

	public static void main(String[] args) {
		try {
			System.out.println("RECEPTOR Creando socket datagram");
			
			InetSocketAddress addr = new InetSocketAddress ("192.168.0.21", 5555);
			DatagramSocket datagramSocket = new DatagramSocket(addr);
			
			System.out.println("Recibiendo mensaje");
			
			byte[] mensaje = new byte[25];
			DatagramPacket datagrama1 = new DatagramPacket (mensaje,25);
			datagramSocket.receive(datagrama1);
			
			System.out.println("Mensaje recibido de "+ datagrama1.getAddress()+":" + datagrama1.getPort() +": " + new String(mensaje));
			
			System.out.println("Enviando mensaje");
			
			
			String m = "mensaje desde el servidor";
			mensaje = m.getBytes();
			InetAddress addr2 = InetAddress.getByName("192.168.0.21");
			DatagramPacket datagrama2 = new DatagramPacket (m.getBytes(),m.getBytes().length,addr2,5556);
			datagramSocket.send(datagrama2);
			
			System.out.println("Mensaje enviado");
			System.out.println("Cerrando el socket datagrama");
			datagramSocket.close();
			
			System.out.println("Terminado");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
