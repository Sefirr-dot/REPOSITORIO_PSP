package tarea4;

import java.io.IOException;

public class ProcessExecutor {
 public static void execute(String[] command) throws IOException {
     ProcessBuilder pb = new ProcessBuilder(command);
     pb.inheritIO(); // Esto redirige la entrada/salida estándar
     pb.start();
 }
}
