package ejercicio2;

import javax.xml.crypto.Data;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main() {
        final int PUERTO = 6000;
        final int N = 3; // Clientes a atender

        ServerSocket servidor = null;

        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");
            System.out.println("Esperando a "+N+" clientes...");

            int contadorClientes = 0;

            // Bucle para atender a N clientes
            while (contadorClientes < N) {

                // 1. Esperar conexión
                Socket socketCliente = servidor.accept();

                // 2. Contador cuando entra un cliente
                contadorClientes++;

                System.out.println("Cliente conectado. Asignando número: "+contadorClientes);

                // 3. Enviar mensaje a cliente
                DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());
                salida.writeUTF("Hola, eres el cliente numero "+contadorClientes);

                // 4. Cerrar conexión con ese cliente
                socketCliente.close();
            }

            System.out.println("Se ha alcanzado el máximo de "+N+" clientes. Cerrando servidor");
            servidor.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
