/**
 * Utiliza el objeto Runtime para obtener información del equipo donde se
 * ejecuta el programa. Muestra la información acerca del número de
 * procesadores disponibles.
 * @author delhoyoballestin23
 */
public class RunTime_Ejercicio02 {

    public static void main(String[] args) {
        // Instancia RunTime
        Runtime runtime = Runtime.getRuntime();

        // Obtener el número de procesadores
        int numberOfProcessors = runtime.availableProcessors();

        // Mostrar la información
        System.out.println("\nNúmero de procesadores disponibles: " + numberOfProcessors);
    }
}