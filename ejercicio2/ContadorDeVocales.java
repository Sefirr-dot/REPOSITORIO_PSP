package ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class ContadorDeVocales {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Uso: java ContadorDeVocales <archivo_entrada> <vocal> <archivo_salida>");
            System.out.println("Argumentos proporcionados: " + Arrays.toString(args));
            System.exit(1);
        }

        String archivoEntrada = args[0];
        char vocalABuscar = args[1].toLowerCase().charAt(0);
        String archivoSalida = args[2];

        if (!"aeiou".contains(String.valueOf(vocalABuscar))) {
            System.out.println("Por favor, especifique una vocal válida (a, e, i, o, u).");
            System.exit(1);
        }

        int contador = 0;

        // Contar las ocurrencias de la vocal en el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                for (char c : linea.toLowerCase().toCharArray()) {
                    if (c == vocalABuscar) {
                        contador++;
                    }
                }
            }
            System.out.println("Lectura del archivo completada. Vocal '" + vocalABuscar + "' encontrada " + contador + " veces.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de entrada: " + e.getMessage());
            System.exit(1);
        }

        // Guardar el resultado en el archivo de salida
        try (FileWriter fw = new FileWriter(archivoSalida)) {
            fw.write("Numero de ocurrencias de la vocal '" + vocalABuscar + "': " + contador);
            System.out.println("Resultado guardado en " + archivoSalida);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo de salida: " + e.getMessage());
            System.exit(1);
        }
    }
}
