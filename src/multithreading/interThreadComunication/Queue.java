package multithreading.interThreadComunication;

public class Queue {

    int n;
    boolean isValueSet = false;

    public synchronized int getValue() {
        while (!isValueSet) {
            try {
                System.out.println("Consumer going into wait  for producer to produce");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Got : " + n);
        isValueSet = false;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
        return n;
    }

    public synchronized void setValue(int n) {
        while (isValueSet) {
            try {
                System.out.println("Producer going to wait for consumer to consume");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Put : " + n);
        this.n = n;
        isValueSet = true;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();

    }


}
