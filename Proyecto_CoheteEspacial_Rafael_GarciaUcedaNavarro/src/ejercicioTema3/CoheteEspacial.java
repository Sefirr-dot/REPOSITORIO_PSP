
package ejercicioTema3;

import java.util.Scanner; //Importamos el paquete java.util para introducir el scanner

/**
 *
 * @author rafag
 */
public class CoheteEspacial {
    // Rafael Garcia Uceda Navarro Tema 3 Programación

    public static void main(String[] args) {  // Creamos el método principal
        //Ejercicio 2
        System.out.println("Bienvenido al programa de la clase Cohete Espacial de Rafael Garcia Uceda Navarro");
        Scanner scanner = new Scanner(System.in); //Introducimos el scanner
        String strDenominacionCohete;   //Declaración de la variable String strDenominacion

        System.out.print("Introduce un nombre para el cohete: ");
        strDenominacionCohete = scanner.nextLine(); //Lectura del valor recogido por teclado
        CoheteEspacial miCohete = new CoheteEspacial();
        miCohete.setDenominacion(strDenominacionCohete);//Asignación de la variable al atributo
        System.out.println(miCohete.getDenominacion()); //Muestra por consola

        String strAgenciaEspacial; //Declaramos una nueva variable String
        System.out.print("Introduce el nombre de la Agencia: ");
        strAgenciaEspacial = scanner.nextLine();// Lectura del valor que se recogerá por teclado
        miCohete.setAgenciaEspacial(strAgenciaEspacial); //Se asigna la variable al atributo
        System.out.println(miCohete.getAgenciaEspacial()); // Muestra por consola
        // Ejercicio 3
        System.out.print("Ingresa su altura: ");
        float flAltura = scanner.nextFloat(); //Se irán pidiendo los datos a través del escaner
        miCohete.setAltura(flAltura); // Al igual que en los anteriores, se asignará el valor introducido por teclado en el atributo, en este caso altura.

        System.out.print("Ingresa su diametro: ");
        float flDiametro = scanner.nextFloat();
        miCohete.setDiametro(flDiametro);

        System.out.print("Ingresa su masa: ");
        int Masa = scanner.nextInt();
        miCohete.setMasa(Masa);

        System.out.print("Ingresa sus etapas: ");
        int Etapas = scanner.nextInt();
        miCohete.setEtapas(Etapas);

        System.out.print("Reutilizable(True/False): ");
        boolean reutilizable = scanner.nextBoolean();
        miCohete.setReutilizable(reutilizable);

        System.out.println(miCohete.toString()); //Con el método toString pordremos mostrar todos los datos restantes

        //Ejercicio 6
        CoheteEspacial cohetePorDefecto = new CoheteEspacial();
        System.out.println(cohetePorDefecto.toString()); //Se crea un nuevo cohete que utiliza el primer constructor y lo mostramos por pantalla
        //Apartado G: Se ha creado un objeto de tipo CoheteEspacial cada vez que hemos creado un nuevo cohete.
        //Apartado A
        CoheteEspacial cohete1 = new CoheteEspacial("Ariane 5", "ESA", 59f, 5.4f, 777000, 2, false); //Se utiliza el segundo constructor en este caso para crear 3 nuevos cohetes
        CoheteEspacial cohete2 = new CoheteEspacial("Saturno V", "NASA", 1106f, 5.4f, 2970000, 3, false);
        CoheteEspacial cohete3 = new CoheteEspacial("Falcon 9", "SpaceX", 70f, 3.66f, 549054, 2, false);
        // Apartado B
        System.out.println(cohete1.toString()); //Se muestran los datos de cada cohete a través del toString, en correspondencia con cada cohete
        System.out.println(cohete2.toString());
        System.out.println(cohete3.toString());
        // Apartado C
        cohete1.setAgenciaEspacial("Agencia Espacial China"); //Gracias al .set, podremos cambiar los datos que cada cohete indicando que cohete es y que dato queremos cambiar (coheteejemplo.setAltura)
        cohete1.setMasa(123456);
        cohete2.setEtapas(1);
        cohete2.setDiametro(83f);
        cohete3.setDenominacion("Nova 8");
        cohete3.setAltura(45f);
        // Apartado D
        System.out.println(cohete1.toString()); //Se vuelven a mostrar los datos de los cohete con los valores cambiados
        System.out.println(cohete2.toString());
        System.out.println(cohete3.toString());
        // Apartado E
        CoheteEspacial cohete4 = new CoheteEspacial("Jupiter 14", "Agencia Espacial Checa", 27f, 3.26f, 889000, 2, true); //Se crea un nuevo cohete con el segundo constructor
        System.out.println(cohete4.toString());
        // Apartado F
        cohete4.setMasa(8312832); //Con el set, cambiamos los datos del cohete4, el anteriormente creado
        cohete4.setEtapas(4);
        System.out.println(cohete4.toString());
        //Apartado H
        System.out.println("La suma de etapas de " + cohete3.getDenominacion() + " y " + cohete2.getDenominacion() + " es " + cohete3.sumarEtapas(cohete2)); //Con el método sumarEtapas ya creado, lo introducimos para sumar en este caso cohete3 y cohete2
        //Apartado I
        System.out.println("El volumen del cohete es " + cohete1.calcularVolumen()); //Con el método calcular volumen, en este caso del cohete1, se realizará la operación
        //Apartado K
        cohete1.setEtapas(10); //Se cambian las etapas para comprobar que el método setEtapas funciona correctamente y su valor máximo es 5, por lo que al imprimirlo por pantalla saldrá 5 aunque le hemos asignado 10
        System.out.println(cohete1.etapas);
        //Apartado L
        cohete4.setEtapas(-1);
        System.out.println(cohete4.etapas); //En este caso, asignamos al cohete4 -1 etapas con el setEtapas para comprobar que el valor minímo establecido es 1.
        //Apartado M
        System.out.println(contadorCohetes); //Para mostrar el contador de cohetes primero debemos cambiar de private a public el static int contadorCohetes.
        //Apartado N
        System.out.println("La gravedad es: " + GRAVEDAD);
        
        

    }

