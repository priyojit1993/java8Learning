package multithreading.interThreadComunication;

public class Consumer implements Runnable {
    Queue q;

    public Consumer(Queue q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        while (true) {
            q.getValue();
        }
    }
}
