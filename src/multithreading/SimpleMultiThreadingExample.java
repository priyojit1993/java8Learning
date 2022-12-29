package multithreading;

public class SimpleMultiThreadingExample {


    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 11; i <= 20; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });


        thread2.start();
        thread1.start();


    }


}
