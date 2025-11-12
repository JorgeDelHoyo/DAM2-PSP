/**
 * Ejercicio 1: Tic y Tac
 * Clase -> TAC
 * @author delhoyoballestin23
 */
public class Ejercicio01_TAC extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("TAC");
            try{
                Thread.sleep(500); // pausa 0.5 segundos
            }catch(InterruptedException e){
                System.out.println("Hilo TAC interrumpido");
                return;
            }
        }
    }
}
