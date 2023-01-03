package javaConcurrency.semaphoreDemo;

import java.util.concurrent.Semaphore;

public class ConcurrencySemaphoreSynchronizerDemo implements Runnable {

    String name;
    Semaphore semaphore;

    public ConcurrencySemaphoreSynchronizerDemo(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        System.out.println("Acquiring  semaphore");
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Semaphore Acquired");
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " " + Count.count++);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Releasing semaphore");
        semaphore.release();
        System.out.println("Released Semaphore");
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        ConcurrencySemaphoreSynchronizerDemo thread1 = new ConcurrencySemaphoreSynchronizerDemo("Thread A", semaphore);
        ConcurrencySemaphoreSynchronizerDemo thread2 = new ConcurrencySemaphoreSynchronizerDemo("Thread B", semaphore);

    }

}
