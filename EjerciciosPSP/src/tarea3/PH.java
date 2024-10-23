package tarea3;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PH {
 public static void main(String[] args) {
     if (args.length != 1) {
         System.out.println("Error: Se requiere una fecha en formato dd/mm/yyyy");
         System.exit(1);
     }

     String fechaInput = args[0];
     SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
     Date fechaIngresada;
     Date fechaActual = new Date();

     try {
         fechaIngresada = formatoFecha.parse(fechaInput);

         // Calcular la diferencia en días
         long diferenciaEnMilisegundos = fechaIngresada.getTime() - fechaActual.getTime();
         long diferenciaEnDias = TimeUnit.DAYS.convert(diferenciaEnMilisegundos, TimeUnit.MILLISECONDS);

         // Asegurarse de que no sea un número negativo
         if (diferenciaEnDias < 0) {
             diferenciaEnDias = 0;
         }

         // Mostrar el resultado
         System.out.println(diferenciaEnDias);

     } catch (ParseException e) {
         System.out.println("Error: Fecha inválida. Asegúrese de usar el formato dd/mm/yyyy");
         System.exit(1);
     }
 }
}
