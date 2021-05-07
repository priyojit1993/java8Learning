package functional_interface;

public class RunnableAsFunctionalInterface {
    /*
     * Here we will create a lambda for Runnable interface which is a functional interface  itself and  then  create a new  thread  with that
     * Runnable interface
     * */

    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println("Starting new thread  : " + Thread.currentThread().currentThread().getName());
            for (int i = 1; i <= 10; i++) {
                System.out.println("hello world from child thread");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread myThread = new Thread(runnable);
        System.out.println("Starting main thread " + Thread.currentThread().getName());
        myThread.start();
        for (int i = 1; i <= 10; i++) {
            System.out.println("hello world from main thread");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
