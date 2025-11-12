/**
 * Ejercicio 3: Dividir una operación en hilos
 * Clase -> Main (Runnable)
 * @author delhoyoballestin23
 */
public class Ejercicio03_MainRunnable {
    public static void main(String[] args) {
        Ejercicio03_OperacionRunnable op1 = new Ejercicio03_OperacionRunnable(1, 2, "multiplicar");
        Ejercicio03_OperacionRunnable op2 = new Ejercicio03_OperacionRunnable(2, 3, "sumar");

        Thread t1 = new Thread(op1);
        Thread t2 = new Thread(op2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Error: "+e.getMessage());
        }

        double resultadoFinal = op1.getResultado() / op2.getResultado();
        System.out.println("Resultado final: " + resultadoFinal);
    }
}
