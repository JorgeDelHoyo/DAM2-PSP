package ej3_3;

import java.net.InetAddress;

public class EscanerRed {
    public static void main(String[] args) {
        // CAMBIA ESTO SEGÚN TU RED (ejemplo para 192.168.1.X)
        byte[] red = {(byte)192, (byte)168, (byte)1};

        System.out.println("Escaneando red 192.168.1.0/24 ...");

        // Iteramos del 1 al 254 (HostMin a HostMax)
        // Omitimos el 0 (Red) y el 255 (Broadcast)
        for (int i = 1; i < 255; i++) {
            try {
                // Construimos la dirección IP completa (4 bytes)
                byte[] ipBytes = {red[0], red[1], red[2], (byte)i};
                InetAddress address = InetAddress.getByAddress(ipBytes);

                // Intentamos conectar con un timeout de 100ms
                // Nota: isReachable intenta ICMP (Ping) o TCP puerto 7
                if (address.isReachable(100)) {
                    System.out.println(address.getHostAddress() + " es ALCANZABLE (" + address.getHostName() + ")");
                }
            } catch (Exception e) {
                // Ignoramos errores para no ensuciar la salida
            }
        }
        System.out.println("Escaneo finalizado.");
    }
}
