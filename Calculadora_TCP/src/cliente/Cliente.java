package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	private final String HOST;
	private final int PORT;
	private final Socket socket;
	private DataInputStream recibirDatos = null;
	private DataOutputStream enviarDatos = null;
	
	public Cliente (String H, int P) throws UnknownHostException, IOException {
		this.HOST=H;
		this.PORT=P;
		System.out.println("Iniciando socket contra el HOST: "+this.HOST+" y el PORT: "+this.PORT);
		
		socket = new Socket(HOST, PORT);
	}
	
	public void connect() throws IOException {
		//recibirDatos del servidor trabaja contra enviarDatos del cliente
		//recibirDatos del cliente trabaja contra enviarDatos del servidor
		recibirDatos = new DataInputStream(socket.getInputStream());
		enviarDatos = new DataOutputStream(socket.getOutputStream());
		readUTF();
		readUTF();
		int opc = -1;
		while(opc!=0) {
			readUTF();//<-- menu
			opc = writeInt();//<-- opcion
			if (opc != 0) {
				if (opc<=5 || opc>=1) {
					readUTF();//<-- primer num
					writeInt();//<-- envio num1
					readUTF();//<-- segundo num
					writeInt();//<-- envio num2
					readUTF();//<-- resultado
				}else {
					readUTF();//<-- mensaje opcion incorrecta
				}
			}		
		}
		System.out.println("Adios");
	}
	
	private void readUTF() {
		try {
			System.out.println(Colors.ANSI_CYAN+"SERVER: "+ recibirDatos.readUTF()+Colors.ANSI_RESET);
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
	
	private int writeInt() {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		try {
			enviarDatos.writeInt(num);
		}catch(IOException ex) {
			System.err.println("Error al enviar datos al servidor");
		}
		return num;
	}
	
}
