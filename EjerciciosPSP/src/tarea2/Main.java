package tarea2;


import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // Pedimos los valores de N y M
     System.out.print("Ingrese el valor de N: ");
     int N = scanner.nextInt();

     System.out.print("Ingrese el valor de M: ");
     int M = scanner.nextInt();

     if (N > M || N < 0 || M >= 1000) {
         System.out.println("Error: Verifique que N >= 0, M < 1000 y N <= M");
         scanner.close();
         return;
     }

     scanner.close();

     try {
    	 File paFile = new File(".\\bin\\");
         // Ejecutar PH (el proceso hijo) en el mismo paquete mypackage
         Process pb = new ProcessBuilder("java", "tarea2.PH", String.valueOf(N), String.valueOf(M)).redirectErrorStream(true).directory(paFile).start();
         

         // Capturar la salida del proceso hijo (PH)
         BufferedReader reader = new BufferedReader(new InputStreamReader(pb.getInputStream()));
         StringBuilder output = new StringBuilder();
         String line;

         // Leer la salida del proceso hijo y almacenarla
         while ((line = reader.readLine()) != null) {
             output.append(line).append("\n");
         }

         // Esperar a que el proceso hijo termine
         pb.waitFor();

         // Imprimir los resultados
         System.out.println("N: " + N);
         System.out.println("M: " + M);

         // Verificamos si hay números primos o no
         String result = output.toString().trim();
         if (result.isEmpty()) {
             System.out.println("Ten primos 'pa' esto");
         } else {
             System.out.println(result);
         }

     } catch (Exception e) {
         e.printStackTrace();
     }
 }
}
