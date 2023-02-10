package javaConcurrency.callable_future_demo;

import java.util.concurrent.Callable;

public class FactorialThread implements Callable<Integer> {
    int stop;

    public FactorialThread(int stop) {
        this.stop = stop;
    }

    @Override
    public Integer call() throws Exception {

        int fact = 1;
        for (int i = 2; i <= stop; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
