package miguel1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainServidor {

	public static void main(String[] args) throws IOException {
		Servidor s1 = new Servidor(55555);
		s1.conectar();
	} 
}