    static final float GRAVEDAD = 9.811f;
    static final float PI = 3.1416f;
    static final int MAX_ETAPAS = 5;
    static final int MIN_ETAPAS = 1;
    //Ejercicio 6: Apartado J
    public static int contadorCohetes = 0; // El contador de Cohetes debe empezar en 0 para que así vaya contando cada nuevo cohete cuando utilicemos cualquiera de los dos constructores

    private String denominacion;
    private String agenciaEspacial;
    private float altura;
    private float diametro;
    private int masa;
    private int etapas;
    private boolean reutilizable;

    public CoheteEspacial() {
        this.denominacion = "S/N";
        this.agenciaEspacial = "S/A";
        this.altura = 0;
        this.diametro = 0;
        this.masa = 0;
        this.etapas = 1;
        this.reutilizable = false;
        this.contadorCohetes = this.contadorCohetes + 1; //Para que funcione el contador, debemos incluir en cada constructor el this.contadorCohetes
                                                        //Así, cada vez que utilicemos cualquiera de los dos constructores para crear un cohete sumará +1, contando así cada cohete creado, en total 6
    }

    public CoheteEspacial(String denominacion, String agenciaEspacial, float altura, float diametro, int masa, int etapas, boolean reutilizable) {
        this.denominacion = denominacion;
        this.agenciaEspacial = agenciaEspacial;
        this.altura = altura;
        this.diametro = diametro;
        this.masa = masa;
        this.etapas = etapas;
        this.reutilizable = reutilizable;
        contadorCohetes = this.contadorCohetes + 1;

    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getAgenciaEspacial() {
        return agenciaEspacial;
    }

    public void setAgenciaEspacial(String agenciaEspacial) {
        this.agenciaEspacial = agenciaEspacial;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getDiametro() {
        return diametro;
    }

    public void setDiametro(float diametro) {
        this.diametro = diametro;
    }

    public int getMasa() {
        return masa;
    }

    public void setMasa(int masa) {
        this.masa = masa;
    }

    public int getEtapas() {
        return etapas;
    }

    public void setEtapas(int etapas) {

        if (etapas >= MIN_ETAPAS) {
            if (etapas > MAX_ETAPAS) {
                this.etapas = MAX_ETAPAS;
            } else {
                this.etapas = etapas;
            }
        } else {
            this.etapas = MIN_ETAPAS;

        }
    }

    public boolean isReutilizable() {
        return reutilizable;
    }

    public void setReutilizable(boolean reutilizable) {
        this.reutilizable = reutilizable;
    }
    //Ejercicio 4 
    public float calcularVolumen() {                // Se crea el método que es un public float
        float radio = this.diametro / 2;            //Primero se establece que el diametro del cohete que posteriormente escojamos se divida entre dos
        float radioAlCuadrado = (float) Math.pow(radio, 2); // En segundo lugar, a través del Mathw Pow, elevamos el diametro al cuadrado para que corresponda con la fórmula posterior 

        return PI * radioAlCuadrado * this.altura; // Se expone la fórmula de pi por diametro partido de dos y elevado a dos y por la altura del cohete.
                                                   //Gracias al uso de this y return, podremos referirnos a cualquiera de los cohetes
    }
    //Ejercicio 5
    public int sumarEtapas(CoheteEspacial cohete) { //Creamos el método que recibirá un CoheteEspacial y sumará sus etapas con otro objeto CoheteEspacial.
        return this.etapas + cohete.etapas;        //Para ello, utilizamos return y this, sumando el valor del objeto que llamamos con el this al objeto que recibirá.

    }

    @Override
    public String toString() {
        return "CoheteEspacial(" + "denominacion=" + denominacion
                + ", agenciaEspacial=" + agenciaEspacial
                + ", altura=" + altura + " metros" + ", diametro=" + diametro   // Se han añadido metros y kg para establecer medidas y peso de los atributos: altura, diametro y masa
                + " metros" + ", masa=" + masa + " kg" + ", etapas=" + etapas
                + ", reutilizable=" + reutilizable + '}';
    }

}
