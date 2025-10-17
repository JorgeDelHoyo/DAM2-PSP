import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Ejemplo1 {
    public static void main(String[] args) throws IOException {
        /**
         * DISTINTAS FORMAS DE LANZAR UN PROCESO
         */

        // Opcion 1
        // Runtime.getRuntime().exec("Notepad.exe");

        // Opcion 2
        // Runtime.getRuntime().exec("Notepad.exe notas.txt");

        // Opcion 3
        String[] infoProceso = {"Notepad.exe","notas.txt"};
        Runtime.getRuntime().exec(infoProceso);
    }
}