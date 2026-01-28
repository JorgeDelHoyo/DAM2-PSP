package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;

public class Cliente {
    public static void main() {

        // Misma máquina y puerto que servidor
        final String HOST = "localhost";
        final int PUERTO = 5000;

        try {

            // 1. Conectarse al servidor
            System.out.println("Intentado conectar al servidor...");
            Socket socket = new Socket(HOST, PUERTO);

            // 2. Preparamos los canales
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            // 3. RECIBIR mensaje del servidor
            String mensajeRecibido = entrada.readUTF();
            System.out.println("Servidor me dijo: "+mensajeRecibido);

            // 4. DEVOLVER el mensaje al servidor
            System.out.println("Devolviendo el mensaje...");
            salida.writeUTF(mensajeRecibido);

            // 5. Cerrar
            socket.close();

        } catch (Exception e) {
            System.out.println("Error: Asegúrate de que el Servidor este encendido primero.");
            e.printStackTrace();
        }
    }
}
