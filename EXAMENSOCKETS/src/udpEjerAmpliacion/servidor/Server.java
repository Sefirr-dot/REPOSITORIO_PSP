package udpEjerAmpliacion.servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
	private InetAddress IP_DESTINO;
	private int PUERTO_DESTINO;
	private final DatagramSocket socket;
	private final int MAX_SIZE = 1024;
	
	public Server(int pUERTO) throws SocketException {
		this.socket = new DatagramSocket(pUERTO);
		//establecemos puerto para recibir la informacion por él
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
			System.err.println("No se ha podido recibir el mensaje del cliente");		
			System.err.println(e.getMessage());
			return;
		}
		IP_DESTINO = datagramPacket.getAddress();
		PUERTO_DESTINO = datagramPacket.getPort();
		String data = new String(datagramPacket.getData()).trim();
		
		String[] nums = data.split(":");
		int opcion = Integer.parseInt(nums[0]);
		int num1 = Integer.parseInt(nums[1]);
		int num2 = Integer.parseInt(nums[2]);
		String msg;
		switch (opcion) {
			case 1:
				int suma = num1+num2;
				msg = "\nEl resultado de la suma es: "+suma;
				sendData(msg);
				break;
			case 2:
				int resta = num1-num2;
				msg = "\nEl resultado de la resta es: "+resta;
				sendData(msg);
				break;
			case 3:
				int mul = num1*num2;
				msg = "\nEl resultado de la multiplicacion es: "+mul;
				sendData(msg);
				break;
			case 4:
				if (num2<1) {
					sendData("Esta división no se puede realizar. Introduce un division mayor que 1");
				} else {
					float div = num1/(float)num2;
					msg = "\nEl resultado de la división es: "+div;
					sendData(msg);
				}
				break;
			case 5:
				int resto = num1%num2;
				msg = "\nEl resultado del resto es: "+resto;
				sendData(msg);
				break;
		}

	}
}
