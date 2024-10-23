package tarea4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Main {
 public static void main(String[] args) {
     // Verifica si se ha pasado al menos un argumento
     if (args.length < 1) {
         System.out.println("Error: Se requiere el nombre del archivo como argumento.");
         System.exit(1);
     }

     try {
         // Comando 1: 'type miLista.txt'
         String[] command1 = new String[2];
         command1[0] = "cmd.exe"; // Llama al intérprete de comandos de Windows
         command1[1] = "/c"; // Ejecuta el siguiente comando y termina
         command1 = new String[]{"cmd.exe", "/c", "type " + args[0]}; // El primer argumento es el nombre del archivo (miLista.txt)

         // Comando 2: 'find /c /v ""'
         String[] command2 = new String[]{"cmd.exe", "/c", "find /c /v \"\""}; // Cuenta líneas

         // Proceso 1
         ProcessBuilder pb1 = new ProcessBuilder(command1);
         Process process1 = pb1.start();

         // Proceso 2
         ProcessBuilder pb2 = new ProcessBuilder(command2);
         Process process2 = pb2.start();

         // Conectar la salida del primer proceso a la entrada del segundo
         InputStream inputStream = process1.getInputStream();
         OutputStream outputStream = process2.getOutputStream();

         // Leer la salida del primer proceso y escribir en el segundo
         BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
         String line;
         while ((line = reader.readLine()) != null) {
             outputStream.write((line + System.lineSeparator()).getBytes());
         }
         outputStream.flush();
         outputStream.close(); // Cerrar el flujo de salida del segundo proceso

         // Esperar a que los procesos terminen
         process1.waitFor();
         process2.waitFor();

         // Obtener el código de salida de los procesos
         int exitCode1 = process1.exitValue();
         int exitCode2 = process2.exitValue();

         // Imprimir los códigos de salida
         System.out.println("Código de salida del primer comando (type): " + exitCode1);
         System.out.println("Código de salida del segundo comando (find): " + exitCode2);

         // Leer y mostrar la salida del segundo proceso
         BufferedReader reader2 = new BufferedReader(new InputStreamReader(process2.getInputStream()));
         System.out.println("Salida de find:");
         while ((line = reader2.readLine()) != null) {
             System.out.println(line);
         }

     } catch (IOException | InterruptedException e) {
         e.printStackTrace();
     }
 }
}
