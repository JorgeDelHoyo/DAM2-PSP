public class Ejemplo_so {
    public static void main(String[] args) {

        String so = System.getProperty("os.name");
        System.out.println("Sistema operativo: "+so);

        // Determinar comando Windows o Linux
        if (so.equals("Linux")) {
            System.out.println("Estamos en Linux");
        } else {
            System.out.println("Estamos en Windows");
        }
    }
}
