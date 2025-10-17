import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. Monitor de procesos
 * Crear un programa que ejecute el comando del sistema que muestra una lista de los procesos activos:
 *
 * Windows: tasklist
 * Linux/Mac: ps -aux
 *
 * Mostrar en consola la lista de procesos en ejecución.
 * Permitir buscar un proceso por nombre, ordenar, etc.
 */
public class Ejercicio01 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in); // Scanner
        String sistemaOperativo = System.getProperty("os.name").toLowerCase(); // Sistema operativo en minusculas
        String comando; // Comando a ejecutar

        // Determinar el comando según su sistema operativo
        if(sistemaOperativo.contains("win")){ // Windows
            comando = "tasklist";
        } else { // Linux/Mac
            comando = "ps -aux";
        }

        // Ejecutar comando
        Process p = Runtime.getRuntime().exec(comando);
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String linea;
        // Lista de procesos dentro de un ArrayList
        List<String> procesos = new ArrayList<>();

        // Leer la salida del comando y añadirla al arrayList
        while((linea = br.readLine()) != null) {
            procesos.add(linea);
        }

        // Mostrar lista completa
        System.out.println("##### Procesos activos #####");
        for (String s : procesos){
            System.out.println(s);
        }

        // Buscar por nombre
        System.out.print("Ingrese nombre de proceso a buscar (o ENTER para omitir): ");
        String procesoBuscar = sc.nextLine().trim().toLowerCase();
        if(!procesoBuscar.isEmpty()){
            System.out.println("\n######### Procesos filtrados #########");
            for(int i = 0 ; i < procesos.size(); i++){
                String proceso = procesos.get(i);
                if(proceso.toLowerCase().contains(procesoBuscar)) {
                    System.out.println(proceso);
                }
            }
        }

        // Ordenar alfabéticamente
        System.out.print("\n¿Desea ordenar la lista alfabéticamente? (s/n): ");
        String respuesta = sc.nextLine().trim().toLowerCase();
        if (respuesta.equals("s")) {
            // Lista de procesos ordenados mediante el arrayList de procesos
            List<String> procesosOrdenados = new ArrayList<>(procesos);
            procesosOrdenados.sort(Comparator.naturalOrder());
            System.out.println("\n######### Procesos ordenados #########");
            procesosOrdenados.forEach(System.out::println);
        }

        // Cerramos el escaner para liberar recursos
        sc.close();
        System.out.println("Programa terminado");

    }
}