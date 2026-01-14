import java.util.Random;
/**
 * Ejercicio 5: Parking de Consumidores y Productores
 * Clase --> Coche
 * @author delhoyoballestin23
 */
class Ejercicio05_Coche extends Thread {
    private int id;
    private Ejercicio05_Parking parking;
    private Random random;

    public Ejercicio05_Coche(int id, Ejercicio05_Parking parking) {
        this.id = id;
        this.parking = parking;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            System.out.println("Coche " + id + " listo para aparcar");

            // Intenta entrar (si está lleno, se quedará bloqueado aquí dentro)
            parking.entrar(id);

            // Simular tiempo aparcado (entre 1 y 3 segundos aprox)
            Thread.sleep(random.nextInt(2000) + 1000);

            // Salir del parking
            parking.salir(id);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
