package tarea1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class Lanzador {

    public static void main(String[] args) throws IOException, InterruptedException {
        // args = tarea1.Sumador si
        if (args.length < 2) {
            System.out.println("Debe proporcionar dos argumentos: clase y si/no.");
            return;
        }

        String clase = args[0];
        String siOno = args[1].toLowerCase();

        File pathFile = new File(".\\bin\\");

        Process processTrProcess = new ProcessBuilder("java", clase, siOno)
                .redirectErrorStream(true)
                .directory(pathFile)
                .start();

        // Esperar si se indicó "si"
        if ("si".equals(siOno)) {
            processTrProcess.waitFor();
        }

        // Leer la salida del proceso
        try (InputStream inputStream = processTrProcess.getInputStream();
             BufferedReader br1 = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            String output = br1.lines().collect(Collectors.joining("\n"));
            System.out.println(output);
        }
    }
}
