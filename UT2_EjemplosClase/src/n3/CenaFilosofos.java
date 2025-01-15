package n3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CenaFilosofos {

    // Número de filósofos
    private static final int NUM_FILOSOFOS = 5;

    public static void main(String[] args) {
        // Crear palillos (locks)
        Lock[] palillos = new Lock[NUM_FILOSOFOS];
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            palillos[i] = new ReentrantLock();
        }

        // Crear filósofos
        Filosofo[] filosofos = new Filosofo[NUM_FILOSOFOS];
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            filosofos[i] = new Filosofo(i, palillos[i], palillos[(i + 1) % NUM_FILOSOFOS]);
            new Thread(filosofos[i]).start();
        }
    }
}

class Filosofo implements Runnable {
    private final int id;
    private final Lock palilloIzquierdo;
    private final Lock palilloDerecho;

    public Filosofo(int id, Lock palilloIzquierdo, Lock palilloDerecho) {
        this.id = id;
        this.palilloIzquierdo = palilloIzquierdo;
        this.palilloDerecho = palilloDerecho;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Pensar
                System.out.println("Filósofo " + id + " pensando");
                Thread.sleep((long) (Math.random() * 1000));

                System.out.println("Filósofo " + id + " quiere comer");

                // Solución asimétrica para evitar interbloqueo
                if (id % 2 == 0) {
                    // Los filósofos pares toman primero el palillo izquierdo
                    palilloIzquierdo.lock();
                    palilloDerecho.lock();
                } else {
                    // Los filósofos impares toman primero el palillo derecho
                    palilloDerecho.lock();
                    palilloIzquierdo.lock();
                }

                // Comer
                System.out.println("Filósofo " + id + " comiendo");
                Thread.sleep((long) (Math.random() * 1000));

                // Dejar los palillos
                palilloIzquierdo.unlock();
                palilloDerecho.unlock();

                System.out.println("Filósofo " + id + " terminó de comer");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
