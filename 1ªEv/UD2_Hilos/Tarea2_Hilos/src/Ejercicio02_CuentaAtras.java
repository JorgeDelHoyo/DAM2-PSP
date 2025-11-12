/**
 * Ejercicio 2: Cuenta atras calculadora humana
 * Clase -> CuentaAtras(Main)
 * @author delhoyoballestin23
 */
public class Ejercicio02_CuentaAtras {
    public static void main(String[] args) {
        Ejercicio02_CalculadoraHumana juegoCalculadora = new Ejercicio02_CalculadoraHumana();
        juegoCalculadora.start();

        // Cuenta atrás para el hilo principal
        for (int i = 10; i > 0; i--) {
            System.out.println("⏰ Tiempo restante: " + i + " segundos");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("El hilo principal fue interrumpido.");
            }
        }

        System.out.println("TIEMPO AGOTADO!!");
        // Se interrumpe el hilo del juego de la calculadora
        juegoCalculadora.interrupt();
        try{
            // Esperamos que el hilo termine ordenadamente
            juegoCalculadora.join();
        }catch(InterruptedException e){
            System.out.println("Error al esperar el hilo");
        }
        System.out.println("Puntuación final :"+juegoCalculadora.getPuntuacionHumano());
    }
}
