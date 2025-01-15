package psp;

public class Contador {
    private int contador;
    private String nombreHilo;
    private int limite;

    public Contador(String nombreHilo, int limite) {
        this.nombreHilo = nombreHilo;
        this.limite = limite;
        this.contador = 0;
    }

    public void contar() {
        while (contador <= limite) {
            System.out.println(nombreHilo + " - Contador: " + contador);
            contador++;
        }
    }
}
