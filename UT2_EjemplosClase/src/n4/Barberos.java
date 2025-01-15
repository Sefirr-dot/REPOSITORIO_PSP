package n4;
import java.util.concurrent.*;
import java.util.Random;

public class Barberos {
    // Constantes
    private static final int NUM_BARBEROS = 2;  // Número de barberos
    private static final int NUM_SILLAS = 5;    // Número de sillas disponibles
    private static final int TIEMPO_AFEITAR = 2000; // Tiempo que tarda en afeitar (ms)

    // Semáforos para controlar los recursos
    private final Semaphore sillasDisponibles = new Semaphore(NUM_SILLAS, true); // Controla sillas de espera
    private final Semaphore barberosDisponibles = new Semaphore(NUM_BARBEROS, true); // Controla barberos libres
    private final Semaphore clientesListos = new Semaphore(0, true); // Indica clientes listos para ser atendidos

    public void clienteLlega(int clienteId) throws InterruptedException {
        System.out.println("Cliente " + clienteId + " llega a la barbería.");
        if (sillasDisponibles.tryAcquire()) { // Si hay sillas disponibles
            System.out.println("Cliente " + clienteId + " se sienta en la sala de espera.");
            clientesListos.release(); // Avisar a los barberos que hay un cliente esperando
            barberosDisponibles.acquire(); // Espera a que un barbero esté libre
            sillasDisponibles.release(); // Libera la silla de espera
            System.out.println("Cliente " + clienteId + " es atendido.");
        } else {
            System.out.println("Cliente " + clienteId + " se marcha porque no hay sillas libres.");
        }
    }

    public void atenderCliente(int barberoId) throws InterruptedException {
        while (true) {
            clientesListos.acquire(); // Espera a que haya clientes listos
            System.out.println("Barbero " + barberoId + " comienza a atender a un cliente.");
            Thread.sleep(TIEMPO_AFEITAR); // Simula el tiempo de afeitar
            System.out.println("Barbero " + barberoId + " ha terminado de atender a un cliente.");
            barberosDisponibles.release(); // Libera al barbero para atender al siguiente cliente
        }
    }

    public static void main(String[] args) {
        Barberos barberia = new Barberos();
        Random random = new Random();

        // Crear barberos
        for (int i = 1; i <= NUM_BARBEROS; i++) {
            final int barberoId = i;
            new Thread(() -> {
                try {
                    barberia.atenderCliente(barberoId);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }

        // Generar clientes de forma aleatoria
        int clienteId = 1;
        while (true) {
            final int id = clienteId++;
            new Thread(() -> {
                try {
                    barberia.clienteLlega(id);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
            try {
                Thread.sleep(random.nextInt(1000)); // Tiempo aleatorio entre llegadas de clientes
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
