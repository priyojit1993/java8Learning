package multithreading;

public class MultiThreadingUsingRunnableInterface implements Runnable {

    Thread t;

    public MultiThreadingUsingRunnableInterface(String threadName) {
        t = new Thread(this, threadName);
        t.start();
    }

    @Override
    public void run() {
        System.out.println("Thread started ... " + t);
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread() + " " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread ended ... " + t);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread stared ...." + Thread.currentThread());
        MultiThreadingUsingRunnableInterface t1 = new MultiThreadingUsingRunnableInterface("T1");
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main thread ends ...." + Thread.currentThread());
    }
}




