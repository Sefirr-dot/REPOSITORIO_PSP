package ejercicio1;

import java.util.Scanner;

public class VisualizadorMensajes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int edadMasBaja = 99;
		int edadMasAlta = 0;
		String alumnoMasEdadString="";
		String alumnoMenosEdadString="";
		boolean salir = false;
		int numAlumnosLeidos = 0;
		
		while(!salir) {
			System.out.println("Di el nombre del alumno");
			String nombreString = scanner.next();
			
			
			if(nombreString.equals("*")) {
				
				salir = true;
			} else {
				System.out.println();
				System.out.println("Di su edad");
				int edad = scanner.nextInt();
				numAlumnosLeidos++;
				if(nombreString.isBlank() || nombreString.isEmpty()) {
					System.out.println("Nombre vacio o de longitud 0. Volver a escribir el nombre.");
					nombreString = scanner.next();
				}
				if(edad<0 || edad>99) {
					System.out.println("Edad menor que 0 o mayor que 99. Volver a escribirla");
					edad = scanner.nextInt();
				}
				if(edadMasBaja>edad) {
					edadMasBaja = edad;
					alumnoMenosEdadString = nombreString;
				}
				if(edadMasAlta<edad) {
					edadMasAlta = edad;
					alumnoMasEdadString=nombreString;
				}
				
			}
		}
		System.out.println("Numero de alumnos leidos: "+numAlumnosLeidos);
		System.out.println("El alumno con mas edad es: "+alumnoMasEdadString+" y el que menos es: "+alumnoMenosEdadString);
	}

}
