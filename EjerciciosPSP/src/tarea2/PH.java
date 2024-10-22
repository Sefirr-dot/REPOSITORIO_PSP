package tarea2;
//PH.java (Proceso Hijo - PH)

import java.util.ArrayList;
import java.util.List;

public class PH {
 public static void main(String[] args) {
     if (args.length != 2) {
         System.out.println("Error: Se requieren exactamente dos argumentos: N y M");
         System.exit(1);
     }

     int N = Integer.parseInt(args[0]);
     int M = Integer.parseInt(args[1]);

     if (N > M || N < 0 || M >= 1000) {
         System.out.println("Error: Verifique que N >= 0, M < 1000 y N <= M");
         System.exit(1);
     }

     // Lista de números primos en el rango
     List<Integer> primos = new ArrayList<>();

     for (int i = N; i <= M; i++) {
         if (esPrimo(i)) {
             primos.add(i);
         }
     }

     // Mostrar el resultado de los primos o mensaje si no hay
     if (primos.isEmpty()) {
         System.out.println("Ten primos 'pa' esto");
     } else {
         for (int primo : primos) {
             System.out.println(primo);
         }
     }
 }

 // Método para verificar si un número es primo
 public static boolean esPrimo(int num) {
     if (num < 2) return false;
     for (int i = 2; i <= Math.sqrt(num); i++) {
         if (num % i == 0) return false;
     }
     return true;
 }
}
