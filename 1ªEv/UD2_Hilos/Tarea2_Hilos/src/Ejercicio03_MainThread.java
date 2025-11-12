/**
 * Ejercicio 3: Dividir una operación en hilos
 * Clase -> Main (Thread)
 * @author delhoyoballestin23
 */
public class Ejercicio03_MainThread {
    public static void main(String[] args) {
        Ejercicio03_OperacionThread operacion1 = new Ejercicio03_OperacionThread(1,2,"multiplicar");
        Ejercicio03_OperacionThread operacion2 = new Ejercicio03_OperacionThread(2,3,"sumar");

        operacion1.start();
        operacion2.start();

        try {
            operacion1.join();
            operacion2.join();
        } catch (InterruptedException e) {
            System.out.println("Error: "+e.getMessage());
        }

        double resultadoFinal = operacion1.getResultado() / operacion2.getResultado();
        System.out.println("Resultado final "+resultadoFinal);
    }
}
