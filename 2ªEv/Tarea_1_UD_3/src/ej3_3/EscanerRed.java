package ej3_3;

import java.net.InetAddress;

public class EscanerRed {
    public static void main(String[] args) {
        // Depende de la red referenciada
        byte[] red = {(byte)192, (byte)168, (byte)1};

        System.out.println("Escaneando red 192.168.1.0/24 ...");

        // Iteramos del 1 al 254 (HostMin a HostMax)
        // Omitimos el 0 (Red) y el 255 (Broadcast)
        for (int i = 1; i < 255; i++) {
            try {
                // Construimos la dirección IP completa (4 bytes)
                byte[] ipBytes = {red[0], red[1], red[2], (byte)i};
                InetAddress address = InetAddress.getByAddress(ipBytes);

                // timeout 500 ms para mayor fiabilidad
                if(address.isReachable(500)){
                    System.out.println(address.getHostAddress()+" es ALCANZABLE ("+address.getHostName()+")");
                }
            } catch (Exception e) {
                // Ignoramos errores para no ensuciar la salida
            }
        }
        System.out.println("Escaneo finalizado.");
    }
}
