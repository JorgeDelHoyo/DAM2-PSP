/**
 * Ejercicio 6: Productor-Consumidor de Patas y Tableros
 * Clase --> Stock/Almacen
 * @author delhoyoballestin23
 */
class Ejercicio06_WareHouse {
    private final int MAX_LEGS = 6;
    private final int MAX_TABLETOPS = 2;

    // Variables para controlar el stock actual
    private int legs = 0;
    private int tabletops = 0;

    // Productor de Patas
    public synchronized void storeLeg() {
        // Mientras el almacén de patas esté lleno, esperamos
        while (legs >= MAX_LEGS) {
            try {
                System.out.println(">> Almacén de PATAS lleno. Productor esperando...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Producimos una pata
        legs++;
        System.out.println("Pata depositada. Stock Patas: " + legs + "/" + MAX_LEGS);

        // Notificamos a todos
        notifyAll();
    }
    // Productor de Tableros
    public synchronized void storeTabletop() {
        // Mientras el almacén de tableros esté lleno, esperar
        while (tabletops >= MAX_TABLETOPS) {
            try {
                System.out.println(">> Almacén de TABLEROS lleno. Productor esperando...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Producir un tablero
        tabletops++;
        System.out.println("Tablero depositado. Stock Tableros: " + tabletops + "/" + MAX_TABLETOPS);

        // Notificamos a todos
        notifyAll();
    }
    // Consumidor (Ensamblador de Mesas)
    public synchronized void buildTable() {
        // Condición de espera: NO hay suficientes patas (necesita 4) O NO hay tableros (necesita 1)
        while (legs < 4 || tabletops < 1) {
            try {
                System.out.println("... Esperando piezas para montar mesa (Stock actual: " + legs + " patas, " + tabletops + " tableros)");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Si llega aquí, es que tiene materiales. Los consume.
        legs -= 4;
        tabletops -= 1;
        System.out.println("=== MESA FABRICADA EXITOSAMENTE === (Stock restante: " + legs + " patas, " + tabletops + " tableros)");

        // Notificamos a los productores
        notifyAll();
    }
}