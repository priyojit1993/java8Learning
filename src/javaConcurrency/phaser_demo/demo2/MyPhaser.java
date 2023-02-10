package javaConcurrency.phaser_demo.demo2;

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser {

    int numPhases;

    public MyPhaser(int parties, int numPhases) {
        super(parties);
        this.numPhases = numPhases - 1;

    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("phase  " + phase + " is completed.");
        if (phase == numPhases || registeredParties == 0)
            return true;
        else
            return false;
    }
}
