import java.io.File;
import java.io.IOException;

/**
 * Modificar el ejercicio 1 para utilizar ProcessBuilder y que guarde el
 * resultado en un archivo txt. Necesitarás utilizar el metodo redirectOutput.
 * @author delhoyoballestin23
 */

public class ProcessBuilder_Ejercicio01 {

    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();
        String comando;
        String outputFileName = "ip_result.txt";

        // Determinar el sistema operativo
        if (os.contains("win")) {
            comando = "ipconfig";
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            comando = "ip";
        } else {
            System.out.println("Sistema operativo no compatible.");
            return;
        }
        try {
            // Crea el process builder
            ProcessBuilder processBuilder;
            if (os.contains("linux") || os.contains("nix")) {
                // Linux
                processBuilder = new ProcessBuilder("ip", "addr");
            } else {
                // Windows
                processBuilder = new ProcessBuilder(comando);
            }

            // Salida del proceso al archivo
            File outputFile = new File(outputFileName);
            processBuilder.redirectOutput(outputFile);

            // Iniciar proceso
            Process process = processBuilder.start();

            // Esperar a que el proceso termine
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("\nLa información de la red ha sido guardada en '" + outputFile.getAbsolutePath());
            } else {
                System.out.println("\nEl comando finalizó: " + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Ocurrió un error al ejecutar el proceso:");
            System.out.println(e.getMessage());
        }
    }
}