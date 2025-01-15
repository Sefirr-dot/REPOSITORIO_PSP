package ejercicioMarcos;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Random;

public class SuperMarket {

    private final int numCajas; // Número de cajas disponibles en el supermercado
    private final AtomicInteger resultados; // Almacena el total recaudado de forma segura para la concurrencia
    private final BlockingQueue<Cliente>[] colas; // Array de colas bloqueantes, una por cada caja
    private final ExecutorService ejecutoresCajas; // Gestor de hilos para las cajas

    public SuperMarket(int numCajas) {
        this.numCajas = numCajas;
        this.resultados = new AtomicInteger(0); // Inicializa la recaudación total en 0
        //importante que sea atomico porque varioss  hilos acceden a el simultaneamente
        // Inicializa las colas de las cajas
        //Esta cola sirve para que un hilo espere hasta que haya elementos disponibes
        this.colas = new BlockingQueue[numCajas]; 
        this.ejecutoresCajas = Executors.newFixedThreadPool(numCajas); // Crea un pool fijo de hilos igual al número de cajas

        // Inicializar las colas y asignar hilos a las cajas
        for (int i = 0; i < numCajas; i++) {
            colas[i] = new LinkedBlockingQueue<>(); // Cada caja tiene su propia cola bloqueante
            int finalI = i; // Necesario para usar en expresiones lambda
            // Inicia un hilo para procesar clientes en esta caja
            ejecutoresCajas.submit(() -> procesarCaja(finalI));
        }
    }

    // Método para procesar clientes en una caja específica
    private void procesarCaja(int idCaja) {
        try {
            while (true) {
                Cliente cliente = colas[idCaja].take(); // Extrae un cliente de la cola de esta caja (bloquea si está vacía)
                System.out.println("Caja " + idCaja + " atendiendo al cliente " + cliente.getIdCliente());
                int pago = cliente.procesarPago(); // Procesa el pago del cliente
                resultados.addAndGet(pago); // Añade el pago al total recaudado de forma segura
                System.out.println("Caja " + idCaja + " procesó un pago de: " + pago);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaura el estado de interrupción del hilo
        }
    }

    // Método para que un cliente se una a una cola de caja aleatoria
    public void unirseACaja(Cliente cliente) {
        int idCaja = new Random().nextInt(numCajas); // Selecciona una caja aleatoria
        try {
            colas[idCaja].put(cliente); // Añade al cliente a la cola de la caja seleccionada
            System.out.println("Cliente " + cliente.getIdCliente() + " se unió a la caja " + idCaja);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaura el estado de interrupción
        }
    }

    // Devuelve el total recaudado hasta el momento
    public int getResultados() {
        return resultados.get(); // Lee el valor actual de forma segura
    }

    // Método para cerrar el supermercado y terminar los hilos de las cajas
    public void cerrar() {
        ejecutoresCajas.shutdownNow(); // Detiene inmediatamente todos los hilos de las cajas
        System.out.println("Supermercado cerrado. Total recaudado: " + getResultados());
    }

    // Clase Cliente: cada cliente es un hilo que realiza compras y se une a una caja
    static class Cliente implements Runnable {
        private final int idCliente; // Identificador único del cliente
        private final SuperMarket supermercado; // Referencia al supermercado

        public Cliente(int idCliente, SuperMarket supermercado) {
            this.idCliente = idCliente;
            this.supermercado = supermercado;
        }

        public int getIdCliente() {
            return idCliente; // Devuelve el ID del cliente
        }

        // Simula el tiempo de compra del cliente
        private void comprar() throws InterruptedException {
            int tiempoCompra = new Random().nextInt(3000) + 1000; // Tiempo aleatorio entre 1 y 4 segundos
            System.out.println("Cliente " + idCliente + " comprando por " + tiempoCompra + " ms");
            Thread.sleep(tiempoCompra); // Pausa el hilo simulando el tiempo de compra
        }

        // Simula el procesamiento del pago del cliente
        public int procesarPago() {
            return new Random().nextInt(50) + 1; // Genera un pago aleatorio entre 1 y 50 unidades
        }

        @Override
        public void run() {
            try {
                comprar(); // Simula el tiempo de compra
                supermercado.unirseACaja(this); // Después de comprar, el cliente se une a una caja
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restaura el estado de interrupción
            }
        }
    }

    public static void main(String[] args) {
        // Verifica si se han proporcionado los argumentos necesarios
        if (args.length < 2) {
            System.out.println("Uso: java SuperMarket <M: número de clientes> <N: número de cajas>");
            return;
        }

        // Lee el número de clientes y cajas de los argumentos
        int M = Integer.parseInt(args[0]); // Número de clientes
        int N = Integer.parseInt(args[1]); // Número de cajas

        // Crea una instancia del supermercado con N cajas
        SuperMarket supermercado = new SuperMarket(N);

        // Crea un pool de hilos para los clientes
        ExecutorService ejecutoresClientes = Executors.newFixedThreadPool(M);
        for (int i = 0; i < M; i++) {
            ejecutoresClientes.submit(new Cliente(i, supermercado)); // Lanza cada cliente como un hilo
        }

        // Espera a que todos los clientes terminen
        ejecutoresClientes.shutdown();
        try {
            ejecutoresClientes.awaitTermination(1, TimeUnit.MINUTES); // Espera un máximo de 1 minuto
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaura el estado de interrupción
        }

        // Cierra el supermercado y muestra el total recaudado
        supermercado.cerrar();
    }
}
