package udp;

import java.net.SocketException;
import java.util.ArrayList;

public class MainServer {

	public static ArrayList<String> nombreStrings = new ArrayList<String>();
	public static void main(String[] args) throws SocketException, InterruptedException {
		// TODO Auto-generated method stub

		ServerU s1 = new ServerU(55555);
		int opcion = 1;
		while(opcion!=0) {
			opcion =Integer.parseInt(s1.getDataString());
			switch (opcion) {
			case 1:
				nombreStrings.add(s1.getDataString());
				s1.sendData("Mensaje enciado");
				break;
			case 2:
				s1.sendData(nombreStrings.toString());
			default:
				break;
			}
		}
		
		
	}

}
