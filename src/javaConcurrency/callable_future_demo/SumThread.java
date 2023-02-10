package javaConcurrency.callable_future_demo;

import java.util.concurrent.Callable;

public class SumThread implements Callable<Integer> {
    int limit;

    public SumThread(int limit) {
        this.limit = limit;
    }

    @Override
    public Integer call() throws Exception {
        int s = 0;
        for (int i = 1; i <= limit; i++) {
            s += i;

        }
        return s;
    }
}
