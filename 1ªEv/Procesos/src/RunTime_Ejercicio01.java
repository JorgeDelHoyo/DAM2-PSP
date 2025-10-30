import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Realiza un programa en Java que ejecute el comando correspondiente con
 * el sistema operativo donde se esté ejecutando (Windows o Linux), muestre
 * la dirección IP a través de la consola y muestre su resultado por pantalla.
 * @author delhoyoballestin23
 */
public class RunTime_Ejercicio01 {

    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();
        String comando;

        if (os.equals("Linux")){
            comando = "ifconfig";
        }else{
            comando = "ipconfig";
        }

        try {
            // Ejecutar comando
            Process process = Runtime.getRuntime().exec(comando);

            // Mostrar en pantalla
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // 4. Imprimir cada línea de la salida en la consola
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("-------------------------------------------------");
            System.out.println("-> El comando finaliza con código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            System.err.println("Ocurrió un error al ejecutar el comando:");
            e.printStackTrace();
        }
    }

}