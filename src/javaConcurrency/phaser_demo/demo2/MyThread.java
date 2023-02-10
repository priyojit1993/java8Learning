package javaConcurrency.phaser_demo.demo2;

import java.util.concurrent.Phaser;
/**
 * This loop simply calls arriveAndAwaitAdvance( ) until the phaser is terminated. The phaser
 * won’t terminate until the specified number of phases have been executed. In this case, the
 * loop continues to execute until four phases have run. Next, notice that the threads also call
 * arriveAndAwaitAdvance( ) within a loop that runs until the phaser is terminated. This
 * means that they will execute until the specified number of phases has been completed.
 * Now, look closely at the code for onAdvance( ). Each time onAdvance( ) is called, it is
 * passed the current phase and the number of registered parties. If the current phase equals
 * the specified phase, or if the number of registered parties is zero, onAdvance( ) returns
 * true, thus stopping the phaser
 *
 * */

public class MyThread implements Runnable {

    Phaser p;
    String name;

    public MyThread(Phaser p, String name) {
        this.p = p;
        this.name = name;
        p.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!p.isTerminated()) {
            System.out.println("Thread " + name + " Beginning Phase " +
                    p.getPhase());
            p.arriveAndAwaitAdvance();
            // Pause a bit to prevent jumbled output. This is for illustration
            // only. It is not required for the proper operation of the phaser.
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
