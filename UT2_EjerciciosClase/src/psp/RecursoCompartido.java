package psp;

import java.util.concurrent.Semaphore;

public class RecursoCompartido implements Runnable {
    private static final Semaphore semaforo = new Semaphore(2);
    private String nombre;

    public RecursoCompartido(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            System.out.println(nombre + " intentando acceder al recurso...");
            semaforo.acquire();
            System.out.println(nombre + " accedió al recurso.");
            Thread.sleep((int) (Math.random() * 1000) + 1000);
            System.out.println(nombre + " liberó el recurso.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }
}
