import java.io.IOException;

public class Ejemplo2 {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Creo el proceso y lo lanzo
        String[] infoProceso = {"Notepad.exe","notas.txt"};
        Process proceso = Runtime.getRuntime().exec(infoProceso);

        // Espero a recibir la respuesta de finalizacion de ejecución
        int codigoRetorno = proceso.waitFor();
        System.out.println("Fin de la ejecución: " + codigoRetorno);
    }
}
