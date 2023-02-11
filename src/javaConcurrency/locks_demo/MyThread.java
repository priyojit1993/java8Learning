package javaConcurrency.locks_demo;

import java.util.concurrent.locks.Lock;

public class MyThread implements Runnable {

    private String name;
    private Lock lock;

    public MyThread(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        System.out.println("Starting");
        try {
            System.out.printf("Thread %s acquiring lock%n", name);
            lock.lock();
            System.out.printf("Thread %s acquired lock%n", name);
            Shared.sharedCount++;
            System.out.printf("%s count %d%n", name, Shared.sharedCount);
            System.out.printf("Thread %s sleeping", name);
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
