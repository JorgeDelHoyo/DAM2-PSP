/**
 * Ejercicio 6: Productor-Consumidor de Patas y Tableros
 * Clase --> Main
 * @author delhoyoballestin23
 */
public class Ejercicio06_FabricaMesas {
    public static void main(String[] args) {
        Ejercicio06_WareHouse warehouse = new Ejercicio06_WareHouse();

        // Crear los hilos
        Ejercicio06_LegProducer legProd = new Ejercicio06_LegProducer(warehouse);
        Ejercicio06_TabletopProducer boardProd = new Ejercicio06_TabletopProducer(warehouse);
        Ejercicio06_TableBuilder builder = new Ejercicio06_TableBuilder(warehouse);

        // Iniciar la simulación
        legProd.start();
        boardProd.start();
        builder.start();
    }

}
