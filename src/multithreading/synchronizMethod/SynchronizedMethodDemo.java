package multithreading.synchronizMethod;

public class SynchronizedMethodDemo implements Runnable {

    private PrintDummy printDummy;
    private Thread thread;
    private String message;

    public SynchronizedMethodDemo(String name, PrintDummy printDummy, String message) {
        this.printDummy = printDummy;
        this.message = message;
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        printDummy.callMe(message);
    }

    public static void main(String[] args) {
        System.out.println("Main thread started");
        PrintDummy printDummy = new PrintDummy();
        SynchronizedMethodDemo t1 = new SynchronizedMethodDemo("T1", printDummy, "Hello");
        SynchronizedMethodDemo t2 = new SynchronizedMethodDemo("T2", printDummy, "hi");
        SynchronizedMethodDemo t3 = new SynchronizedMethodDemo("T3", printDummy, "world");
        try {
            System.out.println("Waiting for other threads");
            t1.thread.join();
            t2.thread.join();
            t3.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread ends..");
    }
}
