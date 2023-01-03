package javaConcurrency.semaphoreDemo.producerConsumerSemaphore;

public class Consumer implements Runnable {
    Queue q;

    public Consumer(Queue q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            q.get();
        }
    }
}
