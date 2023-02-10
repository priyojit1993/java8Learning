package javaConcurrency.callable_future_demo;

import java.util.concurrent.Callable;

public class HypotThread implements Callable<Double> {
    double side1;
    double side2;

    public HypotThread(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public Double call() throws Exception {
        return Math.sqrt((side1 * side1) + (side2 * side2));
    }
}
