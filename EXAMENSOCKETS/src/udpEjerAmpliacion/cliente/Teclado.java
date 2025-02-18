package udpEjerAmpliacion.cliente;

import java.util.Scanner;

public class Teclado {
	private static Scanner  scanner = new Scanner(System.in);
	
	public static int getNum() {
		System.out.println("Introduce el numero deseado");
		int num = scanner.nextInt();
		scanner.nextLine();//limpia el buffer del santo de linea
		return num;
	}
	
	public static String getString() {
		System.out.println("Introduce el texto deseado");
		return scanner.nextLine();
	}
}
