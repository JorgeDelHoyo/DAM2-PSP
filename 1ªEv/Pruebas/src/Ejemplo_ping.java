import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejemplo_ping {
    public static void main(String[] args) throws IOException {

        Process process = Runtime.getRuntime().exec("ping www.google.com");
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
