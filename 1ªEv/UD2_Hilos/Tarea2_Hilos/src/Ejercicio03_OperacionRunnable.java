/**
 * Ejercicio 3: Dividir una operación en hilos
 * Clase -> OperacionRunnable
 * @author delhoyoballestin23
 */
public class Ejercicio03_OperacionRunnable implements Runnable {
    private double a, b;
    private String operacion;
    private double resultado;

    public Ejercicio03_OperacionRunnable(double a, double b, String operacion) {
        this.a = a;
        this.b = b;
        this.operacion = operacion;
    }

    public void run() {
        switch (operacion) {
            case "multiplicar":
                resultado = a * b;
                break;
            case "sumar":
                resultado = a + b;
                break;
            case "dividir":
                resultado = a / b;
                break;
        }
    }

    public double getResultado() {
        return resultado;
    }
}
