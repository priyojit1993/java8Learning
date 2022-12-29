package multithreading.synchronizMethod;

import java.util.concurrent.Semaphore;

public class PrintDummy {

    public synchronized void callMe(String message) {
        System.out.print("[" + message);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("]");
        System.out.println();

    }


}
