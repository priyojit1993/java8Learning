package javaConcurrency.phaser_demo.demo1;

import java.util.concurrent.Phaser;

public class MyThread implements Runnable {
    /**
     *
     * at MyThread. First, notice that the constructor is passed a reference to the
     * phaser that it will use and then registers with the new thread as a party on that phaser.
     * Thus, each new MyThread becomes a party registered with the passed-in phaser. Also notice
     * that each thread has three phases. In this example, each phase consists of a placeholder
     * that simply displays the name of the thread and what it is doing. Obviously, in real-world
     * code, the thread would be performing more meaningful actions. Between the first two
     * phases, the thread calls arriveAndAwaitAdvance( ). Thus, each thread waits until all threads
     * have completed the phase (and the main thread is ready). After all threads have arrived
     * (including the main thread), the phaser moves on to the next phase. After the third phase,
     * each thread deregisters itself with a call to arriveAndDeregister( ).
     *
     *
     * */

    private Phaser phaser;
    private String name;

    public MyThread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();// register the current thread with the phaser
        new Thread(this).start();
    }

    @Override
    public void run() {
        //beginning of phase1
        System.out.println("Thread " + name + " Beginning Phase One");
        phaser.arriveAndAwaitAdvance(); // Signal arrival.
       // Pause a bit to prevent jumbled output. This is for illustration
       // only. It is not required for the proper operation of the phaser.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Thread " + name + " Beginning Phase Two");
        phaser.arriveAndAwaitAdvance(); // Signal arrival.
        // Pause a bit to prevent jumbled output. This is for illustration
        // only. It is not required for the proper operation of the phaser.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Thread " + name + " Beginning Phase Three");
        phaser.arriveAndDeregister(); // Signal arrival and deregister.
    }
}
