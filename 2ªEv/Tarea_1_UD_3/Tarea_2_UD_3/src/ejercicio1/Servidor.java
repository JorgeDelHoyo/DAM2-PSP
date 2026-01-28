package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[]args) {

        // Puerto cualquiera
        final int PUERTO = 5000;

        try {

            // 1. Iniciamos el servidor en el puerto
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado. Esperando conexión...");

            // 2. Esperamos (se bloquea aquí) hasta que llegue un cliente
            Socket socketCliente = servidor.accept();
            System.out.println("!Cliente conectado");

            // 3. Preparamos los canales de comunicación
            DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());
            DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());

            // 4. ENVIAR mensaje al cliente
            String mensajeOriginal = "Hola Cliente, este es un mensaje desde el Servidor";
            salida.writeUTF(mensajeOriginal);
            System.out.println("Mensaje enviado al cliente: "+ mensajeOriginal);

            // 5. RECIBIR el mensaje de vuelta (eco)
            String mensajeDevuelto = entrada.readUTF();
            System.out.println("El cliente me ha devuelto: "+mensajeDevuelto);

            // 6. Cerrar conexiones
            servidor.close();
            socketCliente.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
