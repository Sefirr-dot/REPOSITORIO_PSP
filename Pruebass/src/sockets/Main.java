package sockets;

import java.io.IOException;
import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		Cliente c1 = new Cliente("localhost",55555);
		System.out.println("-- Me he conectado al servidor --");
		System.out.println(c1.recibir());
	}

}
