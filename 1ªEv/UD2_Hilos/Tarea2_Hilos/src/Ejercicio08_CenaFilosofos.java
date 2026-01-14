/**
 * Ejercicio 8: Productor-Consumidor: Filósofos Comensales con Palillos
 * Clase --> Main
 * @author delhoyoballestin23
 */
public class Ejercicio08_CenaFilosofos {
    public static void main(String[] args) {
        int numFilosofos = 5;
        Ejercicio08_Palillo[] palillos = new Ejercicio08_Palillo[numFilosofos];
        Ejercicio08_Filosofo[] filosofos = new Ejercicio08_Filosofo[numFilosofos];

        // Crear palillo
        for (int i = 0; i < numFilosofos; i++) {
            palillos[i] = new Ejercicio08_Palillo(i);
        }

        // Crear los filósofos y asignar palillos
        for (int i = 0; i < numFilosofos; i++) {
            // Por defecto: Palillo derecho es el 'i', Izquierdo es el siguiente '(i+1)%5' (mesa redonda)
            Ejercicio08_Palillo derecho = palillos[i];
            Ejercicio08_Palillo izquierdo = palillos[(i + 1) % numFilosofos];

            // El último filósofo coge los palillos AL REVÉS (Izquierda primero, luego derecha).
            // Esto rompe el ciclo de espera circular.
            if (i == numFilosofos - 1) {
                filosofos[i] = new Ejercicio08_Filosofo(i, izquierdo, derecho); // Cambio de orden
                System.out.println("Filósofo " + i + " (Zurdo) se sienta.");
            } else {
                filosofos[i] = new Ejercicio08_Filosofo(i, derecho, izquierdo); // Orden normal
                System.out.println("Filósofo " + i + " (Diestro) se sienta.");
            }
        }

        System.out.println("--- Comienza la cena ---");

        // Inicia hilos
        for (Ejercicio08_Filosofo f : filosofos) {
            f.start();
        }
    }
}
