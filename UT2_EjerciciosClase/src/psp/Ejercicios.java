package psp;

import java.util.Scanner;

public class Ejercicios {
	
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int opcion;

	        do {
	            System.out.println("\n--- Menú de Ejercicios ---");
	            System.out.println("1. Mostrar números o letras pares");
	            System.out.println("2. Contador");
	            System.out.println("3. Carrera de caballos");
	            System.out.println("4. Semáforo para recurso compartido");
	            System.out.println("5. Carrera de tortugas");
	            System.out.println("6. Pasteles de alumnos");
	            System.out.println("7. Simulación de supermercado");
	            System.out.println("8. Gestión de cuenta corriente");
	            System.out.println("0. Salir");
	            System.out.print("Seleccione una opción: ");
	            opcion = scanner.nextInt();

	            switch (opcion) {
	                case 1:
	                    System.out.print("Ingrese 1 para números pares o 2 para letras pares: ");
	                    int tipo = scanner.nextInt();
	                    Thread h1 = new Thread(new CaracteresPares(tipo));
	                    h1.start();
	                    break;
	                case 2:
	                    System.out.print("Ingrese el nombre del hilo: ");
	                    String nombreHilo = scanner.next();
	                    System.out.print("Ingrese el límite del contador: ");
	                    int limite = scanner.nextInt();
	                    Contador contador = new Contador(nombreHilo, limite);
	                    contador.contar();
	                    break;
	                case 3:
	                    Thread caballo1 = new Thread(new Caballo("Caballo 1"));
	                    Thread caballo2 = new Thread(new Caballo("Caballo 2"));
	                    Thread caballo3 = new Thread(new Caballo("Caballo 3"));
	                    caballo1.start();
	                    caballo2.start();
	                    caballo3.start();
	                    break;
	                case 4:
	                    Thread recurso1 = new Thread(new RecursoCompartido("Thread 1"));
	                    Thread recurso2 = new Thread(new RecursoCompartido("Thread 2"));
	                    Thread recurso3 = new Thread(new RecursoCompartido("Thread 3"));
	                    Thread recurso4 = new Thread(new RecursoCompartido("Thread 4"));
	                    Thread recurso5 = new Thread(new RecursoCompartido("Thread 5"));
	                    recurso1.start();
	                    recurso2.start();
	                    recurso3.start();
	                    recurso4.start();
	                    recurso5.start();
	                    break;
	                case 5:
	                    Thread tortuga1 = new Thread(new Tortuga("Tortuga 1"));
	                    Thread tortuga2 = new Thread(new Tortuga("Tortuga 2"));
	                    Thread tortuga3 = new Thread(new Tortuga("Tortuga 3"));
	                    tortuga1.start();
	                    tortuga2.start();
	                    tortuga3.start();
	                    break;
	                case 6:
	                    Thread alumno1 = new Thread(new Alumno("Alumno 1"));
	                    Thread alumno2 = new Thread(new Alumno("Alumno 2"));
	                    Thread alumno3 = new Thread(new Alumno("Alumno 3"));
	                    alumno1.start();
	                    alumno2.start();
	                    alumno3.start();
	                    break;
	                case 7:
	                    Cliente cliente1 = new Cliente(new int[]{1, 3, 5});
	                    Cliente cliente2 = new Cliente(new int[]{2, 4, 6});
	                    Cliente cliente3 = new Cliente(new int[]{3, 5, 7});
	                    Thread cajera1 = new Thread(new Cajera("Cajera 1", cliente1));
	                    Thread cajera2 = new Thread(new Cajera("Cajera 2", cliente2));
	                    Thread cajera3 = new Thread(new Cajera("Cajera 3", cliente3));
	                    cajera1.start();
	                    cajera2.start();
	                    cajera3.start();
	                    break;
	                case 8:
	                    Cuenta cuenta = new Cuenta(100);
	                    Thread titular1 = new Thread(() -> cuenta.retirarDinero("Titular 1", 50));
	                    Thread titular2 = new Thread(() -> cuenta.retirarDinero("Titular 2", 70));
	                    titular1.start();
	                    titular2.start();
	                    break;
	                case 0:
	                    System.out.println("Saliendo del programa...");
	                    break;
	                default:
	                    System.out.println("Opción no válida.");
	            }
	        } while (opcion != 0);

	        scanner.close();
	    }
	}



