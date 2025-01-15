package psp;

public class Cajera implements Runnable {
    private String nombre;
    private Cliente cliente;

    public Cajera(String nombre, Cliente cliente) {
        this.nombre = nombre;
        this.cliente = cliente;
    }

    @Override
    public void run() {
        System.out.println(nombre + " comienza a atender al cliente.");
        for (int producto : cliente.getProductos()) {
            try {
                Thread.sleep(producto * 1000);
                System.out.println(nombre + " procesó un producto en " + producto + " segundos.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + " terminó con el cliente.");
    }
}