package javaConcurrency.callable_future_demo;

import java.util.concurrent.*;

public class CallableFutureDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        SumThread sumThread = new SumThread(10);
        FactorialThread factorialThread = new FactorialThread(5);
        HypotThread hypotThread = new HypotThread(4.5, 6.7);
        Future<Integer> submit = executorService.submit(sumThread);
        Future<Double> submit1 = executorService.submit(hypotThread);
        Future<Integer> submit2 = executorService.submit(factorialThread);
        try {
            System.out.println("Sum is : " + submit.get());
            System.out.println("Hypotenous is  : " + submit1.get());
            System.out.println("Factorial is : " + submit2.get());
        } catch (InterruptedException | ExecutionException e2) {
            e2.printStackTrace();
        }
        executorService.shutdown();
    }
}
