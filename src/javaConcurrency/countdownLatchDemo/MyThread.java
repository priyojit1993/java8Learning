package javaConcurrency.countdownLatchDemo;

import java.util.concurrent.CountDownLatch;

public class MyThread implements Runnable {
    CountDownLatch countDownLatch;
    String name;

    public MyThread(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " : " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }
    }
}
