/**
 * Ejercicio 7: Consumidor-Productor de Sopas
 * Clase --> Cliente
 * @author delhoyoballestin23
 */
class Ejercicio07_Cliente extends Thread {
    private int id;
    private Ejercicio07_Olla olla;

    public Ejercicio07_Cliente(int id, Ejercicio07_Olla olla) {
        this.id = id;
        this.olla = olla;
    }

    @Override
    public void run() {
        olla.comerSopa(id);
    }
}
