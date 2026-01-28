package ejercicio2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        final int PUERTO = 6000;
        final int N = 3; // Cuantos clientes son atendidos

        ServerSocket servidor = null;

        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("SERVIDOR INICIADO");
            System.out.println("Esperando a " + N + " clientes...");

            int contadorClientes = 0;

            // El bucle se repite mientras no hayamos llegado a N clientes
            while (contadorClientes < N) {
                // 1. Esperar conexión (se bloquea aquí)
                Socket socketCliente = servidor.accept();

                // 2. Aumentamos el contador porque ha entrado alguien
                contadorClientes++;

                System.out.println("Cliente conectado. Asignando número: " + contadorClientes);

                // 3. Enviar el mensaje
                DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());
                salida.writeUTF("Hola, eres el cliente número " + contadorClientes);

                // 4. Cerrar conexión con este cliente específico
                socketCliente.close();
            }

            System.out.println("Se ha alcanzado el cupo de " + N + " clientes. Cerrando servidor.");
            servidor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}