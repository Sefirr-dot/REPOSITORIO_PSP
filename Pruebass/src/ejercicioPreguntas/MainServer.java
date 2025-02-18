package ejercicioPreguntas;

import java.io.IOException;

public class MainServer {

	public static void main(String[] args) throws IOException {
		Server s1 = new Server(55555);
		s1.conectar();
	}

}
