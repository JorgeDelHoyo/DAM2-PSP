/**
 * Ejercicio 6: Productor-Consumidor de Patas y Tableros
 * Clase --> Constructor de tables
 * @author delhoyoballestin23
 */
public class Ejercicio06_TableBuilder extends Thread {
    private Ejercicio06_WareHouse warehouse;

    public Ejercicio06_TableBuilder(Ejercicio06_WareHouse warehouse) {
        this.warehouse = warehouse;
    }

    public void run() {
        try {
            while (true) {
                warehouse.buildTable();
                Thread.sleep(2000); // Tiempo que tarda en montar la mesa
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
