package psp;

public class Tortuga implements Runnable {
    private String nombre;
    private int distancia;

    public Tortuga(String nombre) {
        this.nombre = nombre;
        this.distancia = 0;
    }

    @Override
    public void run() {
        while (distancia < 20) {
            distancia += (int) (Math.random() * 3) + 1;
            System.out.println(nombre + " ha avanzado " + distancia + " metros.");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + " ha llegado a la meta!");
    }
}