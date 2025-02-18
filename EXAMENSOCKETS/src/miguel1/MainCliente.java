package miguel1;

import java.io.IOException;
import java.net.UnknownHostException;

public class MainCliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Cliente c1 = new Cliente("localhost", 55555);
		c1.enviar("Buenas tetas por cierto");
		System.out.println(c1.recibir());
	}

}
