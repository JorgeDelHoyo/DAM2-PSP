package ej3_4;

import java.net.*;
import java.util.Enumeration;
import java.util.List;

public class ObtenerBroadcastLocal {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface netInt = interfaces.nextElement();

                // Descartar si no está activa o es loopback (127.0.0.1)
                if (!netInt.isUp() || netInt.isLoopback()) {
                    continue;
                }

                List<InterfaceAddress> listIntAddr = netInt.getInterfaceAddresses();
                for (InterfaceAddress addr : listIntAddr) {
                    InetAddress ipAddr = addr.getAddress();

                    // Buscar una dirección IPv4 que sea "SiteLocal" (192.168.x.x, 10.x.x.x, etc.)
                    if (ipAddr instanceof Inet4Address && ipAddr.isSiteLocalAddress()) {
                        System.out.println(">>> Interfaz seleccionada: " + netInt.getDisplayName());
                        System.out.println(">>> Tu IP: " + ipAddr.getHostAddress());

                        // Obtener broadcast
                        if (addr.getBroadcast() != null) {
                            System.out.println(">>> DIRECCIÓN DE BROADCAST: " + addr.getBroadcast().getHostAddress());
                            // variable para usarla en sockets UDP
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
