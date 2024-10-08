package ejercicico1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class SumaIntervalo extends Thread {
    private int inicio, fin, numFichero;

    public SumaIntervalo(int inicio, int fin, int numFichero) {
        this.inicio = inicio;
        this.fin = fin;
        this.numFichero = numFichero;
    }

    @Override
    public void run() {
        int suma = 0;
        for (int i = inicio; i <= fin; i++) {
            suma += i;
        }
        String nombreFichero = "fich" + numFichero + ".txt";
        guardarResultadoEnFichero(nombreFichero, suma);
    }

    private void guardarResultadoEnFichero(String nombreFichero, int suma) {
        try (FileWriter writer = new FileWriter(nombreFichero)) {
            writer.write("Suma del intervalo [" + inicio + ", " + fin + "]: " + suma);
        } catch (IOException e) {
            System.out.println("Error escribiendo en el archivo: " + nombreFichero);
            e.printStackTrace();
        }
    }
}