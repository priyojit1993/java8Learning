package javaConcurrency.phaser_demo.demo1;

import java.util.concurrent.Phaser;

public class PhaserDemo {
    /**
    *  First, in main( ), a Phaser called
     * phsr is created with an initial party count of 1 (which corresponds to the main thread).
     * Then three threads are started by creating three MyThread objects. Notice that MyThread
     * is passed a reference to phsr (the phaser). The MyThread objects use this phaser to
     * synchronize their activities. Next, main( ) calls getPhase( ) to obtain the current phase
     * number (which is initially zero) and then calls arriveAndAwaitAdvance( ). This causes
     * main( ) to suspend until phase zero has completed. This won’t happen until all MyThreads
     * also call arriveAndAwaitAdvance( ). When this occurs, main( ) will resume execution, at
     * which point it displays that phase zero has completed, and it moves on to the next phase. This
     * process repeats until all three phases have finished. Then, main( ) calls arriveAndDeregister( ).
     * At that point, all three MyThreads have also deregistered. Since this results in there being
     * no registered parties when the phaser advances to the next phase, the phaser is terminated.
    *
    *
    *
    * */
    public static void main(String[] args) {
        Phaser phsr = new Phaser(1);
        int curPhase;
        new MyThread(phsr, "A");
        new MyThread(phsr, "B");
        new MyThread(phsr, "C");

        // Wait for all threads to complete phase one.
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " Complete");
        // Wait for all threads to complete phase two.
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " Complete");
        //Wait for all threads to complete phase three.
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " Complete");
        // Deregister the main thread.
        phsr.arriveAndDeregister();
        if(phsr.isTerminated())
            System.out.println("The Phaser is terminated");


    }
}
