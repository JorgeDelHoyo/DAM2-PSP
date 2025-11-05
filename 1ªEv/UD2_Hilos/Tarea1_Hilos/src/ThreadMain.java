public class ThreadMain {

    public static void main(String[] args) {
        Thread.currentThread().setName("Main");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().toString());

        ThreadGroup even = new ThreadGroup("Even threads");
        ThreadGroup odd = new ThreadGroup("Odd threads");
        Thread localThread = null;

        for (int i = 0; i < 10; i++) {
            // Creamos un hilo pasando el Runnable y el grupo correspondiente
            Runnable task = new U3S2_ThreadMethodsExample();
            localThread = new Thread((i % 2 == 0) ? even : odd, task, "Thread" + i);
            localThread.setPriority(i + 1);
            localThread.start();
        }

        try {
            localThread.join(); // Espera a que termine el último hilo
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            System.err.println("The main thread was interrupted while waiting for "
                    + localThread.toString() + " to finish");
        }

        System.out.println("Main thread ending");
    }
}
