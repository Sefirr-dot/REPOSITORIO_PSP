package psp;

public class Alumno implements Runnable {
    private String nombre;

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(nombre + " ha hecho un pastel " + i + "/3");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + " terminó sus pasteles.");
    }
}
