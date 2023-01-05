package javaConcurrency.countdownLatchDemo;

import java.util.concurrent.CountDownLatch;

public class CDLDemo {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(5);
        System.out.println("Main Thread starting ");
        new MyThread(countDownLatch, "Thread A");
        try {
            /*
            * the main thread calls await( ) on cdl, which causes execution of the main
            * thread to pause until cdl’s count has been decremented five times.
            *
            * */
            System.out.println("Main Thread waiting for all events of countDownLatch to complete");
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done");

    }

}
