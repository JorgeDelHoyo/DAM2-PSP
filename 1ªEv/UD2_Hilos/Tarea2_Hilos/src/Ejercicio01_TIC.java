/**
 * Ejercicio 1: Tic y Tac
 * Clase -> TIC
 * @author delhoyoballestin23
 */
public class Ejercicio01_TIC extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("TIC");
            try{
                Thread.sleep(500); // pausa 0.5 segundos
            }catch(InterruptedException e){
                System.out.println("Hilo TIC interrumpido");
                return;
            }
        }
    }
}
