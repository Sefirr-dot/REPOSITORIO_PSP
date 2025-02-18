package ejercicio1;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;


public class Hilo implements Runnable{
	
	private Socket socketStream;

	Hilo(Socket socketStream) {
	      this.socketStream = socketStream;
	}

	@Override
	public void run() {
		
		InputStream is = null;
		byte [] buffer = new byte[1024];
		int bytes_leidos = 0;
		String str = "";
		
		try {
	         PrintStream pstream = new PrintStream(socketStream.getOutputStream());

	         is = socketStream.getInputStream();
			 bytes_leidos = is.read(buffer);
			 str = new String(buffer,0,bytes_leidos);
			 System.out.println(str);
			 
			 
			 System.out.println("Hilo terminado");
			 
	         pstream.close();
	         socketStream.close();
	      }
	      catch (IOException e) {
	         System.out.println(e);
	      }
		
	}

}
