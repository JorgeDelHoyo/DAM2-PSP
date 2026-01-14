/**
 * Ejercicio 7: Consumidor-Productor de Sopas
 * Clase --> Cocinero
 * @author delhoyoballestin23
 */
class Ejercicio07_Cocinero extends Thread {
    private Ejercicio07_Olla olla;

    public Ejercicio07_Cocinero(Ejercicio07_Olla olla) {
        this.olla = olla;
    }

    @Override
    public void run() {
        while (true) {
            olla.reponerSopa();
        }
    }
}
