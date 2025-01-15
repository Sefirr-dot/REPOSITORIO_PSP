package psp;

public class Caballo implements Runnable {
    private String nombre;
    private int progreso;

    public Caballo(String nombre) {
        this.nombre = nombre;
        this.progreso = 0;
    }

    @Override
    public void run() {
        while (progreso < 75) {
            progreso += (int) (Math.random() * 10) + 1;
            System.out.println(nombre + " ha avanzado hasta " + progreso + "%");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + " ha llegado a la meta!");
    }
}	