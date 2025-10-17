import java.io.IOException;

public class Ejemplo_processBuilder {
    public static void main(String[] args) throws IOException {
        // Create ProcessBuilder.
        ProcessBuilder p = new ProcessBuilder();
        // Use command "notepad.exe" and open the file.
        p.command("notepad.exe", "notas.txt");
        // p.command("notepad.exe", "C:\\file.txt");

        Process pr = p.start();

        System.out.println("");
    }
}
