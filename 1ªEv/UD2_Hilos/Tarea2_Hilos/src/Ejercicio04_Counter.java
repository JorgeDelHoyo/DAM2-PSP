/**
 * Ejercicio 3: Contador
 * Clase -> Counter
 * @author delhoyoballestin23
 */
public class Ejercicio04_Counter {
    private int contador = 0;

    public synchronized void incrementar() { // synchronized evita errores
        contador++;
    }

    public int getContador(){
        return contador;
    }
}
