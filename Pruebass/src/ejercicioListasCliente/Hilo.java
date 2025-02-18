package ejercicioListasCliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Hilo extends Thread {

	private Socket socket;
	private DataInputStream dataInputStream = null;
	private DataOutputStream dataOutputStream=null;
	private static ArrayList<String> listaArrayList = new ArrayList<String>();


	public Hilo(Socket socket) throws IOException {
		super();
		this.socket = socket;
		dataInputStream = new DataInputStream(socket.getInputStream());
		dataOutputStream = new DataOutputStream(socket.getOutputStream());
	}

	@Override
	public void run() {
	    try {
	        while (true) { // Mantiene la conexión abierta para múltiples peticiones
	            String opcion = recibir();
	            int opcionInt = Integer.parseInt(opcion);
	            
	            if (opcionInt == 1) {
	                String nombre = recibir();
	                listaArrayList.add(nombre);
	                enviar("Nombre añadido con éxito.");
	            } else if (opcionInt == 2) {
	                if (listaArrayList.isEmpty()) {
	                    enviar("La lista está vacía.");
	                } else {
	                	String holaString = "";
	                	for (String string : listaArrayList) {
							holaString+=string+" ";
						}
	                    enviar("Lista de nombres: " + holaString);
	                }
	            } else if (opcionInt == 0) { // Opción para cerrar el cliente correctamente
	                enviar("Desconectando cliente...");
	                break;
	            } else {
	                enviar("Escoge una opción válida.");
	            }
	        }
	    } catch (IOException e) {
	        System.out.println("Error en el hilo: " + e.getMessage());
	    } finally {
	        try {
	            socket.close();
	        } catch (IOException e) {
	            System.out.println("Error al cerrar el socket: " + e.getMessage());
	        }
	    }
	}



	public void enviar(String mensaje) throws IOException {
		dataOutputStream = new DataOutputStream(socket.getOutputStream());
		dataOutputStream.writeUTF(mensaje);
	}

	public String recibir() throws IOException {
		dataInputStream = new DataInputStream(socket.getInputStream());
		return dataInputStream.readUTF();
	}
}
