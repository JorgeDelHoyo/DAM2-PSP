import java.util.Random;
import java.util.Scanner;

/**
 * Ejercicio 2: Cuenta atras calculadora humana
 * Clase -> CalculadoraHumana
 * @author delhoyoballestin23
 */
public class Ejercicio02_CalculadoraHumana extends Thread{
    private int puntuacionHumano = 0;
    private Random rd = new Random();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void run() {
        // mientras no haya sido interrumpido
        while (!Thread.currentThread().isInterrupted()) {
            // Numeros aleatorios entre 0 y 9
            int a = rd.nextInt(10);
            int b = rd.nextInt(10);
            int resultadoCorrecto = a+b;

            System.out.println("¿Cuánto es "+a+" + "+b+" ?");

            try{
                int respuesta = sc.nextInt();
                if(respuesta == resultadoCorrecto){
                    puntuacionHumano ++;
                    System.out.println("CORRECTO!! (Puntuacion: "+puntuacionHumano+")");
                }else {
                    System.out.println("INCORRECTO!!");
                }
            }catch (Exception e){
                System.out.println("Error: "+e.getMessage());
                break;
            }
        }
        System.out.println("Hilo finalizado");
    }

    public int getPuntuacionHumano() {
        return puntuacionHumano;
    }
}
