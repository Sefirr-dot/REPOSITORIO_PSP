package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class EmisorDatagram {

	public static void main(String[] args) {
		try {
			System.out.println("EMISOR Creando socket datagram");
			InetSocketAddress addre = new InetSocketAddress ("192.168.0.21", 5556);
			DatagramSocket datagramsocket = new DatagramSocket(addre);
			System.out.println("Enviando mensaje");
			
			String mensaje = "mensaje desde el emisor";
			
			InetAddress addr = InetAddress.getByName("192.168.0.21");
			DatagramPacket datagrama_ = new DatagramPacket (mensaje.getBytes(),
					mensaje.getBytes().length,addr,5555);
			
			datagramsocket.send(datagrama_);
			System.out.println("Mensaje enviado");
			
			byte[] m = new byte[25];
			DatagramPacket datagrama2_ = new DatagramPacket (m,25);
			datagramsocket.receive(datagrama2_);
			
			System.out.println("Mensaje recibido: " + new String(m));
			System.out.println("Cerrando el socket datagrama");
			datagramsocket.close();
			
			System.out.println("Terminado");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
