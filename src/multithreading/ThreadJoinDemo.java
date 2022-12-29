package multithreading;

public class ThreadJoinDemo implements Runnable {
    Thread t;

    public ThreadJoinDemo(String name) {
        t = new Thread(this,name);
        t.start();
    }


    @Override
    public void run() {
        System.out.println(String.format("Thread %s starting", t.getName()));
        for (int i = 1; i <= 10; i++) {
            System.out.println(String.format(t.getName() + " " + i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(String.format("Thread %s ending", t.getName()));
    }


    public static void main(String[] args) {
        System.out.println(String.format("Thread %s starting", Thread.currentThread().getName()));
        ThreadJoinDemo t1 = new ThreadJoinDemo("T1");
        ThreadJoinDemo t2 = new ThreadJoinDemo("T2");
        ThreadJoinDemo t3 = new ThreadJoinDemo("T3");
        try {
            System.out.println("Waiting for threads to finish");
            t1.t.join();
            t2.t.join();
            t3.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("Thread %s is alive %s",t1.t.getName(),t1.t.isAlive()));
        System.out.println(String.format("Thread %s is alive %s",t2.t.getName(),t2.t.isAlive()));
        System.out.println(String.format("Thread %s is alive %s",t3.t.getName(),t3.t.isAlive()));


        System.out.println(String.format("Thread %s ending", Thread.currentThread().getName()));

    }
}
