package psp;

public class Cuenta {
    private int saldo;

    public Cuenta(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void retirarDinero(String titular, int cantidad) {
        if (saldo >= cantidad) {
            System.out.println(titular + " está retirando " + cantidad);
            saldo -= cantidad;
            System.out.println("Saldo restante: " + saldo);
        } else {
            System.out.println(titular + " intentó retirar " + cantidad + " pero no hay suficiente saldo.");
        }
    }

    public int getSaldo() {
        return saldo;
    }
}