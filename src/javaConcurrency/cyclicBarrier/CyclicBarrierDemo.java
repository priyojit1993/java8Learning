package javaConcurrency.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new PostBarrierAction());
        System.out.println("Starting");
        new MyThread(cyclicBarrier, "A");
        new MyThread(cyclicBarrier, "B");
        new MyThread(cyclicBarrier, "C");


        new MyThread(cyclicBarrier, "X");
        new MyThread(cyclicBarrier, "Y");
        new MyThread(cyclicBarrier, "Z");

    }
}
