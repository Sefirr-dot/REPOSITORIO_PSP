package ejercicio2;

import java.io.File;
import java.io.IOException;

public class LanzadorContadorDeVocales {
    // Ruta donde se encuentran los archivos .class del proyecto
	static File path = new File(".\\bin\\");

	// POner C:\\Users\\miguel\\Desktop\\DAM2\\PSP\\EjerciciosPSP\\1.txt a C:\\Users\\miguel\\Desktop\\DAM2\\PSP\\EjerciciosPSP\\resultado.txt

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Uso: java ContadorDeVocalesExecutor <archivo_entrada> <vocal> <archivo_salida>");
            System.exit(1);
        }

        String archivoEntrada = args[0];
        String vocal = args[1];
        String archivoSalida = args[2];

        // Crear el proceso para ejecutar ContadorDeVocales
        ProcessBuilder processBuilder = new ProcessBuilder("java", "ejercicio2.ContadorDeVocales", archivoEntrada, vocal, archivoSalida);


        processBuilder.directory(path);
        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("El proceso se ejecutó correctamente.");
            } else {
                System.out.println("El proceso terminó con errores. Código de salida: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al ejecutar el proceso: " + e.getMessage());
        }
    }
}
