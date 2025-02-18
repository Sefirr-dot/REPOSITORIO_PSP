package ejercicio1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerMultiHilo {

	public static void main(String[] args) {
		
		// variables
		ServerSocket sv = null;
		boolean continuar = true;
		InetSocketAddress addr = null;
		String ip = "";
		int puerto = 0;
		Socket s = null;
		Hilo h = null;
		Thread t = null;
		
		// se comprueba el numero de parametros
		if(args.length == 2){
		
			ip = args[0];
			puerto = Integer.parseInt(args[1]);
			
		
			// se crea el socket servidor
			System.out.println("Creando socket servidor...");
			try {
				sv = new ServerSocket();
			} catch (IOException e) {
				System.out.println("Error creando el socket servidor");
				continuar = false;
			}
			
			if(continuar){
				// se prepara la conexion: ip y el puerto
				System.out.println("Realizando el bind...");
				addr = new InetSocketAddress(ip,puerto);
				try {
					sv.bind(addr);
				} catch (IOException e) {
					System.out.println("Error realizando el bind()");
					continuar = false;
				}
			}
			
			if(continuar){		
				// se esperan conexiones 
				System.out.println("Aceptando alguna conexion...");
				
				while (true) {
					try {
						s = sv.accept();
						System.out.println("Conexion recibida");
						// se crea el nuevo hilo pasando como argumento el socket que se acaba de crear para que sea gestionado por el hilo
						h = new Hilo(s);
						t = new Thread(h);
						t.start();
					} catch (IOException e) {
						System.out.println("Error realizando el accept()");
						continuar = false;
					}
				}
			}
		}else{
			System.out.println("Error al iniciar el servidor. Se debe especificar direccion ip y puerto");
			System.out.println("Ejemplo: java SeverMultiHilo localhost 5555");
		}

	}

}
