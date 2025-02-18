package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerS {
	private final ServerSocket serverSocket;
	private final int PORT = 54322;
	private DataInputStream recibirDatos = null;
	private DataOutputStream enviarDatos = null;
	public ServerS() throws IOException {
		this.serverSocket = new ServerSocket(PORT);
	}
	
	public void waitConnections () throws IOException {
		while(true) {
			System.out.println("Esperar conexiones de clientes");
			Socket socket = serverSocket.accept();
	
			//recibirDatos del servidor trabaja contra enviarDatos del cliente
			//recibirDatos del cliente trabaja contra enviarDatos del servidor
			recibirDatos = new DataInputStream(socket.getInputStream());
			enviarDatos = new DataOutputStream(socket.getOutputStream());
			//recibirDatos.read();
			writeUTF("Bienvenido a la calculadora");
			writeUTF("Selecciona una opción: ");
			int opcion= -1;
			while(opcion!=0) {
				writeUTF("\n\t1.-SUMAR\n\t2.-RESTAR\n\t3.-MULTIPLICAR\n\t4.-DIVIDIR\n\t5.-MOD\n\t0.-SALIR\n");
				opcion = readInt();
	
				switch (opcion) {
					case 0:
						writeUTF("Gracias por usar la calculadora!!");
						System.out.println("Fin de la aplicación");
						break;
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
						operacion(opcion);
						break;
					default:
						writeUTF("Opción incorrecta");
				}
			}
		}
	}
	
	private void readUTF() {
		try {
			System.out.println(Colors.ANSI_YELLOW + "CLIENT: "+ recibirDatos.readUTF()+Colors.ANSI_RESET);
		}catch(IOException ex) {
			System.err.println("Error al leer datos del servidor");
			System.err.println(ex.getMessage());
			System.exit(-2);
		}
		
	}
	
	private void writeUTF(String s) {
		try {
			enviarDatos.writeUTF(s);
		}catch(IOException ex) {
			System.err.println("Error al enviar datos al servidor");
		}
		
	}
	
	private int readInt() {
		int num = 0;
		try {
			num = recibirDatos.readInt();
			System.out.println(Colors.ANSI_YELLOW + "CLIENT: "+ num +Colors.ANSI_RESET);
		}catch(IOException ex) {
			System.err.println("Error al leer datos Int del servidor");
			System.err.println(ex.getMessage());
			System.exit(-2);
		}
		return num;
	}
	
	private void operacion (int op) {
		writeUTF("Introduce el primer número");
		int num1 = readInt();
		writeUTF("Introduce el segundo número");
		int num2 = readInt();
		
		switch (op) {
			case 1:
				writeUTF("El resultado de la suma es: "+(num1+num2));
				break;
			case 2:
				writeUTF("El resultado de la resta es: "+(num1-num2));
				break;
			case 3:
				writeUTF("El resultado de la multiplicacion es: "+(num1*num2));
				break;
			case 4:
				writeUTF("El resultado de la division es: "+(num1/num2));
				break;
			case 5:
				writeUTF("El resultado del módulo es: "+(num1%num2));
				break;
		}	
	}
}
