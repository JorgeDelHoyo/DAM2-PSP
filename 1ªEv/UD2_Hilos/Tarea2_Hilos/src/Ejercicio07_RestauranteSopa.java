/**
 * Ejercicio 7: Consumidor-Productor de Sopas
 * Clase --> Main
 * @author delhoyoballestin23
 */
public class Ejercicio07_RestauranteSopa {
    static final int NUM_CLIENTES = 12;
    static final int CAPACIDAD_OLLA = 4;

    public static void main(String[] args) {
        Ejercicio07_Olla olla = new Ejercicio07_Olla(CAPACIDAD_OLLA);

        // Crear y lanzar al cocinero
        Ejercicio07_Cocinero cocinero = new Ejercicio07_Cocinero(olla);

        cocinero.setDaemon(true);
        cocinero.start();

        // Crear y lanzar clientes
        for (int i = 1; i <= NUM_CLIENTES; i++) {
            new Ejercicio07_Cliente(i, olla).start();
        }
    }
}
