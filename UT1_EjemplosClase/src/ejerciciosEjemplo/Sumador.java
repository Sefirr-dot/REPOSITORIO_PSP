package ejerciciosEjemplo;

public class Sumador {

	public static void main(String[] args) {

		if(args.length <= 0) {
			System.err.println("Se necesita un programa para ejecutar");
			System.exit(-1);
		}
		
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		
		System.out.println("La summa es "+(num1+num2));
	}

	public static int sumar(int n1, int n2) {
		return n1+n2;
	}
}
