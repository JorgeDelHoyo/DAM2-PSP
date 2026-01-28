package ejercicio2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    public static void main(String[] args){

        // Misma máquina y puerto que servidor
        final String HOST = "localhost";
        final int PUERTO = 6000;

        try {
            // 1. Conectar al servidor
            Socket socket = new Socket(HOST, PUERTO);

            // 2. Preparar canal entrada
            DataInputStream entrada = new DataInputStream(socket.getInputStream());

            // 3. Leer mensaje servidor
            String mensasje = entrada.readUTF();

            // 4. Mostrar por pantalla
            System.out.println("SERVIDOR DICE: "+mensasje);

            // 5. Cerrar
            socket.close();

        } catch (IOException e) {
            System.out.println("Error: No se puede conectar al servidor (o está lleno/apagado).");
        }
    }
}
