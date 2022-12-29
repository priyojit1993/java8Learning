package multithreading;

public class MultiThreadingUsingThreadClass extends Thread {

    public MultiThreadingUsingThreadClass(String name) {
        super(name);
        this.start();
    }

    @Override
    public void run() {
        System.out.println("Thread started ... " + this);
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread() + " " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread ended ... " + this);
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread stared ...." + Thread.currentThread());
        MultiThreadingUsingThreadClass t1 = new MultiThreadingUsingThreadClass("T1");
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
