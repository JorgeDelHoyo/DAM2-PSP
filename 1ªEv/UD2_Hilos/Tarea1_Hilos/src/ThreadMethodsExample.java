public class ThreadMethodsExample extends Thread {

    public void run() {
        System.out.println("Comienza el hilo: " + getName());
        try {
            for (int i = 3; i > 0; i--) {
                System.out.println(getName() + " contando: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrumpido.");
        }
        System.out.println(getName() + " finalizado.");
    }

    public static void main(String[] args) {
        ThreadMethodsExample t1 = new ThreadMethodsExample();
        ThreadMethodsExample t2 = new ThreadMethodsExample();

        t1.start();
        t2.start();
    }
}