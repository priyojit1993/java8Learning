package javaConcurrency.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread implements Runnable {

    CyclicBarrier cyclicBarrier;
    String name;

    public MyThread(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        System.out.println(name);
        try {
            /*
            *
            *
            * */
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
