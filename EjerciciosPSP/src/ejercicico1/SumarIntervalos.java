package ejercicico1;

import java.util.Scanner;

public class SumarIntervalos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Rango numeros
        int inicioRango = 0, finRango = 0;
        while (true) {
            System.out.print("Introduce el numero inicial del rango: ");
            inicioRango = scanner.nextInt();
            System.out.print("Introduce el numero final del rango: ");
            finRango = scanner.nextInt();

            if (inicioRango < finRango) {
                break;
            } else {
                System.out.println("El numero inicial debe ser menor que el número final. Inténtalo de nuevo.");
            }
        }

        
        int numIntervalos = 0;
        while (true) {
            System.out.print("Introduce el numero de intervalos: ");
            numIntervalos = scanner.nextInt();
            //vemos que el numero de intervalos sea correcto
            if (numIntervalos > 0 && numIntervalos <= (finRango - inicioRango + 1)) {
                break;
            } else {
                System.out.println("El numero de intervalos debe ser positivo y menor o igual al rango de numeros. Intntalo de nuevo.");
            }
        }

        // Calculamos el tamño del intervalo
        int tamañoIntervalo = (finRango - inicioRango + 1) / numIntervalos;
        int resto = (finRango - inicioRango + 1) % numIntervalos;

        int inicio = inicioRango;
        int fin;


        for (int i = 1; i <= numIntervalos; i++) {
            
            fin = inicio + tamañoIntervalo - 1;
            if (resto > 0) {
                fin++;
                resto--;
            }

            // Crear el hilo para sumar el intervalo
            SumaIntervalo hilo = new SumaIntervalo(inicio, fin, i);
            hilo.start();

            // Actualizar el inicio para el siguiente intervalo
            inicio = fin + 1;
        }

        scanner.close();
    }
}