package javaConcurrency.executor_demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExecutorDemo {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);
        CountDownLatch cdl2 = new CountDownLatch(5);
        CountDownLatch cdl3 = new CountDownLatch(5);
        CountDownLatch cdl4 = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(2); //fixed thread pool of 2 threads that will be used to run all the 4 thread classes.
        System.out.println("Starting");
        // Start the threads.
        es.execute(new MyThread(cdl, "A"));
        es.execute(new MyThread(cdl2, "B"));
        es.execute(new MyThread(cdl3, "C"));
        es.execute(new MyThread(cdl4, "D"));

        try {
            cdl.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
        /**
        *The call to shutdown( ) is important. If it were not present in the program, then the
         * program would not terminate because the executor would remain active
        * */
        es.shutdown();
        System.out.println("Done");
    }
}
