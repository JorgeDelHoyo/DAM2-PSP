import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class ListarInterfaces {
    public static void main(String[] args) {
        try {
            // Obtener todas las interfaces del sistema
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface netInt = interfaces.nextElement();

                System.out.println("Nombre de visualización: " + netInt.getDisplayName());
                System.out.println("Nombre interno: " + netInt.getName());
                // isUp() nos dice si la interfaz está levantada y funcionando
                System.out.println("¿Está activa (Up)?: " + netInt.isUp());
                System.out.println("¿Es Loopback?: " + netInt.isLoopback());
                System.out.println("-----------------------------------");
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}