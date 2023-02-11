package javaConcurrency.atomic_demo;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread implements Runnable {
    String name;

    public MyThread(String name) {
        this.name = name;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        System.out.printf("Starting thread %s", name);
        System.out.println();
        for (int i = 1; i <= 3; i++) {
            int i1 = MyAtomic.atomicInteger.get();
            i1 += i;
            MyAtomic.atomicInteger.getAndSet(i1);
            System.out.println(name + " got: " +
                    MyAtomic.atomicInteger);
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
