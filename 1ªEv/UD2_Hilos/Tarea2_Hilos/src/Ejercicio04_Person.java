/**
 * Ejercicio 3: Contador
 * Clase -> Person
 * @author delhoyoballestin23
 */
public class Ejercicio04_Person extends Thread{
    private Ejercicio04_Counter contador;

    public Ejercicio04_Person(Ejercicio04_Counter counter) {
        this.contador = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            contador.incrementar();
        }
    }
}
