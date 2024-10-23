package tarea3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     System.out.print("Ingrese una fecha en formato dd/mm/yyyy: ");
     String fechaInput = scanner.nextLine();
     scanner.close();

     try {
         // Ejecutar PH (el proceso hijo) en el mismo paquete mypackage
         ProcessBuilder pb = new ProcessBuilder("java", "-cp", "bin", "tarea3.PH", fechaInput);
         Process process = pb.start();

         // Capturar la salida del proceso hijo (PH)
         BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
         String output = reader.readLine();

         // Esperar a que el proceso hijo termine
         process.waitFor();

         // Imprimir el resultado
         System.out.println("Días restantes: " + output);

     } catch (Exception e) {
         e.printStackTrace();
     }
 }
}
