package examen1;

public class PuenteSimulacion {

    static class GestorPuente {
        private boolean ocupado = false;

        public synchronized void entrarNorte(String nombreVehiculo) throws InterruptedException {
            while (ocupado) {
                System.out.println(nombreVehiculo + " esperando para cruzar el puente desde el norte.");
                wait();
            }
            ocupado = true;
            System.out.println(nombreVehiculo + " está cruzando el puente desde el norte.");
        }

        public synchronized void entrarSur(String nombreVehiculo) throws InterruptedException {
            while (ocupado) {
                System.out.println(nombreVehiculo + " esperando para cruzar el puente desde el sur.");
                wait();
            }
            ocupado = true;
            System.out.println(nombreVehiculo + " está cruzando el puente desde el sur.");
        }

        public synchronized void salir(String nombreVehiculo) {
            ocupado = false;
            System.out.println(nombreVehiculo + " ha cruzado el puente.");
            notifyAll();
        }
    }

    static class Vehiculo extends Thread {
        private final GestorPuente puente;
        private final String nombre;
        private final String entrada;

        public Vehiculo(GestorPuente puente, String nombre, String entrada) {
            this.puente = puente;
            this.nombre = nombre;
            this.entrada = entrada;
        }

        @Override
        public void run() {
            try {
                if ("Norte".equalsIgnoreCase(entrada)) {
                    puente.entrarNorte(nombre);
                } else if ("Sur".equalsIgnoreCase(entrada)) {
                    puente.entrarSur(nombre);
                }
                Thread.sleep(2000); // Simula el tiempo que toma cruzar el puente
                puente.salir(nombre);
            } catch (InterruptedException e) {
                System.err.println(nombre + " fue interrumpido.");
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        GestorPuente puente = new GestorPuente();

        Vehiculo vehiculo1 = new Vehiculo(puente, "Vehículo 1", "Norte");
        Vehiculo vehiculo2 = new Vehiculo(puente, "Vehículo 2", "Sur");
        Vehiculo vehiculo3 = new Vehiculo(puente, "Vehículo 3", "Norte");
        Vehiculo vehiculo4 = new Vehiculo(puente, "Vehículo 4", "Sur");
        Vehiculo vehiculo5 = new Vehiculo(puente, "Vehículo 5", "Norte");

        vehiculo1.start();
        vehiculo2.start();
        vehiculo3.start();
        vehiculo4.start();
        vehiculo5.start();

        try {
            vehiculo1.join();
            vehiculo2.join();
            vehiculo3.join();
            vehiculo4.join();
            vehiculo5.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Todos los vehículos han cruzado el puente.");
    }
}
