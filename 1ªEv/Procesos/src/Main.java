import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        // ############################ RunTime ############################ //
        // Runtime.getRuntime().exec("Notepad.exe");
        // Runtime.getRuntime().exec("calc.exe");

        // Gestion de proceso
        // String[] infoProceso = {"Notepad.exe","notas.txt"};
        // Process proceso = Runtime.getRuntime().exec(infoProceso);
        // int codigoRetorno = proceso.waitFor();
        // System.out.println("Fin de la ejecucion: "+codigoRetorno);

        /**
        Process proceso2 = Runtime.getRuntime().exec("ping www.google.com");
        BufferedReader reader = new BufferedReader(new InputStreamReader(proceso2.getInputStream()));
        String line = "";
        while((line  = reader.readLine()) != null){
            System.out.println(line);
        }
        String so = System.getProperty("os.name");
        String comando;
        if(so.equals("Linux")){
            comando = "ifconfig";
        }else{
            comando = "ipconfig";
        }
         */
        // ############################ PROCESS BUILDER ############################ //
        ProcessBuilder pb = new ProcessBuilder("calc.exe");
        Process p = pb.start();
        System.out.println("Calculadora abierta.PID "+p.pid());
    }
}