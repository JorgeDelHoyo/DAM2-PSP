/**
 * 2 Thread
 */
public class LiftOffThread extends Thread {
    private int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOffThread() {}

    public LiftOffThread(int countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        while (countDown > 0) {
            System.out.println(id + " (" + countDown + ")");
            countDown--;
        }
        System.out.println("Lanzamiento (" + id + ")");
    }

    public static void main(String[] args) {
        LiftOffThread launch1 = new LiftOffThread();
        LiftOffThread launch2 = new LiftOffThread();
        LiftOffThread launch3 = new LiftOffThread();

        launch1.start();
        launch2.start();
        launch3.start();

        System.out.println("Comienza la cuenta atrás!");
    }
}
