import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjecucionClassDemo {

    public static void main(String[] args) throws IOException {

        // Declaro ProcessBuilder
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("java","Sumador","1","4");
        Process p = pb.start();

        // OPCION 1: La salida del programa la guardo en un TXT
        // pb.redirectOutput(new File("test.txt"));

        // OPCIO 2: La salida del programa la muestro en pantalla
        BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
    }
}