package psp;

public class CaracteresPares implements Runnable {
    private int tipo;

    public CaracteresPares(int tipo) { 
        this.tipo = tipo;
    }

    @Override
    public void run() {
        if (tipo == 1) {
            for (int i = 2; i <= 30; i += 2) {
                System.out.println(i);
            }
        } else if (tipo == 2) {
            for (char c = 'b'; c <= 'z'; c += 2) {
                System.out.println(c);
            }
        }
    }
}