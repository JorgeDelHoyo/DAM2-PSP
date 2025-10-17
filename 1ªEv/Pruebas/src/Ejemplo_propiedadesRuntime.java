public class Ejemplo_propiedadesRuntime {

    // Referencia al entorno de ejecución actual
    Runtime r = Runtime.getRuntime();

    void mostrarInfo() {
        // r.availableProcessors() processadores disponibles
        System.out.println(this.r.availableProcessors());
    }

    void mostrarEntorno() {
        // r.totalMemory() cantidad memoria reservada para JVM
        System.out.println("Mem Total: " + this.r.totalMemory());

        // r.freeMemory() indica memoria libre en la JVM
        System.out.println("Mem Libre: " + this.r.freeMemory());

    }

    void NetajaFem() {
        this.r.gc();
    }

    public static void main(String[] args) throws Exception {

        Ejemplo_propiedadesRuntime rd = new Ejemplo_propiedadesRuntime();

        // Procesadores disponibles
        rd.mostrarInfo();
        System.out.println("\nEstado inicial..");

        //Llenamos la memoria
        rd.mostrarEntorno();
        for (int i = 0; i <= 10000; i++) {
            new Object();
        }

        System.out.println("\nEstado después de crear 10.000 objects");
        rd.mostrarEntorno();

        // Llamamos al colector de basura
        rd.NetajaFem();

        System.out.println("\nEstado colector de basura");
        rd.mostrarEntorno();
    }
}
