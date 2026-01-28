package ejercicio2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PUERTO = 6000;

        try {
            // 1. Conectar al servidor
            Socket socket = new Socket(HOST, PUERTO);

            // 2. Preparar canal de entrada
            DataInputStream entrada = new DataInputStream(socket.getInputStream());

            // 3. Leer mensaje del servidor
            String mensaje = entrada.readUTF();

            // 4. Mostrar por pantalla
            System.out.println("SERVIDOR DICE: " + mensaje);

            // 5. Cerrar
            socket.close();

        } catch (IOException e) {
            System.out.println("Error: No se puede conectar al servidor (o está lleno/apagado).");
        }
    }
}