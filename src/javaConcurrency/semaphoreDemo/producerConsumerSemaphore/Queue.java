package javaConcurrency.semaphoreDemo.producerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Queue {

    int n;
    static Semaphore cSemaphore = new Semaphore(0);
    static Semaphore pSemaphore = new Semaphore(1);

    void get() {
        try {
            cSemaphore.acquire();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
        System.out.println("Got: " + n);
        pSemaphore.release();
    }

    void put(int n) {
        try {
            pSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.n = n;
        System.out.println("Put: " + n);
        cSemaphore.release();
    }
}
