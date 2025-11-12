/**
 * Ejercicio 3: Contador
 * Clase -> Main
 * @author delhoyoballestin23
 */
public class Ejercicio04_Main {
    public static void main(String[] args) {
        Ejercicio04_Counter counter = new Ejercicio04_Counter();
        int numeroPersonas = 10;

        Ejercicio04_Person[] personas = new Ejercicio04_Person[numeroPersonas];

        for(int i = 0; i < numeroPersonas; i++){
            personas[i] = new Ejercicio04_Person(counter);
            personas[i].start();
        }

        // Esperamos a que todos los hilos terminen
        for(int i = 0; i < numeroPersonas; i++){
            try{
                personas[i].join();
            }catch (InterruptedException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
        System.out.println("Contador finalizado: "+counter.getContador());
    }
}
