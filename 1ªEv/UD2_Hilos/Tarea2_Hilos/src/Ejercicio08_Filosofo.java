import java.util.Random;
/**
 * Ejercicio 8: Productor-Consumidor: Filósofos Comensales con Palillos
 * Clase --> Filosofo
 * @author delhoyoballestin23
 */
class Ejercicio08_Filosofo extends Thread {
    private int id;
    private Ejercicio08_Palillo palilloDerecho;
    private Ejercicio08_Palillo palilloIzquierdo;
    private Random random = new Random();

    public Ejercicio08_Filosofo(int id, Ejercicio08_Palillo palilloDerecho, Ejercicio08_Palillo palilloIzquierdo) {
        this.id = id;
        this.palilloDerecho = palilloDerecho;
        this.palilloIzquierdo = palilloIzquierdo;
    }
    /**
     * Metodo para "pensar"
     * @throws InterruptedException
     */
    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está PENSANDO");
        Thread.sleep(random.nextInt(1000) + 1000); // Piensa entre 1 y 2 seg
    }
    /**
     * Metodo para comer
     * @throws InterruptedException
     */
    private void comer() throws InterruptedException {
        // Intenta coger el primer palillo (bloqueo synchronized)
        synchronized (palilloDerecho) {
            System.out.println("Filósofo " + id + " tiene palillo " + palilloDerecho.getId() + " (Derecho). Esperando izquierdo...");

            // Intenta coger el segundo palillo
            synchronized (palilloIzquierdo) {
                System.out.println("Filósofo " + id + " tiene palillo " + palilloIzquierdo.getId() + " (Izquierdo). COMIENDO");
                Thread.sleep(random.nextInt(1000) + 1000); // Come un rato
            } // Al salir del bloque, suelta el palillo izquierdo

        }// Al salir del bloque, suelta el palillo derecho
        System.out.println("Filósofo " + id + " terminó de comer y suelta los palillos.");
    }
    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                comer();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
