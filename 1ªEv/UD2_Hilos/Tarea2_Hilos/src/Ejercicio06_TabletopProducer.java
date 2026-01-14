/**
 * Ejercicio 6: Productor-Consumidor de Patas y Tableros
 * Clase --> Constructor de topTables
 * @author delhoyoballestin23
 */
public class Ejercicio06_TabletopProducer extends Thread {
    private Ejercicio06_WareHouse warehouse;

    public Ejercicio06_TabletopProducer(Ejercicio06_WareHouse warehouse) {
        this.warehouse = warehouse;
    }

    public void run() {
        try {
            while (true) {
                warehouse.storeTabletop();
                Thread.sleep(1500); // Tarda más en producir un tablero que una pata
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
