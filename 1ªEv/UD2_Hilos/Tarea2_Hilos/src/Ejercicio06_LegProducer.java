/**
 * Ejercicio 6: Productor-Consumidor de Patas y Tableros
 * Clase --> Productor de patas
 * @author delhoyoballestin23
 */
public class Ejercicio06_LegProducer extends Thread {
    private Ejercicio06_WareHouse warehouse;

    public Ejercicio06_LegProducer(Ejercicio06_WareHouse warehouse) {
        this.warehouse = warehouse;
    }

    public void run() {
        try {
            while (true) {
                warehouse.storeLeg();
                Thread.sleep(500); // Tarda un poco en producir
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
