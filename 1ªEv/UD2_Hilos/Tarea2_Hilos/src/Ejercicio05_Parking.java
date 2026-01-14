/**
 * Ejercicio 5: Parking de Consumidores y Productores
 * Clase --> Parking
 * @author delhoyoballestin23
 */
class Ejercicio05_Parking {
    private int plazasTotales;
    private int plazasOcupadas;

    public Ejercicio05_Parking(int plazasTotales) {
        this.plazasTotales = plazasTotales;
        this.plazasOcupadas = 0;
    }

    /**
     * Metodo sincronizado para entrar
     * @param idCoche
     */
    public synchronized void entrar(int idCoche) {
        // Mientras no haya sitio, el coche espera
        while (plazasOcupadas >= plazasTotales) {
            try {
                System.out.println("Estacionamiento lleno, el coche " + idCoche + " tiene que esperar");
                wait(); // El hilo suelta el bloqueo y  espera notificación
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Si sale del while, es que hay sitio
        plazasOcupadas++;
        System.out.println("Coche " + idCoche + " ha aparcado");
    }

    /**
     * Metodo sincronizado para salir
     * @param idCoche
     */
    public synchronized void salir(int idCoche) {
        plazasOcupadas--;
        System.out.println("Coche " + idCoche + " ha dejado un espacio libre.");

        // Notificamos a TODOS los hilos que están esperando
        notifyAll();
    }
}
