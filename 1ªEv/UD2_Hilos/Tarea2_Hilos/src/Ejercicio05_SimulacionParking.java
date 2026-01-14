/**
 * Ejercicio 5: Parking de Consumidores y Productores
 * Clase --> Main
 * @author delhoyoballestin23
 */
public class Ejercicio05_SimulacionParking {
    public static void main(String[] args) {
        int plazas = 4;
        int numeroCoches = 7; // Más coches que plazas para ver el bloqueo

        Ejercicio05_Parking parking = new Ejercicio05_Parking(plazas);

        System.out.println("--- Iniciando simulación de Parking con " + plazas + " plazas ---");

        // Crear y lanzar los hilos
        for (int i = 1; i <= numeroCoches; i++) {
            new Ejercicio05_Coche(i, parking).start();
        }
    }
}
