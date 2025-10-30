import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Utilizando ProcessBuilder, realiza un programa en Java que admite como
 * parámetro de entrada el comando a ejecutar en la consola del sistema
 * operativo y muestre en pantalla el resultado. (Not all the command might
 * work)
 * @author delhoyoballestin23
 */
public class ProcessBuilder_Ejercicio02 {

    public static void main(String[] args) {
        // Comprobar comando
        if (args.length == 0) {
            System.out.println("Error: Debes proporcionar un comando a ejecutar.");
            System.out.println("Ejemplo (Windows): java CommandExecutor ipconfig");
            System.out.println("Ejemplo (Linux):   java CommandExecutor ls -l");
            return;
        }
        try {
            // Crear un ProcessBuilder
            ProcessBuilder pb = new ProcessBuilder(args);

            pb.redirectErrorStream(true);

            // Iniciar proceso
            Process process = pb.start();

            // Leer y mostrar la salida del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar a que el proceso termine y mostrar codigo
            int exitCode = process.waitFor();
            System.out.println("\nEl comando finalizó: " + exitCode);
            if (exitCode != 0) {
                System.out.println("(Un código de salida distinto de 0 --> error)");
            }

        } catch (IOException e) {
            System.err.println("Error al ejecutar el comando");
        } catch (InterruptedException e) {
            System.err.println("El proceso fue interrumpido.");
            Thread.currentThread().interrupt();
        }
    }
}
