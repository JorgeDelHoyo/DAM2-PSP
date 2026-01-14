/**
 * Ejercicio 7: Consumidor-Productor de Sopas
 * Clase --> Olla
 * @author delhoyoballestin23
 */
class Ejercicio07_Olla {
    private int tazonesDisponibles = 0; // Empezamos vacíos para que el cocinero trabaje al inicio
    private final int CAPACIDAD_OLLA;

    public Ejercicio07_Olla(int capacidad) {
        this.CAPACIDAD_OLLA = capacidad;
    }
    // Metodo para el Cocinero
    public synchronized void reponerSopa() {
        // El cocinero espera mientras haya sopa.
        while (tazonesDisponibles > 0) {
            try {
                System.out.println("Cocinero: Queda sopa. Me voy a dormir...");
                wait();
            } catch (InterruptedException e) { e.printStackTrace(); }
        }

        System.out.println("Cocinero: ¡La olla está vacía! Cocinando " + CAPACIDAD_OLLA + " tazones...");
        try {
            Thread.sleep(1500); // Simula tiempo de cocina
        } catch (InterruptedException e) { e.printStackTrace(); }
        tazonesDisponibles = CAPACIDAD_OLLA;
        System.out.println("Cocinero: ¡Sopa lista! (4 tazones disponibles). Notificando a clientes.");
        // Notifica a Clientes
        notifyAll();
    }

    // Metodo para el Cliente
    public synchronized void comerSopa(int idCliente) {
        // Si no hay sopa, el cliente espera
        while (tazonesDisponibles == 0) {
            try {
                System.out.println("CLIENTE " + idCliente + ": No hay sopa. Esperando...");
                wait();
            } catch (InterruptedException e) { e.printStackTrace(); }
        }

        // Comer sopa
        tazonesDisponibles--;
        System.out.println("CLIENTE " + idCliente + ": Comiendo sopa. Quedan " + tazonesDisponibles);

        // Si este cliente se toma la última sopa, despierta al cocinero
        if (tazonesDisponibles == 0) {
            System.out.println("CLIENTE " + idCliente + ": ¡He tomado el último tazón! Despertando al cocinero...");
            // Notifica al cocinero
            notifyAll();
        }
    }
}
