package ej3_2;

import java.net.*;
import java.util.*;

public class InfoDetalladaInterfaces {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();

        for (NetworkInterface netint : Collections.list(nets)) {
            System.out.printf("Display name: %s\n", netint.getDisplayName());
            System.out.printf("Name: %s\n", netint.getName());

            // Lista direcciones de interfaz mejor InterfaceAddres que getInetAddresses() porque da máscaras y broadcast
            List<InterfaceAddress> listIntAddr = netint.getInterfaceAddresses();

            for (InterfaceAddress addr : listIntAddr) {
                InetAddress ipAddr = addr.getAddress();

                System.out.print(" -> IP: " + ipAddr.getHostAddress());

                // Distinguir versión IP
                if (ipAddr instanceof Inet4Address) {
                    System.out.print(" (IPv4)");
                } else if (ipAddr instanceof Inet6Address) {
                    System.out.print(" (IPv6)");
                }

                // Máscara (Prefix Length)
                // En Java no da "255.255.255.0", da la longitud del prefijo
                System.out.println("\n    Máscara (bits): /" + addr.getNetworkPrefixLength());

                // Broadcast (Normalmente IPv4)
                if (addr.getBroadcast() != null) {
                    System.out.println("    Broadcast: " + addr.getBroadcast().getHostAddress());
                }
            }
            System.out.println("----------------------------------------");
        }
    }
}
