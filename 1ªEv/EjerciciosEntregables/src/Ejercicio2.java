import java.io.IOException;
import java.util.Scanner;

/**
 * 2. Lanzador de aplicaciones
 * Diseñar un menú en Java donde el usuario pueda elegir una aplicación a abrir (por ejemplo: navegador, bloc de notas, calculadora).
 * Usar ProcessBuilder para ejecutar los comandos correspondientes según el sistema operativo.
 * <p>
 * Ejemplo: "notepad" en Windows, "gedit" en Linux.
 */
public class Ejercicio2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String sistemaOperativo = System.getProperty("os.name").toLowerCase();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n####### Lanzador de aplicaciones #######");
            System.out.println("1. Bloc de notas / Editor de texto");
            System.out.println("2. Calculadora");
            System.out.println("3. Navegador web");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            String opcionElegida = sc.nextLine().trim();

            if (opcionElegida.equalsIgnoreCase("1")) { // Bloc de notas
                if (sistemaOperativo.contains("win")) { // Windows
                    new ProcessBuilder("notepad").start();
                } else if (sistemaOperativo.contains("mac")) { // MAC
                    new ProcessBuilder("open", "-a", "TextEdit").start();
                } else { // Linux
                    new ProcessBuilder("gedit").start();
                }
            } else if (opcionElegida.equals("2")) { // Calculadora
                // Calculadora
                if (sistemaOperativo.contains("win")) { // Windows
                    new ProcessBuilder("calc").start();
                } else if (sistemaOperativo.contains("mac")) { // MAC
                    new ProcessBuilder("open", "-a", "Calculator").start();
                } else { // LINUX
                    new ProcessBuilder("gnome-calculator").start();
                }
            } else if (opcionElegida.equals("3")) { // Navegador web
                if (sistemaOperativo.contains("win")) { // Windows
                    new ProcessBuilder("cmd", "/c", "start", "https://www.google.com").start();
                } else if (sistemaOperativo.contains("mac")) { // MAC
                    new ProcessBuilder("open", "https://www.google.com").start();
                } else { // Linux
                    new ProcessBuilder("xdg-open", "https://www.google.com").start();
                }
            } else if (opcionElegida.equals("4")) { // Salir
                salir = true;
            } else {
                System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }

        // Cerramos el escaner para liberar recursos
        sc.close();
        System.out.println("Programa terminado");
    }
}
