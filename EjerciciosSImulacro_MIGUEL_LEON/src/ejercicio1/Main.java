package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		
		File paFile = new File(".\\bin\\");
		
		 if (args.length == 0) {
	            System.out.println("No se han proporcionado argumentos de entrada. Fin de proceso.");
	            return;
	        }

	        int ejecuciones = 0;

	        for (String filename : args) {
	            File inputFile = new File("src\\ejercicio1\\"+filename);

	            if (!inputFile.exists()) {
	                System.out.println("El archivo de entrada " + filename + " no existe.");
	                continue;
	            }

	            // Crear nombres para los archivos de salida y error
	            String outputFilename = "S" + filename;
	            String errorFilename = "E" + filename;

	            try {
	                // Configuración para redirigir salida y error
	            	ProcessBuilder pb = new ProcessBuilder("java", "-cp","bin","ejercicio1.VisualizadorMensajes");
	                pb.redirectInput(inputFile);
	                pb.redirectOutput(new File(outputFilename));
	                pb.redirectError(new File(errorFilename));

	                 // Leer la salida del proceso hijo y almacenarla
	                Process process = pb.start();
	                process.waitFor();


	                ejecuciones++;
	            } catch (Exception e) {
	                System.out.println("Error al ejecutar EjercicioParteA con el archivo " + filename + ": " + e.getMessage());
	            }
	        }

	        System.out.println("Número de veces que se ejecuta Visualizador de mensajes: " + ejecuciones);
	        System.out.println("Fin de proceso.");
	    }
	}