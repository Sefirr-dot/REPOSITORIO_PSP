package udpEjerAmpliacion.cliente;


public class Menu {
	//private static Scanner scanner = new Scanner(System.in);
	
	
	public static int show() {
		int min=0, max=6;
		int num;
		do {
			System.out.println("Elige una opción: ");
			System.out.println("1.- Sumar");
			System.out.println("2.- Restar");
			System.out.println("3.- Multiplicar");
			System.out.println("4.- Dividir");
			System.out.println("5.- Resto");
			System.out.println("0.- Salir");
			num = Teclado.getNum();
			if (num > max || num < min) {
				System.out.println("Numero introducido incorrecto.");
			}
		} while (num > max || num < min);
		return num;
	}
	
	
}
