package multithreading.interThreadComunication;

public class Producer implements Runnable {
    Queue q;

    public Producer(Queue q) {
        this.q = q;
        new Thread(this, "Producer").start();

    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.setValue(i++);
        }
    }
}
