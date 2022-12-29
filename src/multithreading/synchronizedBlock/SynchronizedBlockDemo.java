package multithreading.synchronizedBlock;


public class SynchronizedBlockDemo implements Runnable {
    private PrintDummy printDummy;
    private Thread thread;
    private String message;

    public SynchronizedBlockDemo(String name, PrintDummy printDummy, String message) {
        this.printDummy = printDummy;
        thread = new Thread(this, name);
        this.message = message;
        thread.start();
    }


    @Override
    public void run() {
        synchronized (printDummy) {
            printDummy.callMe(message);
        }

    }

    public static void main(String[] args) {
        System.out.println("Main thread started");
        PrintDummy printDummy = new PrintDummy();
        SynchronizedBlockDemo t1 = new SynchronizedBlockDemo("T1", printDummy, "Hello");
        SynchronizedBlockDemo t2 = new SynchronizedBlockDemo("T2", printDummy, "hi");
        SynchronizedBlockDemo t3 = new SynchronizedBlockDemo("T3", printDummy, "world");
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
