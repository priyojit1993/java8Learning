package javaConcurrency.semaphoreDemo.producerConsumerSemaphore;

public class Producer implements Runnable {
    Queue q;

    Producer(Queue q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++)
            q.put(i);
    }
}
